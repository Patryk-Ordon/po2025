package symulator;

public class Silnik extends Komponent {
    int maxObroty;
    int obroty;
    public Silnik(String nazwa, Double waga, Double cena, String producent, String model, int maxObroty) {
        super(nazwa, waga, cena, producent, model);
        this.maxObroty = maxObroty;
        this.obroty = 0;
    }
    public int getObroty() { return obroty; }
    boolean uruchom() {
        obroty = 800;
        return true;
    }
    boolean zatrzymaj() {
        obroty = 0;
        return true;
    }
    boolean zwiekszObroty() {
        if (obroty + 100 <= maxObroty) {
            obroty += 100;
            return true;
        }
        return false;
    }
    boolean zmniejszObroty() {
        if(obroty > 0) {
            if (obroty - 100 >= 0) {
                obroty -= 100;
                return true;
            } else if (obroty - 100 <= 0) {
                obroty = 0;
                return true;
            }
        }
        return false;
    }
}
