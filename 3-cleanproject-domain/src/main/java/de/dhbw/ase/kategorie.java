package de.dhbw.ase;

public class kategorie {
    private String id;
    private String name;
    private String beschreibung;

    public kategorie(String id, String name, String beschreibung) {
        this.id = id;
        this.name = name;
        this.beschreibung = beschreibung;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    @Override
    public String toString() {
        return "Kategorie: " + name + "\nBeschreibung: " + beschreibung;
    }
}
