package it.prova.model;

public class Pinguino implements Volatile {
    private String contenenteAppartenenza;

    public Pinguino(String contenenteAppartenenza) {
        this.contenenteAppartenenza = contenenteAppartenenza;
    }

    public String getContenenteAppartenenza() {
        return contenenteAppartenenza;
    }

    public void setContenenteAppartenenza(String contenenteAppartenenza) {
        this.contenenteAppartenenza = contenenteAppartenenza;
    }

    @Override
    public void vola() {
        System.out.println("Io non posso volare..");
    }

    @Override
    public String stampaProprieta() {
        return getContenenteAppartenenza();
    }

    @Override
    public boolean eUgualeA(Volatile altroVolatile) {
        if (!(altroVolatile instanceof Pinguino)) {
            return false;
        } else {
            Pinguino temp = (Pinguino) altroVolatile;
            return this.contenenteAppartenenza.equalsIgnoreCase(temp.getContenenteAppartenenza());
        }
    }
}
