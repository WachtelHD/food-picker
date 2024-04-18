package de.dhbw.ase;

public class energie {

    private double kcal;
    private double kJ;

    public energie(double kcal, double kJ) {
        this.kcal = kcal;
        this.kJ = kJ;
    }

    public double getKcal() {
        return kcal;
    }

    public void setKcal(double kcal) {
        this.kcal = kcal;
    }

    public double getkJ() {
        return kJ;
    }

    public void setkJ(double kJ) {
        this.kJ = kJ;
    }
}

