package com.inetum.mbean;

import org.apache.myfaces.context.FacesContextFactoryImpl;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import jakarta.faces.context.FacesContext;
@ManagedBean
@SessionScoped

public class User {
	
	private String username;
	private String password;
	private Boolean isConnected = false;
	
	public String login() {
		String suite = null;
		if(this.username != null && this.password !=null
			&&this.password.equals("pwd"+this.username)){
				//
			this.isConnected = true;
			suite ="user"; //pour demander au nivagateur d'aller vers la page user.xhtml/jsp/jsl
			}else {
				FacesContext.getCurrentInstance().addMessage(null, 
						new FacesMessage("login fail", "wrong password"));
			}
		return suite;
			}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsConnected() {
		return isConnected;
	}

	public void setIsConnected(Boolean isConnected) {
		this.isConnected = isConnected;
	}

}
