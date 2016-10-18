package fr.creasport.webgestionstock.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.creasport.webgestionstock.bean.ArticleBean;
import fr.creasport.webgestionstock.bean.ArticleStockBean;
import fr.creasport.webgestionstock.metier.Article;
import fr.creasport.webgestionstock.metier.StockArticle;

/**
 * Servlet implementation class WSATailleArticleServlet
 */
public class WSATailleArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WSATailleArticleServlet() {
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
		ArticleStockBean artStockBean=new ArticleStockBean();
		StockArticle artStockMetier= new StockArticle();
		artStockBean.setReference(request.getParameter("reference"));
		artStockBean.setArticle(Integer.parseInt(request.getParameter("artID")));
		artStockBean.setIsActive(true);
		artStockBean.setTaille(Integer.parseInt(request.getParameter("tailleID")));
		
	}

}
