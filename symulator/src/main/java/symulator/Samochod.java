package symulator;

import java.util.ArrayList;

public class Samochod extends Thread{
    Silnik silnik;
    SkrzyniaBiegow skrzynia;
    Pozycja aktualnaPozycja;
    double waga;
    boolean stanWlaczenia;
    String nrRejest;
    String model;
    double predkoscMax;
    double aktualnaPredkosc;
    Pozycja cel;

    private ArrayList<Listener> listeners = new ArrayList<>();

    public void addListener(Listener listener) {
        listeners.add(listener);
    }
    public void removeListener(Listener listener) {
        listeners.remove(listener);
    }
    private void notifyListeners() {
        for (Listener listener : listeners) {
            listener.update();
        }
    }

    public Samochod(String nrRejest, String model, double waga, double predkoscMax, Silnik silnik, SkrzyniaBiegow skrzynia) {
        this.stanWlaczenia = false;
        this.aktualnaPozycja = new Pozycja(10,10);
        this.aktualnaPredkosc = 0;
        this.nrRejest = nrRejest;
        this.model = model;
        this.waga = waga;
        this.predkoscMax = predkoscMax;
        this.silnik = silnik;
        this.skrzynia = skrzynia;
        this.cel = new Pozycja(100,100);
        this.start();
    }
    public String getModel() { return this.model; }
    public String getNrRejestracyjny() { return this.nrRejest; }
    public double getPredkoscMax() { return this.predkoscMax; }
    public Silnik getSilnik() { return this.silnik; }
    public double getWaga() { return this.waga; }
    public boolean getStanWlaczenia() { return this.stanWlaczenia; }
    public SkrzyniaBiegow getSkrzynia() { return this.skrzynia; }
    public Pozycja getAktualnaPozycja() {return aktualnaPozycja;}

    @Override
    public void run() {
        double deltat = 0.1;
        while (true) {
            if (cel != null && aktualnaPozycja != cel) {
                double odleglosc = Math.sqrt(Math.pow(cel.x - this.aktualnaPozycja.x, 2) + Math.pow(cel.y - this.aktualnaPozycja.y, 2));
                double dx = getPredkosc() * deltat * (cel.x - this.aktualnaPozycja.x) / odleglosc;
                double dy = getPredkosc() * deltat * (cel.y - this.aktualnaPozycja.y) / odleglosc;
                if(odleglosc > 10) {
                    this.aktualnaPozycja.x += dx;
                    this.aktualnaPozycja.y += dy;
                    notifyListeners();
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public double getPredkosc() {
        if(!skrzynia.sprzeglo.stanSprzegla)
            this.aktualnaPredkosc=this.getSilnik().getObroty()/100*this.getSkrzynia().getAktualnyBieg();
        return this.aktualnaPredkosc;
    }

    public void jedzDo(Pozycja nowaPozycja) {
        this.cel = nowaPozycja;
    }

    public boolean wlacz() {
        if(!stanWlaczenia)
            if(silnik.uruchom())
                stanWlaczenia = true;
        return stanWlaczenia;
    }
    public boolean wylacz() {
        if(stanWlaczenia)
            if(silnik.zatrzymaj())
                stanWlaczenia = false;
        return stanWlaczenia;
    }

    public Pozycja getAktPozycja() {return aktualnaPozycja;}

    public boolean dodajGazu() {
        if(stanWlaczenia && silnik.zwiekszObroty())
            return true;
        return false;
    }

    public boolean ujmijGazu() {
        if(stanWlaczenia && silnik.zmniejszObroty())
        {
            if(silnik.obroty <= 0)
            {
                silnik.obroty = 0;
                stanWlaczenia = false;
            }
            return true;
        }
        return false;
    }
}
