package symulator;

public class Silnik extends Komponent {
    int maxObroty;
    int obroty;
    Silnik(String nazwa, Double waga, Double cena, String producent, String model, int maxObroty) {
        super(nazwa, waga, cena, producent, model);
        this.maxObroty = maxObroty;
        this.obroty = 0;
    }
    void uruchom() {
        obroty = 800;
    }
    void zatrzymaj() {
        obroty = 0;
    }
    void zwiekszObroty() {
        if (obroty + 100 <= maxObroty) {
            obroty += 100;
        }
    }
    void zmniejszObroty() {
        if (obroty-100 >= 0) {
            obroty -= 100;
        }
    }
}
