package de.dhbw.ase;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiClientImpl implements ApiClient {
    private final String apiSchluessel;

    public ApiClientImpl(String apiSchluessel) {
        this.apiSchluessel = apiSchluessel;
    }

    @Override
    public JSONObject get(String endpoint) {
        try {
            URL url = new URL(endpoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");
            connection.setRequestProperty("X-Api-Key", apiSchluessel);
            BufferedReader br = null;
            if (connection.getResponseCode() == 200) {
                br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String strCurrentLine;
                while ((strCurrentLine = br.readLine()) != null) {
                    return new JSONObject(strCurrentLine);
                }
            } else {
                throw new ApiException("Error Response in get: " + connection.getResponseCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public JSONArray getArray(String endpoint) {
        try {
            URL url = new URL(endpoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");
            connection.setRequestProperty("X-Api-Key", apiSchluessel);
            BufferedReader br = null;
            if (connection.getResponseCode() == 200) {
                br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String strCurrentLine;
                while ((strCurrentLine = br.readLine()) != null) {
                    return new JSONArray(strCurrentLine);
                }
            } else {
                throw new ApiException("Error Respnonse in getArray: " + connection.getResponseCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    
}
