package fr.creasport.webgestionstock.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.creasport.webgestionstock.bean.DestinataireBean;
import fr.creasport.webgestionstock.metier.Destinataire;

public class DestinataireDAO {
	
	public List<Destinataire> findDestinataire(String ref) throws ClassNotFoundException {
		
			List<Destinataire> list = new ArrayList<>();
			ref= "%"+ref+"%";
			String query="SELECT * FROM destinataires WHERE de_ref like ? " ;
			try {
				//System.out.println(name);
				PreparedStatement st = DbConnection.getInstance().prepareStatement(query);
				st.setString(1, ref);
				ResultSet rs=st.executeQuery();
			
				 while (rs.next()){
					 Destinataire dest = new Destinataire();
					 dest.setDe_id( rs.getInt("de_id"));
					 dest.setDe_ref( rs.getString("de_ref"));
						dest.setDe_nomClub(rs.getString("de_nomClub"));
						dest.setDe_nomContact(rs.getString("de_nomContact"));
						dest.setDe_adresse1(rs.getString("de_adresse1"));
						dest.setDe_adresse2(rs.getString("de_adresse2"));
						dest.setDe_codePostal(rs.getString("de_codePostal"));
						dest.setDe_ville(rs.getString("de_ville"));
						dest.setDe_IsClient(rs.getBoolean("de_IsClient"));
						dest.setDe_isActive(rs.getBoolean("de_isActive"));
						dest.setPa_id(rs.getInt("pa_id"));
					 list.add(dest);
				 }
				rs.close();
				st.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			//
			//System.out.println(list);
			return list;
		}
	
}
