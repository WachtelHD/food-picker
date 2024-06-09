package de.dhbw.ase;

import org.json.JSONArray;

public class NaehrwertService {
    private final ApiClient apiClient;

    // Nährwerte API
    // Indem man eine API-Call aufruft an api-ninjas, werden hier
    // die Nährwerte eines bestimmten Rezeptes ausgegeben.
    // https://api.api-ninjas.com/v1/recipe?query=
    private static final String BASE_URL = "https://api.api-ninjas.com/v1/nutrition?query=";

    public NaehrwertService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public JSONArray getProductInfo(String params) {
        return apiClient.getArray(BASE_URL + params);
    }
}
