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
    void druckeDaten() {
      System.out.printf("Id " + this.getId() + " Inakzeptables Risiko \"" + this.getBezeichnung()+ "\" aus " + this.getErstellungsDatum().getMonthValue() + "/" + this.getErstellungsDatum().getYear() + "; " +
         "Risikowert %.2f%n" + "; Rückstellung %.2f%n" + "; Maßnahme \"" + this.getMassnahme() + "\"", this.berechneRisikowert(), this.ermittleRueckstellung());
    }

    public String getMassnahme(){
        return massnahme;
    }

    public void setMassnahme(String massnahme){
        this.massnahme = massnahme;
    }
}
