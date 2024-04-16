// package de.dhbw.ase;

// import java.time.Duration;
// import java.time.LocalDateTime;
// import java.util.LinkedList;
// import java.util.List;

// public class EinfacherBevölkerungsGenerator implements BevölkerungsGenerator {

// 	public Bevölkerung generiere(int anzahlPersonen, List<AktivitätsArt> aktivitätenArten, int anzahlAktivitäten,
// 			Duration aktivitätenDauer, List<Fortbewegungsmittel> fortbewegungsmittel) {
// 		List<Person> personen = new LinkedList<Person>();
// 		for (int id = 0; id < anzahlPersonen; id++) {
// 			LocalDateTime startzeit = LocalDateTime.of(2023, 10, 31, 0, 0);
// 			LocalDateTime letzteAktivitätsStartzeit = startzeit;
// 			List<Aktivität> aktivitäten = new LinkedList<Aktivität>();
// 			for (int aktivitätsId = 0; aktivitätsId < anzahlAktivitäten; aktivitätsId++) {
// 				for (AktivitätsArt aktvitätsArt : aktivitätenArten) {
// 					LocalDateTime aktivitätsStartzeit = letzteAktivitätsStartzeit.plus(aktivitätenDauer);
// 					aktivitäten
// 							.add(new Aktivität(aktvitätsArt, id, aktivitätsId, aktivitätenDauer, aktivitätsStartzeit));
// 					letzteAktivitätsStartzeit = aktivitätsStartzeit;
// 				}
// 			}
// 			personen.add(new Person(null, aktivitäten, fortbewegungsmittel, new LinkedList<Weg>()));
// 		}
// 		return new Bevölkerung(personen);
// 	}
// }
