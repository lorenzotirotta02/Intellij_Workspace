package it.prova.gestioneordiniarticolicategorie.test;

import it.prova.gestioneordiniarticolicategorie.dao.EntityManagerUtil;
import it.prova.gestioneordiniarticolicategorie.model.Articolo;
import it.prova.gestioneordiniarticolicategorie.model.Ordine;
import it.prova.gestioneordiniarticolicategorie.service.MyServiceFactory;
import it.prova.gestioneordiniarticolicategorie.service.articolo.ArticoloService;
import it.prova.gestioneordiniarticolicategorie.service.articolo.ArticoloServiceImpl;
import it.prova.gestioneordiniarticolicategorie.service.categoria.CategoriaService;
import it.prova.gestioneordiniarticolicategorie.service.ordine.OrdineService;

public class TestGestioneOrdiniArticoliCategorie {
    public static void main(String[] args){
        ArticoloService articoloServiceInstance = MyServiceFactory.getArticoloServiceInstance();
        CategoriaService categoriaServiceInstance = MyServiceFactory.getCategoriaServiceInstance();
        OrdineService ordineServiceInstance = MyServiceFactory.getOrdineServiceInstance();
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.OFF);

        try{
            // TEST Inserimento Nuovo Articolo
            testInserimentoArticolo(articoloServiceInstance, ordineServiceInstance);

            // TEST Inserimento Nuovo Ordine
//            testInserimentoOrdine(ordineServiceInstance);



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
}
