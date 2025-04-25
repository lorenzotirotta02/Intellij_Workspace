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

//            List<Atleta> lista = atletaServiceInstance.listAll();
//            for(Atleta atleta : lista) {
//                System.out.println("Atleta: " + atleta.getId());
//                System.out.println("Nome: " + atleta.getNome());
//                System.out.println("Cognome: " + atleta.getCognome());
//                System.out.println("Data di Nascita: " + atleta.getDataDiNascita());
//                System.out.println("Codice: " + atleta.getCodice());
//                System.out.println("Numero Medaglie Vinte: " + atleta.getNumeroMedaglieVinte());
//                System.out.println("Stato: " + atleta.getStato());
//            }
//
//            List<Sport> listaSport = sportServiceInstance.listAll();
//            for(Sport sport : listaSport) {
//                System.out.println("Sport: " + sport.getId());
//                System.out.println("Descrizione: " + sport.getDescrizione());
//                System.out.println("Data Inizio: " + sport.getDataInizio());
//                System.out.println("Data Fine: " + sport.getDataFine());
//            }
//
//            Atleta a = atletaServiceInstance.caricaSingoloElemento(1L);
//            Sport s = sportServiceInstance.caricaSingoloElemento(1L);
//
//            a.setCodice("3");
//            atletaServiceInstance.aggiorna(a);
//
//
//            s.setDescrizione("Basket");
//            sportServiceInstance.aggiorna(s);
//
            Sport s = new Sport("Calcio", LocalDate.of(2020, 1, 1), LocalDate.of(2022, 1, 1));
            sportServiceInstance.inserisciNuovo(s);
            sportServiceInstance.rimuovi(s.getId());
//            atletaServiceInstance.rimuovi(a.getId());

            /// FINE TEST CRUD

            /// TEST METODI sommaMedaglieDiAtletiConSportChiuso
//            Long sommaMedaglie = atletaServiceInstance.sommaMedaglieDiAtletiConSportChiuso();
//            System.out.println(sommaMedaglie);

            // Utilizzo Long perchè nella query, utilizzando sum, il dato di ritorno è Long
            // per gestire eventuali overflow



//            ///  TEST trovaTuttiAtletiConSportChiuso
//            List<Atleta> results = atletaServiceInstance.trovaTuttiAtletiConSportChiuso();
//            for(Atleta a : results){
//                System.out.println("Atleta: " + a.getId());
//                System.out.println("Nome: " + a.getNome());
//                System.out.println("Cognome: " + a.getCognome());
//                System.out.println("Data di Nascita: " + a.getDataDiNascita());
//                System.out.println("Codice: " + a.getCodice());
//                System.out.println("Numero Medaglie Vinte: " + a.getNumeroMedaglieVinte());
//                System.out.println("Stato: " + a.getStato());
//            }

            /// TEST caricaAtletaSingoloConSport
//            Atleta atletaSingoloConSport = atletaServiceInstance.caricaAtletaSingoloConSport(2L);
//            System.out.println(atletaSingoloConSport.getNome());
//            System.out.println(atletaSingoloConSport.getCognome());
//            System.out.println(atletaSingoloConSport.getSports().size());
//            System.out.println(atletaSingoloConSport.getDataDiNascita());
//            System.out.println(atletaSingoloConSport.getStato());

            /// TEST trovaTuttiAtletiBySport
//            List<Atleta> atleti = atletaServiceInstance.trovaTuttiAtletiBySport(sportServiceInstance.caricaSingoloElemento(2L));
//            for(Atleta a : atleti){
//                System.out.println("Atleta: " + a.getId());
//                System.out.println("Nome: " + a.getNome());
//                System.out.println("Cognome: " + a.getCognome());
//                System.out.println("Data di Nascita: " + a.getDataDiNascita());
//                System.out.println("Codice: " + a.getCodice());
//                System.out.println("Numero Medaglie Vinte: " + a.getNumeroMedaglieVinte());
//                System.out.println("Stato: " + a.getStato());
//            }

            /// TEST aggiungiSportAtleta
//            Sport sport = sportServiceInstance.caricaSingoloElemento(5L);
//            Atleta atleta = atletaServiceInstance.caricaSingoloElemento(4L);
//
//            sportServiceInstance.aggiungiSportAtleta(sport, atleta.getId());

//            /// TEST rimuoviSportDaAtleta
//            Sport sport = sportServiceInstance.caricaSingoloElemento(5L);
//            Atleta atleta = atletaServiceInstance.caricaSingoloElemento(4L);
//            sportServiceInstance.rimuoviSportDaAtleta(sport.getId(), atleta.getId());

//            Sport sport = sportServiceInstance.caricaSingoloElemento(5L);
//            Atleta atleta = atletaServiceInstance.caricaSingoloElemento(4L);
//            sportServiceInstance.rimuoviAtletaDopoScollegamentoSport(sport.getId(), atleta.getId());

            ///  TEST SportNotFoundException
//            Sport s = sportServiceInstance.caricaSingoloElemento(0L);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
