package fr.creasport.webgestionstock.metier;

import fr.creasport.webgestionstock.bean.ArticleBean;
import fr.creasport.webgestionstock.dao.ArticleDAO;

public class Article {
	protected int ar_id;
	protected String ar_ref="";
	protected String ar_nom="";
	protected boolean ar_isHC;
	protected String ar_description="";
	protected String ar_image ="";
	//protected date ar_dateCreation;
	protected boolean ar_isActif;
	protected int fa_id;
	protected int mo_id;
	
	public void ajouter(ArticleBean articleBean){
		this.ar_ref=articleBean.getReference();
		this.ar_nom=articleBean.getNom();
		this.ar_isHC=articleBean.getIsHC();
		this.ar_description=articleBean.getDescription();
		this.ar_image=articleBean.getImage();
		this.fa_id=articleBean.getFamille();
		this.mo_id=articleBean.getModele();
		ArticleDAO dao=new ArticleDAO();
		dao.ajouter(this);
	}
	
	public void modifier(ArticleBean articleBean){
		this.ar_ref=articleBean.getReference();
		this.ar_nom=articleBean.getNom();
		this.ar_isHC=articleBean.getIsHC();
		this.ar_description=articleBean.getDescription();
		this.ar_image=articleBean.getImage();
		this.fa_id=articleBean.getFamille();
		this.mo_id=articleBean.getModele();
		ArticleDAO dao=new ArticleDAO();
		dao.modifier(this);
	}
	
	public void supprimer(int id){
		ArticleDAO dao=new ArticleDAO();
		try {
			dao.supprimer(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getAr_id() {
		return ar_id;
	}
	public void setAr_id(int ar_id) {
		this.ar_id = ar_id;
	}
	public String getAr_ref() {
		return ar_ref;
	}
	public void setAr_ref(String ar_ref) {
		this.ar_ref = ar_ref;
	}
	public String getAr_nom() {
		return ar_nom;
	}
	public void setAr_nom(String ar_nom) {
		this.ar_nom = ar_nom;
	}
	public boolean isAr_isHC() {
		return ar_isHC;
	}
	public void setAr_isHC(boolean ar_isHC) {
		this.ar_isHC = ar_isHC;
	}
	public String getAr_description() {
		return ar_description;
	}
	public void setAr_description(String ar_description) {
		this.ar_description = ar_description;
	}
	public String getAr_image() {
		return ar_image;
	}
	public void setAr_image(String ar_image) {
		this.ar_image = ar_image;
	}
	public boolean isAr_isActif() {
		return ar_isActif;
	}
	public void setAr_isActif(boolean ar_isActif) {
		this.ar_isActif = ar_isActif;
	}
	public int getFa_id() {
		return fa_id;
	}
	public void setFa_id(int fa_id) {
		this.fa_id = fa_id;
	}
	public int getMo_id() {
		return mo_id;
	}
	public void setMo_id(int mo_id) {
		this.mo_id = mo_id;
	}
	@Override
	public String toString() {
		return "Article [ar_id=" + ar_id + ", ar_ref=" + ar_ref + ", ar_nom=" + ar_nom + ", ar_isHC=" + ar_isHC
				+ ", ar_description=" + ar_description + ", ar_image=" + ar_image + ", ar_isActif=" + ar_isActif
				+ ", fa_id=" + fa_id + ", mo_id=" + mo_id + "]";
	}
	

}
