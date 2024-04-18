package de.dhbw.ase;

public class fett {

    private double insgesamt;
    private double gesättigt;
    private double ungesätigt;
    private double mehrfachUngesättigt;

    public fett(double insgesamt, double gesättigt, double ungesätigt, double mehrfachUngesättigt) {
        this.insgesamt = insgesamt;
        this.gesättigt = gesättigt;
        this.ungesätigt = ungesätigt;
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

    public double getUngesätigt() {
        return ungesätigt;
    }

    public void setUngesätigt(double ungesätigt) {
        this.ungesätigt = ungesätigt;
    }

    public double getMehrfachUngesättigt() {
        return mehrfachUngesättigt;
    }

    public void setMehrfachUngesättigt(double mehrfachUngesättigt) {
        this.mehrfachUngesättigt = mehrfachUngesättigt;
    }
}

