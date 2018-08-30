/*
 * Author: Johannes Pirmann
 * */
package Settings;

import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import java.net.URL;
import java.io.File;

public class ReadJsonSettings {

    public long homePositionX;
    public long homePositionY;
    public long speedWithoutCooling;
    public long speedWithCooling;
    public long speedWithoutMill;
    public String workingSurface;
    public String processedSurface;
    public String drill;
    public String homePosition;
    public long numberOfLogEntry;
    public int intNumberLogEntries;

    public void readJson(){
        try {

            //Get the File Path for the Settings.json.
            URL url = getClass().getResource("Settings.json");
            File filePathToSettings = new File(url.getPath());

            // parsing file "JSONExample.json"
            Object obj = new JSONParser().parse(new FileReader(String.valueOf(filePathToSettings)));

            // typecasting obj to JSONObject
            JSONObject jo = (JSONObject) obj;

            //Save the Values from the JSON to the Variables.
            homePositionX = (long) jo.get("homePositionX");
            homePositionY = (long) jo.get("homePositionY");
            speedWithoutCooling = (long) jo.get("speedWithoutCooling");
            speedWithCooling = (long) jo.get("speedWithCooling");
            speedWithoutMill = (long) jo.get("speedWithoutMill");
            workingSurface = (String) jo.get("workingSurface");
            processedSurface = (String) jo.get("processedSurface");
            drill = (String) jo.get("drill");
            homePosition = (String) jo.get("homePosition");

            numberOfLogEntry = (long) jo.get("numberOfLogEntry");
            intNumberLogEntries= (int) numberOfLogEntry;


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
