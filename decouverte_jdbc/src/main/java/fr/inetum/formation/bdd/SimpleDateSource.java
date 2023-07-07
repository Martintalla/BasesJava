package fr.inetum.formation.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * 
 * @author Martin TALLA
 *
 */

public class SimpleDateSource {
	static String driver;
	static String url;
	static String  username;
	static String password;
	
	public static void init(String nomduFichier) throws  ClassNotFoundException{
		//CHARGEMENT DU FICHIER DE PROPRIETES
				ResourceBundle props = ResourceBundle.getBundle("nomduFichier");
				//RECUPERATION DE LA VALEUR DES LA CLES DU FICHIER PROPERTIES
				driver = props.getString("mysql.driver");
				Class.forName(driver);
				
				url = props.getString("mysql.url");
				username = props.getString("mysql.username");
				password = props.getString("mysql.password");
			}
	
	public static  Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, username, password);
		
	}

}
