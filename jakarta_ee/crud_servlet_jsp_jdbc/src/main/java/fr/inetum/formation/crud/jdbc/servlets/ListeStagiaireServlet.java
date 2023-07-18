package fr.inetum.formation.crud.jdbc.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.inetum.formation.crud.jdbc.dao.IStagiaireService;
import fr.inetum.formation.crud.jdbc.dao.impl.StagiaireService;
import fr.inetum.formation.crud.jdbc.models.Stagiaire;

@WebServlet("/liste")
public class ListeStagiaireServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private IStagiaireService service; 
	
	@Override
	public void init() throws ServletException {
		service = new StagiaireService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Stagiaire> stagiaires = new ArrayList<>();
		try {
			stagiaires = service.allStagiaires();
			request.setAttribute("stagiaires", stagiaires);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/jsp/liste.jsp").forward(request, response);
	}
}