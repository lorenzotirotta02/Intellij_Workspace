package it.prova.model;

public class Boss extends Lavoratore{


    @Override
    public boolean handleItemAdd(Item item) {
        return false;
    }

    @Override
    public boolean handleItemRemove(Item item) {
        return false;
    }
}
