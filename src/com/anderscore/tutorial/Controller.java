package com.anderscore.tutorial;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
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
	private static Vector<String> msg = new Vector<String>();
	public static String myString = "justAtest";


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("myString", myString);
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
			
			forward = SHOWALL_JSP;
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}



	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
