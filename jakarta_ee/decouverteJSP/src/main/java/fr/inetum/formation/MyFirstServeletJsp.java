package fr.inetum.formation;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/majspservlet")
public class MyFirstServeletJsp extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("méthode doget ");
		//ON FAIT ICI TOUS LES TRAITEMENTS QUE L'ON SOUHAITE (calcul, connexion aux bases de données)
		
		
		String prenom = request.getParameter("prenom");
		request.setAttribute("pre", prenom);
		
		String msg ="je suis un message qui provient de la servlet MyFirstSerletJsp";
		request.setAttribute("msg", msg);
		
		String age = request.getParameter("age");
		request.setAttribute("age", age);
		
		LocalDate date = LocalDate.now();
		request.setAttribute("date", date);
		
		
		LocalDateTime time = LocalDateTime.now();
		request.setAttribute("time", time);
		
		String ip = request.getRemoteAddr();
		request.setAttribute("ip", ip);
		
		
		//A LA FIN, ON PASS LA MAIN A LA JSP
		request.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String prenom = req.getParameter("prenom");
		String age = req.getParameter("age");
		System.out.println();
	}

}
