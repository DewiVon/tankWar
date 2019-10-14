package com.tank;

import java.awt.*;

public class Bullet {
    private static final  int SPEED = 10;
    private static final  int WIDTH = 30, HEIGHT = 30;

    private  int x,y;

    private Dir dir ;

    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g){
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
    }
}
