package de.dhbw.ase;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonMapper {

    GetFunktionen get = new GetFunktionen();

    //generiert eine Kategorien Liste 

    public List<basisEssenInfo> generiereBasisEssenInformationListe(String wahl){

        JSONObject essenJson = get.getProductRange(wahl);

        List<basisEssenInfo> essenBasisInfoArray = new ArrayList<basisEssenInfo>();

        JSONArray essenArray = essenJson.getJSONArray("meals");

        for(int i = 0; i < essenArray.length(); i++) {
            JSONObject kategorieObjekt = essenArray.getJSONObject(i);

            String essenId = kategorieObjekt.getString("idMeal");
            String essenString = kategorieObjekt.getString("strMeal");
            String essenBild = kategorieObjekt.getString("strMealThumb");
            
            basisEssenInfo essen = new basisEssenInfo(essenId,essenString,essenBild);
            essenBasisInfoArray.add(essen);
        }

        return essenBasisInfoArray;
    }

    public List<essenKategorie> generiereKategorieListe(){
        JSONObject essenKategorie = get.getEssenKategorien();

        List<essenKategorie> essenKategorieArray = new ArrayList<essenKategorie>();

        JSONArray kategorieArray = essenKategorie.getJSONArray("categories");

        for(int i = 0; i < kategorieArray.length(); i++) {
            JSONObject kategorieObjekt = kategorieArray.getJSONObject(i);

            String kategorieId = kategorieObjekt.getString("idCategory");
            String kategorieString = kategorieObjekt.getString("strCategory");
            String kategorieBild = kategorieObjekt.getString("strCategoryThumb");
            String kategorieBeschreibung = kategorieObjekt.getString("strCategoryDescription");
            
            essenKategorie kategorie = new essenKategorie(kategorieId,kategorieString,kategorieBild,kategorieBeschreibung);
            essenKategorieArray.add(kategorie);
        }

        return essenKategorieArray;
    }

    //generiert eine essenInstanz abhängig von der essenId

    public essen generiereEssenInstanz(String essenId){
        JSONObject essenJsonAntwort = get.getEssenÜberId(essenId);

        JSONObject essenJson = essenJsonAntwort.getJSONArray("meals").getJSONObject(0);

        String essenName = essenJson.getString("strMeal");

        String essenBild = essenJson.getString("strMealThumb");

        String essenAnfrage = essenName.replace(" ", "+");

        System.out.println(essenAnfrage);

        JSONArray nährwertArray = get.getProductInfo(essenAnfrage);

        System.out.println(nährwertArray.toString());

        List<rezeptZutat> zutaten = new ArrayList<rezeptZutat>();

        for(int i = 1; i <= 20; i++){
            if(!essenJson.getString("strIngredient" + i).equals("")) break;
            if(!essenJson.get("strIngredient" + i).equals(null)) break;

            zutaten.add(
                new rezeptZutat(essenJson.getString("strIngredient" + i), essenJson.getString("strMeasure" + i))
            );
        }

        rezept rezept = new rezept(zutaten,essenJson.getString("strInstructions"),essenJson.getString("strYoutube"));

        //generierung der einzelnen Nährwertetabellen

        essen Essen = new essen(essenName, rezept, null, essenBild);

        for(int i = 0; i < nährwertArray.length(); i++) {
            JSONObject obj = nährwertArray.getJSONObject(i);
            energie energie = new energie(obj.getDouble("calories"), 0);
            fett fett = new fett(obj.getDouble("fat_total_g"),obj.getDouble("fat_saturated_g"), 0, 0);
            kohlenhydrate kohlenhydrate = new kohlenhydrate(obj.getDouble("carbohydrates_total_g"), obj.getDouble("sugar_g"));
            naehrwerte werte = new naehrwerte(energie, fett, kohlenhydrate, obj.getDouble("protein_g"), obj.getDouble("sugar_g")); //change suger -> salt
            Essen = new essen(obj.getString("name"), rezept, werte, essenBild);
        }

        return Essen;
    }

}
