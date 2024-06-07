package de.dhbw.ase;

public class basisEssenInfo {

    private String Id;
    private String essen;
    private String essenBild;

    public basisEssenInfo(String id, String essen, String essenBild) {
        Id = id;
        this.essen = essen;
        this.essenBild = essenBild;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getEssen() {
        return essen;
    }

    public void setEssen(String essen) {
        this.essen = essen;
    }

    public String getEssenBild() {
        return essenBild;
    }

    public void setEssenBild(String essenBild) {
        this.essenBild = essenBild;
    }

    @Override
    public String toString() {
        return "Essen (" + this.Id + "):" + this.essen + "\n" + 
        "Bild: " + this.essenBild + "\n" +
        "--------------------------------------------------------------------";
    }
}

