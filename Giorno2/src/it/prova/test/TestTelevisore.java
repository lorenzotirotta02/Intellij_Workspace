package it.prova.test;

import it.prova.model.Televisore;

public class TestTelevisore {
    public static void main(String[] args){
        Televisore t = new Televisore();
        t.setMarca("Samsung");
        t.setModello("S456");
        t.setPollici(34.6);
        t.setPrezzo(174.50);

        Televisore t2 = new Televisore();
        t2.setMarca("Samsung");
        t2.setModello("S455");
        t2.setPollici(35.6);
        t2.setPrezzo(180.50);

        System.out.println("Test costaMenoDelBudgetDisponibile");
        System.out.println(t2.costaMenoDelBudgetDisponibile(190));
        System.out.println("");
        System.out.println("Test verificaStessaMarcaDi");
        System.out.println(t2.stessaMarcaDi(t));
    }
}
