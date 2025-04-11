package it.prova.model;

public class Quadrato extends FiguraGeometrica{
    private int lato1;
    private int lato2;

    public Quadrato(int base, int altezza, int lato1, int lato2) {
        super(base, altezza);
        this.lato1 = lato1;
        this.lato2 = lato2;
    }

    public int getLato1() {
        return lato1;
    }

    public void setLato1(int lato1) {
        this.lato1 = lato1;
    }

    public int getLato2() {
        return lato2;
    }

    public void setLato2(int lato2) {
        this.lato2 = lato2;
    }

    @Override
    public int calcolaArea() {
        if(this.lato1 > 0 && this.lato2 > 0) {
            return this.lato2 * this.lato1;
        }
        return -1;
    }

    @Override
    public int calcolaPerimetro() {
        if(this.lato1 > 0 && this.lato2 > 0 && this.lato > 0 && this.base > 0) {
            return this.lato1 + this.lato2 + this.lato + this.base;
        }
        return -1;
    }
}
