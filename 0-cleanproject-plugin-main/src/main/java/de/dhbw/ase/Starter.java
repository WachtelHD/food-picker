package de.dhbw.ase;

import java.util.Scanner;

public class Starter {

	// pom.xml überprüfen
	public static void main(String[] args) {
		get get = new get();
		functions functions = new functions();

		Integer spielTyp = 0;
		System.out.println("Hallo, was kann ich für dich tun");
		System.out.println("1 - Infos zu einem spezifischen Produkt ausgeben");
		System.out.println("2 - Gerichtsvorschläge einer spezifischen Richtung");
		System.out.println("3 - Zufälliges Essen");
		System.out.println("4 - Essensauswahl spiel");
		System.out.println("5 - Essensauswahl spiel mit spezifisscher Richtung");

		System.out.print("Auswahl: ");

		Scanner in = new Scanner(System.in);
		spielTyp = in.nextInt();

		switch (spielTyp) {
			case 1:
				System.out.println("Essens Auswahl: ");
				if (in.hasNext()) {
					String essensTyp = in.next() + in.nextLine();
					essensTyp = essensTyp.replace(" ", "+");
					System.out.println(essensTyp);
					get.getProductInfo(essensTyp);
				}
				
				break;
			case 2:
				System.out.print("Essens Richtung: ");
				String essensRichtung = in.next();
				get.getProductRange(essensRichtung);
				// Falls gerichte für eine Richtung gewünscht sind diese ausgeben
				break;
			case 3:
				get.getRandomFood();
				// Zufälliges essen
				break;
			case 4:
				functions.essenSpiel();
				// Falls eine Spiel gestartet werden soll mehrere Produkte wählen
				break;
			case 5:
				String essensRichtung2 = in.next();
				functions.essenSpiel(essensRichtung2);
				// Spiel für Produkte in bestimmter Richtung
				break;
			default:
				//TODO: change error
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
