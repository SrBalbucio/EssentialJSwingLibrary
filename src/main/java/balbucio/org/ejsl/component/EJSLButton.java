package balbucio.org.ejsl.component;

import javax.swing.*;
import java.awt.*;

public class EJSLButton extends JComponent {

    private String text;
    private Type buttonType;
    private Color primaryColor;
    private Color SecundaryColor;
    private Color textColor = Color.WHITE;

    public EJSLButton(String text, Color primaryColor, Color secundaryColor) {
        this.text = text;
        this.primaryColor = primaryColor;
        SecundaryColor = secundaryColor;
    }

    public EJSLButton(String text, Type buttonType, Color primaryColor, Color secundaryColor) {
        this.text = text;
        this.buttonType = buttonType;
        this.primaryColor = primaryColor;
        this.SecundaryColor = secundaryColor;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Type getButtonType() {
        return buttonType;
    }

    public void setButtonType(Type buttonType) {
        this.buttonType = buttonType;
    }

    public Color getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(Color primaryColor) {
        this.primaryColor = primaryColor;
    }

    public Color getSecundaryColor() {
        return SecundaryColor;
    }

    public void setSecundaryColor(Color secundaryColor) {
        SecundaryColor = secundaryColor;
    }

    public Color getTextColor() {
        return textColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        Dimension dimension = new Dimension(0,0);
        dimension.width = (g2.getFontMetrics().stringWidth(text) + (5 * 2));
        dimension.height = (g2.getFontMetrics().getHeight()) + (5*2);
        this.setPreferredSize(dimension);
        if(buttonType == Type.COLOR){
            g2.fillRect(0, 0, this.getWidth(), this.getHeight());
            g2.setColor(textColor);
            g2.drawString(text, (this.getWidth() / 2 - (g2.getFontMetrics().stringWidth(text)) / 2), (this.getHeight() / 2 + (g2.getFontMetrics().getHeight() / 3)));
        }
        revalidate();
    }

    public enum Type{
        COLOR
    }

}
