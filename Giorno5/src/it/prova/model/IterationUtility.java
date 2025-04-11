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
    public static boolean verificaSeMultipliTraLoro(int[] valori, int[] multipli){
        for(int i = 0; i < valori.length; i++){
            if(multipli[i] % valori[i] == 0){
                return true;
            }
        }
        return false;
    }
    public static int[] prodottoVettoriale (int[] input1, int[] input2){
        int[] input3 = new int[input1.length];
        for(int i = 0; i < input2.length; i++){
            input3[i] = input1[i] * input2[i];
        }
        return input3;
    }
    public static boolean calcolaSeTantiDispariQuantiPari(int[] input){
        int contaPari = 0;
        int contaDispari = 0;
        for(int i = 0; i < input.length; i++){
            if(input[i] % 2 == 0 && input[i] != 0){
                contaPari += 1;
            }else{
                contaDispari += 1;
            }
        }
        if(contaPari == contaDispari){
            return true;
        }
        return false;
    }
    public static boolean verificaSeDifferenzaPosizioniPariConDispariRisultaPositivo(int[] input){
        int somma1 = 0;
        int somma2 = 0;
        for(int i = 0; i < input.length; i++){
            if(i == 0 || i % 2 == 0){
                somma1 += input[i];
            }else{
                somma2 += input[i];
            }
        }
        if(somma1 - somma2 > 0){
            return true;
        }
        return false;
    }
    public static int quantiSonoDivisibiliPer(int[] valori, int divisore){
        int conto = 0;
        for(int i = 0; i < valori.length; i++) {
            if (valori[i] % divisore == 0) {
                conto += 1;
            }
        }
        return conto;
    }
    public static int[] unioneDueArrayInUno(int[] valori, int[] numeri){
        int[] valori2 = new int[valori.length + numeri.length];

        for(int i = 0; i < valori2.length;i++){
            if(i < valori.length) {
                valori2[i] = valori[i];
            }else{
                valori2[i] = numeri[i - valori.length];
            }
        }
        return valori2;
    }
    public static String creaStringaAlContrarioConIndice(String input, int tipoIndice) {
        String alContrario = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            if (tipoIndice % 2 == 0 && i % 2 == 0) {
                alContrario = alContrario + input.charAt(i);
            }else if(tipoIndice % 2 == 1 && i % 2 == 1){
                alContrario = alContrario + input.charAt(i);
            }
        }
        return alContrario;
    }
}