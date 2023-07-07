package fr.inetum.formation.bdd;

import java.sql.Connection;
import java.sql.SQLException;

public class TestSimpleDateSource {

	public static void main(String[] args) {
		try {
			SimpleDateSource.init("dbParams");
			System.out.println("DRIVER OK");
			
			try(Connection connection = SimpleDateSource.getConnection()){
				System.out.println("CONNEXION OK");
				
			} catch (SQLException e) {
				System.out.println("CONNEXION NOK");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER NOK");
		}
	}

}
