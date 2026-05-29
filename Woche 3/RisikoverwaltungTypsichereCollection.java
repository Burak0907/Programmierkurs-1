import java.util.ArrayList;
import java.util.Iterator;
public class RisikoverwaltungTypsichereCollection {
    ArrayList<Risiko> list = new ArrayList<Risiko>();
    public void aufnehmen(Risiko risiko){
        list.add(risiko);
    }

    public void zeigeRisiko(){
        
        list.stream().sorted((a,b)->Float.compare(a.berechneRisikowert(), b.berechneRisikowert())).forEach(Risiko::druckeDaten);;
        /* 
        Iterator<Risiko> it = list.iterator();
        while (it.hasNext()) {
            it.next().druckeDaten();
        }
        */
        /* 
        for(Risiko r : list){
            r.druckeDaten();
        } */
    }

    public void sucheRisikoMitMaxRueckstellung(){
        float maxRueckstellung = 0;
        int nummer=0;
        int counter = 0;
        Iterator<Risiko> it = list.iterator();
        while (it.hasNext()) {
            Risiko risiko = it.next();
            if (risiko.ermittleRueckstellung() > maxRueckstellung) {
                maxRueckstellung = risiko.ermittleRueckstellung(); 
                nummer = counter;
            }
            counter++;
        }
        list.get(nummer).druckeDaten();
    }

    public float berechneSummeRueckstellungen(){
        if (list.isEmpty()) {
            return (float) 0.0;
        }
        float summe = 0;
        
        for(Risiko r : list){
            summe += r.ermittleRueckstellung();
        } 
        /* 
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Risiko risiko = it.next();
            summe += risiko.ermittleRueckstellung();
        }
        */
        return summe;
    }
}
