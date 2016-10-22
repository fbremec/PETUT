package Servlets;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

public class ServletIndex extends HttpServlet{
	
	private String VUE = "/WEB-INF/jsp/index.jsp";

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );//envoie la requete et la reponse au JSP specifier en url
		
	}
}