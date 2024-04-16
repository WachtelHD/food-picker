public class rezeptZutat {
    private String name;
    private String amount;

    // Constructor
    public rezeptZutat(String name, String amount) {
        this.name = name;
        this.amount = amount;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    // toString method to represent RecipeIngredient as a string
    @Override
    public String toString() {
        return amount + " " + name;
    }
}