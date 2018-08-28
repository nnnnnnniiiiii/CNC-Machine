package Settings;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.*;

/*
* Author: Johannes Pirmann
* */

public class readJsonSettings {

    public long homePositionX;
    public long homePositionY;
    public long speedWithoutCooling;
    public long speedWithCooling;
    public long speedWithoutMill;
    public String workingSurface;
    public String processedSurface;
    public String drill;
    public String homePosition;


    public static void main(String[] args){
        new readJsonSettings().readJson();

    }

    public void readJson(){
        try {

            // parsing file "JSONExample.json"
            Object obj = new JSONParser().parse(new FileReader("/Users/johannes/IdeaProjects/CNC-Projekt/src/Settings/Settings.json"));

            // typecasting obj to JSONObject
            JSONObject jo = (JSONObject) obj;

            homePositionX = (long) jo.get("homePositionX");
            homePositionY = (long) jo.get("homePositionY");
            speedWithoutCooling = (long) jo.get("speedWithoutCooling");
            speedWithCooling = (long) jo.get("speedWithCooling");
            speedWithoutMill = (long) jo.get("speedWithoutMill");

            workingSurface = (String) jo.get("workingSurface");
            processedSurface = (String) jo.get("processedSurface");
            drill = (String) jo.get("drill");
            homePosition = (String) jo.get("homePosition");

            System.out.println(homePositionX+" " +workingSurface);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
