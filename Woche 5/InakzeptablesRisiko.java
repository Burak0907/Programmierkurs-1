import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Objects;

public class InakzeptablesRisiko extends Risiko{
    private String massnahme;
    public InakzeptablesRisiko(String bezeichnung, float eintrittswahrscheinlichkeit, float kosten_im_schadensfall, String massnahme){
        super(bezeichnung, eintrittswahrscheinlichkeit, kosten_im_schadensfall);
        this.massnahme = massnahme;
    }

    @Override
    public float ermittleRueckstellung(){
        return berechneRisikowert();
    }

    @Override
    void druckeDaten(OutputStream stream) {
        PrintStream p = new PrintStream(stream);
        p.printf("Id %d Inakzeptables Risiko \" %s \" ",this.getId(), this.getBezeichnung());
        p.printf("aus %d/%d ; ", this.getErstellungsDatum().getMonthValue(), this.getErstellungsDatum().getYear() );
        p.printf("Risikowert %.2f%n;", this.berechneRisikowert());
        p.printf("Rückstellung %.2f%n;", this.ermittleRueckstellung());
        p.printf("Maßnahme \"s%\"", this.getMassnahme());
     }

    public String getMassnahme(){
        return massnahme;
    }

    public void setMassnahme(String massnahme){
        this.massnahme = massnahme;
    }

    @Override
    public boolean equals(Object r) {
        if (super.equals(r)) {
            InakzeptablesRisiko risiko = (InakzeptablesRisiko) r;
            return massnahme.equals(risiko.massnahme);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), massnahme);
    }
}
