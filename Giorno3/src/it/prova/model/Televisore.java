package it.prova.model;

import static java.util.Collections.min;

public class Televisore {
    //Realizzare una classe Televisore con marca modello pollici e prezzo
    private String marca;
    private String modello;
    private double pollici;
    private double prezzo;

    public Televisore(String marca, String modello, double pollici, double prezzo) {
        this.marca = marca;
        this.modello = modello;
        this.pollici = pollici;
        this.prezzo = prezzo;
    }

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
    public boolean piuGrandeDi(Televisore altroTelevisore){
        return this.pollici < altroTelevisore.pollici;
    }
    public boolean migliorQualitaPrezzoDi(Televisore altroTelevisore){
        return this.prezzo / this.pollici > altroTelevisore.prezzo / altroTelevisore.pollici;
    }
    public boolean esisteAlmenoUnoPiùEconomico(Televisore[] catalogo){
        for(int i = 0; i < catalogo.length; i++){
            if(catalogo[i].getPrezzo() < this.prezzo){
                return true;
            }
        }
        return false;
    }
    public int quantiSonoPiuGrandi(Televisore[] catalogo){
        int count = 0;
        for(int i = 0; i < catalogo.length; i++){
            if(catalogo[i].getPollici() > this.pollici){
                count += 1;
            }
        }
        return count;
    }
    public int quantiSonoPiuCariAvendoStessaMarca(Televisore[] catalogo){
        int count = 0;
        for(int i = 0; i < catalogo.length; i++){
            if(catalogo[i].getPrezzo() > this.prezzo && catalogo[i].marca.equals(this.marca)){
                count += 1;
            }
        }
        return count;
    }
    public boolean ePiuCaroDellaMedia(Televisore[] input){
        double somma = 0;
        for(int i = 0; i < input.length; i++){
            somma += input[i].getPrezzo();
        }
        if(this.prezzo > somma / input.length){
            return true;
        }
        return false;
    }

}
