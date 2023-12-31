package com.inetum.aplliSprinJpa.dao.interfaces;

import java.util.List;

import com.inetum.appliSpringJpa.entity.Employe;


/**
 * DAO = Data Acess Object
 * Avec la méthod CRUD
 */

public interface IDaoEmploye {
	Employe findById(Long numero);
	List<Employe> findAll();
	List<Employe> findByPrenom(String prenom);
	
	Employe insert( Employe emp);// en retour employe avec numéro auto incrémenté
	
	void update(Employe emp);
	void deleteById(Long num);
	
	
 
}
