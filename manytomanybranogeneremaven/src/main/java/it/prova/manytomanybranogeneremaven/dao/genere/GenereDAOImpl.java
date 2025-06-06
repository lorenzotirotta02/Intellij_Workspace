package it.prova.manytomanybranogeneremaven.dao.genere;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.manytomanybranogeneremaven.model.Genere;

public class GenereDAOImpl implements GenereDAO {

	private EntityManager entityManager;

	@Override
	public List<Genere> list() throws Exception {
		return entityManager.createQuery("from Genere", Genere.class).getResultList();
	}

	@Override
	public Genere get(Long id) throws Exception {
		return entityManager.find(Genere.class, id);
	}

	@Override
	public void update(Genere input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		input = entityManager.merge(input);
	}

	@Override
	public void insert(Genere input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);
	}

	@Override
	public void delete(Genere input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(input));
	}
	
	@Override
	public Genere findByDescrizione(String descrizioneInput) throws Exception {
		TypedQuery<Genere> query = entityManager
				.createQuery("select g from Genere g where g.descrizione=?1", Genere.class)
				.setParameter(1, descrizioneInput);
		
		return query.getResultStream().findFirst().orElse(null);
	}

	@Override
	public List<Genere> findGeneriBetweenTwoDates(LocalDate dataInizio, LocalDate dataFine) throws Exception {
		TypedQuery<Genere> query = entityManager
				.createQuery("select g from Genere g left join fetch g.brani b where b.dataPubblicazione between ?1 and ?2", Genere.class)
				.setParameter(1,dataInizio);
				query.setParameter(2,dataFine);
		return query.getResultList();
	}
//						"select c FROM Brano c left join fetch c.generi g where length(g.descrizione) > ?1"
	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
