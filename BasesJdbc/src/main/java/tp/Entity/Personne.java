package tp.Entity;

public class Personne {
	public enum Nationalite {FRANCAIS, ANGLAIS, ALLEMAND, ESPAGNOL, INDIEN}
	private Integer id;
	private  String nom;
	private String prenom;
	private Nationalite nationalite;
   // private String nationalite; // V1 String V2 avec enum
                               //get et set
	//constructeurs
	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Personne(Integer id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.nationalite = Nationalite.ALLEMAND;
	}
	
	
	//getters et setters
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
	public Nationalite getNationalite() {
		return nationalite;
	}
	public void setNationalite(Nationalite nationalite) {
		this.nationalite = nationalite;
	}
	
	

	//fonction toString
	
	
	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	
	

}
