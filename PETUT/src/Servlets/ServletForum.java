package Servlets;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;


public class ServletForum extends HttpServlet{

	private String VUE = "/WEB-INF/jsp/eleve/forum.jsp";

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );//envoie la requete et la reponse au JSP specifier en url
		
	}
	 public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		 String idModule = request.getParameter("idModule");
		 String idForum = request.getParameter("idForum");
		 ObjectMapper mapper = new ObjectMapper();
		 User user = new User();
		 user = this.createDummyUser();
		 //Object to JSON in String
		 String jsonInString = mapper.writeValueAsString(user);
		 response.setContentType("application/json");
		 response.setCharacterEncoding("UTF-8");
		 response.getWriter().write(jsonInString);
		
	 }
	 private  User createDummyUser(){

			User user = new User();

			user.setName("mkyong");
			user.setAge(33);

			List<String> msg = new ArrayList<>();
			msg.add("hello jackson 1");
			msg.add("hello jackson 2");
			msg.add("hello jackson 3");

			user.setMessages(msg);

			return user;

	}
	 public class User {

			private String name;
			private int age;
			private List<String> messages;
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public int getAge() {
				return age;
			}
			public void setAge(int age) {
				this.age = age;
			}
			public List<String> getMessages() {
				return messages;
			}
			public void setMessages(List<String> messages) {
				this.messages = messages;
			}	
	 }
	 
}
