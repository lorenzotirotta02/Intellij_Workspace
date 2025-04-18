package it.prova.proprietarioautomobile.dao;

import it.prova.proprietarioautomobile.dao.automobile.AutomobileDAO;
import it.prova.proprietarioautomobile.dao.automobile.AutomobileDAOImpl;
import it.prova.proprietarioautomobile.dao.proprietario.ProprietarioDAO;
import it.prova.proprietarioautomobile.dao.proprietario.ProprietarioDAOImpl;

public class MyDaoFactory {

    private static ProprietarioDAO proprietarioDAOIstance = null;
    private static AutomobileDAO automobileDAOIstance = null;

    public static ProprietarioDAO getProprietarioDAOInstance() {
        if (proprietarioDAOIstance == null)
            proprietarioDAOIstance = new ProprietarioDAOImpl();
        return proprietarioDAOIstance;
    }
    public static AutomobileDAO getAutomobileDAOInstance() {
        if (automobileDAOIstance == null)
            automobileDAOIstance = new AutomobileDAOImpl();
        return automobileDAOIstance;
    }
}
