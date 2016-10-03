package fr.creasport.webgestionstock.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OutilDao {

	
	public void addClient() {
		String query="INSERT INTO client VALUES(?,?)";
		try {
			PreparedStatement st = DbConnection.getInstance().prepareStatement(query);
			st.setString(1, "3");
			st.setString(2, "4");

			st.executeUpdate();
		    st.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

