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
        float eintrittswahrscheinlichkeit = Float.parseFloat(JOptionPane.showInputDialog("Bitte gebe die Eintrittswahrscheinlichkeit ein: "));
        float kosten_im_schadensfall = Float.parseFloat(JOptionPane.showInputDialog("Bitte gebe die Kosten im Schadensfall ein: "));
        if(eintrittswahrscheinlichkeit * kosten_im_schadensfall > LIMIT){
            String massnahme = JOptionPane.showInputDialog("Bitte gebe die Maßnahme ein: ");
            if(kosten_im_schadensfall > KOSTENLIMIT){
                float versicherungsbeitrag =  Float.parseFloat(JOptionPane.showInputDialog("Bitte gebe den Versicherungsbeitrag ein: "));
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
