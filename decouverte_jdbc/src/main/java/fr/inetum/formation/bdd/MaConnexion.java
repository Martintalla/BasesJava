package fr.inetum.formation.bdd;

import java.sql.Connection;
import java.sql.SQLException;

public class MaConnexion {
	
	private static MaConnexion instance;
	private Connection connection;
	
	private MaConnexion() throws ClassNotFoundException, SQLException  {
		SimpleDateSource.init("dbParams");
		connection = SimpleDateSource.getConnection();
	}
	
	public static synchronized MaConnexion getInstance() throws ClassNotFoundException, SQLException {
		if (instance ==null) {
			instance = new MaConnexion();
			
		}
		return instance;
	}
	
	public Connection getConnection() {
		return connection;
	}
 
}
