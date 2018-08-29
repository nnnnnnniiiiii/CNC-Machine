package Methods;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class G02 {
    List<Point2D.Double> koordinatenKreis(double radius, double mitteX, double mitteY, double startX, double startY){

        //Mit Start Punkt startX/startY und Mittelpunkt Kreis mitteX/mitteY wird der Startwinkel für den
        //Kreisbogen berechnet

        double winkelStart;

        if (startX - mitteX < 0 || startY - mitteY < 0) {

            winkelStart = (2 * Math.PI) + Math.atan2(startY - mitteY, startX - mitteX);

        } else {
            winkelStart = Math.atan2(startY - mitteY, startX - mitteX);
        }

        //Am Startwinkel beginnend werden die auf dem Kreisbogen liegenden Punkte berechnet und abgespeichert


        List<Point2D.Double> listePunkte = new ArrayList<>();

        for (int i = 0; i <= 180; i++) {
            double x = radius * Math.cos(winkelStart) + mitteX;
            double y = radius * Math.sin(winkelStart) + mitteY;
            listePunkte.add(new Point.Double(x,y));


            //System.out.println(punkt + "  aktueller Winkel: " + Math.toDegrees(winkelStart));
            winkelStart = winkelStart + Math.PI / 180;

        }
        System.out.println("Koordinaten Punkt:  "+listePunkte);
        return listePunkte;



    }
}
