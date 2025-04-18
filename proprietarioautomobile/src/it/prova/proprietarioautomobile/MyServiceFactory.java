package it.prova.proprietarioautomobile;

import it.prova.proprietarioautomobile.dao.MyDaoFactory;
import it.prova.proprietarioautomobile.service.automobile.AutomobileService;
import it.prova.proprietarioautomobile.service.automobile.AutomobileServiceImpl;
import it.prova.proprietarioautomobile.service.proprietario.ProprietarioService;
import it.prova.proprietarioautomobile.service.proprietario.ProprietarioServiceImpl;

public class MyServiceFactory {

    private static ProprietarioService proprietarioServiceInstance = null;
    private static AutomobileService automobileServiceInstance = null;

    public static ProprietarioService getProprietarioServiceInstance() {
        if (proprietarioServiceInstance == null) {
            proprietarioServiceInstance = new ProprietarioServiceImpl();
            proprietarioServiceInstance.setProprietarioDAO(MyDaoFactory.getProprietarioDAOInstance());
        }
        return proprietarioServiceInstance;
    }
    public static AutomobileService getAutomobileServiceInstance() {
        if (automobileServiceInstance == null) {
            automobileServiceInstance = new AutomobileServiceImpl();
            automobileServiceInstance.setAutomobileDAO(MyDaoFactory.getAutomobileDAOInstance());
        }
        return automobileServiceInstance;
    }
}
