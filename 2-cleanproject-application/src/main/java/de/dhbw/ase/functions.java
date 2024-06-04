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
            JSONArray meals = zufälligesEssen.getJSONArray("meals");
            zufälligesEssen = meals.getJSONObject(0);
            System.out.println(""); 
            System.out.println(zufälligesEssen.getString("strMeal")); 
        }
        for(int i = 0; i <= 10; i++) {
            // JSONArray meals = zufälligesEssen.getJSONArray("meals");
            // zufälligesEssen = meals.getJSONObject(0);
            // System.out.println(""); 
            // System.out.println(zufälligesEssen.getString("strMeal")); 
            // Integer wahl = in.nextInt();

        }
        
    } 

    // public name

}