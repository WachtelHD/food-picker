package de.dhbw.ase;

public class essen {
    private String name;
    private rezept rezept;
    private naehrwerte naehrwerte;
    
    public essen(String name, rezept rezept, naehrwerte naehrwerte) {
        this.name = name;
        this.rezept = rezept;
        this.naehrwerte = naehrwerte;
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

    @Override
    public String toString(){
        if (this.rezept != null){
            return "Infos:\n" + 
            "Name: " + this.name  + "\n" + 
            this.rezept.toString() + "\n"+ 
            this.naehrwerte.toString();
        }
        else{
            return "Infos:\n" + 
            "Name: " + this.name + "\n" + 
            this.naehrwerte.toString(); 
        }
        
    }

}
