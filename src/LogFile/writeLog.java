package LogFile;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class writeLog {

    //Writing Method
    public void writeToLog(String getNumber,String getCommand) {
        //Create Variables to save the Values which should be written to the Log File.
        String number = getNumber;
        String command = getCommand;

        //---Create all Objects, Arrays and the File Path---
        //Create JSON Parser & Object
        JSONParser parser = new JSONParser();

        //Create JSON Object which will retrieve the JSON with the Log File and parse it into the JSON Array logFile
        JSONObject jobj = null;

        //Create JSON Array which stores the Log file
        JSONArray logFile = null;

        //Create JSON Object which will hold the new Log entry.
        JSONObject newLogEntry = new JSONObject();

        //Log-File Location
        File logFilePath = new File("/Users/johannes/IdeaProjects/CNC-Projekt/src/LogFile/Log.json");



        //---Start with the modification of the JSON File---
        //IF the Log File exists
        if (logFilePath.exists()) {
            //Try opening the file into an Object and then parsing it into a JSON Object
            try {

                jobj = (JSONObject)parser.parse(new FileReader(logFilePath));
                logFile = (JSONArray) jobj.get("Log");

                //Append each value from the variables to the JSON Object newLogEntry.
                newLogEntry.put("Nr", number);
                newLogEntry.put("Command", command);

                //Append the newLogEntry JSON Object to the existing JSON Array logFile.
                logFile.add(newLogEntry);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        //IF the Log File does not exists, create a new one.
        else {
            jobj = new JSONObject();
            logFile = new JSONArray();

            //Append each value from the variables to the JSON Object newLogEntry.
            newLogEntry.put("Nr", number);
            newLogEntry.put("Command", command);

            //Append the newLogEntry JSON Object to the existing JSON Array logFile.
            logFile.add(newLogEntry);

            jobj.put("Log",logFile);


        }


        //---Write the changes to the Log File---
        //Write the JSON Object jobj with the new log entry to the file
        try {
            FileWriter file = new FileWriter(logFilePath);
            file.write(jobj.toJSONString());
            file.flush();
            file.close();
            System.out.println("Successfully new log entry to file...");
            System.out.println("\nNew Log Entry: " + newLogEntry);
        } catch (Exception e) {
            e.printStackTrace();
        }



    }




}
