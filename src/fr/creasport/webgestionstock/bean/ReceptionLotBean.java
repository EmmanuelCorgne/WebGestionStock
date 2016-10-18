package fr.creasport.webgestionstock.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReceptionLotBean {
	
	protected String club="";
	protected String expedition="";
	protected String ea_realisePar="";
	protected String ea_dateCreation="";
	protected String ea_TrackingColis="";
	protected String ea_nbArticleEnvoyeTotal="";
	protected String ea_infoComplementaire="";
	protected String ea_isRetourIncomplet="";
	
	
	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
	}
	public String getExpedition() {
		return expedition;
	}
	public void setExpedition(int expedition) {
		this.expedition = Integer.toString(expedition);
	}
	public String getEa_realisePar() {
		return ea_realisePar;
	}
	public void setEa_realisePar(String ea_realisePar) {
		this.ea_realisePar = ea_realisePar;
	}
	public String getEa_dateCreation() {
		return ea_dateCreation;
	}
	public void setEa_dateCreation(Date ea_dateCreation) {
		SimpleDateFormat formatDateJour = new SimpleDateFormat("dd/MM/yyyy"); 
		String dateFormatee = formatDateJour.format(ea_dateCreation); 
		this.ea_dateCreation=dateFormatee;
	}
	public String getEa_TrackingColis() {
		return ea_TrackingColis;
	}
	public void setEa_TrackingColis(String ea_TrackingColis) {
		this.ea_TrackingColis = ea_TrackingColis;
	}
	public String getEa_nbArticleEnvoyeTotal() {
		return ea_nbArticleEnvoyeTotal;
	}
	public void setEa_nbArticleEnvoyeTotal(int ea_nbArticleEnvoyeTotal) {
		this.ea_nbArticleEnvoyeTotal =  Integer.toString(ea_nbArticleEnvoyeTotal);
	}
	public String getEa_infoComplementaire() {
		return ea_infoComplementaire;
	}
	public void setEa_infoComplementaire(String ea_infoComplementaire) {
		this.ea_infoComplementaire = ea_infoComplementaire;
	}
	public String getEa_isRetourIncomplet() {
		return ea_isRetourIncomplet;
	}
	public void setEa_isRetourIncomplet(String ea_isRetourIncomplet) {
		this.ea_isRetourIncomplet = ea_isRetourIncomplet;
	}
	
}
