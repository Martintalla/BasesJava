package fr.inetum.formation.projet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/converter")
public class ConverterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String tem = request.getParameter("celsuis");
//		
//		if (tem instanceof String) {
//			
//			response.sendRedirect("converter");
//		}
//		else 
//			System.out.println("temperature = "+tem*5./9. +32+"°F");
//		
		request.getRequestDispatcher("/WEB-INF/pages/converter.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String celsuis = req.getParameter("celsuis");
		
		try {
			double celsuisDouble = Double.parseDouble(celsuis);
			double Farenhiet = celsuisDouble*5./9. +32;
			req.setAttribute("resultat", Farenhiet);
			doGet(req, resp); // ça se repète on peut faire mieux
		} catch (Exception e) {
			req.setAttribute("erreur", "Attention à votre saisir");
			
			doGet(req, resp);
		}
		
	}
}
