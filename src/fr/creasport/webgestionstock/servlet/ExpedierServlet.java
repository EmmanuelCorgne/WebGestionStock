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
		StockArticleDAO dbStockArticle = new StockArticleDAO();
		TailleDAO dbTaille = new TailleDAO();
		ModeleDAO dbModele = new ModeleDAO();
		ArticleDAO dbArticle = new ArticleDAO();
		StockArticle stockArticle = new StockArticle();
		Article article = new Article();
		ExpedierStockBean bean = new ExpedierStockBean();
		try {
			
			stockArticle=dbStockArticle.selectParRef("CUICYELIT0510160002-S");
			// on recupere le nom de la taille et on le place dans bean
			bean.setTa_nom(dbTaille.selectNom(stockArticle.getTa_id()));
			// on recupere l'id de article pour aller chercher id de modele
			article=dbArticle.Select(stockArticle.getAr_id()); 
			// on recupere le nom du modele et on le place dans bean
			bean.setMo_nom(dbModele.selectNom(article.getMo_id()));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("a"+(bean.getMo_nom()));
		System.out.println(("b"+(bean.getSa_ref())));
		System.out.println(("c"+(bean.getSa_ref())));
		request.setAttribute("bean",bean);
		request.getRequestDispatcher("ExpedierLot.jsp").forward(request, response);
		
		
	}

}
