package it.prova.gestionesmartphoneapp.dao.smartphone;

import it.prova.gestionesmartphoneapp.dao.IBaseDAO;
import it.prova.gestionesmartphoneapp.model.App;
import it.prova.gestionesmartphoneapp.model.Smartphone;

import java.util.List;

public interface SmartphoneDAO extends IBaseDAO<Smartphone> {
    void addApp(Smartphone smartphoneInstance) throws Exception;
    void removeAppFromSmartphone(Long id) throws Exception;
    Smartphone findByIdFetchApps(Long id) throws Exception;
    
}

