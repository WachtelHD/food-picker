package de.dhbw.ase;

import java.util.Scanner;

public class Starter {

	// pom.xml überprüfen
	public static void main(String[] args) {
		Integer spielTyp = 0;
		// Nutzer nach Zielsetzung Fragen
		System.out.println("Hallo, was kann ich für dich tun");
		System.out.println("1 - Infos zu einem spezifischen Produkt ausgeben");
		System.out.println("2 - Gerichtsvorschläge einer spezifischen Richtung");
		System.out.println("3 - Essensauswahl spiel");
		System.out.println("4 - Essensauswahl spiel mit spezifisscher Richtung");

		System.out.print("Auswahl: 1");

		Scanner in = new Scanner(System.in);
		spielTyp = in.nextInt();

		switch (spielTyp) {
			case 1:
				// Falls infos über Spezifisches Produkt gefragt sind diese ausgeben
				break;
			case 2:
				// Falls gerichte für eine Richtung gewünscht sind diese ausgeben
				break;
			case 3:
				// Falls eine Spiel gestartet werden soll mehrere Produkte wählen
				break;
			case 4:
				// Spiel für Produkte in bestimmter Richtung
				break;
			default:
				System.out.println("Es ist ein fehler aufgetreten");
				break;
		}

		in.close(); 
	}

	// private static Map<PersonId, List<Ort>> leseOrte() {
	// 	Map<PersonId, List<Ort>> orte = new HashMap<PersonId, List<Ort>>();
	// 	orte.put(PersonId.createNextId(), Arrays.asList(new Ort(null, null, null)));
	// 	return orte;
	// }

}
