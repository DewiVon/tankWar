package com.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame  extends Frame {

    int x = 200, y = 200;

    Dir dir = Dir.DOWN;

    private static final int SPEED = 10;
    public TankFrame(){
        setSize(800,600);
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

    /**
     * paint 是将背景清楚重新在画一遍
     *
     * 内部类，只有A类用B类，就可以将B类作为A类的内部类就可以了。
     * */
    @Override
    public void paint(Graphics g){
        g.fillRect(x,y,50,50);
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
                default:
                    break;
            }
            setMainTankDir();

            repaint(); //自动调用 paint()

        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("按键弹起相应");
            int keyCode = e.getKeyCode();
            switch (keyCode){
                case KeyEvent.VK_LEFT:
                    /* x -= 10;*/
                    bL = false;
                    break;
                case  KeyEvent.VK_RIGHT:
                    /*x += 10;*/
                    bR = false;
                    break;
                case  KeyEvent.VK_UP:
                    /*y -= 10;*/
                    bU = false;
                    break;
                case    KeyEvent.VK_DOWN:
                    /*y += 10;*/
                    bD = false;
                    break;
                default:
                    break;
            }
        }

        /**
         * 设置主战坦克的方向
         * */
        public void setMainTankDir(){
            if(bU) dir = Dir.UP;
            if(bD) dir = Dir.DOWN;
            if(bL) dir = Dir.LEFT;
            if(bR) dir = Dir.RIGHT;
        }

    }



}
