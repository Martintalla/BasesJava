package com.inetum.appliSpringWeb.init;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inetum.appliSpringWeb.doa.interfaces.IDaoCompte;
import com.inetum.appliSpringWeb.entity.Compte;

/**
 * classe utilitaire qui initialise un jeu de données au démarrage de l'applicaion
 * uile si developpement en mode -auto=create-drop
 */

@Component

public class InitDataSet {
	
	@Autowired
	private IDaoCompte daoCompteJpa;
	
	@PostConstruct
	public void initData() {
		daoCompteJpa.insert(new Compte(null,"compte_1" , 50.0));
    	daoCompteJpa.insert(new Compte(null,"compte_2" , 80.0));
    	daoCompteJpa.insert(new Compte(null,"compte_3" , 250.0));
    	daoCompteJpa.insert(new Compte(null,"compte_4" , 540.0));
    	daoCompteJpa.insert(new Compte(null,"compte_6" , 1000.0));
		
	}

}
