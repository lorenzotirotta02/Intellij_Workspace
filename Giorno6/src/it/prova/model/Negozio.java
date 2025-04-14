package it.prova.model;

import java.util.ArrayList;

public class Negozio {
    private String ragioneSociale;
    private String partitaIva;
    private CentroCommerciale centroCommerciale;
    private ArrayList<Item> items;
    private ArrayList<Lavoratore> lavoratori;

    public ArrayList<Lavoratore> getLavoratori() {
        return lavoratori;
    }

    public void setLavoratori(ArrayList<Lavoratore> lavoratori) {
        this.lavoratori = lavoratori;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public String getRagioneSociale() {
        return ragioneSociale;
    }

    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }

    public String getPartitaIva() {
        return partitaIva;
    }

    public void setPartitaIva(String partitaIva) {
        this.partitaIva = partitaIva;
    }

    public CentroCommerciale getCentroCommerciale() {
        return centroCommerciale;
    }

    public void setCentroCommerciale(CentroCommerciale centroCommerciale) {
        this.centroCommerciale = centroCommerciale;
    }

    public boolean addToItems(Lavoratore lavoratore, Item item) {
        for (Lavoratore lavoratoreItem : lavoratori) {
            if (lavoratoreItem.getNome().equalsIgnoreCase(lavoratore.getNome()) && lavoratoreItem.getCognome().equalsIgnoreCase(lavoratore.getCognome())) {
                return lavoratoreItem.handleItemAdd(item);
            }
        }
        return false;
    }

    public boolean removeFromItems(Lavoratore lavoratore, Item item) {
        for (Lavoratore lavoratoreItem : lavoratori) {
                if (lavoratoreItem.getNome().equalsIgnoreCase(lavoratore.getNome()) && lavoratoreItem.getCognome().equalsIgnoreCase(lavoratore.getCognome())) {
                    return lavoratoreItem.handleItemRemove(item);
                }
        }
        return false;
    }
}
