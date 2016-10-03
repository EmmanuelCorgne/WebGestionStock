package fr.creasport.webgestionstock.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.creasport.webgestionstock.bean.DestinataireBean;

public class OutilDao {

	
	public void addDestinataire(DestinataireBean bean) {
		String query="INSERT INTO destinataires VALUES(null,'',?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement st = DbConnection.getInstance().prepareStatement(query);
			
			st.setString(1, bean.getNomClub());
			st.setString(2, bean.getNomContact());
			st.setString(3, bean.getAdresse1());
			st.setString(4, bean.getAdresse2());
			st.setString(5, bean.getCp());
			st.setString(6, bean.getVille());
			st.setString(7, bean.getPays());
			st.setString(8, bean.getDjClient());
			st.setString(9, bean.getActif());
			st.setString(10, bean.getTelephone());
			st.setString(11, bean.getEmail());
			
			st.executeUpdate();
		    st.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

