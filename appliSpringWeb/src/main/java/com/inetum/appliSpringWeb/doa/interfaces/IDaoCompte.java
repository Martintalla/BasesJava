package com.inetum.appliSpringWeb.doa.interfaces;

import java.util.List;

import com.inetum.appliSpringWeb.entity.Compte;

/*
 * DAO = Data Access Object
 * avec méthode CRUD
 * et throws RuntimeException implicites
 */

public interface IDaoCompte extends IDaoGeneric<Compte,Long> {
     Compte findCompteWithOperationsById(Long numero);
     List<Compte> findComptesOfClient(Long numClient);
     List<Compte> findBySoldeMini(double soldeMini);
     List<Compte> findBySoldeMaxi(double soldeMaxi);
     //findAll() , deleteById() , ... héritées de DaoGeneric
}
