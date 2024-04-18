package de.dhbw.ase;

public class kohlenhydrate {

    private double insgesamt;
    private double zucker;

    public kohlenhydrate(double insgesamt, double zucker) {
        this.insgesamt = insgesamt;
        this.zucker = zucker;
    }

    public double getInsgesamt() {
        return insgesamt;
    }

    public void setInsgesamt(double insgesamt) {
        this.insgesamt = insgesamt;
    }

    public double getZucker() {
        return zucker;
    }

    public void setZucker(double zucker) {
        this.zucker = zucker;
    }
}

