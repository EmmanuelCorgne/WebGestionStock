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
		String a = request.getParameter("artID");
		String artID = a.replace("%0D%0A","") ;
		int qty=Integer.parseInt(request.getParameter("quantite"));
		String ref=request.getParameter("reference");
		
		artStockBean.setArticle(Integer.parseInt(artID));
		artStockBean.setIsActive(true);
		String t = request.getParameter("tailleID");
		String tailleID = t.replace("%20","") ;
		System.out.println("taile"+tailleID);
		artStockBean.setTaille(Integer.parseInt(tailleID));
		
		for (int i = 0; i < qty; i++) {
			artStockBean.setReference(ref+"-"+i);
			artStockMetier.ajouter(artStockBean);
			System.out.println("Ajouter stocke article"+artStockBean.getReference());
		}
				
	}

}
