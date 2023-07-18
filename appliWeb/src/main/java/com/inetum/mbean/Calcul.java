package com.inetum.mbean;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Calcul {
	
	private Double x;
	private Double res;//resultat de la racine carrée
	
	public String calculerRacineCarree() {
		String suite = null;//
		this.res =Math.sqrt(this.x);
		return suite;
		
	}
//	
//	public Calcul(Double x, Double res) {
//		super();
//		this.x = x;
//		this.res = res;
//	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getRes() {
		return res;
	}

	public void setRes(Double res) {
		this.res = res;
	} 
	
	

}
