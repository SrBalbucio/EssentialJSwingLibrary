package balbucio.org.ejsl.component.panel;

import balbucio.org.ejsl.utils.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class JImagePanel extends JPanel {

    private Image image;
    private boolean blur;
    private boolean center;
    private boolean maxSize;

    public JImagePanel(Image image){
        this.image = image;
        this.setPreferredSize(new Dimension(image.getWidth(null), image.getHeight(null)));
    }

    public JImagePanel(Image image, Color bg){
        this(image);
        this.setBackground(bg);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public boolean isBlur() {
        return blur;
    }

    public void setBlur(boolean blur) {
        this.blur = blur;
    }

    public boolean isCenter() {
        return center;
    }

    public void setCenter(boolean center) {
        this.center = center;
    }

    public boolean isMaxSize() {
        return maxSize;
    }

    public void setMaxSize(boolean maxSize) {
        this.maxSize = maxSize;
    }

    private boolean blurIsApplied = false;
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setBackground(getBackground());
        if(maxSize){
            image = ImageUtils.resizeImage(image, this.getWidth(), this.getWidth());
        }
        if(blur && !blurIsApplied){
            image = ImageUtils.addBlur(image);
        }
        if (image != null) {
            if (!center) {
                g2.drawImage(image, 0, 0, this);
            } else {
                g2.drawImage(image, (this.getWidth() / 2 - (image.getWidth(this) / 2)),
                        (this.getHeight() / 2 - (image.getHeight(this) / 2)), this);
            }
        }
    }
}
