package it.prova.model;

public class MaterialeBiblioteca {
    protected String titolo;
    protected String autore;
    protected String codiceIdentificativo;
    protected boolean disponibile;

    public MaterialeBiblioteca() {
    }

    public MaterialeBiblioteca(String titolo, String autore, boolean disponibile, String codiceIdentificativo) {
        this.titolo = titolo;
        this.autore = autore;
        this.disponibile = true;
        this.codiceIdentificativo = codiceIdentificativo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getCodiceIdentificativo() {
        return codiceIdentificativo;
    }

    public void setCodiceIdentificativo(String codiceIdentificativo) {
        this.codiceIdentificativo = codiceIdentificativo;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public boolean isDisponibile() {
        return disponibile;
    }

    public void setDisponibile(boolean disponibile) {
        this.disponibile = disponibile;
    }
    public boolean prestito(){
        this.disponibile = !this.disponibile;
        System.out.println("Il materiale è stato prestato");
        return this.disponibile;
    }
    public boolean restituzione(){
        if(!this.disponibile){
            System.out.println("Il materiale è stato restituito");
            this.disponibile = true;
        }
        return this.disponibile;
    }
    public int calcolaTempoPrestitoMassimo(){
        return 14;
    }
}
