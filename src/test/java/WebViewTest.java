import balbucio.org.ejsl.component.web.JWebView;

import javax.swing.*;
import java.awt.*;

public class WebViewTest {

    public static void main(String[] args) {
        try {
            JFrame frame = new JFrame("WebView Teste");
            frame.setLayout(new BorderLayout());
            frame.setSize(640, 480);
            JWebView web = new JWebView("");
            frame.add(web, BorderLayout.CENTER);
            frame.setVisible(true);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
