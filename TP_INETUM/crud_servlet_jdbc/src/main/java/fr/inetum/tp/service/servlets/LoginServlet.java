package fr.inetum.tp.service.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.inetum.formation.jdbc.utils.MaConnexion;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//A LA FIN, ON PASS LA MAIN A LA JSP
				request.getRequestDispatcher("/WEB-INF/jspFiles/login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requete = "SELECT COUNT(*) FROM Stagiaire WHERE login = ? AND mdp = ?";
		Connection connection = null;
		try {
			connection = MaConnexion.getInstance().getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(requete);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String email = request.getParameter("email");
		String mdp = request.getParameter("mdp");
		
		// Récupérer le résultat
        try {
			rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        int count = 0;
		try {
			count = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Vérifier si le login et le mot de passe existent
        if (count > 0) {
            System.out.println("Le login et le mot de passe existent en base de données.");
        } else {
            System.out.println("Le login et le mot de passe n'existent pas en base de données.");
        }
	}	
		
	}		
	


