package tp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//PersonneDaoSimu = vresion simulée en mémoire sans réelle base de données

import tp.Entity.Personne;

public class PersonneDAOSimu implements PersonneDAO {
	private Map<Integer,Personne> mapIdPersonnes = new HashMap<>();
	private Integer idMAx=0;

	@Override
	public Personne createPersonne(Personne p) {
		p.setId(++idMAx);
		mapIdPersonnes.put(p.getId(),p);
		// TODO Auto-generated method stub
		return p;
	}

	@Override
	public Personne rechercherPersonneParId(Integer idPers) {
		// TODO Auto-generated method stub
		return mapIdPersonnes.get(idPers);
	}

	@Override
	public List<Personne> rechercherToutesPersonne() {
		return new ArrayList<Personne> (mapIdPersonnes.values());
	}

	@Override
	public void updatePersonne(Personne p) {
		mapIdPersonnes.put(p.getId(), p);

	}

	@Override
	public void deletePersonne(Integer idPers) {
        mapIdPersonnes.remove(idPers);
	}

}
