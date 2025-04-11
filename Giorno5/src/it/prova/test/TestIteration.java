package it.prova.test;

import it.prova.model.IterationUtility;

import java.util.Arrays;

public class TestIteration {
    public static void main(String[] args){
        int [] array = {4 ,7 , 3, 12};
        int incremento = 4;
        int[] numeri2 = IterationUtility.incrementaOgniElemento(array, incremento);
        System.out.println(Arrays.toString(numeri2));
    }
}
