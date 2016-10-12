package fr.creasport.webgestionstock.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.creasport.webgestionstock.metier.Famille;
import fr.creasport.webgestionstock.metier.StockArticle;
import fr.creasport.webgestionstock.metier.Taille;

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
	
	public List<Taille> SelectAll() throws ClassNotFoundException {
		List<Taille> list = new ArrayList<Taille>();
		Taille taille;
		String query="SELECT * FROM tailles;";
		
		try {
			Statement st = DbConnection.getInstance().createStatement();
		    ResultSet rs = st.executeQuery(query);
		    while (rs.next()){
		    	taille=new Taille();
		    	taille.setTa_id(rs.getInt("ta_id"));	
		    	taille.setTa_code(rs.getString("ta_code"));	
		    	taille.setTa_nom(rs.getString("ta_nom"));		    	
		    	list.add(taille);
		    }
		    st.close();
		    rs.close();
		} catch(SQLException e) {
		}
		return list;
	}


}
