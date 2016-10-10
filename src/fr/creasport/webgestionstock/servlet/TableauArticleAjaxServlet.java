package fr.creasport.webgestionstock.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import fr.creasport.webgestionstock.bean.ExpedierStockBean;
import fr.creasport.webgestionstock.dao.ArticleDAO;
import fr.creasport.webgestionstock.dao.ModeleDAO;
import fr.creasport.webgestionstock.dao.StockArticleDAO;
import fr.creasport.webgestionstock.dao.TailleDAO;
import fr.creasport.webgestionstock.metier.Article;
import fr.creasport.webgestionstock.metier.StockArticle;

/**
 * Servlet implementation class TableauArticleAjaxServlet
 */
public class TableauArticleAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TableauArticleAjaxServlet() {
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

	private void doWork(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		// pour recuper la ref   String morFilm = request.getParameter("valeur");
	
		StockArticleDAO dbStockArticle = new StockArticleDAO();
		TailleDAO dbTaille = new TailleDAO();
		ModeleDAO dbModele = new ModeleDAO();
		ArticleDAO dbArticle = new ArticleDAO();
		StockArticle stockArticle = new StockArticle();
		Article article = new Article();
		ExpedierStockBean bean = new ExpedierStockBean();
		try {
			//test push
			stockArticle=dbStockArticle.selectParRef("CUICYELIT0510160002-S");
			// on set la ref dans le bean
			bean.setSa_ref(stockArticle.getSa_ref());
			// on recupere le nom de la taille et on le place dans bean
			bean.setTa_nom(dbTaille.selectNom(stockArticle.getTa_id()));
			// on recupere l'id de article pour aller chercher id de modele
			article=dbArticle.SelectById(stockArticle.getAr_id()); 
			// on recupere le nom du modele et on le place dans bean
			bean.setMo_nom(dbModele.selectNom(article.getMo_id()));
			// on envoi vers le .js
			PrintWriter ecrire;
			Gson gson = new Gson();
			ecrire = response.getWriter();
			ecrire.println(gson.toJson(bean));
			System.out.println(gson.toJson(bean));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
