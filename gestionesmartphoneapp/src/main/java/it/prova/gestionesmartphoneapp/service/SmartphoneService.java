package it.prova.gestionesmartphoneapp.service;

import it.prova.gestionesmartphoneapp.dao.smartphone.SmartphoneDAO;
import it.prova.gestionesmartphoneapp.model.App;
import it.prova.gestionesmartphoneapp.model.Smartphone;

public interface SmartphoneService {

    public void setSmartphoneDAO(SmartphoneDAO smartphoneDAO);

    void rimuoviSmartphone(Long id) throws Exception;

    public void aggiungiSmartphone(Smartphone smartphoneInstance) throws Exception;

    public void aggiornaVersioneOs(Smartphone smartphone) throws Exception;

    public Smartphone trovaById(Long id) throws Exception;

    public void aggiungiApp(Smartphone smartphoneInstance) throws Exception;

    void disinstallaApp(Long idApp) throws Exception;

    Smartphone trovaSmartphoneConApp(Long idSmartphone) throws Exception;
}
