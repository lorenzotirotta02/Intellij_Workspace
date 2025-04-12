package it.prova.model;

import java.time.Year;

public class Rivista extends MaterialeBiblioteca{
    private String numeroEdizione;
    private int annoPublicazione;

    //Ho pensato che ipoteticamente annoPublicazione dovrebbe sempre essere < dell'anno corrente
    //quindi ho deciso di definirlo come un intero e non come una Stringa

    public Rivista(String titolo, String autore, boolean disponibile, String codiceIdentificativo, String numeroEdizione, int annoPublicazione) {
        super(titolo, autore, disponibile, codiceIdentificativo);
        this.numeroEdizione = numeroEdizione;
        this.annoPublicazione = annoPublicazione;
    }

    public String getNumeroEdizione() {
        return numeroEdizione;
    }

    public void setNumeroEdizione(String numeroEdizione) {
        this.numeroEdizione = numeroEdizione;
    }

    public int getAnnoPublicazione() {
        return annoPublicazione;
    }

    public void setAnnoPublicazione(int annoPublicazione) {
        this.annoPublicazione = annoPublicazione;
    }

    @Override
    public int calcolaTempoPrestitoMassimo() {
        int annoAttuale = Year.now().getValue();
        if(this.annoPublicazione == annoAttuale){
            return 7;
        }
        return 14;
    }
}
