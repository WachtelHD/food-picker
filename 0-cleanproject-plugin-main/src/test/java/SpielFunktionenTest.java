import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import de.dhbw.ase.BenutzerEingabe;
import de.dhbw.ase.BildService;
import de.dhbw.ase.EssenService;
import de.dhbw.ase.JsonMapper;
import de.dhbw.ase.KategorieService;
import de.dhbw.ase.NaehrwertService;
import de.dhbw.ase.RezeptService;
import de.dhbw.ase.SpielFunktionen;
import de.dhbw.ase.SpielLogik;
import de.dhbw.ase.basisEssenInfo;
import de.dhbw.ase.energie;
import de.dhbw.ase.essen;
import de.dhbw.ase.essenKategorie;
import de.dhbw.ase.fett;
import de.dhbw.ase.kohlenhydrate;
import de.dhbw.ase.naehrwerte;
import de.dhbw.ase.rezept;
import de.dhbw.ase.zutat;

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
    public void testEssenAusgabe() {
        SpielFunktionen spyspielFunktionen = Mockito.spy(spielFunktionen);
        essen mockEssen = new essen(null, null, null, null);
        JSONObject mockEssenJson = new JSONObject();
        mockEssenJson.put("meals", new JSONArray().put(new JSONObject().put("strMeal", "Pizza").put("idMeal", "123")));
        
        when(benutzerEingabe.getInput("Essens Auswahl: ")).thenReturn("Pizza");
        when(essenService.getEssenÜberName("Pizza")).thenReturn(mockEssenJson);
        when(jsonMapper.generiereEssenInstanz("123")).thenReturn(mockEssen);

        doNothing().when(spyspielFunktionen).essenInformationen(mockEssen);

        spyspielFunktionen.essenAusgabe();

        //essen Info

        verify(benutzerEingabe, times(1)).getInput("Essens Auswahl: ");
        verify(essenService, times(1)).getEssenÜberName("Pizza");
        verify(jsonMapper, times(1)).generiereEssenInstanz("123");
        verify(spielFunktionen, times(1)).essenInformationen(mockEssen);
    }

    @Test
    public void testEssenInSpezifischerRichtung() {
        essenKategorie ek = new essenKategorie("1", "Italienisch", "img.png", "Beschreibung");
        List<essenKategorie> mockKategorien = new ArrayList<essenKategorie>();
        mockKategorien.add(ek);
        when(jsonMapper.generiereKategorieListe()).thenReturn(mockKategorien);
        when(benutzerEingabe.getInput("Wahl: ")).thenReturn("3", "Italienisch");

        spielFunktionen.essenInSpezifischerRichtung();

        verify(jsonMapper, times(1)).generiereKategorieListe();
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
    public void testEssenSpiel() {
        JSONObject mockEssen1 = new JSONObject();
        mockEssen1.put("meals", new JSONArray().put(new JSONObject().put("strMeal", "Meal1").put("idMeal", "1")));
        JSONObject mockEssen2 = new JSONObject();
        mockEssen2.put("meals", new JSONArray().put(new JSONObject().put("strMeal", "Meal2").put("idMeal", "2")));
        when(benutzerEingabe.getInput("Wie viele Gerichte sollen gewählt werden: ")).thenReturn("1");
        when(essenService.getZufälligesEssen()).thenReturn(mockEssen1).thenReturn(mockEssen2);
        when(benutzerEingabe.getInput("Wahl: ")).thenReturn("1", "1");

        spielFunktionen.essenSpiel();

        //essen Info

        verify(essenService, times(2)).getZufälligesEssen();
    }

    @Test
    public void testEssenSpielMitRichtung() {
        JSONObject mockEssen = new JSONObject();
        mockEssen.put("meals", new JSONArray()
            .put(new JSONObject().put("strMeal", "Meal1").put("idMeal", "1"))
            .put(new JSONObject().put("strMeal", "Meal2").put("idMeal", "2")));
        when(essenService.getEssenÜberKategorie("Italienisch")).thenReturn(mockEssen);
        when(benutzerEingabe.getInput("Wahl: ")).thenReturn("1", "1");

        spielFunktionen.essenSpiel("Italienisch");

        verify(essenService, times(1)).getEssenÜberKategorie("Italienisch");
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
    public void testEssenInformationen() {
        zutat zutat = new zutat("Mehl", "200g");
        List<zutat> mockZutat = new ArrayList<zutat>();
        mockZutat.add(zutat);

        essen mockEssen = new essen("Pizza",new rezept(mockZutat, "Backen", "youtube.com"), 
            new naehrwerte(new energie(200, 0), new fett(10, 5, 0, 0), 
            new kohlenhydrate(20, 10), 15, 10),
        "bild.png");

        when(benutzerEingabe.getInput("Auswahl: ")).thenReturn("6");

        spielFunktionen.essenInformationen(mockEssen);

        // Keine spezifischen Verifikationen, da die Methode interaktive Elemente enthält.
    }

    @Test
    public void testJsonMapperGeneriereBasisEssenInformationListe() {
        JSONObject mockResponse = new JSONObject(MockDaten.essenBasisInfoMock());
        when(essenService.getEssenÜberKategorie("Italienisch")).thenReturn(mockResponse);

        List<basisEssenInfo> result = jsonMapper.generiereBasisEssenInformationListe("Italienisch");

        assertEquals(2, result.size());
        assertEquals("1", result.get(0).getId());
        assertEquals("Pizza", result.get(0).getEssen());
        assertEquals("img1.png", result.get(0).getEssenBild());
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

