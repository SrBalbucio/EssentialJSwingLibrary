package balbucio.org.ejsl.component.card;

import balbucio.org.ejsl.component.JImage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class JCard extends JPanel {

    private JImage panel;
    private JLabel title;
    private JLabel description;
    public JCard(Image img, String title, String description){
        this.setBorder(new EmptyBorder(15, 15, 15, 15));
        this.setLayout(new GridLayout(3, 1));
        this.title = new JLabel(title);
    }
}
