package it.prova.catenadimontaggio.dao;

import it.prova.catenadimontaggio.model.Automobile;
import it.prova.catenadimontaggio.model.SlotCatenaDiMontaggio;

public interface SlotCatenaDiMontaggioDAO {
    void addAutomobileToSlot(Automobile automobile, SlotCatenaDiMontaggio slotCatenaDiMontaggio);
    SlotCatenaDiMontaggio get(Long id);
}
