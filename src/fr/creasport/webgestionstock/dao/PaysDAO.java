package fr.creasport.webgestionstock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.creasport.webgestionstock.metier.Pays;

public class PaysDAO {

	public PaysDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Pays> SelectAll() throws ClassNotFoundException {
		List<Pays> list = new ArrayList<Pays>();
		Pays pays;
		String query="SELECT * FROM pays;"; 
		
		try {
			Statement st = DbConnection.getInstance().createStatement();
		    ResultSet rs = st.executeQuery(query);
		    while (rs.next()){
		    	pays=new Pays();
		    	pays.setPa_id(rs.getInt("pa_id"));	
		    	pays.setPa_code(rs.getString("pa_code"));	
		    	pays.setPa_nom(rs.getString("pa_nom"));		    	
		    	list.add(pays);
		    }
		    st.close();
		    rs.close();
		} catch(SQLException e) {
		}
		return list;
	}
}
