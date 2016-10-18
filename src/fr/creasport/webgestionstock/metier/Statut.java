package fr.creasport.webgestionstock.metier;

import fr.creasport.webgestionstock.dao.StatutsDAO;

public class Statut {
	private int st_id;
	private String st_code;
	private String st_nom;
	
	
	
	public Statut() {
		// TODO Auto-generated constructor stub
	}


	public int getSt_id() {
		return st_id;
	}


	public void setSt_id(int st_id) {
		this.st_id = st_id;
	}


	public String getSt_code() {
		return st_code;
	}


	public void setSt_code(String st_code) {
		this.st_code = st_code;
	}


	public String getSt_nom() {
		return st_nom;
	}


	public void setSt_nom(String st_nom) {
		this.st_nom = st_nom;
	}
	
	public int EnStock() throws ClassNotFoundException{
		String code="0";
		StatutsDAO dao=new StatutsDAO();
		return dao.SelectCode(code);
	}
	public int Envoye() throws ClassNotFoundException{
		String code="1";
		StatutsDAO dao=new StatutsDAO();
		return dao.SelectCode(code);
	}
	public int NonRecu() throws ClassNotFoundException{
		String code="2";
		StatutsDAO dao=new StatutsDAO();
		return dao.SelectCode(code);
	}
	public int Vendu() throws ClassNotFoundException{
		String code="3";
		StatutsDAO dao=new StatutsDAO();
		return dao.SelectCode(code);
	}
}
