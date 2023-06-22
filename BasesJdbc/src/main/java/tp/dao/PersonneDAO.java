package tp.dao;

import java.util.List;

import tp.Entity.Personne;
//DAO = 

public interface PersonneDAO {
	public Personne createPersonne(Personne p);
	public Personne rechercherPersonneParId(Integer idPers); // en retour, lapersonne avec id auto_incrementée par la base de donnnée
	public List<Personne> rechercherToutesPersonne();
	public void updatePersonne(Personne p);
	public void deletePersonne(Integer idPers);

}
