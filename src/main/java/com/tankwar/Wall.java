package com.tankwar;

import java.awt.*;

public class Wall {

    private int x;
    private int y;

    private boolean horizontal;

    private int howManyBrick;

    public Wall(int x, int y, boolean horizontal, int howManyBrick) {
        this.x = x;
        this.y = y;
        this.horizontal = horizontal;
        this.howManyBrick = howManyBrick;
    }

    public void draw(Graphics g) {
        Image brickImage = Tools.getImage("brick.png");

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


//    assets/images/brick.png
}
