package it.prova.model;

public class Gallina implements Volatile{
    private String piumaggio;

    public Gallina(String piumaggio) {
        this.piumaggio = piumaggio;
    }

    public String getPiumaggio() {
        return piumaggio;
    }

    public void setPiumaggio(String piumaggio) {
        this.piumaggio = piumaggio;
    }

    @Override
    public void vola() {
        System.out.println("Io saltello...");
    }

    @Override
    public String stampaProprieta() {
        return getPiumaggio();
    }
    @Override
    public boolean eUgualeA(Volatile altroVolatile) {
        if (!(altroVolatile instanceof Gallina)) {
            return false;
        } else {
            Gallina temp = (Gallina) altroVolatile;
            return this.piumaggio.equalsIgnoreCase(temp.getPiumaggio());
        }
    }
}
