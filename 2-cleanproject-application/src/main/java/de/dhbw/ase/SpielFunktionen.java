package de.dhbw.ase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class SpielFunktionen {

    GetFunktionen get = new GetFunktionen();
    Scanner in = new Scanner(System.in);
    JsonMapper json = new JsonMapper();

    public SpielFunktionen() {

    }

    public void essenAusgabe(){
        System.out.print("Essens Auswahl: ");
        //check return for rice as the request isnt just rice
        String essensTyp = in.next();
        JSONObject essenObjekt = get.getEssenÜberName(essensTyp);
        String essenId = this.getEssensId(essenObjekt);

        // TODO: wieder hinzufügen -> APi calls limitiert
        // essen essenInstanz = json.generiereEssenInstanz(essenId);
        // this.essenInformationen(essenInstanz);
    }

    public void essenInSpezifischerRichtung(){

        List<essenKategorie> essenkat = json.generiereKategorieListe();
        List<basisEssenInfo> essenBasisInfoArray = new ArrayList<basisEssenInfo>();

        basisEssenInfo option = null;

        boolean amWählen = true;
        
        while(amWählen){
            System.out.println("Möchtest du Informationen über die verfügbaren Kategorien?");
            System.out.println("1 - Vollständige Informationen über die Kategorien Anzeigen");
		    System.out.println("2 - Die einzelnen Kategorien Anzeigen");
            System.out.println("3 - Kategorie Auswählen");
            System.out.print("Wahl: ");
            String wahl = in.next();

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

        while(amWählen){
            System.out.print("Wahl: ");
            String wahl = in.next();
            try{
                essenBasisInfoArray = json.generiereBasisEssenInformationListe(wahl);
                amWählen = false;
            } catch (Exception e) {
                System.out.println("Bitte wähle eine Valide Option");
            }
        }

        amWählen = true;

        while(amWählen){
            System.out.println("Möchtest du Informationen über die verfügbaren Optionen?");
            System.out.println("1 - Vollständige Informationen über Optionen ausgeben");
		    System.out.println("2 - Zufällige Option ausgeben");
            System.out.println("3 - nähere details zur aktuellen Option");
            System.out.println("4 - Optionen über essens id anzeigen");
            System.out.print("Wahl: ");
            String wahl = in.next();

            switch (wahl) {
				case "1":
                    // Ausgabe der Basis essen Informationen der gesammten Kategorie
                    //TODO: besser auswahl des essens (nicht über id)
                    for(basisEssenInfo info: essenBasisInfoArray){
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
                    System.out.print("Id: ");
                    String id = in.next();
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
        JSONObject zufälligesEssenJson = get.getRandomFood();

        String essenId = this.getEssensId(zufälligesEssenJson);

        // TODO: wieder hinzufügen -> APi calls limitiert
        // essen essenInstanz = json.generiereEssenInstanz(essenId);
        // this.essenInformationen(essenInstanz);
    }

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

        System.out.println(mealArray.get(0));

        String essenId = this.getEssensId(mealArray.get(0));

        essen essen = json.generiereEssenInstanz(essenId);

        this.essenInformationen(essen);
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

        // this.essenInformationen(mealArray.get(0));
        
    } 

    private void essenInformationen(essen essen) {
        boolean amWählen = true;

        while(amWählen){
            System.out.println("Möchtest du weitere Informationen über das Essen?");
            System.out.println("1 - Infos zu den Nährwerten");
            System.out.println("2 - Infos zu der Zubereitung");
            System.out.println("3 - Infos zu den Zutaten");
            System.out.println("4 - Vollständige Informationen");
            System.out.println("5 - Bild falls verfügbar");
            System.out.println("6 - Beenden");

            System.out.print("Auswahl: ");

            String wahl = in.next();

            switch (wahl) {
                case "1":
                    //TODO: Nährwerte können nicht das genau gericht beschreiben -> extra name?
                    System.out.println(essen.getNaehrwerte().toString());
                    // Infos zu Nährwerten
                    break;
                case "2":
                    System.out.println(essen.getRezept().toString());
                    // Infos zu Zubereitung
                    break;
                case "3":
                    System.out.println(essen.getRezept().getYoutube());
                    // Infos zu den Zutaten -> potentiell nährwerte für diese ausgeben.
                    break;
                case "4":
                    System.out.println(essen.toString());
                    // Bild
                    break;
                case "5":
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

    private String getEssensName(JSONObject essenObjekt){
        JSONArray meals = essenObjekt.getJSONArray("meals");
        JSONObject essen = meals.getJSONObject(0);
        return essen.getString("strMeal");
    }

    private String getEssensId(JSONObject essenObjekt){
        JSONArray meals = essenObjekt.getJSONArray("meals");
        JSONObject essen = meals.getJSONObject(0);
        return essen.getString("idMeal");
    }

}