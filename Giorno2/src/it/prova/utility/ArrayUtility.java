package it.prova.utility;

public class ArrayUtility {
    public static int controlloLunghezzaNomi(String[] nomi) {
        int conteggio = 0;
        for (int i = 0; i < nomi.length; i++) {
            if (nomi[i].length() % 2 != 0) {
                conteggio += 1;
            }
        }
        return conteggio;
    }
    public static boolean checkParola(String[] lista,String parola){
        for(int i = 0;i < lista.length; i++){
            if(parola.equals(lista[i])){
                return true;
            }
        }
        return false;
    }
    public static boolean trovaSomma(int[] numeri){
        int somma = 0;
        for(int i = 0; i < numeri.length; i++){
            somma += numeri[i];
        }
        if(somma == 0){
            return true;
        }
        return false;
    }
    public static int prodottoElementiPosizionePari(int[] valori){
        int prodotto = 1;
        for(int i = 0; i < valori.length; i++){
            if(i % 2 == 0){
                prodotto = prodotto*valori[i];
            }
        }
        return prodotto;
    }
    public static String trovaParolaPiuLunga(String[] input){
        String parola = "";
        for(int i = 0; i < input.length; i++){
            if(parola.length() < input[i].length()){
                parola = input[i];
            }
        }
        return parola;
    }
    public static String parolaInvertita(String string){
        String risultato = "";
        for(int i = string.length() - 1; i >= 0; i--){
            risultato += string.charAt(i);
        }
        return risultato;
    }
    public static boolean controlloLunghezzaParole(String[] input){
        for(int i = 0; i < input.length - 1; i++){
            if (input[i].length() != input[i+1].length()){
                return false;
            }
        }
        return true;
    }
    public static boolean controlloLetteraFinale(String[] lista, char controllo ){
        for(String parola : lista){
            if(parola.charAt(parola.length() - 1) != controllo){
                return false;
            }
        }
        return true;
    }


    public static int calcoloLunghezzaSingoliElementi(String[] lista){
        int somma = 0;
        for(String parola : lista){
            somma += parola.length();
        }
        return somma;
    }
    public static boolean nomiUgualiNellePrimeNPosizioni(String[] elenco, int nPosizioni) {
        String primoNome = elenco[0];
        for (int i = 1; i < nPosizioni; i++) {
            if (!elenco[i].equals(primoNome)) {
                return false;
            }
        }
        return true;
    }
    public static boolean ePresenteSoloUnaVolta(String[] elenco, String nome) {
        int conteggio = 0;
        for (String n : elenco) {
            if (n.equals(nome)) {
                conteggio += 1;
            }
        }
        return conteggio == 1;
    }
}
