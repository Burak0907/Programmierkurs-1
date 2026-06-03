public class AkzeptablesRisiko extends Risiko{
    public AkzeptablesRisiko(String bezeichnung, float eintrittswahrscheinlichkeit, float kosten_im_schadensfall){
        super(bezeichnung, eintrittswahrscheinlichkeit, kosten_im_schadensfall);
    }

    @Override
    float ermittleRueckstellung() {
        return 0;
    }

    @Override
    void druckeDaten() {
      System.out.printf("Id " + this.getId() + " Akzeptables Risiko \"" + this.getBezeichnung() + "\" aus " + this.getErstellungsDatum().getMonthValue() + "/" + this.getErstellungsDatum().getYear() + "; " +
         "Risikowert %.2f%n" + "; Rückstellung %.2f%n", this.berechneRisikowert(), this.ermittleRueckstellung());
    }
    
}
