package com.inetum.appliSpringJpa.dao;

import java.util.List;

import com.inetum.appliSpringJpa.entity.Compte;

public interface DaoCompte {
	
	List<Compte> findBySoldeMini(double soldeMini);
	List<Compte> findBySoldeMaxi(double soldeMaxi);
	
	

}
