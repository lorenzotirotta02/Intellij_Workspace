package it.prova.model;

public class Pinguino implements Volatile{

    @Override
    public void vola() {
        System.out.println("Io non posso volare..");
    }
}
