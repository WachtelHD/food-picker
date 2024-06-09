package de.dhbw.ase;

import java.util.List;

public class zutatenListe {
    private List<zutat> zutaten;

    public zutatenListe(List<zutat> zutaten) {
        this.zutaten = zutaten;
    }

    public List<zutat> getzutaten() {
        return zutaten;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (zutat zutat : zutaten) {
            sb.append(zutat.toString()).append("\n");
        }
        return sb.toString();
    }
}
