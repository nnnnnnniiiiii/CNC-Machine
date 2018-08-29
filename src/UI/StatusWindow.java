package UI;

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
        JLabel xCurrentPositionLabel = new JLabel("Current X-Position:");
        xCurrentPositionLabel.setFont(new Font("Serif", Font.PLAIN, 12));
        JLabel xCurrentPosition = new JLabel("0");
        xCurrentPosition.setFont(new Font("Serif", Font.BOLD, 12));

        JLabel yCurrentPositionLabel = new JLabel("Current Y-Position:");
        yCurrentPositionLabel.setFont(new Font("Serif", Font.PLAIN, 12));
        JLabel yCurrentPosition = new JLabel("0");
        yCurrentPosition.setFont(new Font("Serif", Font.BOLD, 12));

        JLabel drillstatusLabel = new JLabel("Drill Status:");
        drillstatusLabel.setFont(new Font("Serif", Font.PLAIN, 12));
        JLabel drillstatus = new JLabel("OFF");
        drillstatus.setFont(new Font("Serif", Font.BOLD, 12));

        JLabel drillDirectionLabel = new JLabel("Drill Direction:");
        drillstatusLabel.setFont(new Font("Serif", Font.PLAIN, 12));
        JLabel drillDirection = new JLabel("None");
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
        add(xCurrentPositionLabel, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        add(yCurrentPositionLabel, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        add(drillstatusLabel, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        add(drillDirectionLabel, gc);

        gc.gridx = 0;
        gc.gridy = 4;
        add(coolingLabel, gc);

        gc.gridx = 0;
        gc.gridy = 5;
        add(speedLabel, gc);

        //Second Column
        gc.anchor = GridBagConstraints.LINE_START;
        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 1;
        gc.gridy = 0;
        add(xCurrentPosition, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        add(yCurrentPosition, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        add(drillstatus, gc);

        gc.gridx = 1;
        gc.gridy = 3;
        add(drillDirection, gc);

        gc.gridx = 1;
        gc.gridy = 4;
        add(cooling, gc);

        gc.gridx = 1;
        gc.gridy = 5;
        add(speed, gc);
    }
}
