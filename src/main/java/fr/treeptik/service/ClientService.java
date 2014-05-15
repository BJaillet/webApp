package fr.treeptik.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.dao.ClientDAO;
import fr.treeptik.dao.DAOException;
import fr.treeptik.model.Client;

@Service
public class ClientService {

	@Autowired
	private ClientDAO clientDAO;
	
	@Transactional
	public Client save(Client client) throws ServiceException {
		try {
			return clientDAO.save(client);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
	
	@Transactional
	public Client update(Client client) throws ServiceException {
		try {
			return clientDAO.update(client);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
	
	@Transactional
	public void remove(Client client) throws ServiceException {
		try {
			client = this.findById(client.getId());
			clientDAO.remove(client);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
	
	public Client findById(Integer id) throws ServiceException {
		try {
			return clientDAO.find(id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
	
	public List<Client> findAll() throws ServiceException {
		try {
			return clientDAO.findAll();
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
	
}
