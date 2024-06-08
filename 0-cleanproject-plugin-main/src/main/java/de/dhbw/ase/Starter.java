package de.dhbw.ase;

import java.util.Scanner;

public class Starter {

    public static void main(String[] args) {
        // Initialisierung
        ApiClient mealApiClient = new ApiClientImpl("1");
    	EssenService mealService = new EssenService(mealApiClient);
        NaehrwertService nutritionService = new NaehrwertService(new ApiClientImpl("3kTkxnTFVv/5fW3/lKu70A==fHOzKx39l17N3X0C"));
        SpielFunktionen functions = new SpielFunktionen(mealService, nutritionService);
        Scanner in = new Scanner(System.in);

        String spielTyp = "";
        boolean amWählen = true;

        // Spielschleife
        while (amWählen) {
            // Aus-/Eingabe
            System.out.println("Hallo, was kann ich für dich tun");
            System.out.println("1 - Infos zu einem spezifischen Produkt ausgeben");
            System.out.println("2 - Gerichtsvorschläge einer spezifischen Richtung");
            System.out.println("3 - Zufälliges Essen");
            System.out.println("4 - Essensauswahl spiel");
            System.out.println("5 - Essensauswahl spiel mit spezifischer Richtung");

            System.out.print("Auswahl: ");
            spielTyp = in.next();

			//Wahl der Aufgabe -> Ausführung
            switch (spielTyp) {
                case "1":
                    // Infos zu einem spezifischen Produkt ausgeben
                    functions.essenAusgabe();
                    amWählen = false;
                    break;
                case "2":
                    // Falls Gerichte für eine Richtung gewünscht sind, diese ausgeben
                    functions.essenInSpezifischerRichtung();
                    amWählen = false;
                    break;
                case "3":
                    // Zufälliges Essen
                    functions.zufälligesEssen();
                    amWählen = false;
                    break;
                case "4":
                    // Falls ein Spiel gestartet werden soll, mehrere Produkte wählen
                    functions.essenSpiel();
                    amWählen = false;
                    break;
                case "5":
                    System.out.print("Gib die spezifische Richtung ein: ");
                    String essensRichtung = in.next();
                    // Spiel für Produkte in bestimmter Richtung
                    functions.essenSpiel(essensRichtung);
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
