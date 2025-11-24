package symulator;

public class SkrzyniaBiegow extends Komponent {
    int aktualnyBieg;
    int iloscBiegow;
    int aktualnePrzelozenie;
    Sprzeglo sprzeglo;
    SkrzyniaBiegow(String nazwa, Double waga, Double cena, String producent, String model,int iloscBiegow) {
        super(nazwa,waga,cena,producent,model);
        this.iloscBiegow = iloscBiegow;
        int aktualnyBieg = 0;
        int aktualnePrzelozone = 0;
        sprzeglo = new Sprzeglo("Sprzeglo tej skrzyni",waga,cena,producent,"Sprzeglo");
    }
    void zwiekszBieg() {
        if (aktualnyBieg < iloscBiegow) {
            sprzeglo.wcisnij();
            if (sprzeglo.stanSprzegla) {
                aktualnyBieg++;
                sprzeglo.zwolnij();
            }
        }
    }
    void zmniejszBieg() {
        if (aktualnyBieg > 0) {
            sprzeglo.wcisnij();
            if(sprzeglo.stanSprzegla){
                aktualnyBieg--;
                sprzeglo.zwolnij();
            }
        }
    }
    int getAktBieg() {
        return aktualnyBieg;
    }
    int getAktualnePrzelozenie() {
        return aktualnePrzelozenie;
    }
}
