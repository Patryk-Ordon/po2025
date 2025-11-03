package symulator;

public abstract class Komponent {
    String nazwa;
    Double waga;
    Double cena;
    String producent;
    String model;
    Komponent(String nazwa, Double waga, Double cena, String producent, String model) {
        this.nazwa = nazwa;
        this.waga = waga;
        this.cena = cena;
        this.producent = producent;
        this.model = model;
    }
    public String getNazwa(){
        return nazwa;
    }
    public Double getWaga(){
        return waga;
    }
    public Double Cena(){
        return cena;
    }
    public String getProducent() {
        return producent;
    }
    public String getModel() {
        return model;
    }
}
