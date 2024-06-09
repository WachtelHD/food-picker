package de.dhbw.ase;

public class zutat {
    private String name;
    private String menge;

    public zutat(String name, String menge) {
        this.name = name;
        this.menge = menge;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMenge() {
        return menge;
    }

    public void setMenge(String menge) {
        this.menge = menge;
    }

    @Override
    public String toString() {
        return name + " " + menge;
    }
}