package symulator;

public class Pozycja {
    double x;
    double y;
    Pozycja(double x, double y){
        this.x = x;
        this.y = y;
    }
    void aktualizujPozycje(double deltaX, double deltaY) {
        x = deltaX;
        y = deltaY;
    }

    String getPozycja() {
        return x + " " + y;
    }
}
