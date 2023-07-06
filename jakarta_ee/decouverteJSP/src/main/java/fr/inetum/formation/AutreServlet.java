package fr.inetum.formation;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/autre")
public class AutreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Le suis dans le doget de AutreServlet ").append(request.getContextPath());
	}

	
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String prenom = request.getParameter("prenom");
		String age = request.getParameter("age");
		
		request.setAttribute("prenom", prenom);
		request.setAttribute("age", age);
		//A LA FIN, ON PASS LA MAIN A LA JSP
		request.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(request, response);
		//response.sendRedirect("majspservlet");
		
//		response.getWriter()
//		.append("Le suis dans le dopost de AutreServlet ")
//		.append("\nMon prenom est " +prenom);
//		.append("\nMon age est " +age + "ans");
		
	}

}
