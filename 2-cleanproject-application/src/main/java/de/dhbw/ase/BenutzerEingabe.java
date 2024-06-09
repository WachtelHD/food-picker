package de.dhbw.ase;

import java.util.Scanner;

public class BenutzerEingabe {
    private final Scanner in;

    public BenutzerEingabe() {
        this.in = new Scanner(System.in);
    }

    public String getInput(String prompt) {
        System.out.print(prompt);
        return in.next();
    }

    public void print(String message) {
        System.out.println(message);
    }
}
