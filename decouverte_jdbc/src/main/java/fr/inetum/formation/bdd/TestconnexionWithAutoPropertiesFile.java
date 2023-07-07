package fr.inetum.formation.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TestconnexionWithAutoPropertiesFile {
	static String driver;
	static String url;
	static String  username;
	static String password;

	public static void main(String[] args) {
		//CHARGEMENT DU FICHIER DE PROPRIETES
		ResourceBundle props = ResourceBundle.getBundle("dbParams");
		//RECUPERATION DE LA VALEUR DES LA CLES DU FICHIER PROPERTIES
		driver = props.getString("mysql.driver");
		url = props.getString("mysql.url");
		username = props.getString("mysql.username");
		password = props.getString("mysql.password");
		//System.out.println(driver);
		
		try {
			Class.forName(driver);
			System.out.println("DRIVER OK");
		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER NOK");	
			try(Connection connection = DriverManager.getConnection(url, username, password)){
				System.out.println("CONNEXION OK");			
			} catch (SQLException e1) {
				System.out.println("CONNEXION OK");
			}
			System.out.println("DRIVER NOK");
		}

	}

}
