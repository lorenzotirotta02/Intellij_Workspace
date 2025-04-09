package it.prova.utility;

public class NumberUtility {
    public static boolean verificaSeSonoPari(int[] numeri){
        for(int i = 0; i < numeri.length; i++){
            if(numeri[i] % 2 != 0){
                return false;
            }
        }
        return true;
    }
    public static boolean verificaElementoNegativoPAri(int[] valori){
        for(int i = 0; i < valori.length; i++){
            if(valori[i] < 0 && valori[i] % 2 == 0){
                return true;
            }
        }
        return false;
    }
    public static int sommaAlContrarioElementiInPosizioneDispari(int[] listaDiNumeri){
        int somma = 0;
        for(int i = listaDiNumeri.length - 1; i >= 0; i--) {
            if (i % 2 == 1) {
                somma += listaDiNumeri[i];
            }
        }
        return somma;
    }
    public static int dimmiQuantiElementiStrettamenteMinoriDi(int[] elementi, int soglia) {
        int conteggio = 0;
        for (int elem : elementi) {
            if (elem < soglia) {
                conteggio += 1;
            }
        }
        return conteggio;
    }
    public static boolean sonoTuttiDentroUnIntervallo(int[] valori, int sogliaMin, int sogliaMax) {
        for (int val : valori) {
            if (val < sogliaMin || val > sogliaMax) {
                return false;
            }
        }
        return true;
    }
    public static boolean eSommaDegliIndiciDispariUnNumeroDispari(int[] valori){
        int somma = 0;
        for(int i = 0; i < valori.length; i++){
            if(i % 2 == 1){
                somma += valori[i];
            }
        }
        return somma % 2 == 1;
    }
    public static boolean stessoContenuto(int[] valori, int[] numeri){
        for(int i = 0; i < valori.length; i++) {
            if (valori[i] != numeri[i]) {
                return false;
            }
        }
        return true;
    }


}
