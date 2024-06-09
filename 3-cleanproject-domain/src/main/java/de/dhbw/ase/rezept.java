package de.dhbw.ase;

import java.util.List;

public class rezept {
    private List<zutat> zutaten;
    private String anweisungen;
    private String youTube;

    // Constructor
    public rezept(List<zutat> zutaten, String anweisungen, String youTube) {
        this.zutaten = zutaten;
        this.anweisungen = anweisungen;
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
        return anweisungen;
    }

    public void setInstructions(String anweisungen) {
        this.anweisungen = anweisungen;
    }

    public String getYoutube() {
        return youTube;
    }

    public void setYoutube(String youTube) {
        this.youTube = youTube;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Zutaten:\n");
        for (zutat zutat : zutaten) {
            sb.append(zutat.toString()).append("\n");
        }
        sb.append("\nAnweisungen:\n").append(anweisungen).append("\n");
        sb.append("\nYouTube Link:\n").append(youTube).append("\n");
        return sb.toString();
    }
}

