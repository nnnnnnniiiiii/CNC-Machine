import Logging.*;
import Settings.*;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Executer {
    public static void main(String[]args) throws IOException, ParseException {

        //Create read Settings Object
        readJsonSettings readSettings = new readJsonSettings();
        readSettings.readJson();

        //Create Object for Log File editing.
        LogClass createLog = new LogClass();
        createLog.logMethod("N001","G66");
    }
}
