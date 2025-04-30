package it.prova.catenadimontaggio.service;

import it.prova.catenadimontaggio.dao.SlotCatenaDiMontaggioDAO;
import it.prova.catenadimontaggio.model.Automobile;
import it.prova.catenadimontaggio.model.SlotCatenaDiMontaggio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatenaDiMontaggioServiceImpl implements CatenaDiMontaggioService{

    @Autowired
    private TelaioService telaioService;
    @Autowired
    private MotoreRicercaService motoreRicercaService;
    @Autowired
    private ImpiantoElettricoService impiantoElettricoService;
    @Autowired
    private CarrozzeriaService carrozzeriaService;
    @Autowired
    private SlotCatenaDiMontaggioDAO slotCatenaDiMontaggioDAO;


    @Override
    public void ControlloAuto(SlotCatenaDiMontaggio slotCatenaDiMontaggio) {
        System.out.println("Avvio controllo...");
        System.out.println("************************************");
        for(Automobile automobile : slotCatenaDiMontaggio.getAutomobili()){
            System.out.println("Inizio controllo auto: " + automobile.getModello());
            carrozzeriaService.esaminaCarrozzeria(automobile);
            telaioService.esaminaTelaio(automobile);
            motoreRicercaService.controlloMotore(automobile);
            impiantoElettricoService.controlloImpiantoElettrico(automobile);

            System.out.println("Termine controllo auto: " + automobile.getModello());
            System.out.println("************************************");

        }
    }

    @Override
    public SlotCatenaDiMontaggio findById(Long id) {
        return slotCatenaDiMontaggioDAO.get(id);
    }

    @Override
    public void aggiungiAutomobile(Automobile automobile, SlotCatenaDiMontaggio slotCatenaDiMontaggio) {
        slotCatenaDiMontaggioDAO.addAutomobileToSlot(automobile, slotCatenaDiMontaggio);
    }
}
