package fr.creasport.webgestionstock.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import fr.creasport.webgestionstock.bean.ExpedierStockBean;
import fr.creasport.webgestionstock.dao.ArticleDAO;
import fr.creasport.webgestionstock.dao.ModeleDAO;
import fr.creasport.webgestionstock.dao.OutilDao;
import fr.creasport.webgestionstock.dao.StockArticleDAO;
import fr.creasport.webgestionstock.dao.TailleDAO;
import fr.creasport.webgestionstock.dao.TypeExpeditionDAO;
import fr.creasport.webgestionstock.metier.Article;
import fr.creasport.webgestionstock.metier.StockArticle;
import fr.creasport.webgestionstock.metier.TypeExpedition;

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
		TypeExpeditionDAO typeExpeditionDAO = new TypeExpeditionDAO();
		try {
			List<TypeExpedition> list = typeExpeditionDAO.SelectAll();
		//	System.out.println(list.get(1).getTe_idString());
			request.setAttribute("listoption",list);
			request.getRequestDispatcher("ExpedierLot.jsp").forward(request, response);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//request.setAttribute("bean",bean);

		
		
	}

}
