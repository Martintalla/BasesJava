package com.inetum.appliSpringJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.inetum.aplliSprinJpa.dao.interfaces.IDaoCompte;
import com.inetum.appliSpringJpa.entity.Compte;

@Repository // Pour que ctte classe DAO soit prise en compte apr le spring
@Transactional // Pour demander un commit rollback autaumatiquement

public class DaoCompteJpa implements IDaoCompte {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public Compte findCompteWithOperationsById(Long numero) {
		// Solution provisoire
//		
//		Compte compte = entityManager.find(Compte.class, numero);
//		for(Operation operation : compte.getOperations());
		
		//boucle for vide sue les opérations en mode lazy pour que ça déclenche des petits 
		//selects qui remontent tou de suite  les valeurs en mémoire avec la fin de la transacton et avant 
		//entityManager.Close() de Spring ou autre 
		//====> ça évite LazyInitialisationException
//		return compte;
		
		return entityManager
				.createNamedQuery("Compte.findCompteWithOperationsById", Compte.class)
				.setParameter(1,numero)//pour valeur de ?1
				.getSingleResult();
	}


	@Override
	public List<Compte> findBySoldeMini(double soldeMini) {
		return entityManager.createQuery("SELECT c FROM Compte c WHERE c.solde <?1", Compte.class)
				.setParameter(1, soldeMini).getResultList();
	}

	@Override
	public List<Compte> findBySoldeMaxi(double soldeMaxi) {
		return entityManager.createQuery("SELECT c FROM Compte c WHERE c.solde >?1 ", Compte.class)
				.setParameter(1, soldeMaxi).getResultList();
	}

	public Compte  insert(Compte comp) {

		entityManager.persist(comp);// .numero n'est normalement plus null si auto-incr

		return comp;
	}
	
	@Override
	public Compte findById(Long numero) {

		return entityManager.find(Compte.class, numero);
	}


	@Override
	public void update(Compte compte) {
		
			entityManager.merge(compte);
			
		
	}


	@Override
	public List<Compte> findComptesOfClient(Long numClient) {
		return entityManager
				.createNamedQuery("Compte.findComptesOfClient",Compte.class)
				.setParameter(1,numClient)//pour valeur de ?1
				.getResultList();
	}

	
	

}
