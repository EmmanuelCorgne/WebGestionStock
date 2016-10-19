package fr.creasport.webgestionstock.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import fr.creasport.webgestionstock.dao.LotArticleDAO;

/**
 * Servlet implementation class SaisirDateLotArticleServlet
 */
public class SaisirDateLotArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaisirDateLotArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doWOrk(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doWOrk(request, response);
	}

	private void doWOrk(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		LotArticleDAO lotArticleDAO = new LotArticleDAO();
		int ea_id = Integer.parseInt(request.getParameter("ea_id"));
		int sa_id = Integer.parseInt(request.getParameter("sa_id"));
		lotArticleDAO.ReceptionDateDuJour(ea_id,sa_id);

		try {
			PrintWriter ecrire;
			ecrire = response.getWriter();
			ecrire.println("Date du jour dans la table");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
