package it.prova.utility;

public class NumberUtility {
    public static boolean eDecrescente(int[] numeri){
        for(int i = 0; i < numeri.length - 1; i++){
            if(numeri[i] <= numeri[i+1]){
                return false;
            }
        }
        return true;
    }
    public static int[] creaProgressioneNumeri(int quanti, int moltiplicando){
        int[] lista = new int[quanti];
        int valoreCorrente = 1;
        for(int i = 0; i < quanti; i++){
            lista[i] = valoreCorrente * moltiplicando;
            valoreCorrente = lista[i];
        }
        return lista;

    }
}
