package UI;

import javax.swing.*;
import javax.swing.*;
import java.awt.*;

public class StatusWindow extends JPanel {
    public StatusWindow(){
        // general Settings
        Dimension size= getPreferredSize();
        size.width = 200;
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("Status"));

        // Labels//
        JLabel currentpositionLabel = new JLabel("Current Position (X/Y):");
        currentpositionLabel.setFont(new Font("Serif", Font.PLAIN, 12));
        JLabel currentposition = new JLabel("0/0");
        currentposition.setFont(new Font("Serif", Font.BOLD, 12));

        JLabel drillstatusLabel = new JLabel("Drill Status:");
        drillstatusLabel.setFont(new Font("Serif", Font.PLAIN, 12));
        JLabel drillstatus = new JLabel("OFF");
        drillstatus.setFont(new Font("Serif", Font.BOLD, 12));

        JLabel coolingLabel = new JLabel("Cooling Status:");
        coolingLabel.setFont(new Font("Serif", Font.PLAIN, 12));
        JLabel cooling =new JLabel("OFF");
        cooling.setFont(new Font("Serif", Font.BOLD, 12));

        JLabel speedLabel = new JLabel("Current Speed (m/s):");
        speedLabel.setFont(new Font("Serif", Font.PLAIN, 12));
        JLabel speed = new JLabel("0");
        speed.setFont(new Font("Serif", Font.BOLD, 12));
        // Grid settings
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        //First column
        gc.anchor = GridBagConstraints.LINE_START;
        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 0;
        gc.gridy = 0;
        add(currentpositionLabel, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        add(drillstatusLabel, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        add(coolingLabel, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        add(speedLabel, gc);

        //Second Column
        gc.anchor = GridBagConstraints.LINE_START;
        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 1;
        gc.gridy = 0;
        add(currentposition, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        add(drillstatus, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        add(cooling, gc);

        gc.gridx = 1;
        gc.gridy = 3;
        add(speed, gc);
    }
}
