package it.prova.model;

import static java.lang.Long.sum;

public class Turista extends Cliente{
    private Stanza stanza;

    public Turista(String nome, String cognome, Stanza stanza) {
        super(nome, cognome);
        this.stanza = stanza;
    }

    @Override
    public Stanza getStanza() {
        return stanza;
    }

    @Override
    public void setStanza(Stanza stanza) {
        this.stanza = stanza;
    }

    @Override
    public double sommaDaPagare() {
        return getStanza().getQuantoAPersona();
    }
}
