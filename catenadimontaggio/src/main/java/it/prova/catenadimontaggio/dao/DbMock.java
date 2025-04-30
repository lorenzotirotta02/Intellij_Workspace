package it.prova.catenadimontaggio.dao;

import it.prova.catenadimontaggio.model.Automobile;
import it.prova.catenadimontaggio.model.SlotCatenaDiMontaggio;

import java.util.ArrayList;
import java.util.List;

public class DbMock {

    public static final List<SlotCatenaDiMontaggio> SLOT_CATENA_DI_MONTAGGIOS = new ArrayList<>();

    static {
        SlotCatenaDiMontaggio slot1 = new SlotCatenaDiMontaggio(1L, "Fiat", "Italia");
        Automobile auto1 = new Automobile(1L, "Panda", "12345678901234567", null);
        slot1.getAutomobili().add(auto1);
        Automobile auto2 = new Automobile(2L, "500", "12345678901234568", null);
        slot1.getAutomobili().add(auto2);
        SLOT_CATENA_DI_MONTAGGIOS.add(slot1);

        SlotCatenaDiMontaggio slot2 = new SlotCatenaDiMontaggio(2L, "Ford", "USA");
        Automobile auto3 = new Automobile(3L, "Mustang", "12345678901234569", null);
        slot2.getAutomobili().add(auto3);
        SLOT_CATENA_DI_MONTAGGIOS.add(slot2);
    }
}
