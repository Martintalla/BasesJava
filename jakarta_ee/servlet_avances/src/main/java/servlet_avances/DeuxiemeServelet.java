package servlet_avances;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deux")
public class DeuxiemeServelet extends HttpServlet{
	private static final long serialVersionUID = -71295487;
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("2 je suis dans la méthode dopost");
	
}

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("2 je suis dans la méthode doget");
	
	resp.setContentType("text/html; charset=UTF-8");
	PrintWriter out = resp.getWriter();
	
	try {
		//Ici on construit la réponse
		out.println("<!DOCTYPE html>");
		out.println("<html>"
		 + "<head>"
		 + "<meta charset=UTF-8>"
		 +"<title>Deuxieme Servlet</title>"
		 +"</head>"
		 +"<body>"
		 +"<h1> Ma deuxième servlet avancée </h1>"
		 + "</body>"
		 + "</html>");
	} catch (Exception e) {
		out.close();
	}

}

}


