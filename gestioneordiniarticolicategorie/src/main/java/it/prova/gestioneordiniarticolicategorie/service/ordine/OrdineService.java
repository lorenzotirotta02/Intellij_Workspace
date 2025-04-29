package it.prova.gestioneordiniarticolicategorie.service.ordine;

import it.prova.gestioneordiniarticolicategorie.dao.ordine.OrdineDAO;
import it.prova.gestioneordiniarticolicategorie.model.Ordine;

public interface OrdineService {

    void aggiungiOrdine(Ordine ordineInstance) throws Exception;
    void rimuoviOrdine(Long id) throws Exception;
    void aggiornaOrdine(Ordine ordineInstance) throws Exception;
    Ordine trovaById(Long id) throws Exception;
    void setOrdineDAO(OrdineDAO ordineDAOInstance);
    Ordine trovaByIdEager(Long id) throws Exception;
}
