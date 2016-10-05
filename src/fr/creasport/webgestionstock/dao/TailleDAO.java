package fr.creasport.webgestionstock.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.creasport.webgestionstock.metier.StockArticle;

public class TailleDAO {

	public TailleDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public String selectNom(int id) throws ClassNotFoundException {
		String Nom="";
		String query="SELECT * FROM tailles WHERE ta_id=?";
		try {
			PreparedStatement st = DbConnection.getInstance().prepareStatement(query);
			st.setInt(1, id);
			ResultSet rs=st.executeQuery();
		    if (rs.next()) {
		    	Nom=rs.getString("ta_nom");
		    }
			rs.close();
			st.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return Nom;
	}
	

}
