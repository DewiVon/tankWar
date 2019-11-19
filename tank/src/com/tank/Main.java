package com.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {

        TankFrame tankFrame = new TankFrame();

        BufferedImage read = ImageIO.read(Main.class.getClassLoader().getResource("image/tankimage.gif"));
        if (read!=null){
            System.out.println("有图");
        }
        //黑窗口自动移动
        while(true){
            Thread.sleep(50);
            tankFrame.repaint();
        }
    }
}








