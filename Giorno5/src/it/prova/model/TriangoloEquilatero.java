package it.prova.model;

public class TriangoloEquilatero extends FiguraGeometrica{
    private int ipotenusa;

    public TriangoloEquilatero(int base, int lato, int ipotenusa) {
        super(base, lato);
        this.ipotenusa = ipotenusa;
    }
    public TriangoloEquilatero(int base, int lato){
        super(base, lato);
    }

    public int getIpotenusa() {
        return ipotenusa;
    }

    public void setIpotenusa(int ipotenusa) {
        this.ipotenusa = ipotenusa;
    }

//    @Override
//    public int calcolaArea() {
//        if(this. > 0 && this.base > 0){
//            return  * this.base / 2;
//        }
//        return -1;
//    }

    @Override
    public int calcolaPerimetro() {
        if(this.ipotenusa > 0 && this.lato > 0 && this.base > 0){
            return this.ipotenusa + this.lato + this.base;
        }
        return -1;
    }
    public int teoremaDiPitagora(){
        return 4;
    }

}
