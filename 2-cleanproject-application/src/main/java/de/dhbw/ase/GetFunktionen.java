package de.dhbw.ase;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
public class GetFunktionen {

    public GetFunktionen() {
        
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

    public JSONObject getEssenÜberName(String essenName){
        String APIKey = "1";

        try {
            URL url = new URL("https://www.themealdb.com/api/json/v1/1/search.php?s=" + essenName);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");
            connection.setRequestProperty("X-Api-Key", APIKey);
            
            BufferedReader br = null;
            if (connection.getResponseCode() == 200) {
                br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String strCurrentLine;
                while ((strCurrentLine = br.readLine()) != null) {
                    JSONObject essenJSON = new JSONObject(strCurrentLine);
                    return essenJSON;
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

    public JSONObject getEssenKategorien(){
        String APIKey = "1";

        try {
            URL url = new URL("https://www.themealdb.com/api/json/v1/1/categories.php");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");
            connection.setRequestProperty("X-Api-Key", APIKey);
            
            BufferedReader br = null;
            if (connection.getResponseCode() == 200) {
                br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String strCurrentLine;
                while ((strCurrentLine = br.readLine()) != null) {

                    JSONObject kategorienJson = new JSONObject(strCurrentLine);
                    return kategorienJson;
                    
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

    public JSONObject getEssenÜberId(String idString){
        String APIKey = "1";

        

        try {
            URL url = new URL("https://www.themealdb.com/api/json/v1/1/lookup.php?i=" + idString);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");
            connection.setRequestProperty("X-Api-Key", APIKey);
            
            BufferedReader br = null;
            if (connection.getResponseCode() == 200) {
                br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String strCurrentLine;
                while ((strCurrentLine = br.readLine()) != null) {
                    JSONObject essenJSON = new JSONObject(strCurrentLine);
                    return essenJSON;
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

    public JSONObject getProductRange(String essensRichtung){
        String APIKey = "1";

        // www.themealdb.com/api/json/v1/1/filter.php?i=chicken_breast -> ingredient
        // www.themealdb.com/api/json/v1/1/filter.php?a=Canadian -> Area
        // www.themealdb.com/api/json/v1/1/lookup.php?i=52772 -> meal details by id

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
                    JSONObject essenJSON = new JSONObject(strCurrentLine);
                    return essenJSON;
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

    public JSONArray getProductInfo(String params){
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
                        //TODO: remove print
                        System.out.print(strCurrentLine);

                        JSONArray obj = new JSONArray(strCurrentLine);

                        return obj;
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

}
