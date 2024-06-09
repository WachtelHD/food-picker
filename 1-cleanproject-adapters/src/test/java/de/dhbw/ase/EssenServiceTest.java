package de.dhbw.ase;

import org.json.JSONArray;
import org.json.JSONObject;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class EssenServiceTest {

    private ApiClient mockApiClient;
    private EssenService essenService;

    @BeforeEach
    public void setUp() {
        mockApiClient = Mockito.mock(ApiClient.class);
        essenService = new EssenService(mockApiClient);
    }

    @Test
    public void testGetZufälligesEssen() throws ApiException {
        JSONObject mockResponse = new JSONObject();
        mockResponse.put("meals", new JSONArray().put(new JSONObject().put("strMeal", "Pizza").put("idMeal", "123")));

        when(mockApiClient.get("https://www.themealdb.com/api/json/v1/1/random.php")).thenReturn(mockResponse);

        JSONObject result = essenService.getZufälligesEssen();

        assertNotNull(result);
        assertTrue(result.has("meals"));
        assertEquals("Pizza", result.getJSONArray("meals").getJSONObject(0).getString("strMeal"));

        verify(mockApiClient, times(1)).get("https://www.themealdb.com/api/json/v1/1/random.php");
    }

    @Test
    public void testGetEssenÜberName() throws ApiException {
        String foodName = "Pizza";
        JSONObject mockResponse = new JSONObject();
        mockResponse.put("meals", new JSONArray().put(new JSONObject().put("strMeal", "Pizza").put("idMeal", "123")));

        when(mockApiClient.get("https://www.themealdb.com/api/json/v1/1/search.php?s=" + foodName)).thenReturn(mockResponse);

        JSONObject result = essenService.getEssenÜberName(foodName);

        assertNotNull(result);
        assertTrue(result.has("meals"));
        assertEquals("Pizza", result.getJSONArray("meals").getJSONObject(0).getString("strMeal"));

        verify(mockApiClient, times(1)).get("https://www.themealdb.com/api/json/v1/1/search.php?s=" + foodName);
    }

    @Test
    public void testGetEssensKategorie() throws ApiException {
        JSONObject mockResponse = new JSONObject();
        mockResponse.put("categories", new JSONArray().put(new JSONObject().put("idCategory", "1").put("strCategory", "Beef")));

        when(mockApiClient.get("https://www.themealdb.com/api/json/v1/1/categories.php")).thenReturn(mockResponse);

        JSONObject result = essenService.getEssensKategorie();

        assertNotNull(result);
        assertTrue(result.has("categories"));
        assertEquals("Beef", result.getJSONArray("categories").getJSONObject(0).getString("strCategory"));

        verify(mockApiClient, times(1)).get("https://www.themealdb.com/api/json/v1/1/categories.php");
    }

    @Test
    public void testGetEssenÜberId() throws ApiException {
        String id = "52772";
        JSONObject mockResponse = new JSONObject();
        mockResponse.put("meals", new JSONArray().put(new JSONObject().put("idMeal", "52772").put("strMeal", "Pizza")));

        when(mockApiClient.get("https://www.themealdb.com/api/json/v1/1/lookup.php?i=" + id)).thenReturn(mockResponse);

        JSONObject result = essenService.getEssenÜberId(id);

        assertNotNull(result);
        assertTrue(result.has("meals"));
        assertEquals("Pizza", result.getJSONArray("meals").getJSONObject(0).getString("strMeal"));

        verify(mockApiClient, times(1)).get("https://www.themealdb.com/api/json/v1/1/lookup.php?i=" + id);
    }

    @Test
    public void testGetEssenÜberKategorie() throws ApiException {
        String category = "Seafood";
        JSONObject mockResponse = new JSONObject();
        mockResponse.put("meals", new JSONArray().put(new JSONObject().put("idMeal", "52959").put("strMeal", "Ceviche")));

        when(mockApiClient.get("https://www.themealdb.com/api/json/v1/1/filter.php?c=" + category)).thenReturn(mockResponse);

        JSONObject result = essenService.getEssenÜberKategorie(category);

        assertNotNull(result);
        assertTrue(result.has("meals"));
        assertEquals("Ceviche", result.getJSONArray("meals").getJSONObject(0).getString("strMeal"));

        verify(mockApiClient, times(1)).get("https://www.themealdb.com/api/json/v1/1/filter.php?c=" + category);
    }
}
