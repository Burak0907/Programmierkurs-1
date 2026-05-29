public class RisikoverwaltungArray{
    Risiko[] array;
    int anzahl = 0;
    public RisikoverwaltungArray(int anzahl){
        array = new Risiko[anzahl];
    }
    public void aufnehmen(Risiko risiko){
        if(array.length > anzahl){
            array[anzahl] = risiko;
            anzahl++;
        }else{
            System.out.println("In der Risikoverwaltung ist kein Platz mehr vorhanden");
        }
    }

    public void zeigeRisiko(){
        for(int i = 0 ; i<anzahl; i++){
            array[i].druckeDaten();
        }
    }

    public void sucheRisikoMitMaxRueckstellung(){
        float maxRueckstellung = 0;
        int nummer=0;
        for(int i = 0 ; i<anzahl; i++){
            if (array[i].ermittleRueckstellung()>maxRueckstellung) {
                maxRueckstellung = array[i].ermittleRueckstellung(); 
                nummer = i;
            }
        }
        array[nummer].druckeDaten();
    }

    public float berechneSummeRueckstellungen(){
        if (array.length == 0) {
            return (float) 0.0;
        }
        float summe = 0;
        for(int i=0 ; i < anzahl; i++){
            summe += array[i].ermittleRueckstellung();
        }
        return summe;
    }
}
