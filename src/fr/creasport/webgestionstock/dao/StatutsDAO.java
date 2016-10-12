package fr.creasport.webgestionstock.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.creasport.webgestionstock.metier.Famille;
import fr.creasport.webgestionstock.metier.Statut;

public class StatutsDAO {

	public StatutsDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Statut> SelectAll() throws ClassNotFoundException {
		List<Statut> list = new ArrayList<Statut>();
		Statut statut;
		String query="SELECT * FROM statuts;";
		
		try {
			Statement st = DbConnection.getInstance().createStatement();
		    ResultSet rs = st.executeQuery(query);
		    while (rs.next()){
		    	statut=new Statut();
		    	statut.setSt_id(rs.getInt("st_id"));	
		    	statut.setSt_code(rs.getString("st_code"));	
		    	statut.setSt_nom(rs.getString("st_nom"));		    	
		    	list.add(statut);
		    }
		    st.close();
		    rs.close();
		} catch(SQLException e) {
		}
		return list;
	}


	public Statut SelectId(int id) throws ClassNotFoundException {
		String query="SELECT * FROM statuts WHERE st_id=?";
		Statut statut = null;
		try {
			//System.out.println(id);
			PreparedStatement st = DbConnection.getInstance().prepareStatement(query);
			st.setInt(1, id);
			ResultSet rs=st.executeQuery();
		    if (rs.next()) {
		    	statut=new Statut();
		    	statut.setSt_id(rs.getInt("st_id"));	
		    	statut.setSt_code(rs.getString("st_code"));
		    	statut.setSt_nom(rs.getString("st_nom"));

		    }
			rs.close();
			st.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return statut;
	}


}
