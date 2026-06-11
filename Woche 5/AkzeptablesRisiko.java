import java.io.OutputStream;
import java.io.PrintStream;

public class AkzeptablesRisiko extends Risiko{
    public AkzeptablesRisiko(String bezeichnung, float eintrittswahrscheinlichkeit, float kosten_im_schadensfall){
        super(bezeichnung, eintrittswahrscheinlichkeit, kosten_im_schadensfall);
    }

    @Override
    float ermittleRueckstellung() {
        return 0;
    }

    @Override
    void druckeDaten(OutputStream stream) {
        PrintStream p = new PrintStream(stream);
        p.printf("Id %d Akzeptables Risiko \" %s \" ",this.getId(), this.getBezeichnung());
        p.printf("aus %d/%d ; ", this.getErstellungsDatum().getMonthValue(), this.getErstellungsDatum().getYear() );
        p.printf("Risikowert %.2f%n;", this.berechneRisikowert());
        p.printf("Rückstellung %.2f%n;", this.ermittleRueckstellung());
    }
    
}
