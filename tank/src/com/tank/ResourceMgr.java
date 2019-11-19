package com.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 资源加载*/
public class ResourceMgr {
    public   static BufferedImage tankL,tankR,tankU,tankD;

    static {
        try {
            tankL = ImageIO.read(Main.class.getClassLoader().getResource("image/tankimage.gif"));
            tankR = ImageIO.read(Main.class.getClassLoader().getResource("image/tankimage.gif"));
            tankU = ImageIO.read(Main.class.getClassLoader().getResource("image/tankimage.gif"));
            tankD = ImageIO.read(Main.class.getClassLoader().getResource("image/tankimage.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
