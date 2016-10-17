package fr.creasport.webgestionstock.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.creasport.webgestionstock.dao.ExpeditionArticleDAO;
import fr.creasport.webgestionstock.metier.ExpeditionArticle;
import fr.creasport.webgestionstock.metier.Outil;

/**
 * Servlet implementation class SaisirExpeditionArticleServlet
 */
public class SaisirExpeditionArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaisirExpeditionArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			doWork(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			doWork(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void doWork(HttpServletRequest request, HttpServletResponse response) throws ParseException {
		
		int id_Ea_id=0;
		ExpeditionArticleDAO expeditionArticleDAO = new ExpeditionArticleDAO();
		ExpeditionArticle expeditionArticle = new ExpeditionArticle();
		expeditionArticle.setEa_dateCreation(Outil.convertStringToDate(request.getParameter("ea_dateCreation")));
		expeditionArticle.setEa_realisePar(request.getParameter("ea_realisePar"));
		expeditionArticle.setEa_TrackingColis(request.getParameter("ea_TrackingColis"));		
		expeditionArticle.setEa_nbArticleEnvoyeTotal(Integer.parseInt(request.getParameter("ea_nbArticleEnvoyeTotal")));
		expeditionArticle.setEa_infoComplementaire(request.getParameter("ea_infoComplementaire"));
		boolean b = Boolean.valueOf(request.getParameter("ea_isRetourIncomplet")).booleanValue() ; 
		expeditionArticle.setEa_isRetourIncomplet(b);
		expeditionArticle.setTe_id(Integer.parseInt(request.getParameter("te_id")));
		expeditionArticle.setDe_id(Integer.parseInt(request.getParameter("de_id")));
		expeditionArticleDAO.ajouter(expeditionArticle);
		id_Ea_id= expeditionArticleDAO.SelectWhere(expeditionArticle);
		PrintWriter ecrire;
		try {
			ecrire = response.getWriter();
			ecrire.println(id_Ea_id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
