import balbucio.org.ejsl.component.EJSLButton;

import javax.swing.*;
import java.awt.*;

public class ButtonTeste {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(640, 640);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        frame.add(new EJSLButton("Option Variable", EJSLButton.Type.COLOR, Color.DARK_GRAY, Color.BLACK), gbc);
        frame.setVisible(true);
    }
}
