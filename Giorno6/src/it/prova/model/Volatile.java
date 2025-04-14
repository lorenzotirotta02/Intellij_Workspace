package it.prova.model;

public interface Volatile {
    public void vola();
    public static void performFly(Volatile input){
        input.vola();
    }
}
