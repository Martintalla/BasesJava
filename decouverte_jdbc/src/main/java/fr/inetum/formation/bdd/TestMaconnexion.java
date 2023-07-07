package fr.inetum.formation.bdd;

import java.sql.Connection;
import java.sql.SQLException;

public class TestMaconnexion {

	public static void main(String[] args) {
		try (Connection connection = MaConnexion.getInstance().getConnection()){
			System.out.println("TEST Maconnexion ok");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
