package de.dhbw.ase;

public class naehrwerte {

    energie energie;
    fett fett;
    kohlenhydrate kohlenhydrate;
    double eiweis;
    double salz;

    public naehrwerte(energie energie, fett fett, kohlenhydrate kohlenhydrate, double eiweis, double salz) {
        this.energie = energie;
        this.fett = fett;
        this.kohlenhydrate = kohlenhydrate;
        this.eiweis = eiweis;
        this.salz = salz;
    }

    public energie getEnergie() {
        return energie;
    }

    public void setEnergie(energie energie) {
        this.energie = energie;
    }

    public fett getFett() {
        return fett;
    }

    public void setFett(fett fett) {
        this.fett = fett;
    }

    public kohlenhydrate getKohlenhydrate() {
        return kohlenhydrate;
    }

    public void setKohlenhydrate(kohlenhydrate kohlenhydrate) {
        this.kohlenhydrate = kohlenhydrate;
    }

    public double getEiweis() {
        return eiweis;
    }

    public void setEiweis(double eiweis) {
        this.eiweis = eiweis;
    }

    public double getSalz() {
        return salz;
    }

    public void setSalz(double salz) {
        this.salz = salz;
    }

    @Override
    public String toString(){
        return this.energie.toString() + "\n" +
        this.fett.toString() + "\n" +
        this.kohlenhydrate.toString() + "\n" +
        "Eiweis: " + this.eiweis + "\n" +
        "Salz: " + this.salz + "\n";
    }
}
