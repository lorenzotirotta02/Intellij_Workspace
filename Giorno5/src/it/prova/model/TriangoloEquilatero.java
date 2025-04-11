package it.prova.model;

public class TriangoloEquilatero extends FiguraGeometrica{
    private int ipotenusa;

    public TriangoloEquilatero(int base, int altezza, int ipotenusa) {
        super(base, altezza);
        this.ipotenusa = ipotenusa;
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
//    public int calcolaAltezza(){
//        int altezza = 0;
//        int metaBase = 0;
//        int newBase = 0;
//        if(this.lato > 0 && this.base > 0){
//            metaBase = lato / 2;
//            newBase = (int) Math.pow(metaBase, 2);
//            altezza = Math.sqrt(newBase)
//        }
//    }
//    public int teoremaDiPitagora(){
//
//    }

}
