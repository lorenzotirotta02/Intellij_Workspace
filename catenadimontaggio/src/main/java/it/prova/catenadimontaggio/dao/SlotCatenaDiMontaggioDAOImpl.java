package it.prova.catenadimontaggio.dao;

import it.prova.catenadimontaggio.model.Automobile;
import it.prova.catenadimontaggio.model.SlotCatenaDiMontaggio;
import org.springframework.stereotype.Component;

@Component
public class SlotCatenaDiMontaggioDAOImpl implements SlotCatenaDiMontaggioDAO{
    @Override
    public void addAutomobileToSlot(Automobile automobile, SlotCatenaDiMontaggio slotCatenaDiMontaggio) {
        automobile.setSlotCatenaDiMontaggio(slotCatenaDiMontaggio);
        for (SlotCatenaDiMontaggio s : DbMock.SLOT_CATENA_DI_MONTAGGIOS) {
            if(s.getId() == s.getId())
                s.getAutomobili().add(automobile);
        }
    }

    @Override
    public SlotCatenaDiMontaggio get(Long id) {
        for (SlotCatenaDiMontaggio slotCatenaDiMontaggio : DbMock.SLOT_CATENA_DI_MONTAGGIOS) {
            if(slotCatenaDiMontaggio.getId() == id)
                return slotCatenaDiMontaggio;
        }
        return null;
    }
}
