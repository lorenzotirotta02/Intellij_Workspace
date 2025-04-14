package it.prova.test;

import it.prova.model.Aquila;
import it.prova.model.Gallina;
import it.prova.model.Pinguino;
import it.prova.model.Volatile;

public class TestVolatile {
    public static void main(String[] args){
        Volatile v;
        v = new Aquila();
        Volatile.performFly(v);
        v = new Gallina();
        Volatile.performFly(v);
        v = new Pinguino();
        Volatile.performFly(v);



    }
}
