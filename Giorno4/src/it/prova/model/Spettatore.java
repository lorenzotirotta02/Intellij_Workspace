package it.prova.model;

public class Spettatore {
    private String nome;
    private String cognome;
    private String numeroCartaDiCredito;

    private Biglietto biglietto;

    public Spettatore(String nome, String cognome, String numeroCartaDiCredito, Biglietto biglietto) {
        this.nome = nome;
        this.cognome = cognome;
        this.numeroCartaDiCredito = numeroCartaDiCredito;
        this.biglietto = biglietto;
    }

    public String getNome() {
        return nome;
    }

    public String getNumeroCartaDiCredito() {
        return numeroCartaDiCredito;
    }

    public String getCognome() {
        return cognome;
    }

    public Biglietto getBiglietto() {
        return biglietto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setNumeroCartaDiCredito(String numeroCartaDiCredito) {
        this.numeroCartaDiCredito = numeroCartaDiCredito;
    }

    public void setBiglietto(Biglietto biglietto) {
        this.biglietto = biglietto;
    }
    public int incassoDeiPagantiNellaMiaFila(Spettatore[] elencoPagantiTotali){
        int incasso = this.biglietto.getPrezzo();
        for(int i = 0; i < elencoPagantiTotali.length; i++){
            if(this.biglietto.getLetteraFila() == elencoPagantiTotali[i].getBiglietto().getLetteraFila()){
                incasso += elencoPagantiTotali[i].getBiglietto().getPrezzo();
            }
        }
        return incasso;
    }
    public int numeroSpettatoriDelMioStessoSpettacolo(Spettatore[] elencoPagantiTotali){
        int count = 0;
        for(int i = 0; i < elencoPagantiTotali.length; i++){
            if(this.biglietto.getNomeSpettacolo().equals(elencoPagantiTotali[i].getBiglietto().getNomeSpettacolo())){
                count += 1;
            }
        }
        return count;
    }
    public boolean numeroSpettatoriMioSpettacoloSuperaAspettativa(Spettatore[] paganti, int aspettativa){
        return numeroSpettatoriDelMioStessoSpettacolo(paganti) > aspettativa;
    }
    public static int contaQuantiSenzaBiglietto(Spettatore[] elencoSpettatori){
        int count = 0;
        for(int i = 0; i < elencoSpettatori.length; i++){
            if(elencoSpettatori[i].getBiglietto() == null){
                count += 1;
            }
        }
        return count;
    }
    public int contaQuantiNellaMiaStessaFila(Spettatore[] elencoSpettatori){
        int count = 0;
        for(int i = 0; i < elencoSpettatori.length; i++){
            if(this.getBiglietto().getLetteraFila() == elencoSpettatori[i].getBiglietto().getLetteraFila()){
                count += 1;
            }
        }
        return count;
    }



}
