package fr.creasport.webgestionstock.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.creasport.webgestionstock.bean.ArticleBean;
import fr.creasport.webgestionstock.bean.DestinataireBean;
import fr.creasport.webgestionstock.dao.ArticleDAO;

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
//sss
		ArticleBean bean = new ArticleBean();
		if (request.getParameter("refArticle") != null) {
			bean.setReference(request.getParameter("refArticle"));
			bean.setIsActive(Boolean.valueOf(request.getParameter("actif")));
			bean.setNom(request.getParameter("nomArticle"));
			bean.setIsHC(Boolean.valueOf(request.getParameter("ishc")));
			bean.setFamille(Integer.valueOf(request.getParameter("famille")));
			bean.setModele(Integer.valueOf(request.getParameter("modele")));
			
			ArticleDAO artDAO=new ArticleDAO();
			artDAO.ajouter(bean);

			request.setAttribute("bean", bean);
			request.getRequestDispatcher("vue/SaisirArticle.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("vue/SaisirArticle.jsp").forward(request, response);
		}

	}
}
