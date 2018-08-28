import LogFile.*;
import Settings.*;
public class Executer {
    public static void main(String[]args){

        //Create read Settings Object
        readJsonSettings readSettings = new readJsonSettings();
        readSettings.readJson();

        //Create Object for Log File editing.
        writeLog createLog = new writeLog();
        createLog.writeToLog("N005","G66");
    }
}
