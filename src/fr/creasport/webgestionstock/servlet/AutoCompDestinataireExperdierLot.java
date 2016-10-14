package fr.creasport.webgestionstock.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import fr.creasport.webgestionstock.dao.DestinataireDAO;
import fr.creasport.webgestionstock.metier.Destinataire;

/**
 * Servlet implementation class AutoCompDestinataireExperdierLot
 */
public class AutoCompDestinataireExperdierLot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoCompDestinataireExperdierLot() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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

	private void doWork(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		DestinataireDAO destDAO = new DestinataireDAO();
		String morceauDestinataire = request.getParameter("valeur");

		PrintWriter ecrire;
		try {
			List<Destinataire> list = destDAO.findDestinataire(morceauDestinataire);
			//System.out.println(list);  
			Gson gson = new Gson();
			ecrire = response.getWriter();
			ecrire.println(gson.toJson(list));
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
