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

        System.out.print("Wie viele Gerichte sollen gewählt werden: "); 
        Integer anzahl = in.nextInt();

        for(int i = 0; i <= anzahl; i++) {
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
            if(mealArray.size() == 2){
                System.out.println("Wahl: " + mealArray.get(0));
                break;
            }
            if(wahl == 1){
                mealArray.remove(1);
            } else if( wahl == 2) {
                mealArray.remove(0);
            } else {
                System.out.print("Wähle bitte eine Valide Option"); 
                //TODO: catch wrong user input    
            }
        }
        
    } 

    public void essenSpiel(String essensRichtung){

        JSONObject zufälligesEssen = get.getProductRange(essensRichtung);

        List<Object> mealArray = new ArrayList<Object>();

        mealArray = zufälligesEssen.getJSONArray("meals").toList();
        
        while(true) {
            System.out.print("Essen 1: "); 
            System.out.println(mealArray.get(0)); 
            System.out.print("Essen 2: "); 
            System.out.println(mealArray.get(1)); 
            System.out.print("Wahl: "); 
            Integer wahl = in.nextInt();
            if(mealArray.size() == 2){
                System.out.println("Wahl: " + mealArray.get(0));
                break;
            }
            if(wahl == 1){
                mealArray.remove(1);
            } else if( wahl == 2) {
                mealArray.remove(0);
            } else {
                System.out.print("Wähle bitte eine Valide Option"); 
                //TODO: catch wrong user input    
            }
        }
        
    } 

    private String getEssensName(JSONObject essenObjekt){
        JSONArray meals = essenObjekt.getJSONArray("meals");
        JSONObject essen = meals.getJSONObject(0);
        return essen.getString("strMeal");
    }

}