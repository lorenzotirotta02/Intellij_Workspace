package it.prova.test;

import it.prova.model.Nazione;

public class TestNazione {
    public static void main(String[] args){

        Nazione italia = new Nazione("Italia", 9800.90, 190000);
        Nazione spagna = new Nazione("Spagna", 8900.14, 210000);
        Nazione germania = new Nazione("Germania", 11200.75, 830000);
        Nazione francia = new Nazione("Francia", 10150.30, 670000);
        Nazione regnoUnito = new Nazione("Regno Unito", 9700.00, 680000);
        Nazione statiUniti = new Nazione("Stati Uniti", 25000.50, 3310000);
        Nazione cina = new Nazione("Cina", 17500.40, 14393200);
        Nazione giappone = new Nazione("Giappone", 10000.20, 1260000);
        Nazione brasile = new Nazione("Brasile", 8600.60, 2130000);
        Nazione india = new Nazione("India", 7400.45, 13934000);
        Nazione canada = new Nazione("Canada", 9300.90, 380000);
        Nazione australia = new Nazione("Australia", 8700.33, 260000);
        Nazione[] n1 = {giappone, brasile, australia};
        Nazione[] n2 = {statiUniti};



        boolean ePiuEstesa = italia.piuEstesaDi(spagna);
        System.out.println(ePiuEstesa);

        boolean ePiuPopolosa = cina.piuPopolosaDi(india);
        System.out.println(ePiuPopolosa);

        boolean almenoUnaPiuEstesa = canada.esisteAlmenoUnaPiuEstesa(n1);
        System.out.println(almenoUnaPiuEstesa);

        int dimmiQuante = francia.dimmiQuanteSonoPiuPopolose(n2);
        System.out.println(dimmiQuante);

        boolean haPiuAbitanti = francia.haPiuAbitantiDiTutteLeAltre(n1);
        System.out.println(haPiuAbitanti);

        boolean stessaIniziale = cina.hannoTutteLaMiaStessaIniziale(n1);
        System.out.println(stessaIniziale);

        boolean eSopra = cina.eAlDiSopraDellaMediaComeSuperficie(n2);
        System.out.println(eSopra);
    }
}
