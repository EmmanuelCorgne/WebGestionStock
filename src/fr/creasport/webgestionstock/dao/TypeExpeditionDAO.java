package fr.creasport.webgestionstock.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.creasport.webgestionstock.metier.Statut;
import fr.creasport.webgestionstock.metier.TypeExpedition;

public class TypeExpeditionDAO {

	public TypeExpeditionDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public List<TypeExpedition> SelectAll() throws ClassNotFoundException {
		List<TypeExpedition> list = new ArrayList<TypeExpedition>();
		TypeExpedition typeExpedition;
		String query="SELECT * FROM typesexpeditions";
		
		try {
			Statement st = DbConnection.getInstance().createStatement();
		    ResultSet rs = st.executeQuery(query);
		    while (rs.next()){
		    	typeExpedition=new TypeExpedition();
		    	typeExpedition.setTe_id(rs.getInt("te_id"));	
		    	typeExpedition.setTe_code(rs.getString("te_code"));	
		    	typeExpedition.setTe_nom(rs.getString("te_nom"));		    	
		    	list.add(typeExpedition);
		    }
		    st.close();
		    rs.close();
		} catch(SQLException e) {
		}
		
		return list;
	}


	public TypeExpedition SelectId(int id) throws ClassNotFoundException {
		String query="SELECT * FROM familles WHERE ar_id=?";
		TypeExpedition typeExpedition = null;
		try {
			//System.out.println(id);
			PreparedStatement st = DbConnection.getInstance().prepareStatement(query);
			st.setInt(1, id);
			ResultSet rs=st.executeQuery();
		    if (rs.next()) {
		    	typeExpedition=new TypeExpedition();
		    	typeExpedition.setTe_id(rs.getInt("te_id"));	
		    	typeExpedition.setTe_code(rs.getString("te_code"));
		    	typeExpedition.setTe_nom(rs.getString("te_nom"));

		    }
			rs.close();
			st.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return typeExpedition;
	}


}
