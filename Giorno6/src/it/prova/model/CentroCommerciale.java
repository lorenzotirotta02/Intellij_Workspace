package it.prova.model;

import java.util.ArrayList;

public class CentroCommerciale {
    private String ragioneSociale;
    private String indirizzoPerEsteso;
    private ArrayList<Negozio> negozi;

    public String getRagioneSociale() {
        return ragioneSociale;
    }

    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }

    public String getIndirizzoPerEsteso() {
        return indirizzoPerEsteso;
    }

    public void setIndirizzoPerEsteso(String indirizzoPerEsteso) {
        this.indirizzoPerEsteso = indirizzoPerEsteso;
    }

    public ArrayList<Negozio> getNegozi() {
        return negozi;
    }

    public void setNegozi(ArrayList<Negozio> negozi) {
        this.negozi = negozi;
    }
}
