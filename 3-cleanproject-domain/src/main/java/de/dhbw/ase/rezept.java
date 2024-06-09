package de.dhbw.ase;

import java.util.List;

public class rezept {
    private List<zutat> zutaten;
    private String vorgehen;
    private String youTube;

    // Constructor
    public rezept(List<zutat> zutaten, String vorgehen, String youTube) {
        this.zutaten = zutaten;
        this.vorgehen = vorgehen;
        this.youTube = youTube;
    }

    // Getters and setters
    public List<zutat> getIngredients() {
        return zutaten;
    }

    public void setIngredients(List<zutat> zutaten) {
        this.zutaten = zutaten;
    }

    public String getInstructions() {
        return vorgehen;
    }

    public void setInstructions(String vorgehens) {
        this.vorgehen = vorgehens;
    }

    public String getYoutube() {
        return youTube;
    }

    public void setYoutube(String youTube) {
        this.youTube = youTube;
    }

    @Override
    public String toString() {
        String zutaten = "";
        for(zutat zutat:this.zutaten){
            zutaten = zutaten + zutat.toString() + "\n";
        }

        return "Rezept:\n" + 
        "Zutaten: " + "\n" +
        zutaten +
        "Anweisungen: " + this.vorgehen;
    }
}

