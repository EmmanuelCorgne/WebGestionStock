package fr.creasport.webgestionstock.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/** 
 * Servlet implementation class WSAclubServlet
 */
public class WSAclubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WSAclubServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doWork(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doWork(request, response);
	}

	private void doWork(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("début de la procédure WSAclubServlet");
		String str;
		PrintWriter ecrire;

//		String str = (Util.jsonselect(morFilm));
		str = "{4label4:'FC Nantes',id:1},"
				+ "{label:'MSB','id':2},"
				+ "{'label':'Mancehester UN','id':3}"
				+ "]" ;
		Gson gson = new Gson();
		System.out.println(gson.toJson(str));
		ecrire = response.getWriter();
		ecrire.println(str);

	}

}
