package Methods;

public class MMethods {


/*          • M00: Programmhalt (Spindel, Kühlmittel, Vorschub aus)
            • M02: Programm Ende
            • M03: Spindel Ein: Im Uhrzeigersinn (Rechtslauf)
            • M04: Spindel Ein: Gegen den Uhrzeigersinn (Linkslauf)
            • M05: Spindel Stopp
            • M08: Kühlmittel Ein*
            • M09: Kühlmittel Aus*
            • M13: Spindel Ein, Rechtslauf und Kühlmittel Ein*
            • M14: Spindel Ein, Linkslauf und Kühlmittel Ein*
*/


    public Boolean cooling;
    //cooling = Kühlmitter
    //true  = Kuhlmittel an
    //false = Kühlmittel aus

    public Boolean drill;
    //drill = Spindel
    //true  = Spindel dreht sich
    //false = Spindel dreht sich nicht

    public Boolean drillDirection;
    //drillDirection = drehRichtungSpindel
    //true  = Rechtslauf
    //false = Linkslauf

    //M00: Programmhalt (Spindel, Kühlmittel, Vorschub aus)
    void M00(){

        drill = false;
        cooling = false;

        //Vorschub aus?

    }

    //M02: Programm Ende
    void m02(){

        //Vorschub aus?

    }

    //M03: Spindel Ein: Im Uhrzeigersinn (Rechtslauf)
    void M03(){

        drill = true;
        drillDirection=true;
    }

    //M04: Spindel Ein: Gegen den Uhrzeigersinn (Linkslauf)
    void M04(){

        drill = true;
        drillDirection=false;
    }

    //M05: Spindel Stopp
    void M05(){

        drill = false;
    }

    //M08: Kühlmittel Ein*
    void M08(){

        cooling = true;
    }

    //M09: Kühlmittel Aus*
    void M09() {

        cooling = false;
    }

    //M13: Spindel Ein, Rechtslauf und Kühlmittel Ein*
    void M013(){

        drill = true;
        drillDirection=true;
        cooling = true;

    }

    //M14: Spindel Ein, Linkslauf und Kühlmittel Ein*
    void M14(){

        drill=true;
        drillDirection=false;
        cooling=true;
    }

}
