package fr.creasport.webgestionstock.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.creasport.webgestionstock.bean.DestinataireBean;
import fr.creasport.webgestionstock.metier.Article;
import fr.creasport.webgestionstock.metier.Destinataire;

public class DestinataireDAO {
	
	
	public String ajouter(Destinataire destinataire) {
		String query="INSERT INTO destinataires VALUES(null,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement st = DbConnection.getInstance().prepareStatement(query);
			
			st.setString(1, destinataire.getDe_ref());
			st.setString(2,destinataire.getDe_nomClub());
			st.setString(3, destinataire.getDe_nomContact());
			st.setString(4, destinataire.getDe_adresse1());
			st.setString(5, destinataire.getDe_adresse2());
			st.setString(6, destinataire.getDe_codePostal());
			st.setString(7, destinataire.getDe_ville());
			st.setBoolean(8,destinataire.isDe_IsClient());
			st.setBoolean(9,destinataire.isDe_isActive());
			st.setInt(10, destinataire.getPa_id());

			
			st.executeUpdate();
		    st.close();
		    return("OK");
		} catch(Exception e) {
			e.printStackTrace();
			return(e.getMessage());
		}
	}
	
	public void modifier(Destinataire dest) {
		String query="UPDATE destinataires SET de_ref=?, de_nomClub=?,de_nomContact=?, de_adresse1=?, de_adresse2=?,"
				+ "de_codePostal=?,de_ville=?,de_isClient=?,de_isActif,pa_id=? "
				+ " WHERE de_id=?";
		try {
			PreparedStatement st = DbConnection.getInstance().prepareStatement(query);
			
			st.setString(1, dest.getDe_ref());
			st.setString(2,dest.getDe_nomClub());
			st.setString(3, dest.getDe_nomContact());
			st.setString(4,dest.getDe_adresse1());
			st.setString(5,dest.getDe_adresse2());
			st.setString(6,dest.getDe_codePostal());
			st.setString(7,dest.getDe_ville());
			st.setBoolean(8,dest.isDe_IsClient());
			st.setBoolean(9,dest.isDe_isActive());
			st.setInt(10, dest.getPa_id());

			//where ID
			st.setInt(11, dest.getDe_id());
			
			st.executeUpdate();
		    st.close();
		} catch(Exception e) {
		}
	}
	
	public void supprimer(int id) throws ClassNotFoundException {
		String query="DELETE FROM destintaires WHERE de_id=?";
		
		try {
			PreparedStatement st = DbConnection.getInstance().prepareStatement(query);;
			st.setInt(1, id);
			st.executeUpdate();
			st.close();
		} catch(SQLException e) {
		}
	}
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
