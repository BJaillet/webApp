package fr.treeptik.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.treeptik.dao.DAOException;
import fr.treeptik.model.Client;

@Repository
public class ClientJPADAO implements ClientDAO {

	@PersistenceContext 
	private EntityManager entityManager;
	
	@Override
	public Client save(Client client) throws DAOException{
		try {
			entityManager.persist(client);
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e);
		}
		
		return client;
	}
	
	@Override
	public Client update(Client client) throws DAOException{
		try {
			entityManager.merge(client);
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e);
		}
		
		return client;
	}
	
	@Override
	public void remove(Client client) throws DAOException{
		try {
			entityManager.remove(client);
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e);
		}
	}
	
	@Override
	public Client find(Integer id) throws DAOException{
		
		try {
			return entityManager.find(Client.class, id);
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e);
		}
	}
	
	@Override
	public List<Client> findAll() throws DAOException {
		try {
			TypedQuery<Client> query = entityManager.createQuery("select c from Client c", Client.class);
			return query.getResultList();
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e);
		}
	}
}
