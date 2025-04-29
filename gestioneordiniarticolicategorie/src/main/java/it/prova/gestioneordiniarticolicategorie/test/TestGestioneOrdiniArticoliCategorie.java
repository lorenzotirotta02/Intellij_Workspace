package it.prova.gestioneordiniarticolicategorie.test;

import it.prova.gestioneordiniarticolicategorie.dao.EntityManagerUtil;
import it.prova.gestioneordiniarticolicategorie.exception.ArticoloPresenteInOrdineException;
import it.prova.gestioneordiniarticolicategorie.model.Articolo;
import it.prova.gestioneordiniarticolicategorie.model.Categoria;
import it.prova.gestioneordiniarticolicategorie.model.Ordine;
import it.prova.gestioneordiniarticolicategorie.service.MyServiceFactory;
import it.prova.gestioneordiniarticolicategorie.service.articolo.ArticoloService;
import it.prova.gestioneordiniarticolicategorie.service.categoria.CategoriaService;
import it.prova.gestioneordiniarticolicategorie.service.ordine.OrdineService;

import java.util.List;
import java.util.Set;

public class TestGestioneOrdiniArticoliCategorie {
    public static void main(String[] args){
        ArticoloService articoloServiceInstance = MyServiceFactory.getArticoloServiceInstance();
        CategoriaService categoriaServiceInstance = MyServiceFactory.getCategoriaServiceInstance();
        OrdineService ordineServiceInstance = MyServiceFactory.getOrdineServiceInstance();
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.OFF);

        try{
            // TEST Inserimento Nuovo Articolo
//            testInserimentoArticolo(articoloServiceInstance, ordineServiceInstance);

            // TEST Inserimento Nuovo Ordine
//            testInserimentoOrdine(ordineServiceInstance);

            //TEST Aggiornamento Ordine
//            testAggiornaOrdine(ordineServiceInstance);

            //TEST Aggiornamento Articolo
//            testAggiornaArticolo(articoloServiceInstance);
            //TEST Rimozione Articolo Legato a Ordine
//            testRimuoviArticoloLegatoAOrdine(articoloServiceInstance, ordineServiceInstance);


            //TEST Inserimento Categoria
//            testInserisciCategoria(categoriaServiceInstance);

            //TEST Aggiornamento Categoria
//            testAggiornaCategoriaEsistente(categoriaServiceInstance);

            //Test Aggiunta Articolo a Categoria
         //   testAggiungiArticoloACategoria(articoloServiceInstance, categoriaServiceInstance, ordineServiceInstance);

            // TEST Rimozione Articolo Scollegando da Categoria
            //testRimozioneArticoloScollegandoDaCategoria(articoloServiceInstance, categoriaServiceInstance, ordineServiceInstance);

            // TEST Rimozione Categoria Scollegando da Articolo
            //testRimozioneCategoriaScollegandoDaArticolo(articoloServiceInstance, categoriaServiceInstance, ordineServiceInstance);

            //TEST Rimozione Ordine
//            testRimozioneOrdine(ordineServiceInstance, articoloServiceInstance);

            // TEST sommaPrezziArticoli
//            testSommaPrezziArticoli(articoloServiceInstance, categoriaServiceInstance, ordineServiceInstance);

            //TEST trovaPiuRecente
//            testTrovaOrdinePiuRecenteByCategoria(ordineServiceInstance, categoriaServiceInstance);

            //TEST sommaPrezziArticoliConNomeDestinatario
//            testSommaPrezziArticoliConNomeDestinatario(articoloServiceInstance, ordineServiceInstance);

            //TEST trovaOrdiniByStringaInNumeroSeriale
//            testTrovaOrdiniByStringaInNumeroSeriale(ordineServiceInstance);
            //TEST trovaArticoliConDataSpedizioneDopoDataDiScadenza
            testTrovaArticoliConDataSpedizioneDopoDataDiScadenza(articoloServiceInstance);


        }catch (Throwable e){
            e.printStackTrace();
        }finally {
            EntityManagerUtil.shutdown();
        }

    }

    public static void testInserimentoOrdine(OrdineService ordineService) throws Exception{
        System.out.println(".......testInserimentoOrdine inizio.............");

        Ordine ordine = new Ordine("Mario Rossi", "Via Roma 1", java.time.LocalDateTime.now(), java.time.LocalDateTime.now().plusDays(5));
        ordineService.aggiungiOrdine(ordine);

        if (ordine.getId() == null)
            throw new RuntimeException("testInserimentoOrdine fallito ");

        System.out.println(".......testInserimentoOrdine fine: PASSED.............");
    }
    public static void testInserimentoArticolo(ArticoloService articoloService, OrdineService ordineService) throws Exception {
        System.out.println(".......testInserimentoArticolo inizio.............");

        Ordine ordine = new Ordine("Mario Bianchi", "Via Roma 1", java.time.LocalDateTime.now(), java.time.LocalDateTime.now().plusDays(5));
        ordineService.aggiungiOrdine(ordine);

        if (ordine .getId() == null)
            throw new RuntimeException("testInserimentoOrdine fallito ");

        Articolo articolo = new Articolo("Articolo 1", "Descrizione articolo 1", 10.99, java.time.LocalDateTime.now());
        articolo.setOrdine(ordine);
        articoloService.aggiungiArticolo(articolo);
        if (articolo.getId() == null)
            throw new RuntimeException("testInserimentoArticolo fallito ");

        System.out.println(".......testInserimentoArticolo fine: PASSED.............");
    }
    public static void testAggiornaOrdine(OrdineService ordineService) throws Exception{
        System.out.println(".......testAggiornaOrdine inizio.............");

        Ordine ordine = ordineService.trovaById(1L);

        if (ordine.getId() == null)
            throw new RuntimeException("testAggiornaOrdine fallito ");

        ordine.setNomeDestinatario("Mario Verdi");
        ordineService.aggiornaOrdine(ordine);

        if (!ordine.getNomeDestinatario().equals("Mario Verdi"))
            throw new RuntimeException("testAggiornaOrdine fallito ");

        System.out.println(".......testAggiornaOrdine fine: PASSED.............");
    }
    public static void testAggiornaArticolo(ArticoloService articoloService) throws Exception {
        System.out.println(".......testAggiornaArticolo inizio.............");

        Articolo articolo = articoloService.trovaArticolo(1L);

        if (articolo.getId() == null)
            throw new RuntimeException("testAggiornaArticolo fallito ");

        articolo.setDescrizione("Articolo Aggiornato");
        articoloService.aggiornaArticolo(articolo);

        if (!articolo.getDescrizione().equals("Articolo Aggiornato"))
            throw new RuntimeException("testAggiornaArticolo fallito ");

        System.out.println(".......testAggiornaArticolo fine: PASSED.............");
    }
    public static void testRimuoviArticoloLegatoAOrdine(ArticoloService articoloService, OrdineService ordineService) throws Exception {
        System.out.println(".......testRimuoviArticoloLegatoAOrdine inizio.............");


        Ordine ordine = new Ordine("Mario Rossi", "Via Roma 2", java.time.LocalDateTime.now(), java.time.LocalDateTime.now().plusDays(5));
        ordineService.aggiungiOrdine(ordine);
        if (ordine.getId() == null)
            throw new RuntimeException("errore nell'inserimento dell'ordine ");


        Articolo articolo = new Articolo("Articolo 2", "Descrizione articolo 2", 20.99, java.time.LocalDateTime.now());
        articolo.setOrdine(ordine);
        articoloService.aggiungiArticolo(articolo);

        if(articolo.getId() == null)
            throw new RuntimeException("errore nell'inserimento dell'articolo ");

        if (articolo.getOrdine() == null)
            throw new RuntimeException("L'articolo non è legato a nessun ordine ");


        articoloService.rimuoviArticolo(articolo.getId());

        if (articoloService.trovaArticolo(articolo.getId()) != null)
            throw new RuntimeException("testRimuoviArticoloLegatoAOrdine fallito ");

        System.out.println(".......testRimuoviArticoloLegatoAOrdine fine: PASSED.............");
    }
    public static void testInserisciCategoria(CategoriaService categoriaService)throws Exception{
        System.out.println(".......testInserisciCategoria inizio.............");

        Categoria categoria = new Categoria("Categoria 1", "Descrizione categoria 1");
        categoriaService.aggiungiCategoria(categoria);

        if (categoria.getId() == null)
            throw new RuntimeException("testInserisciCategoria fallito ");

        System.out.println(".......testInserisciCategoria fine: PASSED.............");
    }
    public static void testAggiornaCategoriaEsistente(CategoriaService categoriaService) throws Exception {
        System.out.println(".......testAggiornaCategoriaEsistente inizio.............");

        Categoria categoria = categoriaService.trovaById(1L);
        if (categoria.getId() == null)
            throw new RuntimeException("testAggiornaCategoriaEsistente fallito ");

        categoria.setDescrizione("Descrizione aggiornata");

        categoriaService.aggiornaCategoria(categoria);

        if (!categoria.getDescrizione().equals("Descrizione aggiornata"))
            throw new RuntimeException("testAggiornaCategoriaEsistente fallito ");

        System.out.println(".......testAggiornaCategoriaEsistente fine: PASSED.............");
    }
    public static void testAggiungiArticoloACategoria(ArticoloService articoloService, CategoriaService categoriaService, OrdineService ordineService) throws Exception {
        System.out.println(".......testAggiungiArticoloACategoria inizio.............");

        Ordine ordine = new Ordine("Mario", "Via Roma 144", java.time.LocalDateTime.now(), java.time.LocalDateTime.now().plusDays(5));
        ordineService.aggiungiOrdine(ordine);


        Categoria categoria = new Categoria("Categoria 3", "Descrizione categoria 2");
        categoriaService.aggiungiCategoria(categoria);

        Articolo articolo = new Articolo("Articolo 4", "Descrizione articolo 3", 30.99, java.time.LocalDateTime.now());
        articolo.setOrdine(ordine);

        articoloService.aggiungiArticolo(articolo);

        articolo.getCategorie().add(categoria);

        articoloService.aggiornaArticolo(articolo);

        if (articolo.getCategorie().isEmpty()){
            throw new RuntimeException("Errore nell'aggiunta dell'articolo alla categoria");
        }


        System.out.println(".......testAggiungiArticoloACategoria fine: PASSED.............");
    }

    public static void testRimozioneArticoloScollegandoDaCategoria(ArticoloService articoloService, CategoriaService categoriaService, OrdineService ordineService) throws Exception {
        System.out.println(".......testRimozioneArticoloScollegandoDaCategoria inizio.............");

        Ordine ordine = new Ordine("Mario", "Via Roma 144", java.time.LocalDateTime.now(), java.time.LocalDateTime.now().plusDays(5));
        ordineService.aggiungiOrdine(ordine);


        Categoria categoria = new Categoria("Categoria 3", "Descrizione categoria 2");
        categoriaService.aggiungiCategoria(categoria);

        Articolo articolo = new Articolo("Articolo 4", "Descrizione articolo 3", 30.99, java.time.LocalDateTime.now());
        articolo.setOrdine(ordine);

        articoloService.aggiungiArticolo(articolo);

        articolo.getCategorie().add(categoria);

        articoloService.aggiornaArticolo(articolo);

        articoloService.rimuoviArticoloCollegatoACategoria(articolo);

        // SALVO L'ARTICOLO TROVATO CON L'ID PER VERIFICARE SE SIA STATO CANCELLATO CORRETTAMENTE
        Articolo articoloVerificato = articoloService.trovaArticolo(articolo.getId());

        if (articoloVerificato != null){
            throw new RuntimeException("Errore nella rimozione dell'articolo dalla categoria");
        }else {
            System.out.println("Articolo rimosso!");
        }

        System.out.println(".......testRimozioneArticoloScollegandoDaCategoria fine: PASSED.............");
    }
    public static void testRimozioneCategoriaScollegandoDaArticolo(ArticoloService articoloService, CategoriaService categoriaService, OrdineService ordineService) throws Exception {
        System.out.println(".......testRimozioneArticoloScollegandoDaCategoria inizio.............");

        Ordine ordine = new Ordine("Mario", "Via Roma 144", java.time.LocalDateTime.now(), java.time.LocalDateTime.now().plusDays(5));
        ordineService.aggiungiOrdine(ordine);


        Categoria categoria = new Categoria("Categoria 33", "Descrizione categoria 2");
        categoriaService.aggiungiCategoria(categoria);

        Articolo articolo = new Articolo("Articolo 54", "Descrizione articolo 3", 30.99, java.time.LocalDateTime.now());
        articolo.setOrdine(ordine);

        articoloService.aggiungiArticolo(articolo);

        articolo.getCategorie().add(categoria);

        articoloService.aggiornaArticolo(articolo);

        categoriaService.eliminaCategoriaCollegataAdArticolo(categoria);

        Categoria categoriaDaVerificare = categoriaService.trovaById(categoria.getId());
        if (categoriaDaVerificare != null){
            throw new RuntimeException("Errore nella rimozione dell'articolo dalla categoria");
        }else{
            System.out.println("Categoria rimossa!");
        }

        System.out.println(".......testRimozioneArticoloCollegatoACategoria fine: PASSED.............");
    }
    public static void testRimozioneOrdine(OrdineService ordineService, ArticoloService articoloService) throws Exception {
        System.out.println(".......testRimozioneOrdine inizio.............");

        Ordine ordine = ordineService.trovaById(4L);

        ordineService.rimuoviOrdine(ordine.getId());

        System.out.println(".......testRimozioneOrdine fine: PASSED.............");
    }
    public static void testSommaPrezziArticoli(ArticoloService articoloService, CategoriaService categoriaService, OrdineService ordineService) throws Exception {
        System.out.println(".......testSommaPrezziArticoli inizio.............");

        Categoria categoria = categoriaService.trovaByIdEager(19L);

        double risultato = articoloService.sommaPrezziArticoliCollegatiACategoria(categoria.getId());

        Set<Articolo> result = categoria.getArticoli();
        if (result.isEmpty()){
            throw new RuntimeException("La categoria non contiene articoli");
        }

        System.out.println("La somma dei prezzi articoli per la categoria è: " + risultato);


        System.out.println(".......testSommaPrezziArticoli fine: PASSED.............");
    }
    public static void testTrovaOrdinePiuRecenteByCategoria(OrdineService ordineService, CategoriaService categoriaService) throws Exception {
        System.out.println(".......testTrovaOrdinePiuRecenteByCategoria inizio.............");

        Categoria categoria = categoriaService.trovaByIdEager(19L);

        Ordine ordine = ordineService.trovaPiuRecenteByCategoria(categoria.getId());

        if (ordine == null)
            throw new RuntimeException("testTrovaOrdinePiuRecenteByCategoria fallito ");

        System.out.println("L'ordine più recente per la categoria è: " + ordine.getId() + " - " + ordine.getNomeDestinatario());

        System.out.println(".......testTrovaOrdinePiuRecenteByCategoria fine: PASSED.............");
    }
    public static void testSommaPrezziArticoliConNomeDestinatario(ArticoloService articoloService, OrdineService ordineService) throws Exception {
        System.out.println(".......testSommaPrezziArticoli inizio.............");

        String nomeDestinatario = "Mario Rossi";
        boolean trovato = ordineService.trovaByNomeDestinatario(nomeDestinatario);

        double risultato = articoloService.sommaPrezziArticoliConNomeDestinatario(nomeDestinatario);

        if (!trovato){
            throw new RuntimeException("Non esiste nessun destinatario con questo nome");
        }

        System.out.println("La somma dei prezzi articoli per questo destinatario è: " + risultato);


        System.out.println(".......testSommaPrezziArticoli fine: PASSED.............");
    }
    public static void testTrovaOrdiniByStringaInNumeroSeriale(OrdineService ordineService) throws Exception {
        System.out.println(".......testTrovaOrdiniByStringaInNumeroSeriale inizio.............");

        String stringa = "articolo 3";
        List<Ordine> ordini = ordineService.trovaOrdiniDistintiByStringaInNumeroSeriale(stringa);

        if (ordini.isEmpty()){
            throw new RuntimeException("Non esistono articoli con questa stringa");
        }

        for (Ordine ordine : ordini) {
            System.out.println(ordine.getId() + " - " + ordine.getNomeDestinatario());
        }

        System.out.println(".......testTrovaOrdiniByStringaInNumeroSeriale fine: PASSED.............");
    }
    public static void testTrovaArticoliConDataSpedizioneDopoDataDiScadenza(ArticoloService articoloService) throws Exception {
        System.out.println(".......testTrovaArticoliConDataSpedizioneDopoDataDiScadenza inizio.............");

        List<Articolo> articoli = articoloService.trovaArticoliConDataSpedizioneDopoDataDiScadenza();

        if (articoli.isEmpty()){
            throw new RuntimeException("Non esistono articoli con data di spedizione dopo quella di scadenza");
        }

        for (Articolo articolo : articoli) {
            System.out.println(articolo.getId() + " - " + articolo.getDescrizione());
        }

        System.out.println(".......testTrovaArticoliConDataSpedizioneDopoDataDiScadenza fine: PASSED.............");
    }
}
