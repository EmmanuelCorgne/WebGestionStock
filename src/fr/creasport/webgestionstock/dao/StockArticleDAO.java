package fr.creasport.webgestionstock.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.creasport.webgestionstock.metier.Famille;
import fr.creasport.webgestionstock.metier.StockArticle;

public class StockArticleDAO {

	public void ajouter(StockArticle stockart) {
		String query = "INSERT INTO stocksarticles VALUES(null,?,?,?,?,?,?)";
		Date dateCreation = new Date(new java.util.Date().getTime());
		try {
			PreparedStatement st = DbConnection.getInstance().prepareStatement(query);

			st.setString(1, stockart.getSa_ref());
			st.setDate(2, dateCreation);
			st.setBoolean(3, stockart.isSa_isActive());
			st.setInt(4, stockart.getAr_id());
			st.setInt(5, stockart.getTa_id());
			st.setInt(6, stockart.getSt_id());
			st.executeUpdate();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void modifier(StockArticle stockart) {
		String query = "UPDATE stocksarticles SET sa_ref=?, sa_isActive=?, ar_id=?, ta_id=?,st_id=? "
				+ " WHERE sa_id=?";
		try {
			PreparedStatement st = DbConnection.getInstance().prepareStatement(query);

			st.setString(1, stockart.getSa_ref());
			st.setBoolean(3, stockart.isSa_isActive());
			st.setInt(4, stockart.getAr_id());
			st.setInt(5, stockart.getTa_id());
			st.setInt(6, stockart.getSt_id());

			// where ID
			st.setInt(8, stockart.getSa_id());

			st.executeUpdate();
			st.close();
		} catch (Exception e) {
		}
	}

	public void supprimer(int id) throws ClassNotFoundException {
		String query = "DELETE FROM stocksarticles WHERE sa_id=?";

		try {
			PreparedStatement st = DbConnection.getInstance().prepareStatement(query);
			;
			st.setInt(1, id);
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
		}
	}

	public StockArticle selectParRef(String Ref) throws ClassNotFoundException {
		String query = "SELECT * FROM stocksarticles WHERE sa_ref=?";
		StockArticle stockArticle = null;
		try {
			PreparedStatement st = DbConnection.getInstance().prepareStatement(query);
			st.setString(1, Ref);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				stockArticle = new StockArticle();
				stockArticle.setAr_id((rs.getInt("ar_id")));
				stockArticle.setSa_id((rs.getInt("sa_id")));
				stockArticle.setSt_id((rs.getInt("st_id")));
				stockArticle.setTa_id((rs.getInt("ta_id")));
				stockArticle.setSa_isActive(rs.getBoolean("sa_isActive"));
				stockArticle.setSa_dateCreation(rs.getDate("sa_dateCreation"));
				stockArticle.setSa_ref(Ref);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stockArticle;
	}
	
	
	//recherche tous les stockArticle de l'article
	public List<StockArticle> selectParArticle(int arId) throws ClassNotFoundException {
		String query = "SELECT * FROM stocksarticles WHERE ar_id=?";
		List<StockArticle> list = new ArrayList<StockArticle>();

		StockArticle stockArticle = null;
		try {
			PreparedStatement st = DbConnection.getInstance().prepareStatement(query);
			st.setInt(1, arId);
			
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				stockArticle = new StockArticle();
				stockArticle.setAr_id(rs.getInt("ar_id"));
				stockArticle.setSa_id(rs.getInt("sa_id"));
				stockArticle.setSt_id(rs.getInt("st_id"));
				stockArticle.setTa_id(rs.getInt("ta_id"));
				stockArticle.setSa_isActive(rs.getBoolean("sa_isActive"));
				stockArticle.setSa_dateCreation(rs.getDate("sa_dateCreation"));
				stockArticle.setSa_ref(rs.getString("sa_ref"));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
