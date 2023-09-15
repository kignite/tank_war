package com.tankwar;

import java.awt.*;

class Wall {

    private final int x;
    private final int y;

    private final boolean horizontal;

    private final int howManyBrick;

    private final Image brickImage;

     Wall(int x, int y, boolean horizontal, int howManyBrick) {
        this.brickImage = Tools.getImage("brick.png");
        this.x = x;
        this.y = y;
        this.horizontal = horizontal;
        this.howManyBrick = howManyBrick;
    }

     Rectangle getRectangle() {
        return horizontal ? new Rectangle(x, y,
                howManyBrick * brickImage.getWidth(null), brickImage.getHeight(null))
                : new Rectangle(x, y, brickImage.getWidth(null), howManyBrick * brickImage.getHeight(null));
    }

     void draw(Graphics g) {

        if (horizontal) {
            for (int i = 0; i < howManyBrick; i++) {
                g.drawImage(brickImage, x + i * brickImage.getWidth(null),y ,null);
            }
        }else {
            for (int i = 0; i < howManyBrick; i++) {
                g.drawImage(brickImage, x ,y + i * brickImage.getHeight(null) ,null);
            }
        }
    }
}
