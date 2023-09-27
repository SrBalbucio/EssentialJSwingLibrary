package balbucio.org.ejsl.component.panel;

import javax.swing.*;
import java.awt.*;

public class JCornerPanel extends JPanel {
    private Color background;
    private int cornerRadius;

    public JCornerPanel(Color background, int cornerRadius) {
        this.background = background;
        this.cornerRadius = cornerRadius;
    }

    public JCornerPanel(LayoutManager manager, Color background, int cornerRadius) {
        super(manager);
        this.background = background;
        this.cornerRadius = cornerRadius;
    }

    @Override
    public Color getBackground() {
        return background;
    }

    @Override
    public void setBackground(Color background) {
        this.background = background;
    }

    public int getCornerRadius() {
        return cornerRadius;
    }

    public void setCornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(background);
        g2.fillRoundRect(0, 0, this.getWidth(), this.getHeight(),cornerRadius, cornerRadius);
        g2.dispose();
    }
}
