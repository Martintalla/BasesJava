package com.inetum.appliSpringJpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
//bientôt import jakarta.persistence.Entity;

@Entity
@NamedQuery(name="Employe.findByPrenom", query ="SELECT e FROM Employe e WHERE e.prenom=?1")
public class Employe {
	
	//Attributs de la classe
	
	//@iD : id / primary key
	//@GenerattedValue : pour que la valeur auto incrementée par la base
	//remonte bien en mémoire dans l'objet java lors du entityManager.persist)
	//.numero null puis plus null
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	//private Integer numero;
    private Long numero;
//	private int numero;
	private String nom;
	@Column(name="prenom", length = 64)
	private String prenom;
	private String email;
	
	
	//Contructeur 
	
	
	public Employe(Long numero, String prenom, String nom) {
		super();
		this.numero = numero;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}





	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}





	public Long getNumero() {
		return numero;
	}





	public void setNumero(Long numero) {
		this.numero = numero;
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





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	@Override
	public String toString() {
		return "Employe [numero=" + numero + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	


}
