package it.prova.gestioneordiniarticolicategorie.service.articolo;

import it.prova.gestioneordiniarticolicategorie.dao.articolo.ArticoloDAO;
import it.prova.gestioneordiniarticolicategorie.model.Articolo;

public interface ArticoloService {

    Articolo trovaArticolo(Long id) throws Exception;
    void aggiornaArticolo(Articolo articoloInstance) throws Exception;
    void aggiungiArticolo(Articolo articoloInstance) throws Exception;
    void rimuoviArticolo(Long id) throws Exception;
    void setArticoloDao(ArticoloDAO articoloDAOInstance);
    void rimuoviArticoloCollegatoACategoria(Articolo articoloInstance) throws Exception;
}
