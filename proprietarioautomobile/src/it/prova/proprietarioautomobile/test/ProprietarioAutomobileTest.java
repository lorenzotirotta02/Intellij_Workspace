package it.prova.proprietarioautomobile.test;

import it.prova.proprietarioautomobile.MyServiceFactory;
import it.prova.proprietarioautomobile.dao.EntityManagerUtil;
import it.prova.proprietarioautomobile.model.Automobile;
import it.prova.proprietarioautomobile.model.Proprietario;
import it.prova.proprietarioautomobile.service.automobile.AutomobileService;
import it.prova.proprietarioautomobile.service.proprietario.ProprietarioService;

import java.time.LocalDate;
import java.util.List;

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

////            /// TEST GET AUTOMOBILE
//              Automobile a = automobileService.caricaSingoloAutomobile(3L);
//              System.out.println(a.getMarca());
//              System.out.println(a.getModello());
//
////            /// TEST GET PROPRIETARIO
//              Proprietario p = proprietarioService.caricaSingoloProprietario(1L);
//              System.out.println(p.getNome());
//              System.out.println(p.getCognome());
//
////            /// TEST AGGIORNAMENTO AUTOMOBILE
//              a.setMarca("Ford");
//              a.setModello("Focus");
//              automobileService.aggiorna(a);
//
////            /// TEST AGGIORNAMENTO PROPRIETARIO
//              p.setNome("Mario");
//              p.setCognome("Bianchi");
//              proprietarioService.aggiorna(p);
//
////            /// TEST RIMOZIONE AUTOMOBILE
//              automobileService.rimuovi(3L);
//
////            /// TEST RIMOZIONE PROPRIETARIO
//              proprietarioService.rimuovi(1L);

            /// TEST INSERIMENTO AUTOMOBILE
            Automobile automobile = new Automobile("Fiat", "Panda", "AB123CD", LocalDate.of(2020, 1, 1));
            automobileService.inserisciNuovo(automobile);

            /// TEST INSERIMENTO PROPRIETARIO
            Proprietario proprietario = new Proprietario("Lorenzo", "Rossi", "1234567890", LocalDate.of(1990, 1, 1));
            proprietarioService.inserisciNuovo(proprietario);

            List<Automobile> results = automobileService.listAllAutomobili();
            for (Automobile a : results) {
                System.out.println(a.getMarca());
                System.out.println(a.getModello());
                System.out.println(a.getTarga());
                System.out.println(a.getAnnoImmatricolazione());
            }
            List<Proprietario> risultati = proprietarioService.listAllProprietari();
            for (Proprietario p : risultati) {
                System.out.println(p.getNome());
                System.out.println(p.getCognome());
                System.out.println(p.getCf());
                System.out.println(p.getDataDiNascita());
            }









        } catch (Throwable e) {
        e.printStackTrace();
    } finally {
        // questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
        // main
        EntityManagerUtil.shutdown();
    }


    }
}
