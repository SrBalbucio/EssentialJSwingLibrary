import balbucio.org.ejsl.component.web.JWebView;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class WebViewTest {

    public static void main(String[] args) {
        new WebViewTest();
    }

    public WebViewTest(){
        try {
            JFrame frame = new JFrame("WebView Teste");
            frame.setLayout(new BorderLayout());
            frame.setSize(640, 480);
            Scanner scanner = new Scanner(this.getClass().getResourceAsStream("/html/HTMLPuroTest.html"));
            String html = new String();
            while(scanner.hasNext()) {
                html += scanner.nextLine();
            }
            JWebView web = new JWebView(html);
            frame.add(web, BorderLayout.CENTER);
            frame.setVisible(true);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
