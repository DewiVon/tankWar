package com.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.util.List;

public class TankFrame  extends Frame {

    Tank            tank     =    new Tank(200, 200, Dir.DOWN,this);
    List<Bullet>    listBullet     =    new ArrayList<>();


    static final int GAME_WIDTH=800,GAME_HEIGHT=600;

    public TankFrame(){
        setSize(GAME_WIDTH,GAME_HEIGHT);
        setVisible(true);
        setTitle("坦克大战");
        //设置窗口大小不可以调整
        setResizable(false);
        //按下键盘上的任意键，黑色方框可以移动
        this.addKeyListener(new MyKeyListener());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });




    }

    Image offScreenImage = null;

    /**
     * 双缓冲
     * */
    @Override
    public void update(Graphics g){
        if(offScreenImage == null){
            offScreenImage = this.createImage(GAME_WIDTH,GAME_HEIGHT);
        }
        Graphics graphics = offScreenImage.getGraphics();
        Color color = graphics.getColor();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        graphics.setColor(color);
        paint(graphics);
        g.drawImage(offScreenImage, 0, 0, null);

    }


    /**
     * paint 是将背景清楚重新在画一遍
     *
     * 内部类，只有A类用B类，就可以将B类作为A类的内部类就可以了。
            * */
    @Override
    public void paint(Graphics g){
        Color color = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量："+listBullet.size(),10 ,50 );
        g.setColor(color);
        tank.paint(g);
        //新画法
        for (int i = 0; i < listBullet.size(); i++) {
            listBullet.get(i).paint(g);
        }
        // 老画法 这种画法会出Exception in thread "AWT-EventQueue-0" java.util.ConcurrentModificationException
     /*   for (Bullet bullet1 : listBullet) {
            bullet1.paint(g);
        }*/
    }



    /**
     * 上下左右移动
     * 上下左右可以移动了怎么斜上/斜下移动
     * */
    class MyKeyListener extends KeyAdapter{

        //给上下左右设置四个状态

        boolean bL = false;
        boolean bR = false;
        boolean bU = false;
        boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("按键按下相应");
            //活动虚拟键盘的code
            int keyCode = e.getKeyCode();
            switch (keyCode){
                case KeyEvent.VK_LEFT:
                   /* x -= 10;*/
                    bL = true;
                    break;
                case  KeyEvent.VK_RIGHT:
                    /*x += 10;*/
                    bR = true;
                    break;
                case  KeyEvent.VK_UP:
                    /*y -= 10;*/
                    bU = true;
                    break;
                case    KeyEvent.VK_DOWN:
                    /*y += 10;*/
                    bD = true;
                    break;
                case    KeyEvent.VK_CONTROL:
                    tank.fire();
                    break;
                default:
                    break;
            }
            setMainTankDir();

            repaint(); //自动调用 paint()

        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("按键弹起相应");
             bL = false;
             bR = false;
             bU = false;
             bD = false;
             setMainTankDir();
        }

        /**
         * 设置主战坦克的方向
         * */
        public void setMainTankDir(){
            if(!bU && !bD && !bL && !bR){
                tank.setMoving(false);
            }else{
                tank.setMoving(true);
                if(bU) tank.setDir(Dir.UP);
                if(bD) tank.setDir(Dir.DOWN);
                if(bL) tank.setDir(Dir.LEFT);
                if(bR) tank.setDir(Dir.RIGHT);
            }


        }

    }



}
