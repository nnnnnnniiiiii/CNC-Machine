package UI;
import Logging.LogClass;
import Settings.readJsonSettings;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class CommandWindow extends JPanel {
    String[] commands = {"G00", "G01","G02","G03","G28","M00","M02","M03","M04","M05","M08","M09","M13","M14"};

    public CommandWindow() {
        //Create read Settings Object
        readJsonSettings currentSettings = new readJsonSettings();
        currentSettings.readJson();
        LogClass editLog = new LogClass(currentSettings.intNumberLogEntries);



        // general Settings
        Dimension size = getPreferredSize();
        size.height = 150;
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("Commands"));

        //Labels
        JLabel selectcommandsLabel = new JLabel("Command:");
        selectcommandsLabel.setFont(new Font("Serif", Font.PLAIN, 14));

        //JLabel uploadfileLabel = new JLabel("Upload XML File:");
        //uploadfileLabel.setFont(new Font("Serif", Font.PLAIN, 14));

        JLabel xcoordinateLabel = new JLabel("Enter X Coordinate:");
        xcoordinateLabel.setFont(new Font("Serif", Font.PLAIN, 14));

        JLabel ycoordinateLabel = new JLabel("Enter Y Coordinate:");
        ycoordinateLabel.setFont(new Font("Serif", Font.PLAIN, 14));

        //Textfields

        JTextField x = new JTextField(2);
        JTextField y = new JTextField(2);

        //Textarea
        JTextArea log = new JTextArea();
        log.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        log.setBackground(Color.BLACK);
        log.setCaretColor(Color.green);
        log.setForeground(Color.green);

        //Buttons
        JButton runCommand = new JButton("Add to Que");
        runCommand.setFont(new Font("Serif",Font.PLAIN,12));
        JButton stop = new JButton("Emergency Stop");
        stop.setFont(new Font("Serif",Font.BOLD,20));
        //stop.setSize(10,10);

        //JButton uploadfile = new JButton("Upload Commandsequence");
        //uploadfile.setFont(new Font("Serif",Font.PLAIN,12));

        //Combo Box
        JComboBox commandlist = new JComboBox(commands);

        //File Chooser
        JFileChooser uploadfiles = new JFileChooser();

        // Grid settings
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        //First column
        gc.anchor = GridBagConstraints.LINE_START;
        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 0;
        gc.gridy = 0;
        add(selectcommandsLabel, gc);

       // gc.gridx = 0;
       // gc.gridy = 1;
       // add(uploadfileLabel, gc);

        //Second column
        gc.anchor = GridBagConstraints.LINE_START;
        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 1;
        gc.gridy = 0;
        add(commandlist, gc);

       // gc.gridx = 1;
        //gc.gridy = 1;
        //add(uploadfile, gc);

        //Third column
        gc.anchor = GridBagConstraints.LINE_START;
        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 2;
        gc.gridy = 0;
        add(xcoordinateLabel, gc);

        gc.gridx = 2;
        gc.gridy = 1;
        add(ycoordinateLabel, gc);

        //Fourth column
        gc.anchor = GridBagConstraints.LINE_START;
        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 3;
        gc.gridy = 0;
        add(x, gc);

        gc.gridx = 3;
        gc.gridy = 1;
        add(y, gc);

        //Fifth column
        gc.anchor = GridBagConstraints.LINE_START;
        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 4;
        gc.gridy = 0;
        add(runCommand, gc);



        //Sixth Column
        gc.fill = GridBagConstraints.VERTICAL;
        gc.weightx =1;
        gc.weighty=1;

        gc.gridheight=2;
        gc.gridx = 5;
        gc.gridy = 0;
        add(stop, gc);

        //Seventh Column
        gc.fill=GridBagConstraints.BOTH;
        gc.weightx=10;
        gc.weighty=1;

        gc.gridx=6;
        gc.gridy=0;
        add(log,gc);

        //File chooser
        //JFileChooser fc = new JFileChooser();
        //fc.setFileFilter(new FileNameExtensionFilter("XML-Files only", "xml"));


        //Button action uploadfile
        //uploadfile.addActionListener(new ActionListener() {
         //   @Override
        //    public void actionPerformed(ActionEvent e) {
        //        fc.showOpenDialog(CommandWindow.this);
         //   }
        //});

        //Button action Add to que
        runCommand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String command = (String) commandlist.getSelectedItem();
                try {
                    editLog.logMethod(command);
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }

            }
        });
        // Button action stop
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log.append("Program stopped!\n");
            }
        });
    }
    private void createNewLogEntry(){


    }
}
