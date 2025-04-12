package it.prova.model;

public class Dvd extends MaterialeBiblioteca{
    public int durata;

    public Dvd(String titolo, String autore, boolean disponibile, String codiceIdentificativo, int durata) {
        super(titolo, autore, disponibile, codiceIdentificativo);
        this.durata = durata;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public boolean prestito(){
        this.disponibile = !this.disponibile;
        System.out.println("Il dvd è stato prestato");
        return this.disponibile;
    }

    @Override
    public boolean restituzione(){
        if(!this.disponibile){
            System.out.println("Il dvd è stato restituito");
            this.disponibile = true;
        }
        System.out.println("Il dvd è disponibile");
        return this.disponibile;
    }

    @Override
    public int calcolaTempoPrestitoMassimo() {
        return 7;
    }
}
