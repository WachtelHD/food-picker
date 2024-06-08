package de.dhbw.ase;

import org.json.JSONArray;
import org.json.JSONObject;

public class EssenService {
    private final ApiClient apiClient;

    // www.themealdb.com/api/json/v1/1/filter.php?i=chicken_breast -> ingredient
    // www.themealdb.com/api/json/v1/1/filter.php?a=Canadian -> Area
    // www.themealdb.com/api/json/v1/1/lookup.php?i=52772 -> meal details by id
    private static final String URL = "https://www.themealdb.com/api/json/v1/1/";

    public EssenService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public JSONObject getZufälligesEssen() {
        return apiClient.get(URL + "random.php");
    }

    public JSONObject getEssenÜberName(String foodName) {
        return apiClient.get(URL + "search.php?s=" + foodName);
    }

    public JSONObject getEssensKategorie() {
        return apiClient.get(URL + "categories.php");
    }

    public JSONObject getEssenÜberId(String id) {
        return apiClient.get(URL + "lookup.php?i=" + id);
    }

    public JSONObject getEssenÜberKategorie(String category) {
        return apiClient.get(URL + "filter.php?c=" + category);
    }
}
