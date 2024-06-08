import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import de.dhbw.ase.functions;

public class funktionalitaetTest {

    @Test 
    public void testEssenName(){
        functions funktionen = new functions();

        // Korrigierter JSON-String
        String testObjektString = "{\"meals\": [{\"strMeal\": \"foo\"}]}";

        // Erstellen des JSONObject
        JSONObject testObjekt = new JSONObject(testObjektString);

        // Aufruf der Methode
        String essenId = funktionen.getEssensName(testObjekt);

        // Überprüfung des Ergebnisses
        assertEquals("foo", essenId);
    }

    @Test 
    public void testEssenId(){
        functions funktionen = new functions();

        // Korrigierter JSON-String
        String testObjektString = "{\"meals\": [{\"idMeal\": \"foo\"}]}";

        // Erstellen des JSONObject
        JSONObject testObjekt = new JSONObject(testObjektString);

        // Aufruf der Methode
        String essenId = funktionen.getEssensId(testObjekt);

        // Überprüfung des Ergebnisses
        assertEquals("foo", essenId);
    }
    
}
