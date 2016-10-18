package fr.creasport.webgestionstock.metier;

public class Modele {
	private int mo_id;
	
	private String mo_code;
	private String mo_nom;

	public Modele() {
		// TODO Auto-generated constructor stub
	}
	public int getMo_id() {
		return mo_id;
	}
	public String getMo_idString() {
		return Integer.toString(mo_id);
	}
	public void setMo_id(int mo_id) {
		this.mo_id = mo_id;
	}

	public String getMo_code() {
		return mo_code;
	}

	public void setMo_code(String mo_code) {
		this.mo_code = mo_code;
	}

	public String getMo_nom() {
		return mo_nom;
	}

	public void setMo_nom(String mo_nom) {
		this.mo_nom = mo_nom;
	}


}
