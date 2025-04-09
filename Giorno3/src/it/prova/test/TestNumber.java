package it.prova.test;

import it.prova.utility.NumberUtility;

import java.util.Arrays;

public class TestNumber {
    public static void main(String[] args){

        System.out.println("Inizio test eDescrescente.......");
        int[] valori = {5, 4, 4};
        boolean eDecrescente = NumberUtility.eDecrescente(valori);
        System.out.println(eDecrescente);
        System.out.println("Fine test eDecrescente.........\n");

        System.out.println("Inizio test creaProgressioneNumerica.....");
        int quanti = 4;
        int moltiplicando = 3;
        int[] creaLista = NumberUtility.creaProgressioneNumeri(quanti, moltiplicando);
        System.out.println(Arrays.toString(creaLista));
        System.out.println("Fine test creaProgressioneNumerica.......");
    }
}
