package it.prova.test;

import it.prova.model.Televisore;

public class TestTelevisore {
    public static void main(String[] args){
        Televisore t = new Televisore("Samsung", "S456", 35.7, 180);
        Televisore t2 = new Televisore("Samsung", "S560", 36.7, 190);


        System.out.println("Test costaMenoDelBudgetDisponibile");
        System.out.println(t2.costaMenoDelBudgetDisponibile(190));
        System.out.println("");
        System.out.println("Test verificaStessaMarcaDi");
        System.out.println(t2.stessaMarcaDi(t));
        System.out.println("");


        Televisore t3 = new Televisore("Sony", "BraviaX90J", 65.0, 300);
        Televisore t4 = new Televisore("Philips", "PUS8507", 43.0, 210);
        Televisore t5 = new Televisore("Panasonic", "TX-50JX800E", 50.0, 275);
        Televisore t6 = new Televisore("TCL", "C725", 55.0, 230);
        Televisore[] catalogo = {t4, t5, t6};

        System.out.println("Test esisteAlmenoUnoPiuEconomico....");
        System.out.println(t3.esisteAlmenoUnoPiùEconomico(catalogo));
        System.out.println("");

        Televisore t7 = new Televisore("Hisense", "A6G", 40.0, 180);
        Televisore t8 = new Televisore("Sharp", "Aquos 4T-C50BL5EF2AB", 50.0, 200);
        Televisore t9 = new Televisore("Grundig", "Vision 7", 43.0, 195);
        Televisore t10 = new Televisore("Xiaomi", "Mi TV P1", 32.0, 150);
        Televisore t11 = new Televisore("Thomson", "43UG6400", 43.0, 185);
        Televisore[] input = {t7, t8, t9, t10};

        System.out.println("Test quantiSonoPiuGrandi....");
        System.out.println(t11.quantiSonoPiuGrandi(input));
        System.out.println("");

        Televisore tv1 = new Televisore("Samsung", "Q60B", 50.0, 230);
        Televisore tv2 = new Televisore("Samsung", "CU8000", 55.0, 240);
        Televisore tv3 = new Televisore("Samsung", "The Frame LS03B", 43.0, 210);
        Televisore[] televisori = {tv1, tv2};

        System.out.println("Test quantiSonoPiuCariAvendoStessaMarca");
        System.out.println(tv3.quantiSonoPiuCariAvendoStessaMarca(televisori));
        System.out.println("");

        Televisore tv4 = new Televisore("Samsung", "Crystal UHD AU7190", 65.0, 280);
        Televisore tv5 = new Televisore("Samsung", "QLED Q70A", 75.0, 320);
        Televisore tv6 = new Televisore("Samsung", "S95C OLED", 55.0, 270);
        Televisore tv7 = new Televisore("Samsung", "BU8000", 70.0, 300);
        Televisore tv8 = new Televisore("Samsung", "T5300", 32.0, 150);
        Televisore[] tvs = {tv4, tv5, tv6, tv7};

        System.out.println("Test ePiuCaroDellaMedia");
        System.out.println(tv8.ePiuCaroDellaMedia(tvs));
        System.out.println("");



    }
}

