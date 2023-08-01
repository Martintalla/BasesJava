package com.inetum.appliSpringJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.inetum.aplliSprinJpa.dao.interfaces.IDaoOperations;
import com.inetum.appliSpringJpa.entity.Compte;
import com.inetum.appliSpringJpa.entity.Employe;
import com.inetum.appliSpringJpa.entity.Operation;

@Repository // Pour que ctte classe DAO soit prise en compte apr le spring
@Transactional // Pour demander un commit rollback autaumatiquement

public class DaoOperationJpa implements IDaoOperations {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Operation insert(Operation operation) {
		entityManager.persist(operation);
		return operation;
	}

	@Override
	public Operation findById(Long idOp) {

		return entityManager.find(Operation.class, idOp);
	}

	@Override
	public List<Operation> findAll() {
		return entityManager.createQuery("SELECT e FROM Operation e", Operation.class).getResultList();
	}

	@Override
	public void update(Operation operation) {

		entityManager.merge(operation);

	}

	@Override
	public void deleteById(Long idOp) {

		Operation OpAsupprimer = entityManager.find(Operation.class, idOp);
		entityManager.remove(OpAsupprimer);

	}

}
