package com.inetum.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CalculServlet")
public class CalculServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String sX = request.getParameter("x");
		PrintWriter out = response.getWriter();
		Double x = sX!=null?Double.parseDouble(sX):0;
		Double y = Math.sqrt(x);
		out.println("<html>");
		out.println("<body>");
		out.println("<form method='GET' action=''>");
		out.println("x=<input type = 'text' name= 'x' value ='"+x+"' />");
		out.println("x=<input type = 'submit' value='calculer la racine carree' />");
		
		out.println("</form>");
		out.println("<hr/>");
		out.println("y"+y);
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
