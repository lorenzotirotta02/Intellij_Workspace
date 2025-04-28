package it.prova.gestionesmartphoneapp.service;

import it.prova.gestionesmartphoneapp.dao.smartphone.SmartphoneDAO;
import it.prova.gestionesmartphoneapp.model.Smartphone;

public interface SmartphoneService {

    public void setSmartphoneDAO(SmartphoneDAO smartphoneDAO);

    public void aggiungiSmartphone(Smartphone smartphoneInstance) throws Exception;

    public void AggiornaVersioneOs(Long id, String versione) throws Exception;
}
