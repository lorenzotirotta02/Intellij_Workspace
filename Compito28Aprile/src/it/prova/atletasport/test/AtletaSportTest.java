package it.prova.atletasport.test;

import it.prova.atletasport.model.Atleta;
import it.prova.atletasport.model.Sport;
import it.prova.atletasport.service.AtletaService;
import it.prova.atletasport.service.MyServiceFactory;
import it.prova.atletasport.service.SportService;
import java.time.LocalDate;
import java.util.List;

public class AtletaSportTest {
    public static void main(String[] args){

        java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.OFF);

        AtletaService atletaServiceInstance = MyServiceFactory.getAtletaServiceInstance();
        SportService sportServiceInstance = MyServiceFactory.getSportServiceInstance();

        try {
            /// CRUD TESTING
//            Atleta a = new Atleta("Mario", "Rossi", LocalDate.of(1990, 1, 1), "4", 3);
//            atletaServiceInstance.inserisciNuovo(a);
//
//            Sport s = new Sport("Calcio", LocalDate.of(2020, 1, 1), LocalDate.of(2022, 1, 1));
//            sportServiceInstance.inserisciNuovo(s);

            List<Atleta> lista = atletaServiceInstance.listAll();
            for(Atleta atleta : lista) {
                System.out.println("Atleta: " + atleta.getId());
                System.out.println("Nome: " + atleta.getNome());
                System.out.println("Cognome: " + atleta.getCognome());
                System.out.println("Data di Nascita: " + atleta.getDataDiNascita());
                System.out.println("Codice: " + atleta.getCodice());
                System.out.println("Numero Medaglie Vinte: " + atleta.getNumeroMedaglieVinte());
                System.out.println("Stato: " + atleta.getStato());
            }

            List<Sport> listaSport = sportServiceInstance.listAll();
            for(Sport sport : listaSport) {
                System.out.println("Sport: " + sport.getId());
                System.out.println("Descrizione: " + sport.getDescrizione());
                System.out.println("Data Inizio: " + sport.getDataInizio());
                System.out.println("Data Fine: " + sport.getDataFine());
            }

            Atleta a = atletaServiceInstance.caricaSingoloElemento(1L);
            Sport s = sportServiceInstance.caricaSingoloElemento(1L);

            a.setCodice("3");
            atletaServiceInstance.aggiorna(a);


            s.setDescrizione("Basket");
            sportServiceInstance.aggiorna(s);

            sportServiceInstance.rimuovi(s.getId());
            atletaServiceInstance.rimuovi(a.getId());



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
