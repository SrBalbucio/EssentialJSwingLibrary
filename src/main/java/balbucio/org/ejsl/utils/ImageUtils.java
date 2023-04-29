package balbucio.org.ejsl.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.net.URL;

public class ImageUtils {

    public static Image getImage(String u){
        try{
            URL url = new URL(u);
            return ImageIO.read(url);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
