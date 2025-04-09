package it.prova.test;

import it.prova.utility.ArrayUtility;

public class TestArray {
    public static void main(String[] args){
        System.out.println("Inizio test controlloLunghezzaNomi........");
        String[] nomi = {"Giuseppe", "Lorenzo", "Olek"};
        int calcoloLunghezza = ArrayUtility.controlloLunghezzaNomi(nomi);
        System.out.println(calcoloLunghezza);
        System.out.println("Fine test controlloLunghezzaNomi........\n");

        System.out.println("Inizio test checkParola........");
        String[] lista = {"Ciao", "123", "ciao"};
        String parola = "Ciao";
        boolean controlloParola = ArrayUtility.checkParola(lista, parola);
        System.out.println(controlloParola);
        System.out.println("Fine test checkParola........\n");

        System.out.println("Inizio test trovaSomma........");
        int[] numeri = {1, -1, 2, -2};
        boolean controlloSomma = ArrayUtility.trovaSomma(numeri);
        System.out.println(controlloSomma);
        System.out.println("Fine trovaSomma........\n");

        System.out.println("Inizio test prodottoElementiPosizionePari........");
        int[] valori = {1, 4, 15, 24, 30};
        int prodotto = ArrayUtility.prodottoElementiPosizionePari(valori);
        System.out.println(prodotto);
        System.out.println("Fine test prodottoElementiPosizionePari........\n");

        System.out.println("Inizio test trovaParolaPiuLunga......");
        String[] input = {"Ciao", "Azienda", "mare", "Arcipelago"};
        String risultato = ArrayUtility.trovaParolaPiuLunga(input);
        System.out.println(risultato);
        System.out.println("Fine test trovaParolaPiuLunga.....\n");

        System.out.println("Inizio test parolaInvertita.....");
        String nome = "Roberto";
        String inversa = ArrayUtility.parolaInvertita(nome);
        System.out.println(inversa);
        System.out.println("Fine test parolaInvertita.....\n");

        System.out.println("Inizio test controlloLunghezzaParole.....");
        String[] parole = {"ciao", "mare", "sole"};
        boolean controllo = ArrayUtility.controlloLunghezzaParole(parole);
        System.out.println(controllo);
        System.out.println("Fine test controlloLunghezzaParole.....\n");

        System.out.println("Inizio test controlloLetteraFinale......");
        String[] listaParole = {"Mia", "Maria", "Giada"};
        char lettera = 'a';
        boolean check = ArrayUtility.controlloLetteraFinale(listaParole, lettera);
        System.out.println(check);
        System.out.println("Fine test controlloLetteraFinale......\n");

        System.out.println("Inizio test calcoloLunghezzaSingoliElementi........");
        String[] listaL = {"Io", "Bottiglia", "quattro"};
        int somma = ArrayUtility.calcoloLunghezzaSingoliElementi(listaL);
        System.out.println(somma);
        System.out.println("Fine test calcoloLunghezzaSingoliElementi.........\n");

        System.out.println("Inizio test nomiUgualiNellePrimeNPosizioni.......");
        String[] listaNomi = {"Fabrizio", "Fabrizio", "Fabrizio", "Fabrizio"};
        int posizioni = 3;
        boolean ugualiInNPosizioni = ArrayUtility.nomiUgualiNellePrimeNPosizioni(listaNomi, posizioni);
        System.out.println(ugualiInNPosizioni);
        System.out.println("Inizio test nomiUgualiNellePrimeNPosizioni.......\n");

        System.out.println("Inizio test ePresenteSoloUnaVolta.......");
        String[] elenco = {"Favola", "Libro", "Orchestra"};
        String nomeInElenco = "Favola";
        boolean ePresente = ArrayUtility.ePresenteSoloUnaVolta(elenco, nomeInElenco);
        System.out.println(ePresente);
        System.out.println("Fine test ePresenteSoloUnaVolta.......\n");
    }

}
