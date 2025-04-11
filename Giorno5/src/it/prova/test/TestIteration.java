package it.prova.test;

import it.prova.model.IterationUtility;

import java.util.Arrays;

public class TestIteration {
    public static void main(String[] args){
        int [] array = {4 ,7 , 3, 12};
        int incremento = 4;
        int[] numeri2 = IterationUtility.incrementaOgniElemento(array, incremento);
        System.out.println(Arrays.toString(numeri2));

        int[] valori1 = {4, 8, 9, 12};
        int[] valori2 = {3, 8, 1, 8};
        boolean contiene = IterationUtility.verificaSeMultipliTraLoro(valori1, valori2);
        System.out.println(contiene);

        int[] array1 = {4, 8, 9, 12};
        int[] listaNumeri = {3, 8, 1, 8};
        int[] prodottoVettoriale = IterationUtility.prodottoVettoriale(array1, listaNumeri);
        System.out.println(Arrays.toString(prodottoVettoriale));
    }

}
