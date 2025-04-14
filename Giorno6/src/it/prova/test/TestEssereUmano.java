package it.prova.test;

import it.prova.model.EssereUmano;
import it.prova.model.Mammifero;

public class TestEssereUmano {
    public static void main(String[] args){

        Mammifero m;
        m = new EssereUmano("Onnivoro");
        m.siNutre();
        EssereUmano u = new EssereUmano("Vegetariano");
        System.out.println(u.siNutronoAlloStessoModo(m));
    }
}
