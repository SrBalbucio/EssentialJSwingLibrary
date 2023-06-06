package frame;

import balbucio.org.ejsl.frame.JLoadingFrame;
import balbucio.org.ejsl.utils.ImageUtils;

import java.util.Timer;

public class LoadingFrameTest {

    public static void main(String[] args) throws InterruptedException {
        JLoadingFrame lf = new JLoadingFrame("TESTE",
                ImageUtils.getImage("https://ifflab.org/wp-content/uploads/2019/04/60-The-5-Latest-Cyber-Security-Technologies-for-Your-Business.jpg"), 100);
        lf.setPosition(20);
        Thread.sleep(1000*10);
        lf.setPosition(40);
        Thread.sleep(1000*10);
        lf.setPosition(80);
        Thread.sleep(1000*10);
        lf.setPosition(100);
    }
}
