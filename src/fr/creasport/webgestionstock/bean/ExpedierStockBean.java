package fr.creasport.webgestionstock.bean;

public class ExpedierStockBean {

	public ExpedierStockBean() {
		super();	
	}
	@Override
	public String toString() {
		return "ExpedierStockBean [sa_ref=" + sa_ref + ", mo_nom=" + mo_nom + ", ta_nom=" + ta_nom + "]";
	}
	protected String sa_ref="";
	protected String mo_nom="";
	protected String ta_nom="";
	
	
	public String getSa_ref() {
		return sa_ref;
	}
	public void setSa_ref(String sa_ref) {
		this.sa_ref = sa_ref;
	}
	public String getMo_nom() {
		return mo_nom;
	}
	public void setMo_nom(String mo_nom) {
		this.mo_nom = mo_nom;
	}
	public String getTa_nom() {
		return ta_nom;
	}
	public void setTa_nom(String ta_nom) {
		this.ta_nom = ta_nom;
	}

	
}
