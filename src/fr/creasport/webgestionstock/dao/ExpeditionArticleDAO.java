package fr.creasport.webgestionstock.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.creasport.webgestionstock.metier.Article;
import fr.creasport.webgestionstock.metier.Outil;

import fr.creasport.webgestionstock.metier.ExpeditionArticle;
import fr.creasport.webgestionstock.servlet.*;

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
		String query = "SELECT * FROM expeditionsarticles";

		try {
			Statement st = DbConnection.getInstance().createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				expArt = new ExpeditionArticle();
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
		} catch (SQLException e) {
		}
		return list;
	}

	public ExpeditionArticle selectParId(int ea_id) throws ClassNotFoundException {
		ExpeditionArticle expArt = null;
		String query = "SELECT * FROM expeditionsarticles WHERE ea_id=" + ea_id;

		try {
			Statement st = DbConnection.getInstance().createStatement();
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				expArt = new ExpeditionArticle();
				expArt.setDe_id(rs.getInt("de_id"));
				expArt.setEa_dateCreation(rs.getDate("ea_dateCreation"));
				expArt.setEa_infoComplementaire(rs.getString("ea_infoComplementaire"));
				expArt.setEa_id(rs.getInt("ea_id"));
				expArt.setEa_isRetourIncomplet(rs.getBoolean("ea_isRetourIncomplet"));
				expArt.setEa_nbArticleEnvoyeTotal(rs.getInt("ea_nbArticleEnvoyeTotal"));
				expArt.setEa_realisePar(rs.getString("ea_realisePar"));
				expArt.setEa_TrackingColis(rs.getString("ea_TrackingColis"));
				expArt.setTe_id(rs.getInt("te_id"));

			}
			st.close();
			rs.close();
		} catch (SQLException e) {
		}
		return expArt;
	}

	public int SelectWhere(ExpeditionArticle expart) {

		String query = "SELECT ea_id FROM expeditionsarticles WHERE ea_dateCreation=? AND ea_realisePar=? AND ea_TrackingColis=? AND "
				+ "ea_nbArticleEnvoyeTotal=? AND ea_infoComplementaire=? AND ea_isRetourIncomplet=? AND te_id=? AND de_id=? ";

		int id_Ea_id = 0;
		try {
			// System.out.println(id);
			PreparedStatement st = DbConnection.getInstance().prepareStatement(query);
			st.setDate(1, new Date(expart.getEa_dateCreation().getTime()));

			st.setString(2, expart.getEa_realisePar());
			st.setString(3, expart.getEa_TrackingColis());
			st.setInt(4, expart.getEa_nbArticleEnvoyeTotal());
			st.setString(5, expart.getEa_infoComplementaire());
			st.setBoolean(6, expart.isEa_isRetourIncomplet());
			st.setInt(7, expart.getTe_id());
			st.setInt(8, expart.getDe_id());
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				id_Ea_id = rs.getInt("ea_id");
			}
			rs.close();
			st.close();

		} catch (Exception e) {
		}
		return id_Ea_id;
	}

	public ArrayList<Outil.retourWS> SelectForIndex(int limit, int id) throws ClassNotFoundException {

		String query = "select ea_id as id, DATE_FORMAT(ea_datecreation,'%d/%m/%Y') as date, "
				+ "ea_nbarticleenvoyetotal as nbart, de_nomclub as nomclub "
				+ "from expeditionsarticles EA, destinataires DE where EA.de_id = DE.de_id  ";
		if (id > 0)
			query += " and DE.de_id = " + id;
		query += " and EA.ea_isretourincomplet = false order by EA.ea_dateCreation desc ";
		if (limit > 0)
			query += " limit " + limit;
		System.out.println(query);
		List<Outil.retourWS> listResult = new ArrayList<Outil.retourWS>();

		try {
			Statement st = DbConnection.getInstance().createStatement();
			ResultSet rs = st.executeQuery(query);
			// System.out.println(rs.toString());
			while (rs.next()) {
				Outil.retourWS retour = new Outil.retourWS();
				retour.id = rs.getInt("id");
				retour.dateCreation = rs.getString("date");
				retour.nbArticle = rs.getInt("nbart");
				retour.nomClub = rs.getString("nomclub");
				listResult.add(retour);
			}
			st.close();
			rs.close();
		} catch (SQLException e) {
		}
		return (ArrayList<Outil.retourWS>) listResult;
	}

	public ArrayList<Outil.recusManquants> SelectManquants(int limit) throws ClassNotFoundException {

		String query = "select distinct EA.ea_id as id, " + " DATE_FORMAT(LA.la_dateretour,'%d/%m/%Y') as date, "
				+ " ea_nbarticleenvoyetotal as nbart, " + " de_nomclub as nomclub "
				+ " from expeditionsarticles EA, destinataires DE, lotsarticles as LA " + " where EA.de_id = DE.de_id  "
				+ " and EA.ea_id = LA.ea_id" + " and LA.la_dateretour is not null"
				+ " and EA.ea_isretourincomplet = true " + " order by EA.ea_datecreation desc ";
		if (limit > 0)
			query += "  limit " + limit;

		List<Outil.recusManquants> listResult = new ArrayList<Outil.recusManquants>();

		try {
			Statement st = DbConnection.getInstance().createStatement();
			ResultSet rs = st.executeQuery(query);
			// System.out.println(rs.toString());
			while (rs.next()) {
				Outil.recusManquants retour = new Outil.recusManquants();
				retour.id = rs.getInt("id");
				retour.dateRecep = rs.getString("date");
				retour.nbArticle = rs.getInt("nbart");
				retour.nomClub = rs.getString("nomclub");
				listResult.add(retour);

			}
			st.close();
			rs.close();
		} catch (SQLException e) {
		}
		return (ArrayList<Outil.recusManquants>) listResult;
	}

	public void setRetourIncomplet(int ea_id, boolean ea_isRetourIncomplet) {
		String query = "UPDATE expeditionsarticles SET ea_isRetourIncomplet=? WHERE ea_id=? ";
		try {
			PreparedStatement st = DbConnection.getInstance().prepareStatement(query);

			st.setBoolean(1, ea_isRetourIncomplet);

			// where ID
			st.setInt(2, ea_id);

			st.executeUpdate();
			st.close();
		} catch (Exception e) {
		}
	}

}
