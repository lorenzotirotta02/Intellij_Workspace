package it.prova.test;

import it.prova.model.Aquila;
import it.prova.model.Gallina;
import it.prova.model.Pinguino;
import it.prova.model.Volatile;

public class TestVolatile {
    public static void main(String[] args){
        Volatile v;
        v = new Aquila("Aquila");
        Aquila v2 = new Aquila("Aquila");
        System.out.println(v2.eUgualeA(v));
        System.out.println(v.stampaProprieta());
        Volatile.performFly(v);
        v = new Gallina("rosso");
        Gallina g = new Gallina("blu");
        System.out.println(g.eUgualeA(v));
        System.out.println(v.stampaProprieta());
        Volatile.performFly(v);
        v = new Pinguino("Antartide");
        Pinguino p = new Pinguino("Finlandia");
        System.out.println(p.eUgualeA(v));
        System.out.println(v.stampaProprieta());
        Volatile.performFly(v);



    }
}
