package it.prova.model;

import java.util.ArrayList;
import java.util.List;

public class MyArrayUtility {

    public static List<String> cercaPerTitolo(String s, List<String> input){
        List<String> risultato = new ArrayList<>();
        for(String elem : input){
            if(elem.equalsIgnoreCase(s)){
                risultato.add(elem);
            }
        }
        return risultato;
    }
    public static boolean eDecrescente(List<Integer> numeri){
        for(int i = 0; i < numeri.size(); i++){
            if(numeri.get(i) < numeri.get(i+1)){
                return false;
            }
        }
        return true;
    }
    public static List<Integer> creaProgressioneNumerica(int quanti, int moltiplicando){
        List<Integer> risultato = new ArrayList<>();
        int valoreCorrente = 1;
        for(int i = 0; i < quanti; i++){
            int prodottoTemp = valoreCorrente * moltiplicando;
            risultato.add(prodottoTemp);
            valoreCorrente = prodottoTemp;
        }
        return risultato;
    }
}
