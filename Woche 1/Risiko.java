import java.time.LocalDate;

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

    public static void main(String[]args){
    AkzeptablesRisiko aRisiko = new AkzeptablesRisiko("Lizenzkosten der IDE steigt",  10, 400);
    ExtremesRisiko eRisiko = new ExtremesRisiko("Hauptauftraggeber meldet Insolvenz an", 10, 500, "Versicherung abschließen", 5000);
    InakzeptablesRisiko iRisiko = new InakzeptablesRisiko("DB Experte verlässt das Projekt", 40, 400, "Ersatz bei Dienstleister reservieren");
   
    aRisiko.druckeDaten();
    eRisiko.druckeDaten();
    iRisiko.druckeDaten();
    }
}
