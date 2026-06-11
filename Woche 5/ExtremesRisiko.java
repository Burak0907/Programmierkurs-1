import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Objects;

public class ExtremesRisiko extends InakzeptablesRisiko{
    private float versicherungsbeitrag;

    public ExtremesRisiko(String bezeichnung, float eintrittswahrscheinlichkeit, float kosten_im_schadensfall, String massnahme, float versicherungsbeitrag){
        super(bezeichnung, eintrittswahrscheinlichkeit, kosten_im_schadensfall, massnahme);
        this.versicherungsbeitrag = versicherungsbeitrag;
    }

    @Override
    public float ermittleRueckstellung(){
        return versicherungsbeitrag;
    }

    @Override
    public void druckeDaten(OutputStream stream){
        PrintStream p = new PrintStream(stream);
        p.printf("Id %d Extremes Risiko \" %s \" ",this.getId(), this.getBezeichnung());
        p.printf("aus %d/%d ; ", this.getErstellungsDatum().getMonthValue(), this.getErstellungsDatum().getYear() );
        p.printf("Versicherungsbeitrag %.2f%n;", this.ermittleRueckstellung());
        p.printf("Maßnahme \"s%\"", this.getMassnahme());
    }

    @Override
    public boolean equals(Object r) {
        if (super.equals(r)) {
            ExtremesRisiko risiko = (ExtremesRisiko) r;
            return Float.compare(versicherungsbeitrag, risiko.versicherungsbeitrag) == 0;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), versicherungsbeitrag);
    }
}
