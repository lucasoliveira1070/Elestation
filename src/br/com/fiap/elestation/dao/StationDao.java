package br.com.fiap.elestation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.fiap.elestation.model.Station;

public class StationDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("elestation");
	EntityManager manager = factory.createEntityManager();

	public void insert(Station station) {

		manager.getTransaction().begin();
		manager.persist(station);
		manager.getTransaction().commit();

	}

	public List<Station> listAll() {
		String jpql = "SELECT s FROM Station s";
		TypedQuery<Station> query = manager.createQuery(jpql, Station.class);

		return query.getResultList();
	}
	
	public List<Station> listByState() {
		String jpql = "SELECT s FROM Station s order by s.state";
		TypedQuery<Station> query = manager.createQuery(jpql, Station.class);

		return query.getResultList();
	}

	public void delete(Station station) {
		manager.getTransaction().begin();
		manager.remove(station);
		manager.getTransaction().commit();
	}
	
	public Station find(Long id) {
		return manager.find(Station.class, id);
	}

}
