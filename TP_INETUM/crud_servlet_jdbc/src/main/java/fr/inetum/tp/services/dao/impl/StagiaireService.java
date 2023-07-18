package fr.inetum.tp.services.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.inetum.formation.jdbc.utils.MaConnexion;
import fr.inetum.tp.entity.Adresse;
import fr.inetum.tp.entity.Stagiaire;
import fr.inetum.tp.services.dao.IStagiaireService;
import fr.inetum.tp.services.utils.AppUtil;

public class StagiaireService implements IStagiaireService{

	private Connection connection;
	
	public StagiaireService(Connection connection) {
		this.connection = connection;
	}

	public StagiaireService() throws ClassNotFoundException, SQLException {
		connection = MaConnexion.getInstance().getConnection();
	}

	@Override
	public List<Stagiaire> allStagiaires() throws ClassNotFoundException, SQLException {
		List<Stagiaire> stagiaires = new ArrayList<>();
		
		String requete = "SELECT * FROM Stagiare";
		Connection connection = MaConnexion.getInstance().getConnection();
		PreparedStatement stmt = connection.prepareStatement(requete);
		ResultSet rs = stmt.executeQuery();
		System.out.println("c'est le début de ma méthode");
		while(rs.next()) {
			int id = rs.getInt("id");
			String prenom = rs.getString("prenom");
			String email = rs.getString("email");
			String mdp = rs.getString("mdp");
			LocalDate ddn = rs.getDate("ddn").toLocalDate();
			String role = rs.getString("role");
			int adresseId = rs.getInt("adresseId");
			System.out.println("c'est le début de ma méthode");	
			Stagiaire stagiaire = new Stagiaire(id, prenom, email, ddn, mdp, role, adresseId);
			stagiaires.add(stagiaire);
		}
		return stagiaires;
	}
	
	
	@Override
	public List<Stagiaire> allStagiaires(Adresse adresse) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public void removeStagiaire(Stagiaire stagiaire) throws ClassNotFoundException, SQLException {
		String requete = "DELETE FROM Stagiaire WHERE id = ?";
		//Connection connection = MaConnexion.getInstance().getConnection();
		PreparedStatement stmt = connection.prepareStatement(requete);
		
		//stmt.setInt(1, id);
		//stmt.executeUpdate();
	}

	
	@Override
	public void addStagiaire(Stagiaire stagiaire) throws ClassNotFoundException, SQLException {
		String requete = "INSERT INTO Stagiaire(prenom, email, mdp, ddn) VALUES (?, ?, ?, ?)";
		//Connection connection = MaConnexion.getInstance().getConnection();
		PreparedStatement stmt = connection.prepareStatement(requete);
		
		stmt.setString(1, AppUtil.capitalize(stagiaire.getPrenom()));
		stmt.setString(2, stagiaire.getEmail().toLowerCase());
		stmt.setString(3, AppUtil.hashPassword(stagiaire.getMdp()));
		stmt.setDate(4, Date.valueOf(stagiaire.getDdn()));
		
		stmt.executeUpdate();
	}
	

	@Override
	public Stagiaire getStagiaire(String login, String mdp) throws ClassNotFoundException, SQLException {
		

	        return null;
	}

	@Override
	public Stagiaire getStagiaire(Integer id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
