package de.dhbw.ase;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class get {

    public get() {
        
    }
    public static void main(String[] args) {
       
    }

    public JSONObject getRandomFood(){
        String APIKey = "1";

        try {
            URL url = new URL("https://www.themealdb.com/api/json/v1/1/random.php");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");
            connection.setRequestProperty("X-Api-Key", APIKey);
            
            BufferedReader br = null;
            if (connection.getResponseCode() == 200) {
                br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String strCurrentLine;
                    while ((strCurrentLine = br.readLine()) != null) {
                        // System.out.println(strCurrentLine);
                        JSONObject zufälligesEssenJSON = new JSONObject(strCurrentLine);
                        return zufälligesEssenJSON;
                    }
            } else {
                br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                String strCurrentLine;
                    while ((strCurrentLine = br.readLine()) != null) {
                        System.out.println(strCurrentLine);
                    }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void getProductRange(String essensRichtung){
        String APIKey = "1";

        try {
            URL url = new URL("https://www.themealdb.com/api/json/v1/1/filter.php?c=" + essensRichtung);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");
            connection.setRequestProperty("X-Api-Key", APIKey);
            
            BufferedReader br = null;
            if (connection.getResponseCode() == 200) {
                br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String strCurrentLine;
                    while ((strCurrentLine = br.readLine()) != null) {
                        System.out.println(strCurrentLine);
                        JSONObject json = new JSONObject(strCurrentLine);
                        System.out.println(""); 
                        System.out.println(json.getJSONArray("meals")); 
                        JSONArray meals = json.getJSONArray("meals");
                        System.out.println(""); 
                        System.out.println(meals.getJSONObject(0)); 
                        json = meals.getJSONObject(0);
                        System.out.println(""); 
                        System.out.println(json.getString("strMeal")); 
                    }
            } else {
                br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                String strCurrentLine;
                    while ((strCurrentLine = br.readLine()) != null) {
                        System.out.println(strCurrentLine);
                    }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getProductInfo(String params){
        System.out.println("test");
        String APIKey = "3kTkxnTFVv/5fW3/lKu70A==fHOzKx39l17N3X0C";


        // recipe API
        // https://api.api-ninjas.com/v1/recipe?query=

        try {
            URL url = new URL("https://api.api-ninjas.com/v1/nutrition?query=" + params);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");
            connection.setRequestProperty("X-Api-Key", APIKey);
            
            BufferedReader br = null;
            if (connection.getResponseCode() == 200) {
                br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String strCurrentLine;
                    while ((strCurrentLine = br.readLine()) != null) {
                        System.out.println(strCurrentLine);
                    }
            } else {
                br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                String strCurrentLine;
                    while ((strCurrentLine = br.readLine()) != null) {
                        System.out.println(strCurrentLine);
                    }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
