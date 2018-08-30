package UI;

import Methods.MMethods;
import Methods.StatusValues;
import Settings.ReadJsonSettings;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {

    public StatusWindow status;
    public CommandWindow command;
    public WorkingSurface workspace;
    public ReadJsonSettings jsonSettings;

    StatusValues statValues = new StatusValues();
    MMethods mMethods;

    public MainFrame(String CNCMachine){
        super (CNCMachine);
         jsonSettings = new ReadJsonSettings();
         jsonSettings.readJson();

        //layout Manager
        setLayout(new BorderLayout());

        workspace = new WorkingSurface();
        status = new StatusWindow(statValues, jsonSettings);
        mMethods = new MMethods(statValues,status,this, jsonSettings);
        command = new CommandWindow(this,mMethods);

        //Add components to content pane
        Container c = getContentPane();

        c.add(workspace, BorderLayout.WEST);
        c.add(status, BorderLayout.EAST);
        c.add(command, BorderLayout.SOUTH);

    }

    public void reloadStatus(){
        status.repaint();
        status.revalidate();
    }
}
