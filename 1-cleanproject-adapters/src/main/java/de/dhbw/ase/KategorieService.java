package de.dhbw.ase;

import org.json.JSONObject;

public class KategorieService {

    private final ApiClient apiClient;

    public KategorieService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public JSONObject getKategorien() {
        return apiClient.get("categories.php");
    }

    public JSONObject getGerichteByKategorie(String kategorie) {
        return apiClient.get("filter.php?c=" + kategorie);
    }
}
