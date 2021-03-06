package UI;
import Logging.LogClass;
import Methods.G01;
import Methods.G02;
import Methods.MMethods;
import Settings.ReadJsonSettings;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class CommandWindow extends JPanel {

    private final MainFrame frame;
    private final MMethods mMethods;
    String[] commands = {"G00", "G01","G02","G03","G28","M00","M02","M03","M04","M05","M08","M09","M13","M14"};

    public CommandWindow(MainFrame frame, MMethods mMethods) {
        this.frame = frame;
        this.mMethods = mMethods;
        //Create read Settings Object
        ReadJsonSettings currentSettings = new ReadJsonSettings();
        currentSettings.readJson();
        LogClass editLog = new LogClass(currentSettings.intNumberLogEntries);

        //Create Method Objects
        G01 runG01 = new G01();
        G02 runG02 = new G02();



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

        JLabel xCoordinateLabel = new JLabel("Enter X Coordinate:");
        xCoordinateLabel.setFont(new Font("Serif", Font.PLAIN, 14));

        JLabel yCoordinateLabel = new JLabel("Enter Y Coordinate:");
        yCoordinateLabel.setFont(new Font("Serif", Font.PLAIN, 14));

        JLabel iCoordinateLabel = new JLabel("Enter I Coordinate:");
        iCoordinateLabel.setFont(new Font("Serif", Font.PLAIN, 14));

        JLabel jCoordinateLabel = new JLabel("Enter J Coordinate:");
        jCoordinateLabel.setFont(new Font("Serif", Font.PLAIN, 14));

        //Textfields

        JTextField x = new JTextField(2);
        JTextField y = new JTextField(2);
        JTextField i = new JTextField(2);
        JTextField j = new JTextField(2);

        //Textarea
        JTextArea log = new JTextArea();
        log.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        log.setEditable(false); // set textArea non-editable
        log.setBackground(Color.BLACK);
        log.setCaretColor(Color.green);
        log.setForeground(Color.green);
        JScrollPane scroll = new JScrollPane(log);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);


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
        add(xCoordinateLabel, gc);

        gc.gridx = 2;
        gc.gridy = 1;
        add(yCoordinateLabel, gc);

        gc.gridx = 2;
        gc.gridy = 2;
        add(iCoordinateLabel, gc);

        gc.gridx = 2;
        gc.gridy = 3;
        add(jCoordinateLabel, gc);

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

        gc.gridx = 3;
        gc.gridy = 2;
        add(i, gc);

        gc.gridx = 3;
        gc.gridy = 3;
        add(j, gc);

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
        add(scroll,gc);

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
                String xValue = x.getText();
                String yValue = y.getText();
                String iValue = i.getText();
                String jValue = j.getText();
                try {
                    editLog.logMethod(command,xValue,yValue,iValue,jValue);
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }

                switch (command){
                    case "G01":
                        System.out.println("G01 was run");
                        break;
                    case "G02":
                        System.out.println("G02 was run");
                        break;
                    case "M00":
                        mMethods.M00();
                        System.out.println("M00 was run");
                        break;
                    case "M02":
                        mMethods.m02();
                        System.out.println("M02 was run");
                        break;
                    case "M03":
                        mMethods.M03();
                        System.out.println("M03 was run");
                        break;
                    case "M04":
                        mMethods.M04();
                        System.out.println("M04 was run");
                        break;
                    case "M05":
                        mMethods.M05();
                        System.out.println("M05 was run");
                        break;
                    case "M08":
                        mMethods.M08();
                        System.out.println("M08 was run");
                        break;
                    case "M09":
                        mMethods.M09();
                        System.out.println("M09 was run");
                        break;
                    case "M13":
                        mMethods.M13();
                        System.out.println("M13 was run");
                        break;
                    case "M14":
                        mMethods.M14();
                        System.out.println("M14 was run");

                        frame.reloadStatus();
                        break;
                    default:
                        System.out.println("No Command choosen");
                }


                log.append("Nr: "+ editLog.returnCurrentLogEntry() + " Command: "+ command + " x-Value: "+xValue + " y-Value: "+yValue + " i-Value: "+iValue + " j-Value: "+jValue+"\n");


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
