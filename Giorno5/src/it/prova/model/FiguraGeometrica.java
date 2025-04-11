package it.prova.model;

public class FiguraGeometrica {
    protected int base;
    protected int lato;

    public FiguraGeometrica(){}

    public FiguraGeometrica(int base, int lato) {
        this.base = base;
        this.lato = lato;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getLato() {
        return lato;
    }

    public void setLato(int lato) {
        this.lato = lato;
    }
    public int calcolaPerimetro(){
        return -1;
    }
    public int calcolaArea(){
        return -1;
    }
}
