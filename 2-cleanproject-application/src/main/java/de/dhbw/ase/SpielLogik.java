package de.dhbw.ase;

import org.json.JSONObject;

public class SpielLogik {
    private final EssenService essenService;
    private final NaehrwertService naehrwertService;

    public SpielLogik(EssenService essenService, NaehrwertService naehrwertService) {
        this.essenService = essenService;
        this.naehrwertService = naehrwertService;
    }

    public String getEssensName(JSONObject essenObjekt) {
        return essenObjekt.getJSONArray("meals").getJSONObject(0).getString("strMeal");
    }

    public String getEssensId(JSONObject essenObjekt) {
        return essenObjekt.getJSONArray("meals").getJSONObject(0).getString("idMeal");
    }

    public void printEssenInformationen(BenutzerEingabe in, essen essen) {
        boolean amWählen = true;
        while (amWählen) {
            in.print("Möchtest du weitere Informationen über das Essen?");
            in.print("1 - Infos zu den Nährwerten");
            in.print("2 - Infos zu der Zubereitung");
            in.print("3 - Infos zu den Zutaten");
            in.print("4 - Vollständige Informationen");
            in.print("5 - Bild falls verfügbar");
            in.print("6 - Beenden");

            String wahl = in.getInput("Auswahl: ");
            switch (wahl) {
                case "1":
                    in.print(essen.getNaehrwerte().toString());
                    break;
                case "2":
                    in.print(essen.getRezept().toString());
                    break;
                case "3":
                    in.print(essen.getRezept().getYoutube());
                    break;
                case "4":
                    in.print(essen.toString());
                    break;
                case "5":
                    in.print(essen.getBild());
                    break;
                case "6":
                    amWählen = false;
                    break;
                default:
                    in.print("Bitte wähle eine Valide Option");
                    break;
            }
        }
    }
}
