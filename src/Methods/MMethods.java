package Methods;


import UI.MainFrame;
import UI.StatusWindow;
import Settings.ReadJsonSettings;


public class MMethods {

    private final StatusValues status;
    private final StatusWindow statusWindow;
    private final MainFrame frame;
    private final ReadJsonSettings jsonSettings;

    public MMethods(StatusValues newStatus, StatusWindow statusWindow, MainFrame frame,ReadJsonSettings newJsonSettings){
        this.status = newStatus;
        this.statusWindow = statusWindow;
        this.frame = frame;
        this.jsonSettings = newJsonSettings;
    }

/*          • M00: Programmhalt (Spindel, Kühlmittel, Vorschub aus)
            • M02: Programm Ende
            • M03: Spindel Ein: Im Uhrzeigersinn (Rechtslauf)
            • M04: Spindel Ein: Gegen den Uhrzeigersinn (Linkslauf)
            • M05: Spindel Stopp
            • M08: Kühlmittel Ein*
            • M09: Kühlmittel Aus*
            • M13: Spindel Ein, Rechtslauf und Kühlmittel Ein*
            • M14: Spindel Ein, Linkslauf und Kühlmittel Ein*
*/



    //M00: Programmhalt (Spindel, Kühlmittel, Vorschub aus)
    public void M00(){

        status.drill = false;
        statusWindow.setDrillStatus("OFF");
        status.cooling = false;
        statusWindow.setCooling("OFF");
        statusWindow.setDrillDirection("NONE");
        statusWindow.setSpeed(Long.toString(jsonSettings.speedWithoutMill));

        //Vorschub aus?
        frame.reloadStatus();
    }

    //M02: Programm Ende
    public void m02(){

        //Vorschub aus?
        frame.reloadStatus();
    }

    //M03: Spindel Ein: Im Uhrzeigersinn (Rechtslauf)
    public void M03(){

        status.drill = true; //ON
        statusWindow.setDrillStatus("ON");
        status.drillDirection=true;
        statusWindow.setDrillDirection("Right");
        statusWindow.setSpeed(Long.toString(jsonSettings.speedWithoutCooling));
        frame.reloadStatus();
    }

    //M04: Spindel Ein: Gegen den Uhrzeigersinn (Linkslauf)
    public void M04(){

        status.drill = true;
        statusWindow.setDrillStatus("ON");
        status.drillDirection=false;
        statusWindow.setDrillDirection("Left");
        statusWindow.setSpeed(Long.toString(jsonSettings.speedWithoutCooling));
        frame.reloadStatus();
    }

    //M05: Spindel Stopp
    public void M05(){

        status.drill = false;
        statusWindow.setDrillStatus("OFF");
        statusWindow.setDrillDirection("NONE");
        statusWindow.setSpeed(Long.toString(jsonSettings.speedWithoutMill));
        frame.reloadStatus();
    }

    //M08: Kühlmittel Ein*
    public void M08(){

        status.cooling = true;
        statusWindow.setCooling("ON");
        statusWindow.setSpeed(Long.toString(jsonSettings.speedWithCooling));
        frame.reloadStatus();
    }

    //M09: Kühlmittel Aus*
    public void M09() {

        status.cooling = false;
        statusWindow.setCooling("OFF");
        statusWindow.setSpeed(Long.toString(jsonSettings.speedWithoutCooling));
        frame.reloadStatus();
    }

    //M13: Spindel Ein, Rechtslauf und Kühlmittel Ein*
    public void M13(){

        status.drill = true;
        statusWindow.setDrillStatus("ON");
        status.drillDirection=true;
        statusWindow.setDrillDirection("Right");
        status.cooling = true;
        statusWindow.setCooling("ON");
        statusWindow.setSpeed(Long.toString(jsonSettings.speedWithCooling));
        frame.reloadStatus();
    }

    //M14: Spindel Ein, Linkslauf und Kühlmittel Ein*
    public void M14(){
        status.drill= true;
        statusWindow.setDrillStatus("ON");
        status.drillDirection=false;
        statusWindow.setDrillDirection("Left");
        status.cooling=true;
        statusWindow.setCooling("ON");
        statusWindow.setSpeed(Long.toString(jsonSettings.speedWithCooling));
        frame.reloadStatus();
    }


}
