package com.tank;

import java.awt.*;

/**
 * 封装tank类 封装 基层 多态*/
public class Tank {

     private int x = 200, y = 200;

     private Dir dir = Dir.DOWN;

     private static final int SPEED = 10;

     private boolean moving = false;

     private TankFrame tankFrame;

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Tank(int x, int y, Dir dir,TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g){
        Color color = g.getColor();
        switch (dir){
            case DOWN:
                g.drawImage(ResourceMgr.tankD,x ,y ,null );
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU,x ,y ,null );
                break;
            case LEFT:
                g.drawImage(ResourceMgr.tankL,x ,y ,null );
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR,x ,y ,null );
                break;
        }

        g.drawImage(ResourceMgr.tankL,x ,y ,null );
//        g.setColor(Color.ORANGE);
//        g.fillRect(x,y,50,50);
//        g.setColor(color);
        move();
    }

    private void move() {
        if(!moving) return;
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void fire() {
        tankFrame.listBullet.add(new Bullet(this.x, this.y, this.dir,this.tankFrame));
    }
}
