package it.prova.gestionesmartphoneapp.service;

import it.prova.gestionesmartphoneapp.dao.app.AppDAO;
import it.prova.gestionesmartphoneapp.model.App;

public interface AppService {


    void aggiungiApp(App appInstance) throws Exception;
    void setAppDAO(AppDAO appDAOInstance);
}
