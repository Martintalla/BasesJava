package com.inetum.aplliSprinJpa.dao.interfaces;

import java.util.List;

import com.inetum.appliSpringJpa.entity.Compte;
import com.inetum.appliSpringJpa.entity.Employe;
import com.inetum.appliSpringJpa.entity.Operation;

public interface IDaoOperations {
	
	Operation insert(Operation operation);
	
	Operation findById(Long idOp);
	List<Operation> findAll();
	
	void update(Operation operation);
	void deleteById(Long idOp);
	
	

}
