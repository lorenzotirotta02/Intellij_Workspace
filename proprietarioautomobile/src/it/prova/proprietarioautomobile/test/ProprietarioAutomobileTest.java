package it.prova.proprietarioautomobile.test;

import it.prova.proprietarioautomobile.MyServiceFactory;
import it.prova.proprietarioautomobile.dao.EntityManagerUtil;
import it.prova.proprietarioautomobile.model.Automobile;
import it.prova.proprietarioautomobile.model.Proprietario;
import it.prova.proprietarioautomobile.service.automobile.AutomobileService;
import it.prova.proprietarioautomobile.service.proprietario.ProprietarioService;

import java.time.LocalDate;

public class ProprietarioAutomobileTest {
    public static void main(String[] args) {
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.OFF);
        AutomobileService automobileService = MyServiceFactory.getAutomobileServiceInstance();
        ProprietarioService proprietarioService = MyServiceFactory.getProprietarioServiceInstance();
        try{

//            /// TEST INSERIMENTO AUTOMOBILE
//            Automobile automobile = new Automobile("Fiat", "Panda", "AB123CD", LocalDate.of(2020, 1, 1));
//            automobileService.inserisciNuovo(automobile);

//            /// TEST INSERIMENTO PROPRIETARIO
//            Proprietario proprietario = new Proprietario("Lorenzo", "Rossi", "1234567890", LocalDate.of(1990, 1, 1));
//            proprietarioService.inserisciNuovo(proprietario);

//            /// TEST GET AUTOMOBILE
              automobileService.caricaSingoloAutomobile(1L);

//            /// TEST GET PROPRIETARIO
            proprietarioService.caricaSingoloProprietario(1L);

//            /// TEST AGGIORNAMENTO AUTOMOBILE







        } catch (Throwable e) {
        e.printStackTrace();
    } finally {
        // questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
        // main
        EntityManagerUtil.shutdown();
    }


    }
}
