package fr.creasport.webgestionstock.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModeleDAO {
	
	public String selectNom(int id) throws ClassNotFoundException {
		String Nom="";
		String query="SELECT * FROM modeles WHERE mo_id=?";
		try {
			PreparedStatement st = DbConnection.getInstance().prepareStatement(query);
			st.setInt(1, id);
			ResultSet rs=st.executeQuery();
		    if (rs.next()) {
		    	Nom=rs.getString("mo_nom");
		    }
			rs.close();
			st.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return Nom;
	}
}
