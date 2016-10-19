package fr.creasport.webgestionstock.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.creasport.webgestionstock.metier.Outil.stockArticlesRupture;
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

	public StockArticle selectParId(int id) throws ClassNotFoundException {
		String query = "SELECT * FROM stocksarticles WHERE sa_id=?";
		StockArticle stockArticle = null;
		try {
			PreparedStatement st = DbConnection.getInstance().prepareStatement(query);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				stockArticle = new StockArticle();
				stockArticle.setAr_id((rs.getInt("ar_id")));
				stockArticle.setSa_id(id);
				stockArticle.setSt_id((rs.getInt("st_id")));
				stockArticle.setTa_id((rs.getInt("ta_id")));
				stockArticle.setSa_isActive(rs.getBoolean("sa_isActive"));
				stockArticle.setSa_dateCreation(rs.getDate("sa_dateCreation"));
				stockArticle.setSa_ref((rs.getString("sa_ref")));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stockArticle;
	}

	// recherche tous les stockArticle de l'article
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

	public List<StockArticle> selectAll() throws ClassNotFoundException {
		String query = "SELECT * FROM stocksarticles";
		List<StockArticle> list = new ArrayList<StockArticle>();

		StockArticle stockArticle = null;
		try {
			PreparedStatement st = DbConnection.getInstance().prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				stockArticle = new StockArticle();
				stockArticle.setAr_id(rs.getInt("ar_id"));
				stockArticle.setSa_id(rs.getInt("sa_id"));
				stockArticle.setSt_id(rs.getInt("st_id"));
				stockArticle.setTa_id(rs.getInt("ta_id"));
				stockArticle.setSa_isActive(rs.getBoolean("sa_isActive"));
				stockArticle.setSa_dateCreation(rs.getDate("sa_dateCreation"));
				stockArticle.setSa_ref(rs.getString("sa_ref"));
				list.add(stockArticle);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// Liste des articles en rupture

	public List<stockArticlesRupture> selectRupture() throws ClassNotFoundException {
		String query = "select FA.fa_nom as famille, MO.mo_nom as modele, AR.ar_nom as article, "
				+ "TA.ta_nom as taille , count(sa_id) as nbarticles "
				+ " from stocksarticles SA, articles AR, familles FA, modeles MO, tailles TA"
				+ " where SA.ar_id = AR.ar_id and FA.fa_id = AR.fa_id and MO.mo_id = AR.mo_id"
				+ " and TA.ta_id = SA.ta_id and SA.st_id in (select st_id from statuts where st_code = 0) "
				+ " group by SA.ar_id";
		List<stockArticlesRupture> list = new ArrayList<stockArticlesRupture>();
System.out.println(query);
		try {
			PreparedStatement st = DbConnection.getInstance().prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				stockArticlesRupture element = new stockArticlesRupture();
				element.famille = rs.getString("famille");
				element.modele = rs.getString("modele");
				element.article = rs.getString("article");
				element.taille = rs.getString("taille");
				element.nbArticle = rs.getInt("nbArticles");
				list.add(element);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return list;
	}
}
