package org.example;

public class Main {
    public static void main(String[] args) {
        symulator.Samochod mojTraktor = new symulator.Samochod(
                "TAG8912", "Ursus C330", 24, 2400, 6, 0, 0
        );
        mojTraktor.wlacz();
        mojTraktor.getAktPozycja();
    }

}