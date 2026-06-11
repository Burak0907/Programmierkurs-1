import java.util.Scanner;

import javax.swing.JOptionPane;

public class Menu {
    private RisikoverwaltungTypsichereCollection rTCollection;
    private float LIMIT = 10000.00f;
    private float KOSTENLIMIT = 1000000.00f;

    public Menu(RisikoverwaltungTypsichereCollection rTCollection){
        this.rTCollection = rTCollection;
    }
    public void menuAuswahl(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("""
                Risikoverwaltung

                1. Risiko aufnehmen
                2. Zeige alle Risiken
                3. Zeige Risiko mit maximaler Rückstellung
                4. Berechne Summe aller Rückstellungen
                5. Beenden

                Bitte Menüpunkt wählen:
                """);
        
            switch (scanner.nextInt()) {
                case 1 -> risikoAufnehmen();
                case 2 -> rTCollection.zeigeRisiko();
                case 3 -> rTCollection.sucheRisikoMitMaxRueckstellung();
                case 4 -> rTCollection.berechneSummeRueckstellungen();
                case 5 -> { return;}
            };
        }
        
    }

    public void risikoAufnehmen(){
        String bezeichnung = JOptionPane.showInputDialog("Bitte gebe die Bezeichnung ein: ");
        boolean eingabe = false;
        float eintrittswahrscheinlichkeit = 0.0f;
        while(!eingabe){
            try {
                String inputEintritt = JOptionPane.showInputDialog("Bitte gebe die Eintrittswahrscheinlichkeit ein: ");
                if (inputEintritt == null) {
                        return; 
                }
                eintrittswahrscheinlichkeit = Float.parseFloat(inputEintritt);
                eingabe = true; 
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Bitte gültige Eintrittswahrscheinlichkeit eingeben", "Meldung", JOptionPane.ERROR_MESSAGE);
                
            }
        }
        float kosten_im_schadensfall = 0.0f;
        boolean eingabe2 = false;
        while (!eingabe2) {
           try {
                String inputKosten = JOptionPane.showInputDialog("Bitte gebe die Kosten im Schadensfall ein: ");
                if (inputKosten == null) {
                        return; 
                }
                kosten_im_schadensfall = Float.parseFloat(inputKosten);
                eingabe2 = true;
            } catch (NumberFormatException e) {           
                JOptionPane.showMessageDialog(null, "Bitte gültige Kosten im Schadensfall eingeben", "Meldung", JOptionPane.ERROR_MESSAGE);
            } 
        }
         if(eintrittswahrscheinlichkeit * kosten_im_schadensfall > LIMIT){
            String massnahme = JOptionPane.showInputDialog("Bitte gebe die Maßnahme ein: ");
            if (massnahme == null) {
                    return; 
                }
            if(kosten_im_schadensfall > KOSTENLIMIT){
                float versicherungsbeitrag = 0.0f;
                boolean eingabe3 = false;
                while (!eingabe3) {
                    try {
                        if (bezeichnung == null) {
                            return; 
                        }
                        versicherungsbeitrag = Float.parseFloat(JOptionPane.showInputDialog("Bitte gebe den Versicherungsbeitrag ein: "));
                        eingabe3 = true;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Bitte gültigen Versicherungsbeitrag eingeben", "Meldung", JOptionPane.ERROR_MESSAGE);
                    }
                }
                
                rTCollection.aufnehmen(new ExtremesRisiko(bezeichnung, eintrittswahrscheinlichkeit, kosten_im_schadensfall, massnahme, versicherungsbeitrag));
            }else{
                rTCollection.aufnehmen(new InakzeptablesRisiko(bezeichnung, eintrittswahrscheinlichkeit, kosten_im_schadensfall, massnahme));
            }
        }else{
            rTCollection.aufnehmen(new AkzeptablesRisiko(bezeichnung, eintrittswahrscheinlichkeit, kosten_im_schadensfall));
        }
        System.out.println();
    }

    public static void main (String[]args){
        RisikoverwaltungTypsichereCollection rTCollection = new RisikoverwaltungTypsichereCollection();
        Menu m = new Menu(rTCollection);
        m.menuAuswahl();
    }
}
