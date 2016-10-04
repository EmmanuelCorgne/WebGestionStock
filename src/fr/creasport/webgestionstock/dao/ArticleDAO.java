package fr.creasport.webgestionstock.dao;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.creasport.webgestionstock.bean.ArticleBean;

public class ArticleDAO {

	public ArticleDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void ajouter(ArticleBean article) {
		String query="INSERT INTO artciles VALUES(?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement st = DbConnection.getInstance().prepareStatement(query);
			st.setString(1, article.getReference());
			st.setString(2,article.getNom());
			st.setBoolean(3, article.getIsHC());
			st.setString(4,article.getImage());
			//st.setDate(5,Date.);
			st.setBoolean(6,true );
			st.executeUpdate();
		    st.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void modifier(ArticleBean article) {
		String query="UPDATE article SET ar_ref=?, ar_nom=?,ar_isHC=?, ar_description=?, ar_image=?,ar_isActif "
				+ " WHERE ar_id=?";
		try {
			PreparedStatement st = DbConnection.getInstance().prepareStatement(query);
			st.setString(1, article.getReference());
			st.setString(2, article.getNom());
			st.setBoolean (3, article.getIsHC());
			st.setString(4, article.getDescription());
			st.setString(5, article.getImage());
			st.setBoolean(7, article.getIsActive());
			
			//where ID
			st.setInt(8, article.getId());
			
			st.executeUpdate();
		    st.close();
		} catch(Exception e) {
		}
	}
	
	public void supprimer(int id) throws ClassNotFoundException {
		String query="DELETE FROM article WHERE ar_id=?";
		
		try {
			PreparedStatement st = DbConnection.getInstance().prepareStatement(query);;
			st.setInt(1, id);
			st.executeUpdate();
			st.close();
		} catch(SQLException e) {
		}
	}
	
	public ArrayList<ArticleBean> retrieveAll() throws ClassNotFoundException {
		ArrayList<ArticleBean> list = new ArrayList<ArticleBean>();
		ArticleBean article;
		String query="SELECT * FROM article;";
		
		try {
			Statement st = DbConnection.getInstance().createStatement();
		    ResultSet rs = st.executeQuery(query);
		    while (rs.next()){
		    	article=new ArticleBean();
		    	article.setId(rs.getInt("ar_id"));	
		    	article.setReference(rs.getString("ar_ref"));
		    	article.setNom("ar_nom");
		    	article.setDescription(rs.getString("ar_description"));
		    	article.setImage(rs.getString("ar_image"));
		    	article.setIsHC(rs.getBoolean("ar_isHC"));
		    	article.setIsActive(rs.getBoolean("ar_isActive"));
		    	
		    	list.add(article);
		    }
		    st.close();
		    rs.close();
		} catch(SQLException e) {
		}
		return list;
	}


	public ArticleBean retrieve(int id) throws ClassNotFoundException {
		String query="SELECT * FROM client WHERE ar_id=?";
		ArticleBean article = null;
		try {
			System.out.println(id);
			PreparedStatement st = DbConnection.getInstance().prepareStatement(query);
			st.setInt(1, id);
			ResultSet rs=st.executeQuery();
		    if (rs.next()) {
		    	article=new ArticleBean();
		    	article.setId(rs.getInt("ar_id"));	
		    	article.setReference(rs.getString("ar_ref"));
		    	article.setNom("ar_nom");
		    	article.setDescription(rs.getString("ar_description"));
		    	article.setImage(rs.getString("ar_image"));
		    	article.setIsHC(rs.getBoolean("ar_isHC"));
		    	article.setIsActive(rs.getBoolean("ar_isActive"));
		    }
			rs.close();
			st.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return article;
	}
}