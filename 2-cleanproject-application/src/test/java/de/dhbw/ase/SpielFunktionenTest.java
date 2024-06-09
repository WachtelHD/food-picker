package de.dhbw.ase;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class SpielFunktionenTest {

    @Mock
    private EssenService essenService;

    @Mock
    private NaehrwertService naehrwertService;

    @Mock
    private JsonMapper jsonMapper;

    @Mock
    private RezeptService rezeptService;

    @Mock
    private BildService bildService;

    @Mock
    private KategorieService kategorieService;

    @Mock
    private BenutzerEingabe benutzerEingabe;

    @Spy
    @InjectMocks
    private SpielLogik spielLogik;

    @Spy
    @InjectMocks
    private SpielFunktionen spielFunktionen;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testZufälligesEssen() {
        JSONObject mockEssen = new JSONObject();
        mockEssen.put("meals", new JSONArray().put(new JSONObject().put("strMeal", "RandomMeal").put("idMeal", "456")));
        when(essenService.getZufälligesEssen()).thenReturn(mockEssen);

        spielFunktionen.zufälligesEssen();

        verify(essenService, times(1)).getZufälligesEssen();
    }

    @Test
    public void testGetEssensName() {
        JSONObject mockEssen = new JSONObject();
        mockEssen.put("meals", new JSONArray().put(new JSONObject().put("strMeal", "Pizza")));
        String name = spielFunktionen.getEssensName(mockEssen);
        assertEquals("Pizza", name);
    }

    @Test
    public void testGetEssensId() {
        JSONObject mockEssen = new JSONObject();
        mockEssen.put("meals", new JSONArray().put(new JSONObject().put("idMeal", "123")));
        String id = spielFunktionen.getEssensId(mockEssen);
        assertEquals("123", id);
    }

    @Test
    public void testRezeptServiceGetRezeptById() {
        JSONObject mockRezept = new JSONObject();
        mockRezept.put("meals", new JSONArray().put(new JSONObject().put("idMeal", "1").put("strMeal", "Pizza")));
        when(rezeptService.getRezeptÜberId("1")).thenReturn(mockRezept);

        JSONObject result = rezeptService.getRezeptÜberId("1");

        assertEquals(mockRezept, result);
        verify(rezeptService, times(1)).getRezeptÜberId("1");
    }
}

