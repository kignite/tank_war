package com.tankwar;

import java.awt.*;

class Missile {
    
    private static final int SPEED = 10;

    private int x;

    private int y;

    private final boolean enemy;

    private final Direction direction;

    boolean live = true;

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    Missile(int x, int y, boolean enemy, Direction direction) {
        this.x = x;
        this.y = y;
        this.enemy = enemy;
        this.direction = direction;
    }

    Image getImage() {
        return direction.getImage("missile");
    }

    void move() {
       x += direction.xFactor * SPEED;
       y += direction.yFactor * SPEED;
    }

    public void draw(Graphics g) {
        move();
        if(x < 0 || x > 800 || y <0 || y >600) {
            this.setLive(false);
            return;
        }

        Rectangle rectangle = this.getRectangle();
        for(Wall wall : GameClient.getInstance().getWalls()) {
            if(rectangle.intersects(wall.getRectangle())){
                this.setLive(false);
                return;
            }
        }

        if (enemy) {
            Tank playerTank = GameClient.getInstance().getPlayerTank();
            if(rectangle.intersects(playerTank.getRectangle())){
                playerTank.setLive(false);
                playerTank.setHp(playerTank.getHp() - 20);
                if (playerTank.getHp() <= 0) {
                    playerTank.setLive(false);
                }
                this.setLive(false);
            }
        } else {
            for (Tank tank : GameClient.getInstance().getEnemyTanks()) {
                if(rectangle.intersects(tank.getRectangle())){
                    tank.setLive(false);
                    this.setLive(false);
                    break;
                }
            }
        }

        g.drawImage(getImage(), x, y, null);
    }

    Rectangle getRectangle() {
        return new Rectangle(x, y, getImage().getWidth(null), getImage().getHeight(null));
    }
}
