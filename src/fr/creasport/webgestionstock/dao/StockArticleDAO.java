package fr.creasport.webgestionstock.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.creasport.webgestionstock.bean.ArticleBean;
import fr.creasport.webgestionstock.metier.StockArticle;

public class StockArticleDAO {
	//attention il manque la gestion de la date
	public StockArticle selectParRef(String Ref) throws ClassNotFoundException {
			String query="SELECT * FROM stocksarticles WHERE sa_ref=?";
			StockArticle stockArticle = null;
			try {
				PreparedStatement st = DbConnection.getInstance().prepareStatement(query);
				st.setString(1, Ref);
				ResultSet rs=st.executeQuery();
			    if (rs.next()) {
			    	stockArticle=new StockArticle();
			    	stockArticle.setAr_id((rs.getInt("ar_id")));
			    	stockArticle.setSa_id((rs.getInt("sa_id")));
			    	stockArticle.setSt_id((rs.getInt("st_id")));	
			    	stockArticle.setTa_id((rs.getInt("ta_id")));
			    	stockArticle.setSa_isActive(rs.getBoolean("sa_isActive"));
			    	stockArticle.setSa_ref(Ref);
			    }
				rs.close();
				st.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			return stockArticle;
		}

}
