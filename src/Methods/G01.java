package Methods;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class G01 {
    List lerpKoordinaten(double x1, double x2, double y1, double y2, double schritte){

        /*Punkte auf Strecke von (X1/Y1) nach (X2/Y2) werden berechnet
         *Variable double schritte gibt an wie viele Zwischenschritte dabei erfolgen
         *Punkte werden in Liste gespeichert*/

        List<Point2D.Double> koordinatenGerade = new ArrayList<>();


        for(int t = 0;t<=schritte;t++) {

            double x = x1 + (x2 - x1) * t / schritte;
            double y = y1 + (y2 - y1) * t / schritte;
            koordinatenGerade.add(new Point2D.Double(x,y));

        }


        System.out.println("Koordinaten Gerade:  "+koordinatenGerade);
        return koordinatenGerade;


    }
}
