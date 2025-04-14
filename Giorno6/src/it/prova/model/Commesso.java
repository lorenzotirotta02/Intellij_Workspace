package it.prova.model;

public class Commesso extends Lavoratore{


    @Override
    public boolean handleItemAdd(Item item) {
        return this.getNegozio().getItems().add(item);
    }

    @Override
    public boolean handleItemRemove(Item item) {
        return this.getNegozio().getItems().remove(item);
    }
}
