package it.prova.gestioneordiniarticolicategorie.dao.articolo;

import it.prova.gestioneordiniarticolicategorie.dao.IBaseDAO;
import it.prova.gestioneordiniarticolicategorie.model.Articolo;
import it.prova.gestioneordiniarticolicategorie.model.Categoria;

import java.util.List;

public interface ArticoloDAO extends IBaseDAO<Articolo> {
    void deleteArticoloLinkedToCategorie(Articolo articoloInstance) throws Exception;
    double sumAllPrezziDiArticoliLinkedToOneCategoria(Long id) throws Exception;
    double sumAllPrezziDiArticoliWithNomeDestinatario(String nomeDestinatario) throws Exception;
    List<Articolo> findAllWithDataSpedizioneAfterDataDiScadenza() throws Exception;
}
