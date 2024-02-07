package balbucio.org.ejsl.component.panel;

import javax.swing.*;
import java.awt.*;

public abstract class BorderedPanel extends JPanel {

    public BorderedPanel(){
        super(new BorderLayout());
        this.add(getNorthPanel(), BorderLayout.NORTH);
        this.add(getSouthPanel(), BorderLayout.SOUTH);
        this.add(getWestPanel(), BorderLayout.WEST);
        this.add(getEastPanel(), BorderLayout.EAST);
        this.add(getCenterPanel(), BorderLayout.CENTER);
    }

    public JPanel getNorthPanel(){ return new JPanel(); }
    public JPanel getSouthPanel(){ return new JPanel(); }
    public JPanel getWestPanel(){ return new JPanel(); }
    public JPanel getEastPanel(){ return new JPanel(); }
    public JPanel getCenterPanel(){ return new JPanel(); }
}
