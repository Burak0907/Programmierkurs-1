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
    public void druckeDaten(){
          System.out.printf("Id " + this.getId() + " Extremes Risiko \"" + this.getBezeichnung()+ "\" aus " + this.getErstellungsDatum().getMonthValue() + "/" + this.getErstellungsDatum().getYear() + "; " +
         "Versicherungsbeitrag %.2f%n" + "; Maßnahme \"" + this.getMassnahme() + "\"", this.ermittleRueckstellung());
    }
}
