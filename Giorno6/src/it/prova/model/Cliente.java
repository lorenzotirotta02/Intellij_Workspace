package it.prova.model;

public abstract class Cliente {
    protected String nome;
    protected String cognome;
    private Stanza stanza;

    public Cliente(String nome, String cognome) {
    }

    public Stanza getStanza() {
        return stanza;
    }

    public void setStanza(Stanza stanza) {
        this.stanza = stanza;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public abstract double sommaDaPagare();


}
