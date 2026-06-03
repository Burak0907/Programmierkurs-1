import java.time.LocalDate;
import java.util.Objects;

public abstract class Risiko{
    private static int nextId = 0;
    private int id;
    private String bezeichnung;
    private float eintrittswahrscheinlichkeit;
    private float kosten_im_schadensfall;
    private LocalDate erstellungsdatum;

    public Risiko(String bezeichnung, float eintrittswahrscheinlichkeit, float kosten_im_schadensfall){
        this.id = nextId++;
        this.bezeichnung = bezeichnung;
        this.eintrittswahrscheinlichkeit = eintrittswahrscheinlichkeit;
        this.kosten_im_schadensfall = kosten_im_schadensfall;
        this.erstellungsdatum = LocalDate.now();
    }

    public float berechneRisikowert(){
        float risikowert = eintrittswahrscheinlichkeit * kosten_im_schadensfall;
        return risikowert;
    }

    abstract float ermittleRueckstellung();
    abstract void druckeDaten();

    public int getId(){
        return id;
    }

    public String getBezeichnung(){
        return bezeichnung;
    }

    public float getEintrittswahrscheinlichkeit(){
        return eintrittswahrscheinlichkeit;
    }

    public float getKosten_im_schadensfall(){
        return kosten_im_schadensfall;
    }

    public LocalDate getErstellungsDatum(){
        return erstellungsdatum;
    }

    public void setBezeichnung(String bezeichnung){
        this.bezeichnung = bezeichnung;
    }

    public void setEintrittswahrscheinlichkeit(float eintrittswahrscheinlichkeit){
        this.eintrittswahrscheinlichkeit = eintrittswahrscheinlichkeit;
    }

    public void setKosten_im_schadensfall(float kosten_im_schadensfall){
        this.kosten_im_schadensfall = kosten_im_schadensfall;
    }

    @Override
    public boolean equals(Object r){
        if(this == r) return true;
        if(r == null || getClass() != r.getClass()) return false;

        Risiko risiko = (Risiko) r;
        return bezeichnung.equals(risiko.bezeichnung) && Float.compare(eintrittswahrscheinlichkeit, risiko.eintrittswahrscheinlichkeit) == 0 && Float.compare(kosten_im_schadensfall, risiko.kosten_im_schadensfall) == 0 && erstellungsdatum.equals(risiko.erstellungsdatum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bezeichnung, eintrittswahrscheinlichkeit, kosten_im_schadensfall, erstellungsdatum);
    }

    public void vergleich(Risiko r2){
        if (equals(r2) && hashCode() == r2.hashCode()) {
            System.out.println("Die Objekte mit Id " + id + " und Id " + r2.id + " sind (fachlich) gleich");
            System.out.println("Die gleichen Objekte haben den Hashcode "+ hashCode());
        }else{
            System.out.println("Die Objekte mit Id " + id + " und Id " + r2.id + " sind nicht gleich");
            System.out.println("Die unterschiedlichen Objekte haben die Hashcodes "+ hashCode() + " und " + r2.hashCode());
        }
    }

    public static void main(String[]args){
    AkzeptablesRisiko aRisiko = new AkzeptablesRisiko("Lizenzkosten der IDE steigt",  10, 400);
    ExtremesRisiko eRisiko = new ExtremesRisiko("Hauptauftraggeber meldet Insolvenz an", 10, 500, "Versicherung abschließen", 5000);
    InakzeptablesRisiko iRisiko = new InakzeptablesRisiko("DB Experte verlässt das Projekt", 40, 400, "Ersatz bei Dienstleister reservieren");
    InakzeptablesRisiko iRisiko2 = new InakzeptablesRisiko("DB Experte verlässt das Projekt", 40, 400, "Ersatz bei Dienstleister reservieren");
    /* 
    aRisiko.druckeDaten();
    eRisiko.druckeDaten();
    iRisiko.druckeDaten();

    aRisiko.vergleich(eRisiko);
    iRisiko.vergleich(iRisiko2);
    */
    /* Test A3
    RisikoverwaltungArray rVArray = new RisikoverwaltungArray(3);
    rVArray.aufnehmen(iRisiko);
    rVArray.aufnehmen(iRisiko2);
    rVArray.aufnehmen(eRisiko);
    rVArray.aufnehmen(aRisiko);
    rVArray.berechneSummeRueckstellungen();
    rVArray.sucheRisikoMitMaxRueckstellung();
    rVArray.zeigeRisiko();
    */
    /* 
    RisikoverwaltungCollection rVCollection = new RisikoverwaltungCollection();
    rVCollection.aufnehmen(iRisiko);
    rVCollection.aufnehmen(iRisiko2);
    rVCollection.aufnehmen(eRisiko);
    rVCollection.aufnehmen(aRisiko);
    System.out.println("Das ist die berechnete Rueckstellungssumme: " + rVCollection.berechneSummeRueckstellungen());
    
    rVCollection.sucheRisikoMitMaxRueckstellung();
    rVCollection.zeigeRisiko();
    */

    RisikoverwaltungTypsichereCollection rVTCollection = new RisikoverwaltungTypsichereCollection();
    rVTCollection.aufnehmen(iRisiko);
    rVTCollection.aufnehmen(iRisiko2);
    rVTCollection.aufnehmen(eRisiko);
    rVTCollection.aufnehmen(aRisiko);
    System.out.println("Das ist die berechnete Rueckstellungssumme: " + rVTCollection.berechneSummeRueckstellungen());
    
    rVTCollection.sucheRisikoMitMaxRueckstellung();
    rVTCollection.zeigeRisiko();
    }
}
