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
		// pour recuper la ref
		String ref = request.getParameter("ref");
		//System.out.println(ref);
		// CUICYELIT0510160002-S
		try {

			ExpedierStockBean bean = new ExpedierStockBean();
			StockArticle stockArticle = new StockArticle();
			StockArticleDAO dbStockArticle = new StockArticleDAO();
			stockArticle = dbStockArticle.selectParRef(ref);
			if(null!=stockArticle){
	

			// on set la ref dans le bean
			bean.setSa_ref(stockArticle.getSa_ref());

			// on recupere le nom de la taille et on le place dans bean
			TailleDAO dbTaille = new TailleDAO();
			bean.setTa_nom(dbTaille.selectNom(stockArticle.getTa_id()));

			// on recupere l'id de article pour aller chercher id de modele
			Article article = new Article();
			ArticleDAO dbArticle = new ArticleDAO();
			article = dbArticle.SelectById(stockArticle.getAr_id());

			// on recupere le nom du modele et on le place dans bean
			ModeleDAO dbModele = new ModeleDAO();
			bean.setMo_nom(dbModele.selectNom(article.getMo_id()));

			// on stock l'id Stock article dans le ExpedierStockBean
			bean.setSa_id(stockArticle.getSa_id());

			// on envoi vers le .js
			PrintWriter ecrire;
			Gson gson = new Gson();
			ecrire = response.getWriter();
			ecrire.println(gson.toJson(bean));
			// System.out.println(gson.toJson(bean));
			}else{
				PrintWriter ecrire;
				Gson gson = new Gson();
				ecrire = response.getWriter();
				ecrire.println(gson.toJson("Erreur : la Ref n'est pas dans la base de donnee StockArticle"));

			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
