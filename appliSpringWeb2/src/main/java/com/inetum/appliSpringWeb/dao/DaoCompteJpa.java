package com.inetum.appliSpringWeb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.inetum.appliSpringWeb.doa.interfaces.IDaoCompte;
import com.inetum.appliSpringWeb.entity.Compte;

@Repository //pour cette classe de DAO soit prise en charge par Spring
@Transactional //pour demander commit/rollback automatiques
public class DaoCompteJpa extends DaoGenericJpa<Compte,Long> implements IDaoCompte {
	
	@PersistenceContext
	private EntityManager entityManager;

	public DaoCompteJpa() {
		super(Compte.class);
	}
	
	@Override
	public EntityManager getEntityManager() {

		return entityManager;
	}

	@Override
	public List<Compte> findBySoldeMini(double soldeMini) {
		return entityManager
				.createNamedQuery("Compte.findBySoldeMini",Compte.class)
				.setParameter(1,soldeMini)//pour valeur de ?1
				.getResultList();
	}

	@Override
	public List<Compte> findBySoldeMaxi(double soldeMaxi) {
		return entityManager
				.createNamedQuery("Compte.findBySoldeMaxi",Compte.class)
				.setParameter(1,soldeMaxi)//pour valeur de ?1
				.getResultList();
	}

	@Override
	public Compte findById(Long numero) {
		return entityManager.find(Compte.class, numero);
	}

	@Override
	public Compte insert(Compte cpt) {
		entityManager.persist(cpt);// .numero n'est normalement plus null si auto-incr
		return cpt; // on retourne l'objet modifié (avec .numro non null)
	}

	@Override
	public void update(Compte cpt) {
			entityManager.merge(cpt);
	}

	@Override
	public void deleteById(Long num) {
			Compte compteAsupprimer = entityManager.find(Compte.class, num);
			entityManager.remove(compteAsupprimer);
	}

	@Override
	public Compte findCompteWithOperationsById(Long numero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compte> findComptesOfClient(Long numClient) {
		// TODO Auto-generated method stub
		return null;
	}
}
