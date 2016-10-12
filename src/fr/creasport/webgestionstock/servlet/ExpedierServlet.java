package fr.creasport.webgestionstock.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.creasport.webgestionstock.bean.ExpedierStockBean;
import fr.creasport.webgestionstock.dao.ArticleDAO;
import fr.creasport.webgestionstock.dao.ModeleDAO;
import fr.creasport.webgestionstock.dao.OutilDao;
import fr.creasport.webgestionstock.dao.StockArticleDAO;
import fr.creasport.webgestionstock.dao.TailleDAO;
import fr.creasport.webgestionstock.metier.Article;
import fr.creasport.webgestionstock.metier.StockArticle;

/**
 * Servlet implementation class ExpedierServlet
 */
public class ExpedierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpedierServlet() {
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
		
		//request.setAttribute("bean",bean);
		request.getRequestDispatcher("ExpedierLot.jsp").forward(request, response);
		
		
	}

}