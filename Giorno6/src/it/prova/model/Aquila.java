package it.prova.model;

public class Aquila implements Volatile {
    private String razzaAquila;

    public Aquila(String razzaAquila) {
        this.razzaAquila = razzaAquila;
    }

    public String getRazzaAquila() {
        return razzaAquila;
    }

    public void setRazzaAquila(String razzaAquila) {
        this.razzaAquila = razzaAquila;
    }

    @Override
    public void vola() {
        System.out.println("Io posso volare..");
    }

    @Override
    public String stampaProprieta() {
        return getRazzaAquila();
    }
    @Override
    public boolean eUgualeA(Volatile altroVolatile) {
        if (!(altroVolatile instanceof Aquila)) {
            return false;
        } else {
            Aquila temp = (Aquila) altroVolatile;
            return this.razzaAquila.equalsIgnoreCase(temp.getRazzaAquila());
        }
    }
}
