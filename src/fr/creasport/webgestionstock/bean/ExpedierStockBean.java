package fr.creasport.webgestionstock.bean;

public class ExpedierStockBean {

	public ExpedierStockBean() {
		super();	
	}

	protected String sa_ref="";
	protected String mo_nom="";
	protected String ta_nom="";
	protected int sa_id;
	
	
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
	public int getSa_id() {
		return sa_id;
	}
	public void setSa_id(int sa_id) {
		this.sa_id = sa_id;
	}
	@Override
	public String toString() {
		return "ExpedierStockBean [sa_ref=" + sa_ref + ", mo_nom=" + mo_nom + ", ta_nom=" + ta_nom + ", sa_id=" + sa_id
				+ "]";
	}

	
}
