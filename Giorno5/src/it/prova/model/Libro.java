package it.prova.model;

public class Libro extends MaterialeBiblioteca{
    private int numeroPagine;
    private String genere;

    public Libro(String titolo, String autore, boolean disponibile, String codiceIdentificativo, int numeroPagine, String genere) {
        super(titolo, autore, disponibile, codiceIdentificativo);
        this.numeroPagine = numeroPagine;
        this.genere = genere;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }
    @Override
    public boolean prestito(){
        this.disponibile = !this.disponibile;
        System.out.println("Il libro è stato prestato");
        return this.disponibile;
    }
    @Override
    public boolean restituzione(){
        if(!this.disponibile){
            System.out.println("Il libro è stato restituito");
            this.disponibile = true;
        }
        System.out.println("Il libro è disponibile");
        return this.disponibile;
    }

    @Override
    public int calcolaTempoPrestitoMassimo() {
        return switch (this.genere) {
            case "Horror" -> 10;
            case "Azione" -> 14;
            case "Giallo" -> 20;
            default -> 30;
        };
    }
}
