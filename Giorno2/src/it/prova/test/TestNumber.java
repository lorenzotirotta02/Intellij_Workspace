package it.prova.test;

import it.prova.utility.ArrayUtility;
import it.prova.utility.NumberUtility;

import java.awt.font.NumericShaper;

public class TestNumber {
    public static void main(String[] args){

        System.out.println("Inizio test sommaAlContrarioElementiInPosizioneDispari....");
        int[] valori = {1, 3, 5, 9, 10};
        int somma = NumberUtility.sommaAlContrarioElementiInPosizioneDispari(valori);
        System.out.println(somma);
        System.out.println("Fine test sommaAlContrarioElementiInPosizioneDispari.......\n");

        System.out.println("Inizio test verificaSeSonoPari..........");
        int[] numeri = {1, 4, 15, 25};
        boolean verifica = NumberUtility.verificaSeSonoPari(numeri);
        System.out.println(verifica);
        System.out.println("Fine test verificaSeSonoPari.................\n");


        System.out.println("Inizio test verificaElementoNegativoPari.....");
        int[] listaDiNumeri = {1, -2, -10, -40, 50};
        boolean controlloLista = NumberUtility.verificaElementoNegativoPAri(listaDiNumeri);
        System.out.println(controlloLista);
        System.out.println("Fine test verificaElementoNegativoPari........\n");

        System.out.println("Inizio test dimmiQuantiElementiStrettamenteMinoriDi.......");
        int[] valoriL = {1, 2, 3, 5, 7, 8, 9, 19};
        int sogliaMin = 5;
        int sogliaMax = 9;
        boolean quantiValori = NumberUtility.sonoTuttiDentroUnIntervallo(valoriL, sogliaMin, sogliaMax);
        System.out.println("Fine test dimmiQuantiElementiStrettamenteMinoriDi.......\n");

        System.out.println("Inizio test dimmiQuantiElementiStrettamenteMinoriDi.......");
        int[] elementi = {1, 20, 10, 50, 60};
        int soglia = 10;
        int quantiElementi = NumberUtility.dimmiQuantiElementiStrettamenteMinoriDi(elementi, soglia);
        System.out.println(quantiElementi);
        System.out.println("Fine test dimmiQuantiElementiStrettamenteMinoriDi.......\n");

        System.out.println("Inizio test eSommaDegliIndiciDispariUnNumeroDispari.......");
        int[] listaNumeri = {1, 4, 10, 11, 24};
        boolean eDispari = NumberUtility.eSommaDegliIndiciDispariUnNumeroDispari(listaNumeri);
        System.out.println(eDispari);
        System.out.println("Fine test eSommaDegliIndiciDispariUnNumeroDispari.......");

        System.out.println("Inizio test stessoContenuto........");
        int[] lista1 = {1, 3, 4};
        int[] lista2 = {1, 4, 4};
        boolean sonoUguali = NumberUtility.stessoContenuto(lista1, lista2);
        System.out.println(sonoUguali);
        System.out.println("Fine test stessoContenuto......");
    }
}
