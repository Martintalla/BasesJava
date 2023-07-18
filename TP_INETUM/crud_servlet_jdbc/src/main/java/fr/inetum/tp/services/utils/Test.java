package fr.inetum.tp.services.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.inetum.formation.jdbc.utils.MaConnexion;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        String login = "martin@inetum.fr";
        String password = "1234";

        // Connexion à la base de données
       // Connection connection = MaConnexion.getInstance().getConnection();
		

        try {
        	 Connection connection = MaConnexion.getInstance().getConnection();

            // Préparer la requête
            String query = "SELECT COUNT(*) FROM Stagiare WHERE email = ? AND mdp = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, login);
            statement.setString(2, password);

            // Exécuter la requête
            ResultSet resultSet = statement.executeQuery();

            // Récupérer le résultat
            resultSet.next();
            int count = resultSet.getInt(1);

            // Vérifier si le login et le mot de passe existent
            if (count > 0) {
                System.out.println("Le login et le mot de passe existent en base de données.");
            } else {
                System.out.println("Le login et le mot de passe n'existent pas en base de données.");
            }

            // Fermer les ressources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
