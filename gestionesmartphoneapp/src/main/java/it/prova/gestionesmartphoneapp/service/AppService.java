package it.prova.gestionesmartphoneapp.service;

import it.prova.gestionesmartphoneapp.dao.app.AppDAO;
import it.prova.gestionesmartphoneapp.model.App;

public interface AppService {

    App trovaById(Long id) throws Exception;
    void rimuoviApp(Long id) throws Exception;
    void aggiornaVersioneConData(App appIstance) throws Exception;
    void aggiungiApp(App appInstance) throws Exception;
    void setAppDAO(AppDAO appDAOInstance);

}
