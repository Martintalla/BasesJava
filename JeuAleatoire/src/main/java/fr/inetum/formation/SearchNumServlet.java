package fr.inetum.formation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/search")
public class SearchNumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/pages/search.jsp").forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		double rand_num = Math.random()*9;
		
		String  userRandomNum =request.getParameter("userRandomNum");
		Integer  attemps = 0;
		request.setAttribute("tentatives",attemps );
		if (attemps <= 3) {
			
			if (Double.parseDouble(userRandomNum)== rand_num ) {
				//request.setAttribute("attemps",attemps );
				request.setAttribute("resultat","Bravo! vous avez gagné" );		
			}
			
			else
				response.sendRedirect("search");
				System.out.println("perdu");
			    request.setAttribute("attemps",attemps );
			    attemps =  attemps +1;	
			    request.setAttribute("resultat","Non ce n'est pas le bon chiffre, refaites un essai" );
		}
		else
			  
			 response.sendRedirect("history");
			 request.setAttribute("attemps",attemps );
		 	
		
		//doGet(request, response);
	}

}
