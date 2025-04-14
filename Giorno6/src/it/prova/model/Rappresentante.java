package it.prova.model;

public class Rappresentante extends Cliente{
    private Stanza stanza;

    public Rappresentante(String nome, String cognome, Stanza stanza) {
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
        return 0.2 * getStanza().getQuantoAPersona();
    }

}
