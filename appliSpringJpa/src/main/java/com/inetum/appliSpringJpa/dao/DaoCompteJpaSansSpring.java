package com.inetum.appliSpringJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.inetum.aplliSprinJpa.dao.interfaces.IDaoCompte;
import com.inetum.appliSpringJpa.entity.Compte;
import com.inetum.appliSpringJpa.entity.Employe;

public class DaoCompteJpaSansSpring implements IDaoCompte {
	
	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Compte> findBySoldeMini(double soldeMini) {
		return entityManager
				.createQuery("SELECT c FROM Compte c WHERE c.solde <?1", 
						     Compte.class)
				.setParameter(1,soldeMini)
				.getResultList();
	}

	@Override
	public List<Compte> findBySoldeMaxi(double soldeMaxi) {
		return entityManager
				.createQuery("SELECT c FROM Compte c WHERE c.solde >?1 ", 
						     Compte.class)
				.setParameter(1,soldeMaxi)
				.getResultList();
	}
	
	public Compte insert(Compte comp) {
		try {
			entityManager.getTransaction().begin();
			// en entrée , emp est un nouvel objet employé avec .numero à null (encore inconnu)
			// déclenche automatiquement INSERT INTO Employe(prenom, nom....)
			// VALUES(emp.getPrenom() , ....)
			entityManager.persist(comp);// .numero n'est normalement plus null si auto-incr
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw new RuntimeException("echec insertNew(compte)");
		}
		return comp; // on retourne l'objet modifié (avec .numro non null)
	}

	public void insert(Employe employe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Compte findById(Long numero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compte findCompteWithOperationsById(Long numero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Compte compte) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Compte> findComptesOfClient(Long numClient) {
		// TODO Auto-generated method stub
		return null;
	}

}
