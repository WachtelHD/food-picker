package de.dhbw.ase;

import org.json.JSONArray;
import org.json.JSONObject;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class NaehrwertServiceTest {

    private ApiClient mockApiClient;
    private NaehrwertService naehrwertService;

    @BeforeEach
    public void setUp() {
        mockApiClient = Mockito.mock(ApiClient.class);
        naehrwertService = new NaehrwertService(mockApiClient);
    }

    @Test
    public void testGetProductInfo() throws ApiException {
        String params = "apple";
        JSONArray mockResponse = new JSONArray();
        mockResponse.put(new JSONObject().put("name", "apple").put("calories", 52));

        when(mockApiClient.getArray("https://api.api-ninjas.com/v1/nutrition?query=" + params)).thenReturn(mockResponse);

        JSONArray result = naehrwertService.getProductInfo(params);

        assertNotNull(result);
        assertEquals(1, result.length());
        assertEquals("apple", result.getJSONObject(0).getString("name"));
        assertEquals(52, result.getJSONObject(0).getInt("calories"));

        verify(mockApiClient, times(1)).getArray("https://api.api-ninjas.com/v1/nutrition?query=" + params);
    }

    @Test
    public void testGetProductInfoWithEmptyResponse() throws ApiException {
        String params = "nonexistentfood";
        JSONArray mockResponse = new JSONArray();

        when(mockApiClient.getArray("https://api.api-ninjas.com/v1/nutrition?query=" + params)).thenReturn(mockResponse);

        JSONArray result = naehrwertService.getProductInfo(params);

        assertNotNull(result);
        assertEquals(0, result.length());

        verify(mockApiClient, times(1)).getArray("https://api.api-ninjas.com/v1/nutrition?query=" + params);
    }
}
