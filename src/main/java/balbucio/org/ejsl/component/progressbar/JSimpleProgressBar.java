package balbucio.org.ejsl.component.progressbar;

import javax.swing.*;
import java.awt.*;

public class JSimpleProgressBar extends JComponent {

    private int total;
    private int position = 100;
    private String text = "Loading {porcentage}%";
    public JSimpleProgressBar(int total){
        this.total = total;
        this.setPreferredSize(new Dimension(480, 20));
    }

    public void setPosition(int position){
        this.position = position == 0 ? 1 : position;
        this.revalidate();
        this.repaint();
    }

    public int getPosition() {
        return position;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        Stroke s = new BasicStroke(4f);
        g2.setStroke(s);
        g2.setColor(Color.DARK_GRAY);
        g2.fillRect(0, 0, this.getWidth(), this.getHeight());
        g2.setStroke(new BasicStroke(0f));
        g2.setColor(Color.orange);
        int c1 = this.getWidth() * position;
        int c2 = c1 / 100;
        g2.fillRect(0, 0, c2, this.getHeight());
        g2.setColor(Color.WHITE);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 12));
        g2.drawString(text.replace("{porcentage}", String.valueOf(position)), (this.getWidth() / 2 - (g2.getFontMetrics().stringWidth(text.replace("{porcentage}", String.valueOf(position))) / 2)), (this.getHeight() / 2 + (g2.getFontMetrics().getHeight() / 3)));
    }
}
