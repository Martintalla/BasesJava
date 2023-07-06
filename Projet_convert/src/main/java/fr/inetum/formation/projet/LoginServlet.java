package fr.inetum.formation.projet;

import java.io.IOException;

import fr.inetum.formation.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//A LA FIN, ON PASS LA MAIN A LA JSP
				request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String mdp = request.getParameter("mdp");
		
		if (email.equalsIgnoreCase("stagiaire@inetum.fr")&& mdp.equals("1234")) {
			//request.getRequestDispatcher("/WEB-INF/pages/converter.jsp").forward(request, response);
			response.sendRedirect("converter");
			//User user =new User(email, mdp);
			//request.getSession().getAttribute
			//
		}
		else response.sendRedirect("login");
	}
	

}
