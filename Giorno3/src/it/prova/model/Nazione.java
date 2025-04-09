package it.prova.model;

public class Nazione {
    private String denominazione;
    private double superficieKmQ;
    private int abitanti;

    public Nazione(String denominazione, double superficieKmQ, int abitanti) {
        this.denominazione = denominazione;
        this.superficieKmQ = superficieKmQ;
        this.abitanti = abitanti;
    }

    public String getDenominazione() {
        return denominazione;
    }

    public double getSuperficieKmQ() {
        return superficieKmQ;
    }

    public int getAbitanti() {
        return abitanti;
    }

    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    public void setAbitanti(int abitanti) {
        this.abitanti = abitanti;
    }

    public void setSuperficieKmQ(double superficieKmQ) {
        this.superficieKmQ = superficieKmQ;
    }

    public boolean piuEstesaDi(Nazione input){
        return this.superficieKmQ > input.getSuperficieKmQ();
    }
    public boolean piuPopolosaDi(Nazione input){
        return this.abitanti > input.getAbitanti();
    }
    public boolean esisteAlmenoUnaPiuEstesa(Nazione[] nazioni){
        for(int i = 0; i < nazioni.length; i++){
            if(this.superficieKmQ < nazioni[i].getSuperficieKmQ()){
                return true;
            }
        }
        return false;
    }
    public int dimmiQuanteSonoPiuPopolose(Nazione[] nazioni){
        int count = 0;
        for(int i = 0; i < nazioni.length; i++){
            if(this.abitanti < nazioni[i].getAbitanti()){
                count += 1;
            }
        }
        return count;
    }
    public boolean haPiuAbitantiDiTutteLeAltre(Nazione[] nazioni){
        for(int i = 0; i < nazioni.length; i++){
            if(this.abitanti < nazioni[i].getAbitanti()){
                return false;
            }
        }
        return true;
    }
    public boolean hannoTutteLaMiaStessaIniziale(Nazione[] nazioni){
        for(int i = 0; i < nazioni.length; i++){
            if(this.denominazione.charAt(0) != nazioni[i].getDenominazione().charAt(0)){
                return false;
            }
        }
        return true;
    }
    public boolean eAlDiSopraDellaMediaComeSuperficie(Nazione[] nazioni){
        double somma = 0;
        for(int i = 0; i < nazioni.length; i++){
            somma += nazioni[i].getSuperficieKmQ();
        }
        if(this.superficieKmQ > somma / nazioni.length){
            return true;
        }
        return false;
    }
}
