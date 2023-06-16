import balbucio.org.ejsl.EJSL;
import balbucio.org.ejsl.component.EJSLButton;

import javax.swing.*;
import java.awt.*;

public class ButtonTeste {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(640, 640);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        EJSLButton b = new EJSLButton("Option Variable");
        frame.add(b, gbc);
        frame.setVisible(true);
    }
}
