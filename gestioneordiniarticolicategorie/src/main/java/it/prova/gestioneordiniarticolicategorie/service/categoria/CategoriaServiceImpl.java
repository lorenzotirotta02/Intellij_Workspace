package it.prova.gestioneordiniarticolicategorie.service.categoria;

import it.prova.gestioneordiniarticolicategorie.dao.categoria.CategoriaDAO;
import it.prova.gestioneordiniarticolicategorie.model.Categoria;

public class CategoriaServiceImpl implements CategoriaService{

    private CategoriaDAO categoriaDAO;

    @Override
    public void AggiungiCategoria(Categoria categoriaInstance) throws Exception {

    }

    @Override
    public void rimuoviCategoria(Long id) throws Exception {

    }

    @Override
    public void aggiornaCategoria(Categoria categoriaInstance) throws Exception {

    }

    @Override
    public Categoria trovaById(Long id) throws Exception {
        return null;
    }

    @Override
    public void setCategoriaDAO(CategoriaDAO categoriaDAOInstance) {
        this.categoriaDAO = categoriaDAOInstance;
    }
}
