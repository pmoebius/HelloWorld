package com.anderscore.tutorial;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String DELETE_JSP = "/Delete.jsp";
	private static String EDIT_JSP = "/Edit.jsp";
	private static String SHOWALL_JSP = "/ShowAll.jsp";
	private static List<String> msg = new ArrayList<String>();
	public static String myString = "justAtest";

	public Controller() {
		msg.add("Hallo");
		msg.add("Welt");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("ich bin aufgerufen wurden");
//		msg.add(0,new Date().toString());
		PrintWriter out = response.getWriter();
		out.println("<ul>");
		for(String message : msg){
			out.println("<li>" + message + "</li>");
//			response.getWriter().println(message + "<br/>");
		}
		out.println("</ul>");
		/*request.setAttribute("myString", myString);
		request.setAttribute("msg", msg);
		String forward="";
		// Get a map of the request parameters
		@SuppressWarnings("unchecked")
		Map parameters = request.getParameterMap();
		if (parameters.containsKey("delete")){
			forward = DELETE_JSP;
		} else if (parameters.containsKey("edit")){
			forward = EDIT_JSP;
		} else if(parameters.containsKey("Absenden")) {
			msg.add(request.getParameter("user_eingabe"));
			System.out.println(msg);
			forward = SHOWALL_JSP;
		} else {
			
			//forward = SHOWALL_JSP;
		}*/
		//RequestDispatcher view = request.getRequestDispatcher(forward);
		//view.forward(request, response);
	}



	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println("Ich bin der Server, ich habe einen Request bekommen");
		Runtime.getRuntime().exec("eject");
		msg.add(0,req.getParameter("text"));
	}
}
