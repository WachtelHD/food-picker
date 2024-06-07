package de.dhbw.ase;

import java.util.Scanner;

public class Starter {

	// pom.xml überprüfen
	public static void main(String[] args) {
		//Init
		get get = new get();
		functions functions = new functions();
		Scanner in = new Scanner(System.in);

		String spielTyp = "";
		boolean amWählen = true;

		//Spiel schleife
		while(amWählen){
			//Aus-/Eingabe
			System.out.println("Hallo, was kann ich für dich tun");
			System.out.println("1 - Infos zu einem spezifischen Produkt ausgeben");
			System.out.println("2 - Gerichtsvorschläge einer spezifischen Richtung");
			System.out.println("3 - Zufälliges Essen");
			System.out.println("4 - Essensauswahl spiel");
			System.out.println("5 - Essensauswahl spiel mit spezifisscher Richtung");

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
					// Falls gerichte für eine Richtung gewünscht sind diese ausgeben
					functions.essenInSpezifischerRichtung();
					amWählen = false;
					break;
				case "3":
					functions.zufälligesEssen();
					amWählen = false;
					// Zufälliges essen
					break;
				case "4":
					functions.essenSpiel();
					amWählen = false;
					// Falls eine Spiel gestartet werden soll mehrere Produkte wählen
					break;
				case "5":
					String essensRichtung = in.next();
					functions.essenSpiel(essensRichtung);
					amWählen = false;
					// Spiel für Produkte in bestimmter Richtung
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
