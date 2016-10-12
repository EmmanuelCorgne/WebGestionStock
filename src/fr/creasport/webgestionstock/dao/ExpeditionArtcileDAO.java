package fr.creasport.webgestionstock.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.creasport.webgestionstock.metier.ExpeditionArticle;

public class ExpeditionArtcileDAO {

	public ExpeditionArtcileDAO() {
		// TODO Auto-generated constructor stub
	}

	public void ajouter(ExpeditionArticle expart) {
		String query = "INSERT INTO expeditionsarticles VALUES(null,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement st = DbConnection.getInstance().prepareStatement(query);

			st.setDate(1, new Date(expart.getEa_dateRetour().getTime()));
			st.setString(2, expart.getEa_realisePar());
			st.setString(3, expart.getEa_TrackingColis());
			st.setInt(4, expart.getEa_nbArticleEnvoyeTotal());
			st.setString(5, expart.getEa_infoComplementaire());

			st.setBoolean(6, expart.isEa_isRetourIncomplet());

			st.setInt(7, expart.getTe_id());
			st.setInt(8, expart.getTe_id());
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

			st.setDate(1, new Date(expart.getEa_dateRetour().getTime()));
			st.setString(2, expart.getEa_realisePar());

			st.setString(3, expart.getEa_TrackingColis());
			st.setString(4, expart.getEa_TrackingColis());
			st.setInt(5, expart.getEa_nbArticleEnvoyeTotal());
			st.setString(6, expart.getEa_infoComplementaire());
			st.setBoolean(7, expart.isEa_isRetourIncomplet());
			st.setInt(8, expart.getTe_id());
			st.setInt(9, expart.getDe_id());

			// where ID
			st.setInt(10, expart.getEa_id());

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

}
