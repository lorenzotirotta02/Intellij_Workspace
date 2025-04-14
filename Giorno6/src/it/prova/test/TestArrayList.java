package it.prova.test;

import it.prova.model.MyArrayUtility;

import java.util.ArrayList;
import java.util.List;

public class TestArrayList {
    public static void main(String[] args) {

        List<String> lista = new ArrayList<>();
        lista.add("Alberto");

        List<Integer> numeri = MyArrayUtility.creaProgressioneNumerica(4, 3);
        System.out.println(numeri);
    }
}
