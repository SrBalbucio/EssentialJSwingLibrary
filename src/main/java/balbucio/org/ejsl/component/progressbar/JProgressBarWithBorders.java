package balbucio.org.ejsl.component.progressbar;

import javax.swing.*;
import java.awt.*;

public class JProgressBarWithBorders extends JComponent {
    private int total;
    private int position = 100;
    public JProgressBarWithBorders(int total){
        this.total = total;
    }

    public void setPosition(int position){
        this.position = position == 0 ? 1 : position;
    }

    public int getPosition() {
        return position;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        Stroke s = new BasicStroke(4f);
        g2.setStroke(s);
        g2.setColor(Color.WHITE);
        g2.drawRect(0, 0, this.getWidth(), this.getHeight());
        g2.setStroke(new BasicStroke(0f));
        int c1 = this.getWidth() * position;
        int c2 = c1 / 100;
        int result = position != 100 ? (c2 - 6) : (this.getWidth() - 6);
        g2.fillRect(3, 3, result, this.getHeight() - 6);
    }
}
