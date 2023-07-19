package com.inetum.appliSpringJpa.entity;

import javax.persistence.Entity;

@Entity
public class Compte {
	
	private Long id;
	private String label;
	private Double solde;
	
	//Constructeurs
	
	public Compte() {
		super();
		
	}

	public Compte(Long id, String label, Double solde) {
		super();
		this.id = id;
		this.label = label;
		this.solde = solde;
	}

	
	//Getters et setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	@Override
	public String toString() {
		return "Compte [id=" + id + ", label=" + label + ", solde=" + solde + "]";
	}
	
	
	
	
	

}
