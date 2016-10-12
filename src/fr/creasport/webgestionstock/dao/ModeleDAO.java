package fr.creasport.webgestionstock.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.creasport.webgestionstock.metier.Famille;
import fr.creasport.webgestionstock.metier.Modele;

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
	
	public List<Modele> SelectAll() throws ClassNotFoundException {
		List<Modele> list = new ArrayList<Modele>();
		Modele modele;
		String query="SELECT * FROM familles;";
		
		try {
			Statement st = DbConnection.getInstance().createStatement();
		    ResultSet rs = st.executeQuery(query);
		    while (rs.next()){
		    	modele=new Modele();
		    	modele.setMo_id(rs.getInt("mo_id"));	
		    	modele.setMo_code(rs.getString("mo_code"));	
		    	modele.setMo_nom(rs.getString("mo_nom"));		    	
		    	list.add(modele);
		    }
		    st.close();
		    rs.close();
		} catch(SQLException e) {
		}
		return list;
	}
}
