package de.dhbw.ase;

import org.json.JSONObject;

public class RezeptService {

    private final ApiClient apiClient;

    public RezeptService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public JSONObject getRezeptById(String id) {
        return apiClient.get("lookup.php?i=" + id);
    }

    public JSONObject getZutatenByRezept(String id) {
        return apiClient.get("filter.php?i=" + id);
    }
}
