package com.inetum.mbean;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped

public class CalculTva {
	
	private double ht;
	private double  taux_tva;
	private double tva;
	private double ttc;
	
	public String calculerTvaTtc() {
		String suite = null;
		this.tva = this.ht*taux_tva/100;
		this.ttc = this.tva + this.ht;
		return suite;
	}
	
	
	public double getHt() {
		return ht;
	}
	public void setHt(double ht) {
		this.ht = ht;
	}
	public double getTva() {
		return tva;
	}
	public void setTva(double tva) {
		this.tva = 20;
	}
	public double getTtc() {
		return ttc;
	}
	public void setTtc(double ttc) {
		this.ttc = ttc;
	}


	public double getTaux_tva() {
		return taux_tva;
	}


	public void setTaux_tva(double taux_tva) {
		this.taux_tva = taux_tva;
	}
	
	
	
	

}

