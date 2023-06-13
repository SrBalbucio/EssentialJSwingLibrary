import balbucio.org.ejsl.component.JImage;
import balbucio.org.ejsl.utils.ImageUtils;

import javax.swing.*;
import java.awt.*;

public class ImagePanelTest {

    public static void main(String[] args) {
        new ImagePanelTest();
    }

    public ImagePanelTest(){
        JFrame frame = new JFrame();
        frame.setBackground(Color.CYAN);
        frame.setSize(640, 480);
        frame.setLayout(new BorderLayout());
        JImage panel = new JImage(ImageUtils.getImage(this.getClass().getResourceAsStream("/images/img.png")), Color.CYAN);
        panel.setMaxSize(true);
        panel.setCenter(true);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
