package de.dhbw.ase;

public class essenKategorie {
    private String Id;
    private String kategorie;
    private String kategorieBild;
    private String kategorieBeschreibung;

    public essenKategorie(String id, String kategorie, String kategorieBild, String kategorieBeschreibung) {
        Id = id;
        this.kategorie = kategorie;
        this.kategorieBild = kategorieBild;
        this.kategorieBeschreibung = kategorieBeschreibung;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getKategorie() {
        return kategorie;
    }

    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }

    public String getKategorieBild() {
        return kategorieBild;
    }

    public void setKategorieBild(String kategorieBild) {
        this.kategorieBild = kategorieBild;
    }

    public String getKategorieBeschreibung() {
        return kategorieBeschreibung;
    }
    
    public void setKategorieBeschreibung(String kategorieBeschreibung) {
        this.kategorieBeschreibung = kategorieBeschreibung;
    }

    @Override
    public String toString() {
        return "Kategorie: " + this.kategorie +  "\n" +
        "Bild: " + this.kategorieBild + "\n" +
        "Beschreibung: " + this.kategorieBeschreibung + "\n" +
        "--------------------------------------------------------------------"
        ;
    }
}


