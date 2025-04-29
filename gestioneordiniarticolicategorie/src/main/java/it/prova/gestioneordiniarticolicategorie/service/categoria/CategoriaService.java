package it.prova.gestioneordiniarticolicategorie.service.categoria;

import it.prova.gestioneordiniarticolicategorie.dao.categoria.CategoriaDAO;
import it.prova.gestioneordiniarticolicategorie.model.Categoria;

public interface CategoriaService {

    void aggiungiCategoria(Categoria categoriaInstance) throws Exception;
    void rimuoviCategoria(Long id) throws Exception;
    void aggiornaCategoria(Categoria categoriaInstance) throws Exception;
    Categoria trovaById(Long id) throws Exception;
    void setCategoriaDAO(CategoriaDAO categoriaDAOInstance);
    void eliminaCategoriaCollegataAdArticolo(Categoria categoriaInstance) throws Exception;
    Categoria trovaByIdEager(Long id) throws Exception;
}
