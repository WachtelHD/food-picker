// package de.dhbw.ase;

// import java.time.Duration;
// import java.time.LocalDateTime;

// public class Aktivität {

// 	private final AktivitätsArt art;
// 	private final int wichtigkeit;
// 	private final int dringlichkeit;
// 	private final Duration dauer;
// 	private final LocalDateTime startzeit;
// 	private boolean beendet;

// 	public Aktivität(AktivitätsArt art, int wichtigkeit, int dringlichkeit, Duration dauer, LocalDateTime startzeit) {
// 		super();
// 		this.art = art;
// 		this.wichtigkeit = wichtigkeit;
// 		this.dringlichkeit = dringlichkeit;
// 		this.dauer = dauer;
// 		this.startzeit = startzeit;
// 		this.beendet = false;
// 	}

// 	public boolean beendet() {
// 		return this.beendet;
// 	}

// 	public void beende() {
// 		this.beendet = true;
// 	}

// 	public AktivitätsArt art() {
// 		return this.art;
// 	}

// 	public LocalDateTime startzeit() {
// 		return this.startzeit;
// 	}

// 	public LocalDateTime endzeit() {
// 		return this.startzeit.plus(this.dauer);
// 	}

// }
