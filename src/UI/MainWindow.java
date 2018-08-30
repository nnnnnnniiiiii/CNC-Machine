package UI;
import javax.swing.*;

public class MainWindow extends JFrame {

        public void createSurface(){
            JFrame frame = new MainFrame("CNC Machine");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000,750);
            frame.setVisible(true);
        }


}