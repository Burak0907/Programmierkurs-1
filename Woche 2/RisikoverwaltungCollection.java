import java.util.ArrayList;
import java.util.Iterator;

public class RisikoverwaltungCollection{
    ArrayList list = new ArrayList<>();
    public void aufnehmen(Risiko risiko){
        list.add(risiko);
    }

    public void zeigeRisiko(){
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Risiko risiko = (Risiko) it.next();
            risiko.druckeDaten();
        }
        /* 
        for(Object o : list){
            Risiko risiko = (Risiko) o;
            risiko.druckeDaten();
        } */
    }

    public void sucheRisikoMitMaxRueckstellung(){
        float maxRueckstellung = 0;
        int nummer=0;
        int counter = 0;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Risiko risiko = (Risiko) it.next();
            if (risiko.ermittleRueckstellung() > maxRueckstellung) {
                maxRueckstellung = risiko.ermittleRueckstellung(); 
                nummer = counter;
            }
            counter++;
        }
        Risiko risiko = (Risiko) list.get(nummer);
        risiko.druckeDaten();
    }

    public float berechneSummeRueckstellungen(){
        if (list.isEmpty()) {
            return (float) 0.0;
        }
        float summe = 0;
        
        for(Object o : list){
            Risiko risiko = (Risiko) o;
            summe += risiko.ermittleRueckstellung();
        } 
        /* 
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Risiko risiko = (Risiko) it.next();
            summe += risiko.ermittleRueckstellung();
        }
        */
        return summe;
    }
}