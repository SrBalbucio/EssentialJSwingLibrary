import balbucio.org.ejsl.component.progressbar.JProgressBarWithBorders;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ProgressBarWithBordersTest {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Teste do ProgressBar");
        frame.setLayout(new BorderLayout());
        frame.setSize(640, 320);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        JProgressBarWithBorders b = new JProgressBarWithBorders(100);
        b.setBorder(new EmptyBorder(10, 10, 10, 10));
        b.setPreferredSize(new Dimension(640, 25));
        b.setPosition(20);
        frame.add(b, BorderLayout.NORTH);
        frame.setVisible(true);
    }
}
