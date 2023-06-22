package tp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import tp.Entity.Personne;
import tp.dao.PersonneDAO;
import tp.dao.PersonneDAOSimu;
import tp.dao.PersonneDaoJdbc;

public class MyApp {

	public static void main(String[] args) {
		//testCrud();
		//test_etablirConnectionJdbc();
		//testCrudJdbc();
		//testEnum();
		 testDate();

	}
public static void testDate() {
	Date date = new Date(); 
	//System.out.println("data (aujourd'hui)=" + date);
	
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
	String sdate = simpleDateFormat.format(new Date());
	String sdate2 = simpleDateFormat2.format(new Date());
	System.out.println("Nous sommes le " + sdate+" ou bien le "+sdate2);
}	
	

public static void testEnum() {
	Personne p1 = new Personne(null, "Alex", "Joueur");
	//V1 (de type string) on ne controle pas trop les valeurs possibles
	//p1.setNationalite("francais"); //ou bien "Francaise"
	
	//V2 (de type enum)
	//p1.setNationalite(Personne.Nationalite.FRANCAIS);
	p1.setNationalite(Personne.Nationalite.INDIEN);
	//System.out.println("nationalite par défaut "+);
	System.out.println("nationalite de p1 "+p1.getNationalite());
}	
	
public static void test_etablirConnectionJdbc() {
	PersonneDaoJdbc personneDaoJdbc = new PersonneDaoJdbc();
	System.out.println("etablir connection"+personneDaoJdbc.etablirConnexion());
}

public static void testCrudJdbc() {
	//créer quelques personnes
	PersonneDAO personneDAO =new PersonneDaoJdbc();
	
	Personne p1 = new Personne(null, "alain", "Maux"); //id encore inconnu
	Personne savedP1 = personneDAO.createPersonne(p1); //on demande à sauvegarer l'objet en base
	System.out.println("SavedP1=" +savedP1.toString());
	
	
	//recherche liste personnes pour vérifier:
			List<Personne> personnes = personneDAO. rechercherToutesPersonne();
			System.out.println("personnes:");
			for(Personne p : personnes) {
				System.out.println(("\t" + p));
			}
}

public static void testCrud() {
	//créer quelques personnes
	PersonneDAO personneDAO =new PersonneDAOSimu();
	
	Personne p1 = new Personne(null, "jean", "Bon"); //id encore inconnu
	Personne savedP1 = personneDAO.createPersonne(p1); //on demande à sauvegarer l'objet en base
	System.out.println("SavedP1=" +savedP1.toString());
	
	
	Personne p2 = personneDAO.createPersonne(new Personne(null, "Pierre", "Marc"));
	System.out.println("savedP2"+p2.toString());
	
	//chagement des valeurs p2 en mémoire
	p2.setPrenom("Sandrine");
	
	//Enregistrement des changement en base de données
	personneDAO.updatePersonne(p2);
	
	//Recherche des enregistrements modifiés pour vérifier :
	Personne p2MisAJour = personneDAO.rechercherPersonneParId(p2.getId());
	System.out.println("p2MisAJour"+p2MisAJour.toString());
	
	//Rechercher es enregistements mdofiées pour vérifier:
	
	//supprimer p2 dans la base de données:
			personneDAO.deletePersonne(p2.getId());
			
	//recherche personnes restantes pour vérifier:
	List<Personne> personnes = personneDAO.rechercherToutesPersonne();
	System.out.println("personnes:");
			for(Personne p : personnes) {
				System.out.println(("\t" + p));
			}
}
}
