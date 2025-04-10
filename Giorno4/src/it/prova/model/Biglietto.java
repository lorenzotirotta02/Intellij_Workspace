package it.prova.model;

public class Biglietto {
    private String nomeSpettacolo;
    private char letteraFila;
    private String numeroPosto;
    private int prezzo;

    public Biglietto(String nomeSpettacolo, char letteraFila, String numeroPosto, int prezzo) {
        this.nomeSpettacolo = nomeSpettacolo;
        this.letteraFila = letteraFila;
        this.numeroPosto = numeroPosto;
        this.prezzo = prezzo;
    }

    public String getNomeSpettacolo() {
        return nomeSpettacolo;
    }

    public char getLetteraFila() {
        return letteraFila;
    }

    public String getNumeroPosto() {
        return numeroPosto;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public void setNomeSpettacolo(String nomeSpettacolo) {
        this.nomeSpettacolo = nomeSpettacolo;
    }

    public void setLetteraFila(char letteraFila) {
        this.letteraFila = letteraFila;
    }

    public void setNumeroPosto(String numeroPosto) {
        this.numeroPosto = numeroPosto;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }
    public static Biglietto trovaIlPiuEconomico(Biglietto[] elencoBiglietti){
        Biglietto b = elencoBiglietti[0];
        for(int i = 1; i < elencoBiglietti.length; i++){
            if(b.getPrezzo() > elencoBiglietti[i].getPrezzo()){
                 b = elencoBiglietti[i];
            }
        }
        return b;
    }
    public boolean bigliettoAncoraInvenduto(Biglietto[] elencoBigliettiInvenduti){
        for(int i = 0; i < elencoBigliettiInvenduti.length; i++){
            if(this.letteraFila == elencoBigliettiInvenduti[i].getLetteraFila() && this.nomeSpettacolo.equals(elencoBigliettiInvenduti[i].getNomeSpettacolo()) && this.numeroPosto.equals(elencoBigliettiInvenduti[i].getNumeroPosto())){
                return true;
            }
        }
        return false;
    }
}
