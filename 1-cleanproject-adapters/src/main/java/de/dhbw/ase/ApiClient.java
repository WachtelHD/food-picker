package de.dhbw.ase;

import org.json.JSONArray;
import org.json.JSONObject;

public interface ApiClient {
    JSONObject get(String endpoint);
    JSONArray getArray(String endpoint);
}
