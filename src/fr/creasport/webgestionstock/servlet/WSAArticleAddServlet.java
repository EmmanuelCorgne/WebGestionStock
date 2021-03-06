package fr.creasport.webgestionstock.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.creasport.webgestionstock.bean.ArticleBean;
import fr.creasport.webgestionstock.dao.ArticleDAO;
import fr.creasport.webgestionstock.metier.Article;



/**
 * Servlet implementation class WSAArticleAddServlet
 */
public class WSAArticleAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WSAArticleAddServlet() {
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
	
		ArticleBean artBean=new ArticleBean();
		artBean.setReference(request.getParameter("reference"));
		artBean.setNom(request.getParameter("nom"));
		boolean b = Boolean.valueOf(request.getParameter("isActive")).booleanValue() ; 
		artBean.setIsActive(b);
		b = Boolean.valueOf(request.getParameter("isHC")).booleanValue() ; 
		artBean.setIsHC(b);
		artBean.setFamille(Integer.parseInt(request.getParameter("familleID")));
		artBean.setModele(Integer.parseInt(request.getParameter("modeleID")));
		
		Article artMetier= new Article();
		Article article=artMetier.ajouter(artBean);
		//retour de l'ajax
		PrintWriter retour;
		try {
			retour = response.getWriter();
			retour.println(article.getAr_id());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
