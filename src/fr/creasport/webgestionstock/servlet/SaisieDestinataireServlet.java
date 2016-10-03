package fr.creasport.webgestionstock.servlet;
import fr.creasport.webgestionstock.bean.DestinataireBean;
import fr.creasport.webgestionstock.dao.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaisieDestinataireServlet
 */
public class SaisieDestinataireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaisieDestinataireServlet() {
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

	private void doWork(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		if(request.getParameter("nomClub")!= null){
			
			DestinataireBean bean= new DestinataireBean();
			bean.setNomClub(request.getParameter("nomClub"));
			bean.setNomContact(request.getParameter("nomContact"));
			bean.setAdresse1(request.getParameter("adresse1"));
			bean.setAdresse2(request.getParameter("adresse2"));
			bean.setCp(request.getParameter("cp"));
			bean.setVille(request.getParameter("ville"));
			bean.setPays(request.getParameter("pays"));
			bean.setEmail(request.getParameter("email"));
			bean.setTelephone(request.getParameter("pays"));
		//	bean.setDjClient(request.getParameter("djClient"));
		//	bean.setActif(request.getParameter("actif"));
			System.out.println(bean.getDjClient());
			System.out.println(bean.toString());///////////////////
			//creation de la connection base
			OutilDao db = new OutilDao();
			// insert dans la base
			db.addDestinataire(bean);
			
			request.getRequestDispatcher("vue/SaisieDestinataire.jsp").forward(request, response);
			
		}else{
			request.getRequestDispatcher("vue/SaisieDestinataire.jsp").forward(request, response);
		}
		
	}

}
