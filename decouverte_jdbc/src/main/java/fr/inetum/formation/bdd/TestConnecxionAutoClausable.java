package fr.inetum.formation.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnecxionAutoClausable {
	final static String DRIVER ="com.mysql.cj.jdbc.Driver";
	final static String URL = "jdbc:mysql://localhost:3306/inetum_db";
	final static String  USER ="root";
	final static String PASSWORD = "";

	public static void main(String[] args) {
		try {
			Class.forName(DRIVER);
			System.out.println("DRIVER OK");
			
			try (Connection connection=DriverManager.getConnection(URL, USER, PASSWORD)){
				System.out.println("CONNEXION Ok");
			} catch (SQLException e) {
				System.out.println("CONNEXION KO");
			}
			
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("DRIVER NOK");
		}
	}

}
