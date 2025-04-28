package it.prova.gestionesmartphoneapp.test;

import it.prova.gestionesmartphoneapp.dao.EntityManagerUtil;
import it.prova.gestionesmartphoneapp.model.App;
import it.prova.gestionesmartphoneapp.model.Smartphone;
import it.prova.gestionesmartphoneapp.service.AppService;
import it.prova.gestionesmartphoneapp.service.MyServiceFactory;
import it.prova.gestionesmartphoneapp.service.SmartphoneService;
import java.time.LocalDateTime;


public class testGestioneSmartphoneApp {
    public static void main(String[] args) throws Exception {

        java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.OFF);
        AppService appServiceInstance = MyServiceFactory.getAppServiceInstance();
        SmartphoneService smartphoneServiceInstance = MyServiceFactory.getSmartphoneServiceInstance();
        try {

//        // TEST Inserimento Nuovo Smartphone
//        testInserimentoNuovoSmartphone(smartphoneServiceInstance);
//
//        // TEST Inserimento Nuova App
//        testInserimentoNuovaApp(appServiceInstance);

        // TEST AggiornamentoVersioneOs
//        testAggiornaVersioneOs(smartphoneServiceInstance);

        // TEST AggiornamentoVersioneAppConData
//            testAggiornaVersioneApp(appServiceInstance);

        // TEST Aggiunta App a Smartphone
//        testAggiungiAppASmartphone(smartphoneServiceInstance, appServiceInstance);

        // TEST Disinstallazione App da Smartphone
//        testDisinstallazioneAppDaSmartphone(smartphoneServiceInstance, appServiceInstance);
        // TEST Rimozione Smartphone e due app
        testRimozioneSmartphone(smartphoneServiceInstance, appServiceInstance);

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
    private static void testAggiornaVersioneOs(SmartphoneService smartphoneServiceInstance) throws Exception {
        System.out.println(".......testAggiornaVersioneOs inizio.............");

        String versione = "1.59";
        Smartphone smartphone = smartphoneServiceInstance.trovaById(1L);

        if(smartphone.getVersioneOs().equals(versione)){
            System.out.println("testAggiornaVersioneOs fallito");
        }
        smartphone.setVersioneOs(versione);
        smartphoneServiceInstance.aggiornaVersioneOs(smartphone);
        System.out.println(".......testAggiornaVersioneOs fine: PASSED.............");
    }
    private static void testAggiornaVersioneApp(AppService appServiceInstance) throws Exception {
        System.out.println(".......testAggiornaVersioneOs inizio.............");

        String versione = "1.59";
        App app = appServiceInstance.trovaById(1L);
        LocalDateTime currentDateTime = LocalDateTime.now();

        if(app.getVersione().equals(versione)){
            System.out.println("testAggiornaVersioneOs fallito");
        }
        app.setVersione(versione);
        app.setDataUltimoAggiornamento(currentDateTime);
        appServiceInstance.aggiornaVersioneConData(app);
        System.out.println(".......testAggiornaVersioneOs fine: PASSED.............");
    }
    public static void testAggiungiAppASmartphone(SmartphoneService smartphoneService, AppService appService) throws Exception {
        System.out.println(".......testAggiungiAppASmartphone inizio.............");

        App app = new App("WhatsApp", LocalDateTime.now(), LocalDateTime.now(), "2.23.10");
        Smartphone smartphone = new Smartphone("Samsung", "Galaxy S21", 699.99, "1.28");

        smartphone.getApps().add(app);
        app.getSmartphone().add(smartphone);

        // Salvo solo lo smartphone (che si porta dietro le App)
        smartphoneService.aggiungiSmartphone(smartphone);

        // Se non hai cascade persist devi salvare anche app a mano, ma prima smartphone!

        System.out.println(".......testAggiungiAppASmartphone fine: PASSED.............");
    }
    private static void testDisinstallazioneAppDaSmartphone(SmartphoneService smartphoneService, AppService appService) throws Exception {
        System.out.println(".......testDisinstallazioneAppDaSmartphone inizio.............");

        smartphoneService.trovaSmartphoneConApp(6L);

        App app = appService.trovaById(3L);

        smartphoneService.disinstallaApp(app.getId());

        System.out.println(".......testDisinstallazioneAppDaSmartphone fine: PASSED.............");
    }
    private static void testRimozioneSmartphone(SmartphoneService smartphoneService, AppService appService) throws Exception {
        System.out.println(".......testRimozioneSmartphone inizio.............");

        Smartphone smartphone = new Smartphone("Nokia", "211", 699.99, "1.28");

        App app = new App("Facebook", LocalDateTime.now(), LocalDateTime.now(), "2.23.10");
        App app2 = new App("Instagram", LocalDateTime.now(), LocalDateTime.now(), "2.23.10");

        smartphone.getApps().add(app);
        smartphone.getApps().add(app2);
        app.getSmartphone().add(smartphone);

        smartphoneService.aggiungiSmartphone(smartphone);

        // Scollego smartphone da app
        smartphoneService.disinstallaApp(app.getId());
        smartphoneService.disinstallaApp(app2.getId());

        // Rimuovo smartphone
        smartphoneService.rimuoviSmartphone(smartphone.getId());
        // Rimuovo app
        appService.rimuoviApp(app.getId());
        appService.rimuoviApp(app2.getId());

        //DOMANDA DA FARE SUL PERCHE' NON FUNZIONA

        System.out.println(".......testRimozioneSmartphone fine: PASSED.............");
    }


}

