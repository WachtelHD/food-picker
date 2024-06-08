package de.dhbw.ase;

import org.json.JSONArray;

public class Naehrwert {
    private final ApiClient apiClient;

    // recipe API
    // https://api.api-ninjas.com/v1/recipe?query=
    private static final String BASE_URL = "https://api.api-ninjas.com/v1/nutrition?query=";

    public NutritionService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public JSONArray getProductInfo(String params) {
        return apiClient.getArray(BASE_URL + params);
    }
}
