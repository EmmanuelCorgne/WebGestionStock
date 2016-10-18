package fr.creasport.webgestionstock.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.creasport.webgestionstock.dao.LotArticleDAO;
import fr.creasport.webgestionstock.metier.LotArticle;

/**
 * Servlet implementation class SaisirLotArticleServlet
 */
public class SaisirLotArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaisirLotArticleServlet() {
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

	private void doWork(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		LotArticle lA= new LotArticle();
	
		LotArticleDAO lADAO = new LotArticleDAO();
		String a = request.getParameter("id");
		String b = a.replace("%0D%0A","") ;
		int c = Integer.parseInt(b);
		lA.setEa_id(c);
		lA.setSa_id(Integer.parseInt(request.getParameter("sa_id")));
		lADAO.ajouter(lA);

	}

}
