package symulator;

public class SkrzyniaBiegow extends Komponent {
    int aktualnyBieg;
    int iloscBiegow;
    int aktualnePrzelozenie;
    Sprzeglo sprzeglo;
    public SkrzyniaBiegow(String nazwa, Double waga, Double cena, String producent, String model, int iloscBiegow, Sprzeglo sprzeglo) {
        super(nazwa,waga,cena,producent,model);
        this.iloscBiegow = iloscBiegow;
        aktualnyBieg = 0;
        aktualnePrzelozenie = 0;
        this.sprzeglo = sprzeglo;
    }
    public boolean zwiekszBieg() {
        boolean zmieniono = false;
        if (aktualnyBieg < iloscBiegow) {
            if (sprzeglo.stanSprzegla) {
                aktualnyBieg++;
                zmieniono = true;
            }
        }
        return zmieniono;
    }
    public boolean zmniejszBieg() {
        boolean zmieniono = false;
        if (aktualnyBieg > 0) {
            if(sprzeglo.stanSprzegla){
                aktualnyBieg--;
                zmieniono = true;
            }
        }
        return zmieniono;
    }
    public int getAktualnyBieg() {
        return aktualnyBieg;
    }
    public int getAktualnePrzelozenie() {
        return aktualnePrzelozenie;
    }
    public Sprzeglo getSprzeglo() { return sprzeglo; }
}
