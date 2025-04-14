package it.prova.model;

public class PersonaleAmministrativo extends Lavoratore{

    @Override
    public boolean handleItemAdd(Item item) {
        return this.getNegozio().getItems().add(item);
    }

    @Override
    public boolean handleItemRemove(Item item) {
        return false;
    }
}
