package fr.creasport.webgestionstock.metier;

import java.util.Date;

public class LotArticle {
	private int la_id;
	private Date la_dateRetour;
	private int sa_id;
	private int ea_id;
	

	@Override
	public String toString() {
		return "LotArticle [la_id=" + la_id + ", la_dateRetour=" + la_dateRetour + ", sa_id=" + sa_id + ", ea_id="
				+ ea_id + "]";
	}


	public LotArticle() {
		// TODO Auto-generated constructor stub
	}


	public int getLa_id() {
		return la_id;
	}


	public void setLa_id(int la_id) {
		this.la_id = la_id;
	}


	public Date getLa_dateRetour() {
		return la_dateRetour;
	}


	public void setLa_dateRetour(Date la_dateRetour) {
		this.la_dateRetour = la_dateRetour;
	}


	public int getSa_id() {
		return sa_id;
	}


	public void setSa_id(int sa_id) {
		this.sa_id = sa_id;
	}


	public int getEa_id() {
		return ea_id;
	}


	public void setEa_id(int ea_id) {
		this.ea_id = ea_id;
	}

}
