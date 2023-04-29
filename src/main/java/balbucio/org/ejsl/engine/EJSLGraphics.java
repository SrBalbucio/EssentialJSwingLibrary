package balbucio.org.ejsl.engine;

import java.awt.*;

public class EJSLGraphics {

    private Graphics defaultGraphics;
    private WebGraphics webGraphics;

    public EJSLGraphics(Graphics graphics) {
        this.defaultGraphics = graphics;
        this.webGraphics = new WebGraphics();
    }

    public WebGraphics getWebGraphics() {
        return webGraphics;
    }

    public Font createFont(String fontName, int size){
        Font font = new Font(fontName, Font.PLAIN, size);
        return font;
    }

    public class WebGraphics{

        public WebGraphics(){

        }

        public RenderResult renderH1(int x, int y, String text){
            Font font = defaultGraphics.getFont().deriveFont(Font.PLAIN, 24);
            Graphics2D graphics = (Graphics2D) defaultGraphics.create();
            graphics.setFont(font);
            graphics.drawString(text, x, y);
            return new RenderResult(x+graphics.getFontMetrics().stringWidth(text), y + font.getSize());
        }

        public RenderResult renderH2(int x, int y, String text){
            Font font = defaultGraphics.getFont().deriveFont(Font.PLAIN, 20);
            Graphics2D graphics = (Graphics2D) defaultGraphics.create();
            graphics.setFont(font);
            graphics.drawString(text, x, y);
            return new RenderResult(x+graphics.getFontMetrics().stringWidth(text), y + font.getSize());
        }
        public RenderResult renderH3(int x, int y, String text){
            Font font = defaultGraphics.getFont().deriveFont(Font.PLAIN, 16);
            Graphics2D graphics = (Graphics2D) defaultGraphics.create();
            graphics.setFont(font);
            graphics.drawString(text, x, y);
            return new RenderResult(x+graphics.getFontMetrics().stringWidth(text), y + font.getSize());
        }
        public RenderResult renderH4(int x, int y, String text){
            Font font = defaultGraphics.getFont().deriveFont(Font.PLAIN, 12);
            Graphics2D graphics = (Graphics2D) defaultGraphics.create();
            graphics.setFont(font);
            graphics.drawString(text, x, y);
            return new RenderResult(x+graphics.getFontMetrics().stringWidth(text), y + font.getSize());
        }

        public RenderResult renderH5(int x, int y, String text){
            Font font = defaultGraphics.getFont().deriveFont(Font.PLAIN, 10);
            Graphics2D graphics = (Graphics2D) defaultGraphics.create();
            graphics.setFont(font);
            graphics.drawString(text, x, y);
            return new RenderResult(x+graphics.getFontMetrics().stringWidth(text), y + font.getSize());
        }

        public RenderResult renderImg(int x, int y, Image image){
            Graphics2D graphics = (Graphics2D) defaultGraphics.create();
            graphics.drawImage(image, x,y, null);
            return new RenderResult(x+image.getWidth(null), y+image.getHeight(null));
        }

        public RenderResult renderButton(int x, int y, String text){
            Font font = defaultGraphics.getFont().deriveFont(Font.PLAIN, 12);
            Graphics2D graphics = (Graphics2D) defaultGraphics.create();
            graphics.setFont(font);
            graphics.setBackground(Color.WHITE);
            int height, width;
            width = graphics.getFontMetrics().stringWidth(text) + (2*5);
            height = graphics.getFontMetrics().getHeight() + (2*5);
            graphics.setColor(Color.DARK_GRAY);
            graphics.drawRoundRect(x, y, width, height, 7, 7);
            graphics.setColor(Color.BLACK);
            graphics.drawString(text, (width / 2 - (graphics.getFontMetrics().stringWidth(text) / 2))+x, (height / 2 + (graphics.getFontMetrics().getHeight() / 3))+y);
            return new RenderResult(x+width, y+height);
        }
    }
}
