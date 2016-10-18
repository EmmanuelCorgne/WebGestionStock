package fr.creasport.webgestionstock.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xerces.internal.impl.xs.XMLSchemaLoader.LocationArray;

import fr.creasport.webgestionstock.metier.LotArticle;
import fr.creasport.webgestionstock.metier.StockArticle;

public class LotArticleDAO {

	public LotArticleDAO() {
		// TODO Auto-generated constructor stub
	}

	public void ajouter(LotArticle lotArt) {
		String query = "INSERT INTO lotsarticles VALUES(null,null,?,?)";

		try {
			PreparedStatement st = DbConnection.getInstance().prepareStatement(query);

			//st.setDate(1, new Date(lotArt.getLa_dateRetour().getTime()));
			st.setInt(1, lotArt.getSa_id());
			st.setInt(2, lotArt.getEa_id());
			st.executeUpdate();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void modifier(LotArticle lotArt) {
		String query = "UPDATE lotsarticles SET la_dateRetour=?, sa_id=?, ea_id=? " + " WHERE la_id=?";
		try {
			PreparedStatement st = DbConnection.getInstance().prepareStatement(query);

			st.setDate(1, new Date(lotArt.getLa_dateRetour().getTime()));

			st.setInt(2, lotArt.getSa_id());
			st.setInt(3, lotArt.getEa_id());

			// where ID
			st.setInt(4, lotArt.getLa_id());

			st.executeUpdate();
			st.close();
		} catch (Exception e) {
		}
	}

	public void supprimer(int id) throws ClassNotFoundException {
		String query = "DELETE FROM lotsarticles WHERE la_id=?";

		try {
			PreparedStatement st = DbConnection.getInstance().prepareStatement(query);

			st.setInt(1, id);
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
		}
	}
	//recherche tous les articles envoyé pour un lot precit
		public List<LotArticle> selectParExpedition(int eaId) throws ClassNotFoundException {
			String query = "SELECT * FROM lotsarticles WHERE ea_id=?";
			List<LotArticle> list = new ArrayList<LotArticle>();

			LotArticle lotArticle = null;
			try {
				PreparedStatement st = DbConnection.getInstance().prepareStatement(query);
				st.setInt(1, eaId);
				
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					lotArticle = new LotArticle();
					lotArticle.setEa_id(rs.getInt("ea_id"));
					lotArticle.setLa_dateRetour(rs.getDate("la_dateRetour"));
					lotArticle.setLa_id(rs.getInt("la_id"));
					lotArticle.setSa_id(rs.getInt("sa_id"));
					list.add(lotArticle);
				}
				rs.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}

}
