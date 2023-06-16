package balbucio.org.ejsl.component;

import balbucio.org.ejsl.event.ClickListener;
import balbucio.org.ejsl.utils.ColorUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EJSLButton extends JComponent implements MouseListener {

    private List<ClickListener> clickListeners = new ArrayList<>();
    private String text;
    private Type buttonType = Type.COLOR;
    private Color primaryColor = ColorUtils.hexToRgb("#212529");
    private Color secundaryColor = ColorUtils.hexToRgb("#495057");
    private Color textColor = Color.WHITE;
    private Color selectedTextColor = Color.YELLOW;
    private int fontSize = 12;
    private boolean hovered = false;
    private boolean animation = true;
    private boolean selected = false;

    public EJSLButton(String text) {
        this();
        this.text = text;
    }

    public EJSLButton(String text, Color primaryColor, Color secundaryColor) {
        this();
        this.text = text;
        this.primaryColor = primaryColor;
        this.secundaryColor = secundaryColor;
    }

    public EJSLButton(String text, Type buttonType, Color primaryColor, Color secundaryColor) {
        this();
        this.text = text;
        this.buttonType = buttonType;
        this.primaryColor = primaryColor;
        this.secundaryColor = secundaryColor;
    }

    public EJSLButton(){
        this.addMouseListener(this);
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
        return secundaryColor;
    }

    public void setSecundaryColor(Color secundaryColor) {
        this.secundaryColor = secundaryColor;
    }

    public Color getTextColor() {
        return textColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }

    public List<ClickListener> getClickListeners() {
        return clickListeners;
    }

    public void setClickListeners(List<ClickListener> clickListeners) {
        this.clickListeners = clickListeners;
    }

    public Color getSelectedTextColor() {
        return selectedTextColor;
    }

    public void setSelectedTextColor(Color selectedTextColor) {
        this.selectedTextColor = selectedTextColor;
    }

    public boolean isHovered() {
        return hovered;
    }

    public void setHovered(boolean hovered) {
        this.hovered = hovered;
    }

    public boolean isAnimation() {
        return animation;
    }

    public void setAnimation(boolean animation) {
        this.animation = animation;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setFont(getFont());
        g2.setFont(!selected ? g2.getFont().deriveFont(Font.PLAIN, fontSize) : g2.getFont().deriveFont(Font.BOLD, fontSize));
        Dimension dimension = new Dimension(0,0);
        dimension.width = (g2.getFontMetrics().stringWidth(text) + (5 * 2));
        dimension.height = (g2.getFontMetrics().getHeight()) + (5*2);
        this.setPreferredSize(dimension);
        if(buttonType == Type.COLOR){
            g2.setColor(selected ? secundaryColor : primaryColor);
            g2.setBackground(selected ? secundaryColor : primaryColor);
            g2.fillRect(0, 0, this.getWidth(), this.getHeight());
            g2.setColor(hovered && animation ? selectedTextColor : textColor);
            g2.drawString(text, (this.getWidth() / 2 - (g2.getFontMetrics().stringWidth(text)) / 2), (this.getHeight() / 2 + (g2.getFontMetrics().getHeight() / 3)));
        }
        revalidate();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        clickListeners.forEach(l -> l.click(this));
        setSelected(!selected);
        revalidate();
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        hovered = true;
        revalidate();
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        hovered = false;
        revalidate();
        repaint();
    }

    public enum Type{
        COLOR
    }

}
