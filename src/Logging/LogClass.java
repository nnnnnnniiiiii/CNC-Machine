package Logging;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class LogClass {
    String number;
    String command;

    File jsonLogFile;

    //Create all Objects, Arrays and parser
    JSONParser newJSONParser = new JSONParser();
    Object allEntries = new Object();
    JSONObject allLogEntries = new JSONObject();
    JSONObject newLogEntry = new JSONObject();

    public void logMethod(String number, String command) throws IOException, ParseException {
        this.number = number;
        this.command = command;

        createJSON();
        createNewLogEntry();
        writeToFile();
    }

    private void createJSON() throws IOException{
        //Get the path to the Logging JSON.
        jsonLogFile = new File("./src/Logging/Log.json");
        //If it does not exists, create one.
        if (!jsonLogFile.exists()){
            jsonLogFile.getParentFile().mkdirs();
            jsonLogFile.createNewFile();

            //Add an empty JSON Object to it.
            FileWriter changedJSON = new FileWriter(jsonLogFile);
            JSONObject newJSONObject = new JSONObject();
            changedJSON.write(newJSONObject.toJSONString());
            changedJSON.flush();
            changedJSON.close();
            //Print a success message.
            System.out.println("A new JSON File was created!");
        }
    }

    private void createNewLogEntry() throws IOException, ParseException {
        allEntries = newJSONParser.parse(new FileReader(jsonLogFile));
        allLogEntries = (JSONObject) allEntries;
        newLogEntry.put("Command:", command);

        allLogEntries.put(number,newLogEntry);
    }

    private void writeToFile(){
        try{
            //Write the changes to the JSON.
            FileWriter changedJSON = new FileWriter(jsonLogFile);
            changedJSON.write(allLogEntries.toJSONString());
            changedJSON.flush();
            changedJSON.close();
            System.out.println("Successfully new log entry to file...");
            System.out.println("\nNew Log Entry: " + newLogEntry);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}