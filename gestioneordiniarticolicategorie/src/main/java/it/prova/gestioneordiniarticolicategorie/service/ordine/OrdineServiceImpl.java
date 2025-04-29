package it.prova.gestioneordiniarticolicategorie.service.ordine;

import it.prova.gestioneordiniarticolicategorie.dao.EntityManagerUtil;
import it.prova.gestioneordiniarticolicategorie.dao.ordine.OrdineDAO;
import it.prova.gestioneordiniarticolicategorie.model.Ordine;

import javax.persistence.EntityManager;

public class OrdineServiceImpl implements OrdineService{

    private OrdineDAO ordineDAO;

    @Override
    public void aggiungiOrdine(Ordine ordineInstance) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try{
            if(ordineInstance == null){
                throw new Exception("Problema valore in input");
            }
            entityManager.getTransaction().begin();

            ordineDAO.setEntityManager(entityManager);

            ordineDAO.insert(ordineInstance);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            entityManager.close();
        }

    }

    @Override
    public void rimuoviOrdine(Long id) throws Exception {

    }

    @Override
    public void aggiornaOrdine(Ordine ordineInstance) throws Exception {

    }

    @Override
    public Ordine trovaById(Long id) throws Exception {
        return null;
    }

    @Override
    public void setOrdineDAO(OrdineDAO ordineDAOInstance) {
        this.ordineDAO = ordineDAOInstance;
    }
}
