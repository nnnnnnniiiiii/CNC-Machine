package Methods;


import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class G02 {
    public List<Point2D.Double> koordinatenKreis(double xStart, double yStart, double xMitte, double yMitte, double radius){

        /*Punkte im Uhrzeigersinn auf Kreisbahn werden berechnet
         * Zuerst wird der startWinkel auf Basis des Start- und Mittelpunkts des Kreises bestimmt
         * Von diesem Winkel ausgehend werden die Punkte auf der Kreisbahn von startWinkel bis startWinkel-180° berechnet
         * Anzahl an bestimmten Punkten auf der Kreisbahn werden mit der Abnahme von i bestimmt
         * (i-- -> 180 Punkte)
         * Punkte werden in Liste gespeichert
         */

        double x = xStart-xMitte;
        double y = yStart-yMitte;

        double winkelStart = Math.atan2(-y,-x)+Math.PI;

        List<Point2D.Double> listePunkteG02 = new ArrayList<>();


        for (int i = 180; i >=0; i--) {
            double xKoordinaten = radius * Math.cos(winkelStart) + xMitte;
            double yKoordinaten = radius * Math.sin(winkelStart) + yMitte;

            listePunkteG02.add(new Point.Double(xKoordinaten, yKoordinaten));

            if (winkelStart<0){
                winkelStart = winkelStart+2*Math.PI;
            }

            winkelStart = winkelStart - Math.PI / 180;


        }

        return listePunkteG02;

    }
}
