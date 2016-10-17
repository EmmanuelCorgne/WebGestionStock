package fr.creasport.webgestionstock.metier;


public class Destinataire {
	
	protected int de_id;
	protected String de_ref="";
	protected String de_nomClub="";
	protected String de_nomContact="";
	protected String de_adresse1="";
	protected String de_adresse2="";
	protected String de_codePostal="";
	protected String de_ville="";
	protected boolean de_IsClient;
	protected boolean de_isActive;
	protected int pa_id;
	
	public Destinataire() {
		super();
	}

	public int getDe_id() {
		return de_id;
	}
	public void setDe_id(int de_id) {
		this.de_id = de_id;
	}
	public String getDe_ref() {
		return de_ref;
	}
	public void setDe_ref(String de_ref) {
		this.de_ref = de_ref;
	}
	public String getDe_nomClub() {
		return de_nomClub;
	}
	public void setDe_nomClub(String de_nomClub) {
		this.de_nomClub = de_nomClub;
	}
	public String getDe_nomContact() {
		return de_nomContact;
	}
	public void setDe_nomContact(String de_nomContact) {
		this.de_nomContact = de_nomContact;
	}
	public String getDe_adresse1() {
		return de_adresse1;
	}
	public void setDe_adresse1(String de_adresse1) {
		this.de_adresse1 = de_adresse1;
	}
	public String getDe_adresse2() {
		return de_adresse2;
	}
	public void setDe_adresse2(String de_adresse2) {
		this.de_adresse2 = de_adresse2;
	}
	public String getDe_codePostal() {
		return de_codePostal;
	}
	public void setDe_codePostal(String de_codePostal) {
		this.de_codePostal = de_codePostal;
	}
	public String getDe_ville() {
		return de_ville;
	}
	public void setDe_ville(String de_ville) {
		this.de_ville = de_ville;
	}
	public boolean isDe_IsClient() {
		return de_IsClient;
	}
	public void setDe_IsClient(boolean de_IsClient) {
		this.de_IsClient = de_IsClient;
	}
	public boolean isDe_isActive() {
		return de_isActive;
	}
	public void setDe_isActive(boolean de_isActive) {
		this.de_isActive = de_isActive;
	}
	public int getPa_id() {
		return pa_id;
	}
	public void setPa_id(int pa_id) {
		this.pa_id = pa_id;
	}

	@Override
	public String toString() {
		return "Destinataire [de_id=" + de_id + ", de_ref=" + de_ref + ", de_nomClub=" + de_nomClub + ", de_nomContact="
				+ de_nomContact + ", de_adresse1=" + de_adresse1 + ", de_adresse2=" + de_adresse2 + ", de_codePostal="
				+ de_codePostal + ", de_ville=" + de_ville + ", de_IsClient=" + de_IsClient + ", de_isActive="
				+ de_isActive + ", pa_id=" + pa_id + "]";
	}

}
