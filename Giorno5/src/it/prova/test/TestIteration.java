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

        int[] listaNumeri2 = {1, 2, 3, 4};
        boolean conto = IterationUtility.calcolaSeTantiDispariQuantiPari(listaNumeri2);
        System.out.println(conto);

        int[] listNumerii = {9000, 1, 1, 450};
        boolean check = IterationUtility.verificaSeDifferenzaPosizioniPariConDispariRisultaPositivo(listNumerii);
        System.out.println(check);

        int[] list = {9000, 1, 1, 450, 90, 55, 60};
        int numero = 5;
        int conteggio = IterationUtility.quantiSonoDivisibiliPer(list, numero);
        System.out.println(conteggio);

        int[] list1 = {9000, 1, 1, 450, 90, 55, 60};
        int[] lista2 = {4000, 1000};
        int[] risultato = IterationUtility.unioneDueArrayInUno(list1, lista2);
        System.out.println(Arrays.toString(risultato));

        String ciao = "CIAO";
        int index = 77;
        String result = IterationUtility.creaStringaAlContrarioConIndice(ciao, index);
        System.out.println(result);
    }

}
