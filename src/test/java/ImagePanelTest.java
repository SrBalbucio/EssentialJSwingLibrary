import balbucio.org.ejsl.component.panel.JImagePanel;
import balbucio.org.ejsl.utils.ImageUtils;

import javax.swing.*;
import java.awt.*;

public class ImagePanelTest {

    public static void main(String[] args) {
        new ImagePanelTest();
    }

    public ImagePanelTest(){
        JFrame frame = new JFrame();
        frame.setSize(640, 480);
        frame.setLayout(new BorderLayout());
        JImagePanel panel = new JImagePanel(ImageUtils.getImage(this.getClass().getResourceAsStream("/images/img.png")));
        panel.setMaxSize(true);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
