package fr.creasport.webgestionstock.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.creasport.webgestionstock.bean.DestinataireBean;

public class OutilDao {

	
	public void addDestinataire(DestinataireBean bean) {
		String query="INSERT INTO destinataires VALUES(null,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement st = DbConnection.getInstance().prepareStatement(query);
			st.setString(1, bean.getNomClub());
			st.setString(2, bean.getNomClub());
			st.setString(3, bean.getNomContact());
			st.setString(4, bean.getAdresse1());
			st.setString(5, bean.getAdresse2());
			st.setString(6, bean.getCp());
			st.setString(7, bean.getVille());
			st.setString(8, bean.getPays());
			st.setBoolean(9, bean.getDjClient());
			st.setBoolean(10, bean.getActif());
			st.setString(11, bean.getTelephone());
			st.setString(12, bean.getEmail());
			st.executeUpdate();
		    st.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

