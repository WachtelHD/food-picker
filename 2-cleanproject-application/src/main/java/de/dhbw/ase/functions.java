package de.dhbw.ase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class functions {

    public functions() {

    }

    get get = new get();
    Scanner in = new Scanner(System.in);

    // public essenNachKategorie(){

    // }

    public void essenSpiel(){

        List<JSONObject> mealArray = new ArrayList<JSONObject>();

        for(int i = 0; i <= 10; i++) {
            JSONObject zufälligesEssen = get.getRandomFood();
            mealArray.add(zufälligesEssen);
        }
        while(true) {
            System.out.print("Essen 1: "); 
            System.out.println(getEssensName(mealArray.get(0))); 
            System.out.print("Essen 2: "); 
            System.out.println(getEssensName(mealArray.get(1))); 
            System.out.print("Wahl: "); 
            Integer wahl = in.nextInt();
            if(wahl == 1){
                mealArray.remove(1);
            } else if( wahl == 2) {
                mealArray.remove(0);
            } else {
                break;
                //TODO: catch wrong user input    
            }
            System.out.println(i);
            System.out.println(mealArray.size());

        }
        
    } 

    private String getEssensName(JSONObject essenObjekt){
        JSONArray meals = essenObjekt.getJSONArray("meals");
        JSONObject essen = meals.getJSONObject(0);
        return essen.getString("strMeal");
    }

}