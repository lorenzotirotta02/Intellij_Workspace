package it.prova.test;

import it.prova.model.FiguraGeometrica;
import it.prova.model.Quadrato;
import it.prova.model.TriangoloEquilatero;
import it.prova.model.TriangoloIsoscele;

public class TestFiguraGeometrica {
    public static void main(String[] args){

//        FiguraGeometrica figura = new FiguraGeometrica(4,5);
//        System.out.println(figura.calcolaArea());
//        System.out.println(figura.calcolaPerimetro());
//
//        FiguraGeometrica triangolo = new TriangoloEquilatero(4, 5, 6);
//        System.out.println("L'area del triangolo è " + triangolo.calcolaArea());
//        System.out.println("Il perimetro del triangolo è " + triangolo.calcolaPerimetro());
//
//        FiguraGeometrica quadrato = new Quadrato(4, 6, 7, 8);
//        System.out.println("L'area del quadrato è " + quadrato.calcolaArea());
//        System.out.println("Il perimetro del quadrato è " + quadrato.calcolaPerimetro());

        //CALCOLO ALTEZZA
        TriangoloIsoscele triangoloTest = new TriangoloIsoscele(10, 13);
        System.out.println("L'altezza del triangolo è : " + triangoloTest.teoremaDiPitagora());
        //CALCOLO LATO
        TriangoloIsoscele triangoloTest1 = new TriangoloIsoscele();
        triangoloTest1.setAltezza(12);
        triangoloTest1.setBase(10);
        System.out.println("Il lato del triangolo è : " + triangoloTest1.teoremaDiPitagora());
        //CALCOLO BASE
        TriangoloIsoscele triangoloIsoscele = new TriangoloIsoscele();
        triangoloIsoscele.setAltezza(12);
        triangoloIsoscele.setLato(13);
        System.out.println("La base del triangolo è : " + triangoloIsoscele.teoremaDiPitagora());
    }
}
