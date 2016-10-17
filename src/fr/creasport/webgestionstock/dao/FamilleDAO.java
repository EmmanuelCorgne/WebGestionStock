package fr.creasport.webgestionstock.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.creasport.webgestionstock.metier.Famille;

public class FamilleDAO {

	public FamilleDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Famille> SelectAll() throws ClassNotFoundException {
		List<Famille> list = new ArrayList<Famille>();
		Famille famille;
		String query="SELECT * FROM familles";
		
		try {
			Statement st = DbConnection.getInstance().createStatement();
		    ResultSet rs = st.executeQuery(query);
		    while (rs.next()){
		    	famille=new Famille();
		    	famille.setFa_id(rs.getInt("fa_id"));	
		    	famille.setFa_code(rs.getString("fa_code"));	
		    	famille.setFa_nom(rs.getString("fa_nom"));		    	
		    	list.add(famille);
		    }
		    st.close();
		    rs.close();
		} catch(SQLException e) {
		}
		return list;
	}


	public Famille SelectId(int id) throws ClassNotFoundException {
		String query="SELECT * FROM familles WHERE fa_id=?";
		Famille famille = null;
		try {
			//System.out.println(id);
			PreparedStatement st = DbConnection.getInstance().prepareStatement(query);
			st.setInt(1, id);
			ResultSet rs=st.executeQuery();
		    if (rs.next()) {
		    	famille=new Famille();
		    	famille.setFa_id(rs.getInt("fa_id"));	
		    	famille.setFa_code(rs.getString("fa_code"));
		    	famille.setFa_nom(rs.getString("fa_nom"));

		    }
			rs.close();
			st.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return famille;
	}

}
