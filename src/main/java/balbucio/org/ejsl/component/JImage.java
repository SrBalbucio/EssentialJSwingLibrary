package balbucio.org.ejsl.component;

import balbucio.org.ejsl.utils.ImageUtils;

import javax.swing.*;
import java.awt.*;

public class JImage extends JComponent {

    private Image orginalImage;
    private Image image;
    private boolean blur = false;
    private boolean center = false;
    private boolean maxSize = false;

    public JImage(Image img){
        this.orginalImage = img;
        this.setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
    }

    public JImage(Image image, Color bg){
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
        g2.setColor(getBackground());
        g2.fillRect(0, 0, this.getWidth(), this.getHeight());
        if(maxSize){
            Dimension dimension = ImageUtils.getProportion(this.getSize().width, this.getSize().height, orginalImage);
            image = ImageUtils.resizeImage(orginalImage, dimension.width, dimension.height, getBackground());
        } else {
            image = ImageUtils.resizeImage(orginalImage, this.getWidth(), getHeight(), getBackground());
        }
        if(blur && !blurIsApplied){
            image = ImageUtils.addBlur(image);
        }
        if (image != null) {
            if (!center) {
                g2.drawImage(image, this.getX(), this.getY(), this);
            } else {
                g2.drawImage(image, (this.getWidth() / 2 - (image.getWidth(this) / 2)),
                        (this.getHeight() / 2 - (image.getHeight(this) / 2)), this);
            }
        }
    }
}
