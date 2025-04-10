package it.prova.test;

import it.prova.onetomany.Foglio;
import it.prova.onetomany.Raccoglitore;

public class TestRaccoglitore {
    public static void main(String[] args){
        Raccoglitore n = new Raccoglitore("rosso", "25",
                new Foglio[] {new Foglio("bassa", "quadretti")});
        Foglio n2 = new Foglio("media", "righe");




    n.addToFogli(n2);
    System.out.println(n);
    System.out.println(n.removeFogli(1));
    Raccoglitore n3 = new Raccoglitore("rosso", "25",
            new Foglio[] {new Foglio("bassa", "Quadretti")});
    System.out.println(n3.esisteAlmenoUnFoglioAQuadretti());

    Raccoglitore n4 = new Raccoglitore("rosso", "24",
            new Foglio[]{new Foglio("alta", "righe"),
                    new Foglio("media", "quadretti")});

    Raccoglitore n5 = new Raccoglitore("rosso", "26",
            new Foglio[]{new Foglio("bassa", "righe"),
                    new Foglio("alta", "quadretti")});

    System.out.println("I fogli di alta qualità sono " + n4.quantiFogliDiAltaQualita());

    System.out.println(n4.stessoColoreENumeroFogliDi(n5));
    }
}
