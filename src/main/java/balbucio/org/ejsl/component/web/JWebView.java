package balbucio.org.ejsl.component.web;

import balbucio.org.ejsl.engine.web.WebPanel;
import org.jsoup.Jsoup;

import javax.swing.*;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class JWebView extends JPanel{

    private WebPanel panel;
    private JScrollPane scroll;
    private HTMLEditorKit kit;

    public JWebView(String html){
        super(new BorderLayout());
        this.panel = new WebPanel(Jsoup.parse(html));
        panel.setSize(this.getSize());
        this.add(panel, BorderLayout.CENTER);
    }

    public JWebView(URL url) throws IOException {
        super(new BorderLayout());
        this.panel = new WebPanel(Jsoup.parse(url, 2000));
        panel.setSize(this.getSize());
        this.add(panel, BorderLayout.CENTER);
    }

    public void setURL(String url) {
    }
}
