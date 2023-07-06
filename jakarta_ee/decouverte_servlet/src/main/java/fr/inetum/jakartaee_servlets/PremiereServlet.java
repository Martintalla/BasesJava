package fr.inetum.jakartaee_servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PremiereServlet extends HttpServlet{
	private static final long serialVersionUID=1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Taitement des requêtes get
		System.out.println("Je suis dans la méthode doget");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Ttraitement des requêtes
		System.out.println("Je suis dans la méthode dopost");
	}

}
