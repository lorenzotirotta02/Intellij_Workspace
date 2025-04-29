package it.prova.gestioneordiniarticolicategorie.dao.categoria;

import it.prova.gestioneordiniarticolicategorie.dao.IBaseDAO;
import it.prova.gestioneordiniarticolicategorie.model.Categoria;

public interface CategoriaDAO extends IBaseDAO<Categoria> {
    void deleteCategoriaLinkedToArticoli(Categoria categoriaInstance) throws Exception;
    Categoria findByIdEager(Long id) throws Exception;
}
