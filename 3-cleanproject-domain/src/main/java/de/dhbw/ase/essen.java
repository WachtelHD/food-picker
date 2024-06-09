package de.dhbw.ase;

public class essen {
    private String name;
    private rezept rezept;
    private naehrwerte naehrwerte;
    private String bild;
    
    public essen(String name, rezept rezept, naehrwerte naehrwerte, String bild) {
        this.name = name;
        this.rezept = rezept;
        this.naehrwerte = naehrwerte;
        this.bild = bild;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public rezept getRezept() {
        return rezept;
    }

    public void setRezept(rezept rezept) {
        this.rezept = rezept;
    }

    public naehrwerte getNaehrwerte() {
        return naehrwerte;
    }

    public void setNaehrwerte(naehrwerte naehrwerte) {
        this.naehrwerte = naehrwerte;
    }

    public String getBild() {
        return bild;
    }

    public void setNaehrwerte(String bild) {
        this.bild = bild;
    }

    @Override
    public String toString() {
        return String.format("Name: %s\n\nRezept:\n%s\n\nNährwerte:\n%s\n\nBild: %s", 
                             name, rezept.toString(), naehrwerte.toString(), bild);
    }

}
