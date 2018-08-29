package UI;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

        public void createSurface(){
            JFrame frame = new MainFrame("CNC UI");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000,750);
            frame.setVisible(true);
        }

}