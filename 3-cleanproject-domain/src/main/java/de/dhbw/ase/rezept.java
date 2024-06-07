package de.dhbw.ase;

import java.util.List;

public class rezept {
    private List<rezeptZutat> ingredients;
    private String instructions;
    private String youTube;

    // Constructor
    public rezept(List<rezeptZutat> ingredients, String instruction, String youTube) {
        this.ingredients = ingredients;
        this.instructions = instruction;
        this.youTube = youTube;
    }

    // Getters and setters
    public List<rezeptZutat> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<rezeptZutat> ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getYoutube() {
        return instructions;
    }

    public void setYoutube(String youTube) {
        this.youTube = youTube;
    }

    // toString method to represent Recipe as a string
    @Override
    public String toString() {
        String zutaten = "";
        for(rezeptZutat zutat:this.ingredients){
            zutaten = zutaten + zutat.toString() + "\n";
        }

        return "Rezept:\n" + 
        "Zutaten: " + "\n" +
        zutaten +
        "Anweisungen: " + this.instructions;
    }
}

