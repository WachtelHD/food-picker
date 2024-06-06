package de.dhbw.ase;

import java.util.List;

public class rezept {
    private String title;
    private List<rezeptZutat> ingredients;
    private String instructions;
    private String youTube;

    // Constructor
    public rezept(String title, List<rezeptZutat> ingredients, String instruction, String youTube) {
        this.title = title;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.youTube = youTube;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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
        return "Rezept:\n" + 
        "Name: " + this.title + "\n" + 
        "Zutaten: " + this.ingredients + "\n" +
        "Anweisungen: " + this.instructions;
    }
}

