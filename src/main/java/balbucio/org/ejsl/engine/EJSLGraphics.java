package balbucio.org.ejsl.engine;

import org.jsoup.nodes.Element;

import javax.swing.text.html.HTML;
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
            Font font = defaultGraphics.getFont().deriveFont(Font.PLAIN, 20);
            Graphics2D graphics = (Graphics2D) defaultGraphics.create();
            graphics.setFont(font);
            graphics.drawString(text, x, y);
            return new RenderResult(x+graphics.getFontMetrics().stringWidth(text), y + font.getSize());
        }

        public RenderResult renderH2(int x, int y, String text){
            Font font = defaultGraphics.getFont().deriveFont(Font.PLAIN, 18);
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
            Font font = defaultGraphics.getFont().deriveFont(Font.PLAIN, 14);
            Graphics2D graphics = (Graphics2D) defaultGraphics.create();
            graphics.setFont(font);
            graphics.drawString(text, x, y);
            return new RenderResult(x+graphics.getFontMetrics().stringWidth(text), y + font.getSize());
        }

    }
}
