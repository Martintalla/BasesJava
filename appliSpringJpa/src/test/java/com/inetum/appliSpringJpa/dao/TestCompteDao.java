package com.inetum.appliSpringJpa.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.inetum.aplliSprinJpa.dao.interfaces.IDaoCompte;
import com.inetum.appliSpringJpa.entity.Compte;




@SpringBootTest //calsse interprétée par Junit et SpringBoot
public class TestCompteDao {
	Logger logger  = LoggerFactory.getLogger(TestCompteDao.class);
	
	@Autowired //Pour initialisation daoCompte qui va référencer un composant spring existant compatible 
	private  IDaoCompte doaCompteJpa;
	
	@Test
	public void testQueries() {
		
		doaCompteJpa.insert(new Compte(null,"compte1" , 2000.0));
		doaCompteJpa.insert(new Compte(null,"compte2" , 500.0));
		doaCompteJpa.insert(new Compte(null,"compte3" , 50.));
		doaCompteJpa.insert(new Compte(null,"compte4" , 200.));
		
		List<Compte> compteAvecSoldeMini500 = doaCompteJpa.findBySoldeMini(500);
		
		assertTrue(compteAvecSoldeMini500.size() >=2);
		
		for (Compte comp :compteAvecSoldeMini500)
		logger.trace("Les empoyees ayant un compte mininal de ="+comp);
		
	}

}
