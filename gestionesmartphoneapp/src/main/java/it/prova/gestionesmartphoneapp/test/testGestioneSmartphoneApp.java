package it.prova.gestionesmartphoneapp.test;

import it.prova.gestionesmartphoneapp.dao.EntityManagerUtil;
import it.prova.gestionesmartphoneapp.model.App;
import it.prova.gestionesmartphoneapp.model.Smartphone;
import it.prova.gestionesmartphoneapp.service.AppService;
import it.prova.gestionesmartphoneapp.service.MyServiceFactory;
import it.prova.gestionesmartphoneapp.service.SmartphoneService;

import java.time.LocalDate;

public class testGestioneSmartphoneApp {
    public static void main(String[] args) throws Exception {

        java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.OFF);
        AppService appServiceInstance = MyServiceFactory.getAppServiceInstance();
        SmartphoneService smartphoneServiceInstance = MyServiceFactory.getSmartphoneServiceInstance();
        try {

        // TEST Inserimento Nuovo Smartphone
        testInserimentoNuovoSmartphone(smartphoneServiceInstance);

        // TEST Inserimento Nuova App
        testInserimentoNuovaApp(appServiceInstance);


//        // TEST UpdateVersione
//        String versione = "1.29";
//        smartphoneServiceInstance.AggiornaVersioneOs(1L, versione);


        }catch (Throwable e){
            e.printStackTrace();
        }finally {
            EntityManagerUtil.shutdown();
        }






    }
    private static void testInserimentoNuovoSmartphone(SmartphoneService smartphoneServiceInstance) throws Exception {
        System.out.println(".......testInserimentoNuovoSmartphone inizio.............");

        Smartphone smartphone = new Smartphone("Samsung", "Galaxy S21", 699.99, "1.28");
        smartphoneServiceInstance.aggiungiSmartphone(smartphone);
        if (smartphone.getId() == null)
            throw new RuntimeException("testInserimentoNuovoSmartphone fallito ");

        System.out.println(".......testInserimentoNuovoSmartphone fine: PASSED.............");
    }
    private static void testInserimentoNuovaApp(AppService appServiceInstance) throws Exception {
        System.out.println(".......testInserimentoNuovaApp inizio.............");

        App whatsapp = new App("WhatsApp", java.time.LocalDateTime.now(), java.time.LocalDateTime.now(), "2.23.10");
        appServiceInstance.aggiungiApp(whatsapp);
        if (whatsapp.getId() == null)
            throw new RuntimeException("testInserimentoNuovaApp fallito ");

        System.out.println(".......testInserimentoNuovaApp fine: PASSED.............");
    }
}
