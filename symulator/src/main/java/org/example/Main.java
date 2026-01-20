package org.example;

import symulator.Silnik;
import symulator.SkrzyniaBiegow;
import symulator.Sprzeglo;

public class Main {
    public static void main(String[] args) {
        symulator.Samochod mojTraktor = new symulator.Samochod(
                "TAG8912", "Ursus C330", 2400, 24, new Silnik("Perkins", 500.0, 5000.0, "URSUS", "S330", 2800), new SkrzyniaBiegow("Skrzynia URSUS 6", 550.0, 2000.0, "URSUS", "S6", 6, new Sprzeglo("URSUS Sprzęgło", 200.0, 1000.0, "Warszawa", "Typ 1"))
        );
        mojTraktor.wlacz();
        mojTraktor.getAktPozycja();
    }

}