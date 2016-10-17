package fr.creasport.webgestionstock.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import fr.creasport.webgestionstock.metier.*;
import fr.creasport.webgestionstock.dao.*;

/**
 * Servlet implementation class WSAaddClubServlet
 */
public class WSAaddClubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WSAaddClubServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doWork(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doWork(request, response);
	}

	private void doWork(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

		Destinataire dest = new Destinataire();
		Gson gson = new Gson();

		dest.setDe_ref(request.getParameter("ref"));
		dest.setDe_nomClub(request.getParameter("nom"));
		dest.setDe_nomContact(request.getParameter("nomContact"));
		dest.setDe_adresse1(request.getParameter("adr1"));
		dest.setDe_adresse2(request.getParameter("adr2"));
		dest.setDe_codePostal(request.getParameter("cp"));
		dest.setDe_ville(request.getParameter("ville"));
		
		String temp = (request.getParameter("isClient"));
		
		if ( "O".equals(temp) )
			dest.setDe_IsClient(true);
		else
			dest.setDe_IsClient(false);
		dest.setDe_isActive(true);
		dest.setPa_id(Integer.parseInt(request.getParameter("idpays")));
		
		DestinataireDAO destDAO = new DestinataireDAO();

		destDAO.ajouter(dest);
		
		System.out.println(dest.toString());

		//		PrintWriter ecrire;
		
//		try {
//			// List list = PaysDAO.SelectAll();
//			// System.out.println(list);
//			ecrire = response.getWriter();
//			// ecrire.println(gson.toJson(list));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}
