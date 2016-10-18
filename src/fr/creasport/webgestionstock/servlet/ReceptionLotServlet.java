package fr.creasport.webgestionstock.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.creasport.webgestionstock.bean.ReceptionLotBean;
import fr.creasport.webgestionstock.dao.ArticleDAO;
import fr.creasport.webgestionstock.dao.DestinataireDAO;
import fr.creasport.webgestionstock.dao.ExpeditionArticleDAO;
import fr.creasport.webgestionstock.dao.LotArticleDAO;
import fr.creasport.webgestionstock.dao.ModeleDAO;
import fr.creasport.webgestionstock.dao.StockArticleDAO;
import fr.creasport.webgestionstock.dao.TailleDAO;
import fr.creasport.webgestionstock.dao.TypeExpeditionDAO;
import fr.creasport.webgestionstock.metier.Destinataire;
import fr.creasport.webgestionstock.metier.ExpeditionArticle;
import fr.creasport.webgestionstock.metier.LotArticle;
import fr.creasport.webgestionstock.metier.Modele;
import fr.creasport.webgestionstock.metier.StockArticle;
import fr.creasport.webgestionstock.metier.Taille;

/**
 * Servlet implementation class ReceptionLotServlet
 */
public class ReceptionLotServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceptionLotServlet() {
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
		//id expedition article ea_id
		int ea_id = Integer.parseInt(request.getParameter("ea_id"));

		//int ea_id =133;
		LotArticleDAO lotArticleDAO = new LotArticleDAO();
		ExpeditionArticleDAO expeditionArticleDAO = new ExpeditionArticleDAO();
		StockArticleDAO stockArticleDAO = new StockArticleDAO();
		DestinataireDAO destinataireDAO = new DestinataireDAO();
		TypeExpeditionDAO typeExpeditionDAO = new TypeExpeditionDAO();
		ReceptionLotBean bean = new ReceptionLotBean();
		TailleDAO tailleDAO = new TailleDAO();
		ModeleDAO modeleDAO = new ModeleDAO();
		ArticleDAO article = new ArticleDAO();
		
		List<StockArticle> listStockArticle = new ArrayList<StockArticle>();
		List<Taille> listTaille = new ArrayList<Taille>();
		List<Modele> listModele= new ArrayList<Modele>();
		List<LotArticle> listLotArticle = new ArrayList<LotArticle>();
		
//	System.out.println(ea_id);
		try {
			listLotArticle = lotArticleDAO.selectParExpedition(ea_id);

				  for(int i = 0,j = listLotArticle.size(); i < j;i++){
				  
				  StockArticle stockArticle  = stockArticleDAO.selectParId(listLotArticle.get(i).getSa_id());
				  listStockArticle.add(stockArticle);
				  Taille taille = new Taille();
				  taille.setTa_nom(tailleDAO.selectNom(stockArticle.getTa_id()));
				  listTaille.add(taille);
				  //ar_id --> mo_id
				  Modele modele = new Modele();
				  
				  modele.setMo_nom(modeleDAO.selectNom(article.SelectModelleById(stockArticle.getAr_id())));
				  listModele.add(modele);
			    }
			

			//ta_nom ta_id
			//mo_nom mo_id
			  
			  
			  
			ExpeditionArticle expeditionArticle =expeditionArticleDAO.selectParId(ea_id);
			bean.setEa_dateCreation(expeditionArticle.getEa_dateCreation());
			bean.setEa_infoComplementaire(expeditionArticle.getEa_infoComplementaire());
			bean.setEa_nbArticleEnvoyeTotal(expeditionArticle.getEa_nbArticleEnvoyeTotal());
			Destinataire dest =destinataireDAO.findDestinataireParId(expeditionArticle.getDe_id());
			bean.setEa_TrackingColis(expeditionArticle.getEa_TrackingColis());
			bean.setEa_realisePar(expeditionArticle.getEa_realisePar());
			bean.setClub(dest.getDe_nomClub());
			bean.setExpedition(typeExpeditionDAO.SelectNomById(expeditionArticle.getTe_id()));
		//	List<TypeExpedition> list = typeExpeditionDAO.SelectAll();
			//envoi
			request.setAttribute("bean",bean);
			request.setAttribute("listTaille",listTaille);
			request.setAttribute("listModele",listModele);
			request.setAttribute("ListStockArticle",listStockArticle);
		//	request.setAttribute("listoption",list);

			request.getRequestDispatcher("ReceptionLot.jsp").forward(request, response);
			
		} catch (ClassNotFoundException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		
		
		//
	}

}
