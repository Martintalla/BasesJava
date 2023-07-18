package fr.inetum.formation.crud.jdbc.servlets;

import java.io.IOException;
import java.sql.SQLException;

import fr.inetum.formation.crud.jdbc.dao.IStagiaireService;
import fr.inetum.formation.crud.jdbc.models.Stagiaire;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteStagiaireServlet
 */
@WebServlet("/delete")
public class DeleteStagiaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IStagiaireService service;
	
	@Override
		public void init() throws ServletException {
			Stagiaire stagiaire = new Stagiaire();
		}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/liste.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		try {
			if (Integer.parseInt(id) !=0) {
				service.deleteStagiaire(Integer.parseInt(id));				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("liste");
	}

}
