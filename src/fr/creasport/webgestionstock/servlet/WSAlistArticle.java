package fr.creasport.webgestionstock.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import fr.creasport.webgestionstock.dao.ArticleDAO;
import fr.creasport.webgestionstock.metier.Article;

/**
 * Servlet implementation class WSAlistArticle
 */


public class WSAlistArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WSAlistArticle() {
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
		class MiniArticle {
			public int id;
			public String nom;
			public MiniArticle(){
				
			}
			@Override
			public String toString() {
				return "MiniArticle [id=" + id + ", nom=" + nom + "]";
			}
		}
		List<MiniArticle> listMiniArticle = new ArrayList<MiniArticle>();
			
		ArticleDAO articleDAO = new ArticleDAO();
		
		List<Article> malist = new ArrayList<Article>();

		System.out.println("début de WSAlistArticle");

		try {
			malist = articleDAO.SelectAll();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for (Article temp : malist) {
			MiniArticle miniArticle = new MiniArticle();
			miniArticle.id = temp.getAr_id();
			miniArticle.nom = temp.getAr_nom();
			//System.out.println(miniArticle.toString());
			listMiniArticle.add(miniArticle);
		}
		
		
		try {
			PrintWriter ecrire;
			Gson gson = new Gson();
			ecrire = response.getWriter();
			ecrire.println((listMiniArticle));
		} catch (IOException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("erreur dans WSAlistArticle : " + e);
		}

	}

}
