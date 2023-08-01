package com.inetum.aplliSprinJpa.dao.interfaces;

import java.util.List;

import com.inetum.appliSpringJpa.entity.Compte;

public interface IDaoCompte {
	
	List<Compte> findBySoldeMini(double soldeMini);
	List<Compte> findBySoldeMaxi(double soldeMaxi);
	Compte insert(Compte compte);
	Compte findById(Long numero);
	Compte findCompteWithOperationsById(Long numero);
	void update(Compte compte);
	List<Compte> findComptesOfClient(Long numClient);
	
	

}
