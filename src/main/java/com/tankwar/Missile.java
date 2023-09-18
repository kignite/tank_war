package com.tankwar;

import java.awt.*;

class Missile {
    
    private static final int SPEED = 10;

    private int x;

    private int y;

    private final boolean enemy;

    private final Direction direction;

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
            return;
        }
        g.drawImage(getImage(), x, y, null);
    }
}
