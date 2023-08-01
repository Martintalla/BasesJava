package com.inetum.aplliSprinJpa.dao.interfaces;

import java.util.List;

//E = tpe d'entité persistante (client ou compte)
//PK= type de clef primaire (Long ou Integer ou String)
public interface IDaoGeneic<E,PK> {
	 E findById(PK id);
     List<E> findAll();
     E insert(E e); //en retour client avec numero auto_incrémenté
     void update(E c);
     void deleteById(PK num);

}
