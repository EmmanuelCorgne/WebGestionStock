package fr.creasport.webgestionstock.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.creasport.webgestionstock.bean.ReceptionLotBean;
import fr.creasport.webgestionstock.dao.DestinataireDAO;
import fr.creasport.webgestionstock.dao.ExpeditionArticleDAO;
import fr.creasport.webgestionstock.dao.LotArticleDAO;
import fr.creasport.webgestionstock.dao.StockArticleDAO;
import fr.creasport.webgestionstock.dao.TypeExpeditionDAO;
import fr.creasport.webgestionstock.metier.Destinataire;
import fr.creasport.webgestionstock.metier.ExpeditionArticle;
import fr.creasport.webgestionstock.metier.LotArticle;
import fr.creasport.webgestionstock.metier.StockArticle;
import fr.creasport.webgestionstock.metier.TypeExpedition;

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
		//int ea_id = Integer.parseInt(request.getParameter("ea_id"));
		int ea_id =133;
		LotArticleDAO lotArticleDAO = new LotArticleDAO();
		TypeExpeditionDAO typeExpeditionDAO = new TypeExpeditionDAO();
		ExpeditionArticleDAO expeditionArticleDAO = new ExpeditionArticleDAO();
		StockArticleDAO stockArticleDAO = new StockArticleDAO();
		DestinataireDAO destinataireDAO = new DestinataireDAO();
		ReceptionLotBean bean = new ReceptionLotBean();

	

		
			List<StockArticle> listStockArticle = null;
		try {
			List<LotArticle> listLotArticle = lotArticleDAO.selectParExpedition(ea_id);
			  for (LotArticle s : listLotArticle) {
				  StockArticle stockArticle  = stockArticleDAO.selectParId(s.getSa_id());
				  listStockArticle.add(stockArticle);
			    }
			
			
			ExpeditionArticle expeditionArticle =expeditionArticleDAO.selectParId(ea_id);
			bean.setEa_dateCreation(expeditionArticle.getEa_dateCreation());
			bean.setEa_infoComplementaire(expeditionArticle.getEa_infoComplementaire());
			bean.setEa_nbArticleEnvoyeTotal(expeditionArticle.getEa_nbArticleEnvoyeTotal());
			Destinataire dest =destinataireDAO.findDestinataireParId(expeditionArticle.getDe_id());
			bean.setEa_TrackingColis(expeditionArticle.getEa_TrackingColis());
			bean.setEa_realisePar(expeditionArticle.getEa_realisePar());
			bean.setClub(dest.getDe_nomClub());
			bean.setExpedition(expeditionArticle.getTe_id());
		//	List<TypeExpedition> list = typeExpeditionDAO.SelectAll();
			
			//envoi
			request.setAttribute("bean",bean);
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
