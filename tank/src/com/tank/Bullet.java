package com.tank;

import java.awt.*;

/**
 * 子弹类
 * */
public class Bullet {
    private static final  int SPEED = 10;
    private static final  int WIDTH = 30, HEIGHT = 30;

    private  int x,y;

    private Dir dir ;

    private boolean live  =  true;

    TankFrame tankFrame;

    public Bullet(int x, int y, Dir dir,TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame=tankFrame;
    }

    public void paint(Graphics g){
        if(!live){
            this.tankFrame.listBullet.remove(this);
        }
        Color color = g.getColor();
        g.setColor(Color.red);
        g.fillOval(x, y, WIDTH, HEIGHT);
        move();
        g.setColor(color);
    }

    private void move() {
        switch (dir){
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            default:
                break;
        }

            if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
                live = false;
            }
        }

}
