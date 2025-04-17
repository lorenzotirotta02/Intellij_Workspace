package it.prova.test;

import it.prova.model.Televisore;
import it.prova.service.MyServiceFactory;
import it.prova.service.televisore.TelevisoreService;

import java.time.LocalDate;
import java.util.List;

public class TestTelevisore {
    public static void main(String[] args) {

        // parlo direttamente con il service
        TelevisoreService televisoreService = MyServiceFactory.getTelevisoreServiceImpl();


        try {
            ///  Test ListAll
            List<Televisore> listaTelevisori = televisoreService.listAll();
            for (Televisore t : listaTelevisori) {
                System.out.println("------");
                System.out.println("ID: " + t.getId());
                System.out.println("Marca: " + t.getMarca());
                System.out.println("Modello: " + t.getModello());
                System.out.println("Pollici: " + t.getPollici());
                System.out.println("Data Produzione: " + t.getDataproduzione());
            }

            /// Test FindByID
            Long id = 1L;
            Televisore t = televisoreService.findById(id);
            System.out.println("ID: " + t.getId());
            System.out.println("Marca: " + t.getMarca());
            System.out.println("Modello: " + t.getModello());
            System.out.println("Pollici: " + t.getPollici());
            System.out.println("Data Produzione: " + t.getDataproduzione());

            /// Test Insert
            Televisore nuovoTelevisore = new Televisore();
            nuovoTelevisore.setMarca("Hisense");
            nuovoTelevisore.setModello("A6 Series");
            nuovoTelevisore.setPollici(50);
            nuovoTelevisore.setDataproduzione(LocalDate.of(2023, 5, 10));

            int result = televisoreService.inserisciNuovo(nuovoTelevisore);
            System.out.println("Numero righe inserite: " + result);

            /// Test Update
            Televisore t2 = televisoreService.findById(2L); // Cambia con un ID valido

            if (t2 != null) {
                t.setMarca("Samsung");
                t.setModello("Neo QLED");
                t.setPollici(65);
                t.setDataproduzione(LocalDate.of(2023, 12, 1));

                int risultato = televisoreService.aggiorna(t2);
                System.out.println("Numero righe aggiornate: " + result);
            }


            /// Test Delete
            Long idDaRimuovere = 3L; // Cambia con un ID realmente esistente nel DB
            int righe = televisoreService.rimuovi(idDaRimuovere);
            System.out.println("Numero righe rimosse: " + righe);

            /// Test FindTelevisorePiuGrande

            Televisore piuGrande = televisoreService.cercaIlPiuGrande();
            if (piuGrande != null) {
                System.out.println("Televisore più grande:");
                System.out.println("ID: " + piuGrande.getId());
                System.out.println("Marca: " + piuGrande.getMarca());
                System.out.println("Modello: " + piuGrande.getModello());
                System.out.println("Pollici: " + piuGrande.getPollici());
                System.out.println("Data Produzione: " + piuGrande.getDataproduzione());
            } else {
                System.out.println("Nessun televisore trovato.");
            }
            /// Test findProdottiInUnIntervallo
            LocalDate dataIniziale = LocalDate.of(2023, 1, 1);
            LocalDate dataFinale = LocalDate.of(2023, 12, 31);
            int conteggio = televisoreService.contaITelevisoriProdottiInUnIntervallo(dataIniziale, dataFinale);
            System.out.println(conteggio);

            /// Test cercaPerMarcheDistinteTelevisoriProdottiNegliUltimiMesi
            LocalDate dataInput = LocalDate.of(2024, 1, 1); // Data di riferimento

            List<Televisore> televisoriRecente = televisoreService.cercaPerMarcheDistinteTelevisoriProdottiNegliUltimiMesi(dataInput);
            if (televisoriRecente != null && !televisoriRecente.isEmpty()) {
                System.out.println("Televisori prodotti negli ultimi mesi:");
                for (Televisore televisore : televisoriRecente) {
                    System.out.println("ID: " + televisore.getId());
                    System.out.println("Marca: " + televisore.getMarca());
                    System.out.println("Modello: " + televisore.getModello());
                    System.out.println("Pollici: " + televisore.getPollici());
                    System.out.println("Data Produzione: " + televisore.getDataproduzione());
                    System.out.println("---");
                }
            } else {
                System.out.println("Nessun televisore trovato prodotto dopo la data specificata.");
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
