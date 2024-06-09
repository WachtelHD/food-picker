package de.dhbw.ase;

import org.json.JSONObject;

public class BildService {

    private final ApiClient apiClient;

    public BildService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public JSONObject getBildById(String id) {
        return apiClient.get("images.php?i=" + id);
    }

    public JSONObject getBildByName(String name) {
        return apiClient.get("images.php?s=" + name);
    }
}
