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

import fr.creasport.webgestionstock.dao.ExpeditionArticleDAO;
import fr.creasport.webgestionstock.metier.*;
/**
 * Servlet implementation class WSrecusManquants
 */
public class WSrecusManquants extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WSrecusManquants() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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
		
		List<Outil.recusManquants> list = new ArrayList<Outil.recusManquants>();

		ExpeditionArticleDAO expeditionArticleDAO = new ExpeditionArticleDAO();

		try {
			list = expeditionArticleDAO.SelectManquants(Integer.parseInt(request.getParameter("limit")));
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println(e1);
		}

		try {
			PrintWriter ecrire;
			Gson gson = new Gson();
			ecrire = response.getWriter();
			ecrire.println(gson.toJson(list));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("erreur dans WSrecusManquants : " + e);
		}

	}
}
