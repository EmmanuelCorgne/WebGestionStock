package fr.creasport.webgestionstock.bean;

import sun.util.calendar.BaseCalendar.Date;

public class ArticleBean {
	private String reference;
	private String nom;
	private String image;
	private String description;
	private Boolean isHC;
	private Boolean isActive;
	private int id;
	private int famille;
	private int modele;
	
	

	public ArticleBean() {
		// TODO Auto-generated constructor stub
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsHC() {
		return isHC;
	}

	public void setIsHC(Boolean isHC) {
		this.isHC = isHC;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFamille() {
		return famille;
	}

	public void setFamille(int famille) {
		this.famille = famille;
	}

	public int getModele() {
		return modele;
	}

	public void setModele(int modele) {
		this.modele = modele;
	}

}
