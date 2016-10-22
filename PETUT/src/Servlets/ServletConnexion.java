package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Forms.FormConnexion;
import SQL.SQLConnexion;

public class ServletConnexion extends HttpServlet{

	private String VUE = "/WEB-INF/jsp/connexion.jsp";

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );//envoie la requete et la reponse au JSP specifier en url
		
	}
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
      
    	
    	FormConnexion form = new FormConnexion();
    	try {
			int idEleve = form.connexionUtilisateur(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        /*try {
			int id = form.connexionUtilisateur(request);
			HttpSession session = request.getSession();
			SQLConnexion sql = new SQLConnexion();
        	session.setAttribute("idUtilisateur", sql.recupererIdUtilisateur(request.getParameter("connexionEmail")) );
        	response.sendRedirect( "/LesPetitsChefs");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			request.setAttribute( "traitement", form );
			this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
		}*/
	}
	
	
}
