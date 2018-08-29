package UI;

import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {

    public StatusWindow status;
    public CommandWindow command;
    public WorkingSurface workspace;

    public MainFrame(String CNC){
        super (CNC);

        //layout Manager
        setLayout(new BorderLayout());

        //Swing components
        workspace = new WorkingSurface();
        status = new StatusWindow();
        command= new CommandWindow();

        //Add components to content pane
        Container c = getContentPane();

        c.add(workspace, BorderLayout.WEST);
        c.add(status, BorderLayout.EAST);
        c.add(command, BorderLayout.SOUTH);


    }
}
