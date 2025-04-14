package it.prova.test;

import it.prova.model.*;

import java.util.ArrayList;

public class TestCentroCommerciale {
    public static void main(String[] args) {

        Item bottiglia = new Item();
        bottiglia.setCodice("ll1");
        bottiglia.setDescrizione("Una bottiglia di plastica");
        bottiglia.setPrezzo(2);

        Item tastiera = new Item();
        tastiera.setCodice("POFF5");
        tastiera.setDescrizione("Una tastiera meccanica");
        tastiera.setPrezzo(35);

        Negozio negozio = new Negozio();
        negozio.setPartitaIva("FGAVWGVA12");
        negozio.setRagioneSociale("Alimentari");

        Boss boss = new Boss();
        boss.setNome("Luigi");
        boss.setCognome("Verdi");
        boss.setNegozio(negozio);

        PersonaleAmministrativo p = new PersonaleAmministrativo();
        p.setNome("Mario");
        p.setCognome("Bianchi");
        p.setNegozio(negozio);

        Commesso tommaso = new Commesso();
        tommaso.setNome("Tommaso");
        tommaso.setCognome("Rossi");
        tommaso.setNegozio(negozio);

        ArrayList<Lavoratore> lavoratores = new ArrayList<>();
        lavoratores.add(p);
        lavoratores.add(boss);
        lavoratores.add(tommaso);

        ArrayList<Item> oggetti = new ArrayList<>();
        negozio.setLavoratori(lavoratores);
        negozio.setItems(oggetti);

        System.out.println(negozio.addToItems(lavoratores.get(2), tastiera));
        System.out.println(negozio.removeFromItems(lavoratores.get(2), tastiera));
        System.out.println(negozio.addToItems(lavoratores.get(0), bottiglia));
        System.out.println(negozio.removeFromItems(lavoratores.get(2), bottiglia
        ));

    }
}
