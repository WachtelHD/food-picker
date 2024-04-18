package de.dhbw.ase;

import java.util.List;

public class rezept {
    private String title;
    private List<rezeptZutat> ingredients;
    private List<String> instructions;

    // Constructor
    public rezept(String title, List<rezeptZutat> ingredients, List<String> instructions) {
        this.title = title;
        this.ingredients = ingredients;
        this.instructions = instructions;
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

    public List<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }

    // toString method to represent Recipe as a string
    @Override
    public String toString() {
        return "Recipe{" +
                "title='" + title + '\'' +
                ", ingredients=" + ingredients +
                ", instructions=" + instructions +
                '}';
    }
}

