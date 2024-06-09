package de.dhbw.ase;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class SpielFunktionen {

    private final EssenService essenService;
    private final NaehrwertService naehrwertService;
    private final BildService bildService;
    private final KategorieService kategorieService;
    private final BenutzerEingabe in;
    private final SpielLogik spielLogik;
    private final JsonMapper json;
    private final RezeptService rezeptService;

    public SpielFunktionen(EssenService essenService, NaehrwertService naehrwertService, JsonMapper json, RezeptService rezeptService, BildService bildService, KategorieService kategorieService) {
        this.json = json;
        this.essenService = essenService;
        this.naehrwertService = naehrwertService;
        this.rezeptService = rezeptService;
        this.bildService = bildService;
        this.kategorieService = kategorieService;
        this.in = new BenutzerEingabe();
        this.spielLogik = new SpielLogik(essenService, naehrwertService);
    }

    public void essenAusgabe() {
        String essensTyp = in.getInput("Essens Auswahl: ");
        JSONObject essenObjekt = essenService.getEssenÜberName(essensTyp);
        String essenId = spielLogik.getEssensId(essenObjekt);

        // TODO: wieder hinzufügen -> APi calls limitiert
        // essen essenInstanz = json.generiereEssenInstanz(essenId);
        // this.essenInformationen(essenInstanz);
    }

    public void essenInSpezifischerRichtung() {
        List<essenKategorie> essenkat = json.generiereKategorieListe();
        List<basisEssenInfo> essenBasisInfoArray = new ArrayList<>();

        basisEssenInfo option = null;
        boolean amWählen = true;

        while(amWählen){
            System.out.println("╔══════════════════════════════════════════════════╗");
            System.out.println("║                     Kategorien                   ║");
            System.out.println("╚══════════════════════════════════════════════════╝");
            System.out.println("1 - Vollständige Informationen über die Kategorien Anzeigen");
            System.out.println("2 - Die einzelnen Kategorien Anzeigen");
            System.out.println("3 - Kategorie Auswählen");
            String wahl = in.getInput("Wahl: ");

            switch (wahl) {
                case "1":
                    //Detailierte Informationen über Kategorien ausgeben
                    for(essenKategorie kategorie : essenkat){
                        System.out.println(kategorie.toString());
                    }
                    break;
                case "2":
                    //Kategorien ausgeben
                    for(essenKategorie kategorie : essenkat){
                        System.out.println(kategorie.getKategorie());
                    }
                    break;
                case "3":
                    //Springe zur Auswahl
                    amWählen = false;
                    break;
                default:
                    System.out.println("Bitte wählen sie eine valide Option aus");
                    break;
            }
        }

        amWählen = true;

        while (amWählen) {
            String wahl = in.getInput("Wahl: ");
            try {
                essenBasisInfoArray = json.generiereBasisEssenInformationListe(wahl);
                amWählen = false;
            } catch (Exception e) {
                System.out.println("Bitte wähle eine Valide Option");
            }
        }

        amWählen = true;

        while(amWählen){
            System.out.println("╔══════════════════════════════════════════════════╗");
            System.out.println("║                      Optionen                    ║");
            System.out.println("╚══════════════════════════════════════════════════╝");
            System.out.println("1 - Vollständige Informationen über Optionen ausgeben");
            System.out.println("2 - Zufällige Option ausgeben");
            System.out.println("3 - nähere Details zur aktuellen Option");
            System.out.println("4 - Optionen über Essens-ID anzeigen");
            String wahl = in.getInput("Wahl: ");

            switch (wahl) {
                case "1":
                    // Ausgabe der Basis essen Informationen der gesamten Kategorie
                    for (basisEssenInfo info : essenBasisInfoArray) {
                        System.out.println(info.toString());
                    }
                    break;
                case "2":
                    // Wahl eines zufälligen essens der Kategorie
                    int randomNum = (int)(Math.random() * (essenBasisInfoArray.size() + 1));
                    option = essenBasisInfoArray.get(randomNum);
                    System.out.println(option.toString());
                    break;
                case "3":
                    // Fortfahren zu details des essens
                    essen essen = json.generiereEssenInstanz(option.getId());
                    this.essenInformationen(essen);
                    amWählen = false;
                    break;
                case "4":
                    // Details des essens über id anzeigen
                    String id = in.getInput("Id: ");
                    essen essenÜberId = json.generiereEssenInstanz(id);
                    this.essenInformationen(essenÜberId);
                    amWählen = false;
                    break;
                default:
                    System.out.println("Bitte wähle eine Valide Option");
                    break;
            }
        }
    }

    public void zufälligesEssen(){
        JSONObject zufälligesEssenJson = essenService.getZufälligesEssen();
        String essenId = this.getEssensId(zufälligesEssenJson);

        // TODO: wieder hinzufügen -> APi calls limitiert
        // essen essenInstanz = json.generiereEssenInstanz(essenId);
        // this.essenInformationen(essenInstanz);
    }

    public void essenSpiel() {
        List<JSONObject> mealArray = new ArrayList<>();
        int anzahl = Integer.parseInt(in.getInput("Wie viele Gerichte sollen gewählt werden: "));

        for(int i = 0; i <= anzahl; i++) {
            JSONObject zufälligesEssen = essenService.getZufälligesEssen();
            mealArray.add(zufälligesEssen);
        }

        while (mealArray.size() > 1) {
            System.out.println("Essen 1: " + getEssensName(mealArray.get(0)));
            System.out.println("Essen 2: " + getEssensName(mealArray.get(1)));
            int wahl = Integer.parseInt(in.getInput("Wahl: "));
            if (wahl == 1) {
                mealArray.remove(1);
            } else if (wahl == 2) {
                mealArray.remove(0);
            } else {
                System.out.print("Wähle bitte eine Valide Option");
                //TODO: catch wrong user input    
            }
        }

        String essenId = this.getEssensId(mealArray.get(0));
        essen essenInstanz = json.generiereEssenInstanz(essenId);
        this.essenInformationen(essenInstanz);
    }

    public void essenSpiel(String essensRichtung) {
        JSONObject zufälligesEssen = essenService.getEssenÜberKategorie(essensRichtung);
        List<JSONObject> mealArray = new ArrayList<>();
        List<Object> essenArray = zufälligesEssen.getJSONArray("meals").toList();

        for(int i = 0; i < Math.min(essenArray.size(), 10); i++) {
            JSONObject essen = new JSONObject(essenArray.get(i).toString());
            mealArray.add(essen);
        }

        while (mealArray.size() > 1) {
            System.out.println("Essen 1: " + mealArray.get(0).get("strMeal"));
            System.out.println("Essen 2: " + mealArray.get(1).get("strMeal"));
            int wahl = Integer.parseInt(in.getInput("Wahl: "));
            if (wahl == 1) {
                mealArray.remove(1);
            } else if (wahl == 2) {
                mealArray.remove(0);
            } else {
                System.out.print("Wähle bitte eine Valide Option");
                //TODO: catch wrong user input    
            }
        }

        String essenId = mealArray.get(0).getString("idMeal");
        essen essenInstanz = json.generiereEssenInstanz(essenId);
        this.essenInformationen(essenInstanz);
    }

    private void essenInformationen(essen essen) {
        boolean amWählen = true;

        while(amWählen){
            System.out.println("╔══════════════════════════════════════════════════╗");
            System.out.println("║            Informationen zum Essen               ║");
            System.out.println("╚══════════════════════════════════════════════════╝");
            System.out.println("1 - Infos zu den Nährwerten");
            System.out.println("2 - Infos zu der Zubereitung");
            System.out.println("3 - Infos zu den Zutaten");
            System.out.println("4 - Vollständige Informationen");
            System.out.println("5 - Bild falls verfügbar");
            System.out.println("6 - Beenden");
            String wahl = in.getInput("Auswahl: ");

            switch (wahl) {
                case "1":
                    //TODO: Nährwerte können nicht das genau gericht beschreiben -> extra name?
                    System.out.println("╔══════════════════════════════════════════════════╗");
                    System.out.println("║               Nährwerte                          ║");
                    System.out.println("╚══════════════════════════════════════════════════╝");
                    System.out.println(essen.getNaehrwerte().toString());
                    // Infos zu Nährwerten
                    break;
                case "2":
                    System.out.println("╔══════════════════════════════════════════════════╗");
                    System.out.println("║               Zubereitung                        ║");
                    System.out.println("╚══════════════════════════════════════════════════╝");
                    System.out.println(essen.getRezept().toString());
                    // Infos zu Zubereitung
                    break;
                case "3":
                    System.out.println("╔══════════════════════════════════════════════════╗");
                    System.out.println("║               Zutaten                            ║");
                    System.out.println("╚══════════════════════════════════════════════════╝");
                    System.out.println(essen.getRezept().getYoutube());
                    // Infos zu den Zutaten -> potentiell nährwerte für diese ausgeben.
                    break;
                case "4":
                    System.out.println("╔══════════════════════════════════════════════════╗");
                    System.out.println("║               Vollständige Informationen         ║");
                    System.out.println("╚══════════════════════════════════════════════════╝");
                    System.out.println(essen.toString());
                    // Bild
                    break;
                case "5":
                    System.out.println("╔══════════════════════════════════════════════════╗");
                    System.out.println("║               Bild                               ║");
                    System.out.println("╚══════════════════════════════════════════════════╝");
                    System.out.println(essen.getBild());
                    // bestellung
                    break;
                case "6":
                    amWählen = false;
                    // beenden
                    break;
                default:
                    //TODO: change error
                    System.out.println("Bitte wähle eine Valide Option");
                    break;
            }
        }
    }

    public String getEssensName(JSONObject essenObjekt){
        JSONArray meals = essenObjekt.getJSONArray("meals");
        JSONObject essen = meals.getJSONObject(0);
        return essen.getString("strMeal");
    }

    public String getEssensId(JSONObject essenObjekt){
        JSONArray meals = essenObjekt.getJSONArray("meals");
        JSONObject essen = meals.getJSONObject(0);
        return essen.getString("idMeal");
    }
}