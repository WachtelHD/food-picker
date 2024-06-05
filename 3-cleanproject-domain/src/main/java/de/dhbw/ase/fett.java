package de.dhbw.ase;

public class fett {

    private double insgesamt;
    private double gesättigt;
    private double ungesättigt;
    private double mehrfachUngesättigt;

    public fett(double insgesamt, double gesättigt, double ungesättigt, double mehrfachUngesättigt) {
        this.insgesamt = insgesamt;
        this.gesättigt = gesättigt;
        this.ungesättigt = ungesättigt;
        this.mehrfachUngesättigt = mehrfachUngesättigt;
    }

    public double getInsgesamt() {
        return insgesamt;
    }

    public void setInsgesamt(double insgesamt) {
        this.insgesamt = insgesamt;
    }

    public double getGesättigt() {
        return gesättigt;
    }

    public void setGesättigt(double gesättigt) {
        this.gesättigt = gesättigt;
    }

    public double getungesättigt() {
        return ungesättigt;
    }

    public void setungesättigt(double ungesättigt) {
        this.ungesättigt = ungesättigt;
    }

    public double getMehrfachUngesättigt() {
        return mehrfachUngesättigt;
    }

    public void setMehrfachUngesättigt(double mehrfachUngesättigt) {
        this.mehrfachUngesättigt = mehrfachUngesättigt;
    }

    @Override
    public String toString(){
        return  "Fett:\n" +
                "Insgesamt: " + this.insgesamt + "\n" +
                "Gesättigt: " + this.gesättigt + "\n" +
                "Ungesättigt: " + this.ungesättigt + "\n" +
                "Mehrfach ungesättigt: " + this.mehrfachUngesättigt + "\n";
    }
}

