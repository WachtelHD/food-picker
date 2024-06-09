package de.dhbw.ase;

import java.util.Scanner;

public class Starter {

    public static void main(String[] args) {
        // Initialisierung
        ApiClient essenApiClient = new ApiClientImpl("1");
    	EssenService essenService = new EssenService(essenApiClient);
        NaehrwertService naehrwerteService = new NaehrwertService(new ApiClientImpl("3kTkxnTFVv/5fW3/lKu70A==fHOzKx39l17N3X0C"));
        RezeptService rezeptService = new RezeptService(essenApiClient);
        KategorieService kategorieService = new KategorieService(essenApiClient);
        BildService bildService = new BildService(essenApiClient);
        JsonMapper json = new JsonMapper(essenService, naehrwerteService);
        SpielFunktionen funktionen = new SpielFunktionen(essenService, naehrwerteService, json, rezeptService, bildService, kategorieService);
        Scanner in = new Scanner(System.in);

        String spielTyp = "";
        boolean amWählen = true;

        // Spielschleife
        while (amWählen) {
            // Aus-/Eingabe
            System.out.println("Hallo, was kann ich für dich tun");
            System.out.println("1 - Infos zu einem spezifischen Produkt ausgeben");
            System.out.println("2 - Gerichtsvorschläge einer spezifischen Richtung anzeigen");
            System.out.println("3 - Zufälliges Essen anzeigen");
            System.out.println("4 - Essensvorschläge erhalten");
            System.out.println("5 - Essensvorschlag mit spezifischer Richtung erhalten");

            System.out.print("Auswahl: ");
            spielTyp = in.next();

			//Wahl der Aufgabe -> Ausführung
            switch (spielTyp) {
                case "1":
                    // Infos zu einem spezifischen Produkt ausgeben
                    funktionen.essenAusgabe();
                    amWählen = false;
                    break;
                case "2":
                    // Falls Gerichte für eine Richtung gewünscht sind, diese ausgeben
                    funktionen.essenInSpezifischerRichtung();
                    amWählen = false;
                    break;
                case "3":
                    // Zufälliges Essen
                    funktionen.zufälligesEssen();
                    amWählen = false;
                    break;
                case "4":
                    // Falls ein Spiel gestartet werden soll, mehrere Produkte wählen
                    funktionen.essenSpiel();
                    amWählen = false;
                    break;
                case "5":
                    System.out.print("Gib die spezifische Richtung ein: ");
                    String essensRichtung = in.next();
                    // Spiel für Produkte in bestimmter Richtung
                    funktionen.essenSpiel(essensRichtung);
                    amWählen = false;
                    break;
                default:
					//TODO: change error6
                    System.out.println("--------------------------------------------------------------------");
					System.out.println("	   Bitte wählen sie eine valide Option aus");
                    System.out.println("--------------------------------------------------------------------");

                    break;
            }
        }
        in.close();
    }

}
