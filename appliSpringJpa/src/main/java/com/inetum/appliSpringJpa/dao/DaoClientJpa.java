package com.inetum.appliSpringJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.inetum.aplliSprinJpa.dao.interfaces.IDaoClient;
import com.inetum.appliSpringJpa.entity.Client;



public class DaoClientJpa implements IDaoClient {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Client findById(Long numero) {
		return entityManager.find(Client.class, numero);
	}

	@Override
	public Client findClientWithComptesById(Long numero) {
		return entityManager.createNamedQuery("Client.findClientWithComptesById",Client.class)
				.setParameter(1, numero)
				.getSingleResult();
	}

	@Override
	public List<Client> findAll() {
		return entityManager.createNamedQuery("Client.findAll", Client.class)
	            .getResultList();
	}

	@Override
	public Client insert(Client c) {
		entityManager.persist(c);
		return c;
	}

	@Override
	public void update(Client c) {
		entityManager.merge(c);

	}

	@Override
	public void deleteById(Long num) {
		Client client= entityManager.find(Client.class, num);
		entityManager.remove(client);

	}

	

}
