package it.prova.model;

public class TriangoloIsoscele extends FiguraGeometrica{
    private int ipotenusa;
    private int altezza;

    public TriangoloIsoscele(int base, int lato) {
        super(base, lato);
    }
    public TriangoloIsoscele(){
    }

    public int getAltezza() {
        return altezza;
    }

    public void setAltezza(int altezza) {
        this.altezza = altezza;
    }

    public int getIpotenusa() {
        return ipotenusa;
    }

    public void setIpotenusa(int ipotenusa) {
        this.ipotenusa = ipotenusa;
    }
    public int teoremaDiPitagora(){
        if(this.lato > 0 && this.base > 0){
            return altezza = (int)Math.sqrt(Math.pow(lato, 2) - Math.pow(this.base / 2.0, 2));
        }else if(this.lato > 0 && this.altezza > 0){
            return base = 2 * (int)Math.sqrt((Math.pow(lato, 2) - Math.pow(altezza, 2)));
        }else if(this.base > 0 && this.altezza > 0){
            return lato = (int)Math.sqrt((Math.pow(altezza, 2) + Math.pow(base / 2.0, 2)));
        }
        return -1;

    }
}
