package fr.creasport.webgestionstock.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.creasport.webgestionstock.metier.Article;
import fr.creasport.webgestionstock.metier.ExpeditionArticle;
import fr.creasport.webgestionstock.metier.Famille;

public class ExpeditionArticleDAO {

	public ExpeditionArticleDAO() {
		// TODO Auto-generated constructor stub
	}

	public void ajouter(ExpeditionArticle expart) {
		String query = "INSERT INTO expeditionsarticles VALUES(null,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement st = DbConnection.getInstance().prepareStatement(query);

			st.setDate(1, new Date(expart.getEa_dateCreation().getTime()));
			st.setString(2, expart.getEa_realisePar());
			st.setString(3, expart.getEa_TrackingColis());
			st.setInt(4, expart.getEa_nbArticleEnvoyeTotal());
			st.setString(5, expart.getEa_infoComplementaire());
			st.setBoolean(6, expart.isEa_isRetourIncomplet());
			st.setInt(7, expart.getTe_id());
			st.setInt(8, expart.getDe_id());
			st.executeUpdate();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void modifier(ExpeditionArticle expart) {
		String query = "UPDATE expeditionsarticles SET ea_dateCreation=?, ea_realisePar=?,ea_TrackingColis=?, "
				+ "ea_nbArticleEnvoyeTotal=?, ea_infoComplementaire=?,ea_isRetourIncomplet=?,te_id=?,de_id=? "
				+ " WHERE ae_id=?";
		try {
			PreparedStatement st = DbConnection.getInstance().prepareStatement(query);

			st.setDate(1, new Date(expart.getEa_dateCreation().getTime()));
			st.setString(2, expart.getEa_realisePar());

			st.setString(3, expart.getEa_TrackingColis());
			st.setInt(4, expart.getEa_nbArticleEnvoyeTotal());
			st.setString(5, expart.getEa_infoComplementaire());
			st.setBoolean(6, expart.isEa_isRetourIncomplet());
			st.setInt(7, expart.getTe_id());
			st.setInt(8, expart.getDe_id());

			// where ID
			st.setInt(9, expart.getEa_id());

			st.executeUpdate();
			st.close();
		} catch (Exception e) {
		}
	}

	public void supprimer(int id) throws ClassNotFoundException {
		String query = "DELETE FROM expeditionsarticles WHERE ea_id=?";

		try {
			PreparedStatement st = DbConnection.getInstance().prepareStatement(query);
			;
			st.setInt(1, id);
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
		}
	}

	public List<ExpeditionArticle> SelectAll() throws ClassNotFoundException {
		List<ExpeditionArticle> list = new ArrayList<ExpeditionArticle>();
		ExpeditionArticle expArt;
		String query="SELECT * FROM expeditionsarticles";
		
		try {
			Statement st = DbConnection.getInstance().createStatement();
		    ResultSet rs = st.executeQuery(query);
		    while (rs.next()){
		    	expArt=new ExpeditionArticle();
		    	expArt.setDe_id(rs.getInt("de_id"));	
		    	expArt.setEa_dateCreation(rs.getDate("ea_dateCreation"));
		    	expArt.setEa_infoComplementaire(rs.getString("ea_infoComplementaire"));
		    	expArt.setEa_id(rs.getInt("ea_id"));
		    	expArt.setEa_isRetourIncomplet(rs.getBoolean("ea_isRetourIncomplet"));
		    	expArt.setEa_nbArticleEnvoyeTotal(rs.getInt("ea_nbArticleEnvoyeTotal"));
		    	expArt.setEa_realisePar(rs.getString("ea_realisePar"));
		    	expArt.setEa_TrackingColis(rs.getString("ea_TrackingColis"));
		    	expArt.setTe_id(rs.getInt("te_id"));
		    	list.add(expArt);
		    }
		    st.close();
		    rs.close();
		} catch(SQLException e) {
		}
		return list;
	}
	public int SelectWhere(ExpeditionArticle expart) {

		String query="SELECT ea_id FROM expeditionsarticles WHERE ea_dateCreation=? AND ea_realisePar=? AND ea_TrackingColis=? AND "
			    + "ea_nbArticleEnvoyeTotal=? AND ea_infoComplementaire=? AND ea_isRetourIncomplet=? AND te_id=? AND de_id=? ";
		
		int id_Ea_id=0;
		try {
			//System.out.println(id);
			PreparedStatement st = DbConnection.getInstance().prepareStatement(query);
		    st.setDate(1, new Date(expart.getEa_dateCreation().getTime()));

		    st.setString(2, expart.getEa_realisePar());
		    st.setString(3, expart.getEa_TrackingColis());
		    st.setInt(4, expart.getEa_nbArticleEnvoyeTotal());
		    st.setString(5, expart.getEa_infoComplementaire());
		    st.setBoolean(6, expart.isEa_isRetourIncomplet());
		    st.setInt(7, expart.getTe_id());					
		    st.setInt(8, expart.getDe_id());
			ResultSet rs=st.executeQuery();
		    if (rs.next()) {
		    	id_Ea_id = rs.getInt("ea_id");
		    }
			rs.close();
			st.close();
			
		} catch (Exception e) {
		}
		return id_Ea_id;
	}
	public ArrayList SelectForIndex(int limit)  throws ClassNotFoundException  {
		
		class retourWS {
			public int id;
			public String dateCreation;
			public int nbArticle;
			public String nomClub;
			
			public retourWS() {

			}
			
		}
		String query="select ea_id as id, "
				+ "DATE_FORMAT(ea_datecreation,'%d/%m/%Y') as date, "
				+ "ea_nbarticleenvoyetotal as nbart, "
				+ "de_nomclub as nomclub "
				+ "from expeditionsarticles EA, destinataires DE "
				+ "where EA.ea_isretourincomplet = false "
				+ "and EA.de_id = DE.de_id "
				+ "order by EA.ea_datecreation "
				+ "desc limit " + limit;
		
		List listResult = new ArrayList();

		try {
			Statement st = DbConnection.getInstance().createStatement();
		    ResultSet rs = st.executeQuery(query);
		    while (rs.next()){
		    	String[] result;
		    }
		    st.close();
		    rs.close();
		} catch(SQLException e) {
		}
		return (ArrayList) listResult;
	}
}
