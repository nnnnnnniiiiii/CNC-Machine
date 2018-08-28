package LogFile;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import org.json.simple.parser.JSONParser;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class writeLog {


    //Main Method
    public static void main (String[] args){
        new writeLog().writeToLog("N25","G122");
    }


    //Writing Method
    private void writeToLog(String getNumber,String getCommand) {
        String number = getNumber;
        String command = getCommand;

        //Create JSON Parser & Object
        JSONParser parser = new JSONParser();

        //Create JSON Object which will retrieve the JSON with the Log File and parse it into the JSON Array logFile
        JSONObject jobj = null;
        //Create JSON Object which will be appended to the Log File
        JSONObject newJobj = new JSONObject();
        //Create JSON Array which stores the Log file
        JSONArray logFile = null;

        //Log-File Location
        File f = new File("/Users/johannes/IdeaProjects/writeLog/src/Log.json");

        //IF File exists
        if (f.exists()) {
            //Try opening the file into an Object and then parsing it into a JSON Object
            try {
                Object obj = parser.parse(new FileReader(f));
                jobj = (JSONObject) obj;
                logFile = (JSONArray) jobj.get("Log");


                //Fill the JSON Object with information
                //Add information to the new Object
                newJobj.put("Nr", number);
                newJobj.put("Command", command);
                //Append the Object to the existing Array
                logFile.add(newJobj);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //If the file is not found create a new JSON Object
        //else {
        //   jobj = new JSONObject();
        //}


        //Write the JSON Object to the file
        try {
            FileWriter file = new FileWriter(f);
            file.write(jobj.toJSONString());
            file.flush();
            file.close();
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + logFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
