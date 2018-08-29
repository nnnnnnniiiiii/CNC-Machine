import Logging.*;
import Methods.G01;
import Methods.G02;
import Methods.MMethods;
import Settings.*;
import UI.MainWindow;
import UI.UI_Executer;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Executer {
    public static void main(String[]args) throws IOException, ParseException {

        //Create Method Objects
        G01 runG01 = new G01();
        G02 runG02 = new G02();
        MMethods runMMethods = new MMethods();

        MainWindow newMainWindow = new MainWindow();
        newMainWindow.createSurface();
    }
}
