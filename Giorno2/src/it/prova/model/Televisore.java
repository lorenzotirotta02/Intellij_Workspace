package it.prova.model;

public class Televisore {
    //Realizzare una classe Televisore con marca modello pollici e prezzo
    private String marca;
    private String modello;
    private double pollici;
    private double prezzo;

    public String getMarca() {
        return marca;
    }

    public String getModello() {
        return modello;
    }

    public double getPollici() {
        return pollici;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public void setPollici(double pollici) {
        this.pollici = pollici;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
    public boolean costaMenoDelBudgetDisponibile(int budgetDisponibile) {
        return this.prezzo < budgetDisponibile;
    }
    public boolean stessaMarcaDi(Televisore altroTelevisore) {
        return this.marca.equals(altroTelevisore.marca);
    }

}
