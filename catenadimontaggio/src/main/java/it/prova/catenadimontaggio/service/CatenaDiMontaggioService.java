package it.prova.catenadimontaggio.service;

import it.prova.catenadimontaggio.model.Automobile;
import it.prova.catenadimontaggio.model.SlotCatenaDiMontaggio;
import org.springframework.stereotype.Service;


public interface CatenaDiMontaggioService {
    public void ControlloAuto(SlotCatenaDiMontaggio slotCatenaDiMontaggio);
    SlotCatenaDiMontaggio findById(Long id);
    void aggiungiAutomobile(Automobile automobile, SlotCatenaDiMontaggio slotCatenaDiMontaggio);
}
