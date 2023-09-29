package balbucio.org.ejsl.engine.web;

import balbucio.org.ejsl.engine.EJSLGraphics;
import balbucio.org.ejsl.engine.RenderResult;
import balbucio.org.ejsl.utils.ImageUtils;
import org.jsoup.nodes.Document;

import javax.swing.*;
import javax.swing.text.html.HTML;
import java.awt.*;

public class WebPanel extends JPanel {

    private Document html;
    private int x, y;

    public WebPanel(Document html){
        this.html = html;
        this.setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        x = this.getX() + 10;
        y = this.getY() + 40;
        EJSLGraphics render = new EJSLGraphics(g); // inicia o helper de renderização
        EJSLGraphics.WebGraphics webrender = render.getWebGraphics();
        final RenderResult[] result = {new RenderResult(1, 1)};

        html.body().getAllElements().forEach(es -> {
            switch(es.tag().getName()){
                case "h1":
                    result[0] = webrender.renderH1(x, y, es.text());
                    y = result[0].getY() + 10;
                    break;
                case "h2":
                    result[0] = webrender.renderH2(x, y, es.text());
                    y = result[0].getY() + 10;
                    break;
                case "h3":
                    result[0] = webrender.renderH3(x, y, es.text());
                    y = result[0].getY() + 10;
                break;
                case "h4":
                    result[0] = webrender.renderH4(x, y, es.text());
                    y = result[0].getY() + 10;
                    break;
                case "h5":
                    result[0] = webrender.renderH5(x, y, es.text());
                    y = result[0].getY() + 10;
                    break;
                case "img":
                    result[0] = webrender.renderImg(x, y, ImageUtils.getImage(es.attr("src")));
                    y = result[0].getY() + 10;
                    break;
                case "br":
                    y = result[0].getY() + 10;
                    break;
                case "p":
                    result[0] = webrender.renderP(x, y, es.text());
                    y = result[0].getY() + 10;
                    break;
                case "button":
                    result[0] = webrender.renderButton(x, y, es.text());
                    break;
            }
        });
    }
}
