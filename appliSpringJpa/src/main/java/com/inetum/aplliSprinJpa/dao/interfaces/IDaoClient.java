package com.inetum.aplliSprinJpa.dao.interfaces;

import java.util.List;

import com.inetum.appliSpringJpa.entity.Client;



public interface IDaoClient {
	 Client findById(Long numero);
     Client findClientWithComptesById(Long numero);
     List<Client> findAll();
     Client insert(Client c); //en retour client avec numero auto_incrémenté
     void update(Client c);
     void deleteById(Long num);
}
