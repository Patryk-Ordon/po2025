package symulator;

public class Sprzeglo extends Komponent{
    boolean stanSprzegla;
    Sprzeglo(String nazwa, Double waga, Double cena, String producent, String model){
        super(nazwa,waga,cena,producent,model);
        stanSprzegla=false;
    }
    void wcisnij() {
        stanSprzegla = true;
    }
    void zwolnij() {
        stanSprzegla = false;
    }
}
