package symulator;

public class Sprzeglo extends Komponent{
    boolean stanSprzegla;
    public Sprzeglo(String nazwa, Double waga, Double cena, String producent, String model){
        super(nazwa,waga,cena,producent,model);
        stanSprzegla=false;
    }
    public void wcisnij() {
        stanSprzegla = true;
    }
    public void zwolnij() {
        stanSprzegla = false;
    }
    public boolean getStanSprzegla() {return stanSprzegla;}
}
