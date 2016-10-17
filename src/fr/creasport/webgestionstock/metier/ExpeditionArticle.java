package fr.creasport.webgestionstock.metier;

import java.util.Date;
import java.util.List;

import fr.creasport.webgestionstock.dao.ExpeditionArticleDAO;

public class ExpeditionArticle {
	
	private int ea_id;
	private Date ea_dateCreation;
	private String ea_realisePar;
	private String ea_TrackingColis;
	private int ea_nbArticleEnvoyeTotal;
	private String ea_infoComplementaire;
	private boolean ea_isRetourIncomplet;
	private int te_id;
	private int de_id;
	

	public ExpeditionArticle() {
		// TODO Auto-generated constructor stub
	}

	
	public List<ExpeditionArticle> getAll(){
		ExpeditionArticleDAO dao=new ExpeditionArticleDAO();
		try {
			return dao.SelectAll();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	public int getEa_id() {
		return ea_id;
	}


	public void setEa_id(int ea_id) {
		this.ea_id = ea_id;
	}


	public Date getEa_dateCreation() {
		return ea_dateCreation;
	}


	public void setEa_dateCreation(Date ea_dateRetour) {
		this.ea_dateCreation = ea_dateRetour;
	}


	public String getEa_realisePar() {
		return ea_realisePar;
	}


	public void setEa_realisePar(String ea_realisePar) {
		this.ea_realisePar = ea_realisePar;
	}


	public String getEa_TrackingColis() {
		return ea_TrackingColis;
	}


	public void setEa_TrackingColis(String ea_TrackingColis) {
		this.ea_TrackingColis = ea_TrackingColis;
	}


	public int getEa_nbArticleEnvoyeTotal() {
		return ea_nbArticleEnvoyeTotal;
	}


	public void setEa_nbArticleEnvoyeTotal(int ea_nbArticleEnvoyeTotal) {
		this.ea_nbArticleEnvoyeTotal = ea_nbArticleEnvoyeTotal;
	}


	public boolean isEa_isRetourIncomplet() {
		return ea_isRetourIncomplet;
	}


	public void setEa_isRetourIncomplet(boolean ea_isRetourIncomplet) {
		this.ea_isRetourIncomplet = ea_isRetourIncomplet;
	}


	public int getTe_id() {
		return te_id;
	}

	public void setTe_id(int te_id) {
		this.te_id = te_id;
	}


	public int getDe_id() {
		return de_id;
	}


	public void setDe_id(int de_id) {
		this.de_id = de_id;
	}


	public String getEa_infoComplementaire() {
		return ea_infoComplementaire;
	}


	public void setEa_infoComplementaire(String ea_infoComplementaire) {
		this.ea_infoComplementaire = ea_infoComplementaire;
	}

}
