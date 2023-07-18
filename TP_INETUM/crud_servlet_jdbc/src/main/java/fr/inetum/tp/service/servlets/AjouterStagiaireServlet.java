package fr.inetum.tp.service.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import fr.inetum.tp.entity.Stagiaire;
import fr.inetum.tp.services.dao.IStagiaireService;
import fr.inetum.tp.services.dao.impl.StagiaireService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ajouter")
public class AjouterStagiaireServlet extends HttpServlet {

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

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/ajouter.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String prenom = req.getParameter("prenom");
		String email = req.getParameter("email");
		String mdp = req.getParameter("mdp");
		LocalDate ddn = LocalDate.parse(req.getParameter("ddn"));

		Stagiaire stagiaire = new Stagiaire(null, prenom, email, ddn, mdp, mdp, null);
		try {
			service.addStagiaire(stagiaire);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		resp.sendRedirect("liste");
	}
}
