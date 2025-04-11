package it.prova.model;

public class Gatto extends Animale{
    private int zampe;

    public Gatto(String colore, String verso, int zampe) {
        super(colore, verso);
        this.zampe = zampe;
    }

    public int getZampe() {
        return zampe;
    }

    public void setZampe(int zampe) {
        this.zampe = zampe;
    }

    @Override
    public String versoCheFaIlMioAnimale() {
        return super.versoCheFaIlMioAnimale();
    }
}
