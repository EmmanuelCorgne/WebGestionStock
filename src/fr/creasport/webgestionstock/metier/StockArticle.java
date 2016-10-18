package fr.creasport.webgestionstock.metier;

import java.sql.Date;

import fr.creasport.webgestionstock.bean.ArticleStockBean;



public class StockArticle {
	protected int sa_id;
	protected String sa_ref= "";
	protected Date sa_dateCreation;
	protected boolean sa_isActive;
	protected int ar_id;
	protected int ta_id;
	protected int st_id;
	
	
	public void ajouter(ArticleStockBean bean){
		this.sa_ref=bean.getReference();
		this.sa_dateCreation=bean.getDateCreation();
		this.sa_isActive=bean.getIsActive();
		this.ar_id=bean.getArticle();
		this.ta_id=bean.getTaille();
		Statut st=new Statut();
		this.st_id=st.Envoye();

		ArticleDAO dao=new ArticleDAO();
		dao.ajouter(this);
		try {
			return dao.SelectByRef(this.ar_ref);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public String toString() {
		return "StockArticle [sa_id=" + sa_id + ", sa_ref=" + sa_ref + ", sa_isActive=" + sa_isActive + ", ar_id="
				+ ar_id + ", ta_id=" + ta_id + ", st_id=" + st_id + "]";
	}


	public int getSa_id() {
		return sa_id;
	}


	public void setSa_id(int sa_id) {
		this.sa_id = sa_id;
	}


	public String getSa_ref() {
		return sa_ref;
	}


	public void setSa_ref(String sa_ref) {
		this.sa_ref = sa_ref;
	}


	public Date getSa_dateCreation() {
		return sa_dateCreation;
	}


	public void setSa_dateCreation(Date sa_dateCreation) {
		this.sa_dateCreation = sa_dateCreation;
	}


	public boolean isSa_isActive() {
		return sa_isActive;
	}


	public void setSa_isActive(boolean sa_isActive) {
		this.sa_isActive = sa_isActive;
	}


	public int getAr_id() {
		return ar_id;
	}


	public void setAr_id(int ar_id) {
		this.ar_id = ar_id;
	}


	public int getTa_id() {
		return ta_id;
	}


	public void setTa_id(int ta_id) {
		this.ta_id = ta_id;
	}


	public int getSt_id() {
		return st_id;
	}


	public void setSt_id(int st_id) {
		this.st_id = st_id;
	}
	
	
}
