package com.inetum.appliSpringJpa.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.inetum.aplliSprinJpa.dao.interfaces.IDaoCompte;
import com.inetum.aplliSprinJpa.dao.interfaces.IDaoOperations;
import com.inetum.appliSpringJpa.entity.Compte;
import com.inetum.appliSpringJpa.entity.Operation;

@SpringBootTest // calsse interprétée par Junit et SpringBoot
public class TestOperationDao {
	Logger logger = LoggerFactory.getLogger(TestOperationDao.class);

	@Autowired // Pour initialisation daoCompte qui va référencer un composant spring existant
				// compatible
	private IDaoCompte daoCompteJpa;

	@Autowired
	private IDaoOperations daoOperationJpa;
	
	@Test
	public void testSensSecodaire() {
//		Compte compte1A = daoCompteJpa.insert(new Compte(null, "compte1", 2000.0));
//		compte1A.getOperations().add(new Operation(null, -500.1, "achat lit", new Date()));
//		compte1A.getOperations().add(new Operation(null, -500.1, "achat d'habits", new Date()));
//		
//		daoCompteJpa.update(compte1A);
		
	}

	@Test
	public void testCompteOperation() {

		Compte compte1 = daoCompteJpa.insert(new Compte(null, "compte1", 2000.0));
		Compte compte2 = daoCompteJpa.insert(new Compte(null, "compte2", 500.0));

		Operation op1Compte1 = daoOperationJpa.insert(new Operation(null, -500.1, "achat lit", new Date(), compte1));
		Operation op2Compte1 = daoOperationJpa.insert(new Operation(null, -50.1, "achat avocat", new Date(), compte1));

		Operation op1Compte2 = daoOperationJpa.insert(new Operation(null, -8.1, "achat biscuits", new Date(), compte2));
		Operation op2Compte2 = daoOperationJpa.insert(new Operation(null, -100.1, "achat jouets", new Date(), compte2));

		Operation op1Compte1Relu = daoOperationJpa.findById(op1Compte1.getIdOp());

		logger.trace("L'opération1 du compte 1 =" + op1Compte1Relu);

		assertEquals(-500.1, op1Compte1Relu.getMontant(), 0.00001);

		Compte compte1Relu = daoCompteJpa.findById(compte1.getNumero());
		logger.debug("liste des operations du compte 1");
		for (Operation operation : compte1Relu.getOperations()) {
			logger.debug("\t" + operation.toString());
		}

		Compte compteARelu = daoCompteJpa.findCompteWithOperationsById(compte1.getNumero());

		logger.debug("operations du compteA:");
		for (Operation op : compteARelu.getOperations()) {
			logger.debug("\t" + op.toString());
		}

	}

}
