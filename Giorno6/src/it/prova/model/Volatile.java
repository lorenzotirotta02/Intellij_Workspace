package it.prova.model;

public interface Volatile {
    public void vola();
    public static void performFly(Volatile input){
        input.vola();
    }
    public String stampaProprieta();
    public boolean eUgualeA(Volatile altroVolatile);
}
