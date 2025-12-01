package symulator;

public class Samochod {
    Silnik silnik;
    SkrzyniaBiegow skrzynia;
    Pozycja aktualnaPozycja;
    boolean stanWlaczenia;
    String nrRejest;
    String model;
    double predkoscMax;
    public Samochod(String nrRejest, String model, double predkoscMax, int maxObroty, int iloscBiegow, int x, int y) {
        this.stanWlaczenia = false;
        this.nrRejest = nrRejest;
        this.model = model;
        this.predkoscMax = predkoscMax;
        silnik = new Silnik("Silnik tego pojazdu", 300.0, 2000.0, "Perkins", "D34", maxObroty);
        skrzynia = new SkrzyniaBiegow("Skrzynia tego pojazdu", 300.0, 2000.0, "URSUS", "D324",iloscBiegow);
        aktualnaPozycja = new Pozycja(x,y);
    }
    public String getModel() {
        return this.model;
    }
    public String getNrRejestracyjny() {
        return this.nrRejest;
    }

    public void wlacz() {
        silnik.uruchom();
    }
    public void wylacz() {
        silnik.zatrzymaj();

    }
    public void jedzDo(Pozycja cel) {
        System.out.print("No to jadę");
    }
    public Double getAktPredkosc() {
        return 123.0;
    }
    public Pozycja getAktPozycja() {
        return aktualnaPozycja;
    }
}
