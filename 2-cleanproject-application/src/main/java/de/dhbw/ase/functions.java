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

        this.essenInformationen(mealArray.get(0));
    } 

    public void essenSpiel(String essensRichtung){

        JSONObject zufälligesEssen = get.getProductRange(essensRichtung);

        List<JSONObject> mealArray = new ArrayList<JSONObject>();

        List<Object> essenArray = new ArrayList<Object>();

        essenArray = zufälligesEssen.getJSONArray("meals").toList();

        System.out.println(essenArray);

        //TODO: conversion doesnt work how it should -> object to JSONObject 

        for(int i = 0; i <= 10; i++) {
            Object ess = essenArray.get(i).toString();
            JSONObject essen = new JSONObject(ess);
            System.out.println(essenArray.get(i));
            System.out.println(essen);
            mealArray.add(essen);
        }

        System.out.println(mealArray.get(0));
        
        while(true) {
            System.out.print("Essen 1: "); 
            System.out.println(mealArray.get(0).get("strMeal")); 
            System.out.print("Essen 2: "); 
            System.out.println(mealArray.get(1).get("strMeal")); 
            System.out.print("Wahl: "); 
            Integer wahl = in.nextInt();
            if(mealArray.size() == 2){
                System.out.println("Wahl: " + mealArray.get(0).get("strMeal"));
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

        this.essenInformationen(mealArray.get(0));
        
    } 

    private void essenInformationen(JSONObject essen) {
        System.out.println("Willst du weitere Informationen über das Essen?");
		System.out.println("1 - Infos zu den Nährwerten");
		System.out.println("2 - Infos zu der Zubereitung");
		System.out.println("3 - Infos zu den Zutaten");
		System.out.println("4 - Bild falls verfügbar"); //?
		System.out.println("5 - Wo kann man bestellen"); //?

		System.out.print("Auswahl: ");

		Integer wahl = in.nextInt();

        switch (wahl) {
			case 1:
                get.getProductInfo(essen.getString("strMeal"));
                // Infos zu Nährwerten
				break;
			case 2:
				// Infos zu Zubereitung
				break;
			case 3:
				// Infos zu den Zutaten
				break;
			case 4:
				// Bild
				break;
			case 5:
				// bestellung
				break;
			default:
				//TODO: change error
				System.out.println("Es ist ein fehler aufgetreten");
				break;
		}


    }

    private String getEssensName(JSONObject essenObjekt){
        JSONArray meals = essenObjekt.getJSONArray("meals");
        JSONObject essen = meals.getJSONObject(0);
        return essen.getString("strMeal");
    }

}