package fr.inetum.tp.service.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import fr.inetum.tp.entity.Stagiaire;
import fr.inetum.tp.services.dao.IStagiaireService;
import fr.inetum.tp.services.dao.impl.StagiaireService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/liste_user")
public class ListeStagiaireServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IStagiaireService service;

	@Override
	public void init() throws ServletException {
		try {
			service = new StagiaireService();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println("c'est bien ça?");

		try {
			//if (id != null && Integer.parseInt(id) != 0) {
				//service.removeStagiaire(Integer.parseInt(id));
			//}			
			List<Stagiaire> stagiaires = new ArrayList<>();
			System.out.println(stagiaires+"c'est bien ça2?");
			stagiaires = service.allStagiaires();
			System.out.println(stagiaires+"c'est bien ça2?");
			request.setAttribute("stagiaires", stagiaires);
		} catch (ClassNotFoundException | SQLException e) {
			List<String> erreurs = new ArrayList<>();
			
			if(e instanceof ClassNotFoundException) {
				erreurs.add("Attention, les drivers de la BDD sont introuvables");
			}
			
			if(e instanceof CommunicationsException) {
				erreurs.add("Le serveur de BDD semble à l'arrêt");
			}
			request.setAttribute("erreurs", erreurs);
		}
		request.getRequestDispatcher("/WEB-INF/jspFiles/liste_user.jsp").forward(request, response);
	}
}