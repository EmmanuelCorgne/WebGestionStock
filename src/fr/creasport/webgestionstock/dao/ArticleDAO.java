package fr.creasport.webgestionstock.dao;



//test commit

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.creasport.webgestionstock.metier.Article;

public class ArticleDAO {

	public ArticleDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void ajouter(Article article) {
		String query="INSERT INTO articles VALUES(null,?,?,?,?,?,null,?,?,?)";
		
		try {
			PreparedStatement st = DbConnection.getInstance().prepareStatement(query);
			
			st.setString(1, article.getAr_ref());
			st.setString(2,article.getAr_nom());
			st.setBoolean(3, article.isAr_isHC());
			st.setString(4,article.getAr_image());
			st.setString(5,article.getAr_description());
			//st.setDate(5,Date.);
			st.setBoolean(6,true );
			
			st.setInt(7, article.getFa_id());
			st.setInt(8, article.getMo_id());
			st.executeUpdate();
		    st.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void modifier(Article article) {
		String query="UPDATE articles SET ar_ref=?, ar_nom=?,ar_isHC=?, ar_description=?, ar_image=?,ar_isActif "
				+ " WHERE ar_id=?";
		try {
			PreparedStatement st = DbConnection.getInstance().prepareStatement(query);
			
			st.setString(1, article.getAr_ref());
			st.setString(2,article.getAr_nom());
			st.setBoolean(3, article.isAr_isHC());
			st.setString(4,article.getAr_image());
			st.setString(5,article.getAr_description());
			
			st.setBoolean(7, article.isAr_isActif());
			
			//where ID
			st.setInt(8, article.getAr_id());
			
			st.executeUpdate();
		    st.close();
		} catch(Exception e) {
		}
	}
	
	public void supprimer(int id) throws ClassNotFoundException {
		String query="DELETE FROM articles WHERE ar_id=?";
		
		try {
			PreparedStatement st = DbConnection.getInstance().prepareStatement(query);;
			st.setInt(1, id);
			st.executeUpdate();
			st.close();
		} catch(SQLException e) {
		}
	}
	
	public List<Article> SelectAll() throws ClassNotFoundException {
		List<Article> list = new ArrayList<Article>();
		Article article;
		String query="SELECT * FROM articles";
		
		try {
			Statement st = DbConnection.getInstance().createStatement();
		    ResultSet rs = st.executeQuery(query);
		    while (rs.next()){
		    	article=new Article();
		    	article.setAr_id(rs.getInt("ar_id"));	
		    	article.setAr_ref(rs.getString("ar_ref"));
		    	article.setAr_nom(rs.getString("ar_nom"));
		    	article.setAr_description(rs.getString("ar_description"));
		    	article.setAr_image(rs.getString("ar_image"));
		    	article.setAr_isHC(rs.getBoolean("ar_isHC"));
		    	article.setAr_isActif(rs.getBoolean("ar_isActif"));
		    	article.setFa_id(rs.getInt("fa_id"));
		    	article.setMo_id(rs.getInt("mo_id"));
		    	
		    	list.add(article);
		    }
		    st.close();
		    rs.close();
		} catch(SQLException e) {
			System.out.println("error : " + e);
		}
		return list;
	}


	public Article SelectById(int id) throws ClassNotFoundException {
		String query="SELECT * FROM articles WHERE ar_id=?";
		Article article = null;
		try {
			//System.out.println(id);
			PreparedStatement st = DbConnection.getInstance().prepareStatement(query);
			st.setInt(1, id);
			ResultSet rs=st.executeQuery();
		    if (rs.next()) {
		    	article=new Article();
		    	article.setAr_id(rs.getInt("ar_id"));	
		    	article.setAr_ref(rs.getString("ar_ref"));
		    	article.setAr_nom(rs.getString("ar_nom"));
		    	article.setAr_description(rs.getString("ar_description"));
		    	article.setAr_image(rs.getString("ar_image"));
		    	article.setAr_isHC(rs.getBoolean("ar_isHC"));
		    	article.setAr_isActif(rs.getBoolean("ar_isActif"));
		    	article.setFa_id(rs.getInt("fa_id"));			    	
		    	article.setMo_id(rs.getInt("mo_id"));	
	
		    }
			rs.close();
			st.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return article;
	}
	
	public int SelectModelleById(int id) throws ClassNotFoundException {
		String query="SELECT mo_id FROM articles WHERE ar_id=?";
		int mo_id = 0;
		try {
			//System.out.println(id);
			PreparedStatement st = DbConnection.getInstance().prepareStatement(query);
			st.setInt(1, id);
			ResultSet rs=st.executeQuery();
		    if (rs.next()) {
		 			    	
		    	mo_id=rs.getInt("mo_id");	
	
		    }
			rs.close();
			st.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return mo_id;
	}
}
