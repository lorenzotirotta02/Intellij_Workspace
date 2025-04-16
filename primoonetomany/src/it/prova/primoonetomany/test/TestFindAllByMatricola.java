package it.prova.primoonetomany.test;

import it.prova.primoonetomany.dao.ArticoloDAO;
import it.prova.primoonetomany.model.Articolo;

import java.util.ArrayList;
import java.util.List;

public class TestFindAllByMatricola {
    public static void main(String[] args){

        String input = "AL099";
        ArticoloDAO articolo = new ArticoloDAO();
        List<Articolo> lista = articolo.findAllByMatricola(input);
        Articolo result = lista.get(0);

        System.out.println("L'articolo con la seguente matricola è: " + result);


    }
}
