package UI;
import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;

public class WorkingSurface extends JPanel {
    public WorkingSurface() {
        Dimension size = getPreferredSize();
        size.height = 545;
        size.width = 730;
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("Workspace"));

    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.GRAY);
        g.fillRect(10,20,700,525);
        g.setColor(Color.BLACK);
        g.drawRect(10, 20,700,525 );
    }
}