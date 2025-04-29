package it.prova.gestioneordiniarticolicategorie.dao;


import it.prova.gestioneordiniarticolicategorie.dao.articolo.ArticoloDAO;
import it.prova.gestioneordiniarticolicategorie.dao.articolo.ArticoloDAOImpl;
import it.prova.gestioneordiniarticolicategorie.dao.categoria.CategoriaDAO;
import it.prova.gestioneordiniarticolicategorie.dao.categoria.CategoriaDAOImpl;
import it.prova.gestioneordiniarticolicategorie.dao.ordine.OrdineDAO;
import it.prova.gestioneordiniarticolicategorie.dao.ordine.OrdineDAOImpl;

public class MyDaoFactory {

    private static ArticoloDAO articoloDaoInstance = null;
    private static CategoriaDAO categoriaDAOInstance = null;
    private static OrdineDAO ordineDaoInstance = null;

    public static ArticoloDAO getArticoloDAOInstance() {
        if (articoloDaoInstance == null)
            articoloDaoInstance = new ArticoloDAOImpl();

        return articoloDaoInstance;
    }

    public static CategoriaDAO getCategoriaDAOInstance() {
        if (categoriaDAOInstance == null)
            categoriaDAOInstance = new CategoriaDAOImpl();

        return categoriaDAOInstance;
    }

    public static OrdineDAO getOrdineDAOInstance() {
        if (ordineDaoInstance == null)
            ordineDaoInstance = new OrdineDAOImpl();

        return ordineDaoInstance;
    }
}


