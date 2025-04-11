package it.prova.test;

import it.prova.model.FiguraGeometrica;
import it.prova.model.Quadrato;
import it.prova.model.TriangoloEquilatero;

public class TestFiguraGeometrica {
    public static void main(String[] args){

        FiguraGeometrica figura = new FiguraGeometrica(4,5);
        System.out.println(figura.calcolaArea());
        System.out.println(figura.calcolaPerimetro());

        FiguraGeometrica triangolo = new TriangoloEquilatero(4, 5, 6);
        System.out.println("L'area del triangolo è " + triangolo.calcolaArea());
        System.out.println("Il perimetro del triangolo è " + triangolo.calcolaPerimetro());

        FiguraGeometrica quadrato = new Quadrato(4, 6, 7, 8);
        System.out.println("L'area del quadrato è " + quadrato.calcolaArea());
        System.out.println("Il perimetro del quadrato è " + quadrato.calcolaPerimetro());
    }
}
