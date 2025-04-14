package it.prova.model;

public class Premio extends Cliente{
    private Stanza stanza;

    @Override
    public Stanza getStanza() {
        return stanza;
    }

    @Override
    public void setStanza(Stanza stanza) {
        this.stanza = stanza;
    }

    public Premio(String nome, String cognome, Stanza stanza) {
        super(nome, cognome);
        this.stanza = stanza;
    }

    @Override
    public double sommaDaPagare() {
        return 0;
    }
}
