package de.dhbw.ase;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonMapper {

    public essen generiereEssenInstanz(String essenId){
        get get = new get();

        JSONObject essenJsonAntwort = get.getEssenÜberId(essenId);

        JSONObject essenJson = essenJsonAntwort.getJSONArray("meals").getJSONObject(0);

        String essenName = essenJson.getString("strMeal");

        String essenAnfrage = essenName.replace(" ", "+");
        
        JSONArray nährwertArray = get.getProductInfo(essenAnfrage);

        List<rezeptZutat> zutaten = new ArrayList<rezeptZutat>();

        for(int i = 1; i <= 20; i++){
            if(!essenJson.getString("strIngredient" + i).equals("")) break;
            if(!essenJson.get("strIngredient" + i).equals(null)) break;

            zutaten.add(
                new rezeptZutat(essenJson.getString("strIngredient" + i), essenJson.getString("strMeasure" + i))
            );

        }

        rezept rezept = new rezept(essenName,zutaten,essenJson.getString("strInstructions"),essenJson.getString("strYoutube"));

        //generierung der einzelnen Nährwertetabellen

        for(int i = 0; i < nährwertArray.length(); i++) {
            JSONObject obj = nährwertArray.getJSONObject(i);
            energie energie = new energie(obj.getDouble("calories"), 0);
            fett fett = new fett(obj.getDouble("fat_total_g"),obj.getDouble("fat_saturated_g"), 0, 0);
            kohlenhydrate kohlenhydrate = new kohlenhydrate(obj.getDouble("carbohydrates_total_g"), obj.getDouble("sugar_g"));
            naehrwerte Werte = new naehrwerte(energie, fett, kohlenhydrate, obj.getDouble("protein_g"), obj.getDouble("sugar_g")); //change suger -> salt
            essen Essen = new essen(obj.get("name").toString(), rezept, Werte);
            System.out.println(Essen.toString());
        }

        return new essen(essenId, null, null);
    }

}
