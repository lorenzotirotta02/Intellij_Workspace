package it.prova.model;

public class IterationUtility {
    public static int[]  incrementaOgniElemento(int[] valori, int incremento){
        int[] numeri = new int [valori.length];
        for(int i = 0; i < valori.length; i++){
            if(valori[i] % incremento != 0){
                numeri[i] = 0;
            }else{
                numeri[i] = valori[i] + incremento;
            }
        }
        return numeri;


    }
}