package balbucio.org.ejsl.frame;

import balbucio.org.ejsl.component.JImage;
import balbucio.org.ejsl.component.progressbar.JSimpleProgressBar;

import javax.swing.*;
import java.awt.*;

public class JLoadingFrame extends JFrame {

    private JImage logo;
    private JSimpleProgressBar progressBar;
    public JLoadingFrame(String title, Image imgLogo, int total){
        super(title);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setUndecorated(true);
        this.setSize(620, 360);
        this.setLayout(new BorderLayout());
        this.logo = new JImage(imgLogo);
        this.progressBar = new JSimpleProgressBar(total);
        this.add(logo, BorderLayout.CENTER);
        this.add(progressBar, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public void setPosition(int position){
        this.progressBar.setPosition(position);
    }
}
