package fr.creasport.webgestionstock.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.creasport.webgestionstock.bean.ArticleBean;
import fr.creasport.webgestionstock.bean.DestinataireBean;
import fr.creasport.webgestionstock.dao.ArticleDAO;
import fr.creasport.webgestionstock.dao.FamilleDAO;
import fr.creasport.webgestionstock.dao.ModeleDAO;
import fr.creasport.webgestionstock.dao.TailleDAO;
import fr.creasport.webgestionstock.dao.TypeExpeditionDAO;
import fr.creasport.webgestionstock.metier.Article;
import fr.creasport.webgestionstock.metier.Famille;
import fr.creasport.webgestionstock.metier.Modele;
import fr.creasport.webgestionstock.metier.Taille;
import fr.creasport.webgestionstock.metier.TypeExpedition;

/**
 * Servlet implementation class SaisirArticleServlet
 */
public class SaisirArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaisirArticleServlet() {
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

	protected void doWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// passage à la vue

		ArticleBean bean = new ArticleBean();
		if (request.getParameter("refArticle") != null) {
			bean.setReference(request.getParameter("refArticle"));
			bean.setIsActive(Boolean.valueOf(request.getParameter("actif")));
			bean.setNom(request.getParameter("nomArticle"));
			bean.setIsHC(Boolean.valueOf(request.getParameter("ishc")));
			bean.setFamille(Integer.valueOf(request.getParameter("famille")));
			bean.setModele(Integer.valueOf(request.getParameter("modele")));
			
			Article artMetier=new Article();
			artMetier.ajouter(bean);

			request.setAttribute("bean", bean);
			request.getRequestDispatcher("SaisirArticle.jsp").forward(request, response);
		}else{
			FamilleDAO familleDAO = new FamilleDAO();
			ModeleDAO modeleDAO=new ModeleDAO();
			TailleDAO tailleDAO=new TailleDAO();
			try {
				List<Famille> listFamille = familleDAO.SelectAll();
				List<Modele> listModele =modeleDAO.SelectAll();
				List<Taille> listTaille=tailleDAO.SelectAll();
				request.setAttribute("listModele",listModele);
				request.setAttribute("listFamille",listFamille);
				request.setAttribute("listTaille",listTaille);
				request.getRequestDispatcher("SaisirArticle.jsp").forward(request, response);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		}

	}
}
