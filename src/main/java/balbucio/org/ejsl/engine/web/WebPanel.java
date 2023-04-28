package balbucio.org.ejsl.engine.web;

import balbucio.org.ejsl.engine.EJSLGraphics;
import balbucio.org.ejsl.engine.RenderResult;
import org.jsoup.nodes.Document;

import javax.swing.*;
import javax.swing.text.html.HTML;
import java.awt.*;

public class WebPanel extends JPanel {

    private Document html;
    private int x, y;

    public WebPanel(Document html){
        this.html = html;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        x = this.getX() + 20;
        y = this.getY() + 20;
        EJSLGraphics render = new EJSLGraphics(g); // inicia o helper de renderização
        EJSLGraphics.WebGraphics webrender = render.getWebGraphics();

        html.body().getAllElements().forEach(es -> {
            switch(es.tag().getName()){
                case "h1" -> {
                    RenderResult result = webrender.renderH1(x, y, es.text());
                    y = result.getY();
                }
                case "h2" -> {
                    RenderResult result = webrender.renderH2(x, y, es.text());
                    y = result.getY();
                }
                case "h3" -> {
                    RenderResult result = webrender.renderH3(x, y, es.text());
                    y = result.getY();
                }
                case "h4" -> {
                    RenderResult result = webrender.renderH4(x, y, es.text());
                    y = result.getY();
                }
            }
        });
    }
}
