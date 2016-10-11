package fr.creasport.webgestionstock.bean;

public class DestinataireBean {


		protected String nomClub="";
		protected String nomContact="";
		protected String adresse1=" ";
		protected String adresse2="";
		protected String cp="";
		protected String ville="";
		protected String pays="";
		protected String email="";
		protected String telephone="";
		protected Boolean djClient=true;
		protected Boolean actif=true;
		protected String refClient="";
		
		public DestinataireBean() {
			super();
		}

		public DestinataireBean(String nomClub, String nomContact, String adresse1, String adresse2, String cp,
				String ville, String pays, String email, String telephone, Boolean djClient, Boolean actif, String refClient) {
			super();
			this.nomClub = nomClub;
			this.nomContact = nomContact;
			this.adresse1 = adresse1;
			this.adresse2 = adresse2;
			this.cp = cp;
			this.ville = ville;
			this.pays = pays;
			this.email = email;
			this.telephone = telephone;
			this.djClient = djClient;
			this.actif = actif;
			this.refClient=refClient;
		}
		@Override
	public String toString() {
		return "DestinataireBean [nomClub=" + nomClub + ", nomContact=" + nomContact + ", adresse1=" + adresse1
				+ ", adresse2=" + adresse2 + ", cp=" + cp + ", ville=" + ville + ", pays=" + pays + ", email=" + email
				+ ", telephone=" + telephone + ", djClient=" + djClient + ", actif=" + actif + "]";
	}


		public String getNomClub() {
			return nomClub;
		}

		public void setNomClub(String nomClub) {
			this.nomClub = nomClub;
		}

		public String getNomContact() {
			return nomContact;
		}

		public void setNomContact(String nomContact) {
			this.nomContact = nomContact;
		}

		public String getAdresse1() {
			return adresse1;
		}

		public void setAdresse1(String adresse1) {
			this.adresse1 = adresse1;
		}

		public String getAdresse2() {
			return adresse2;
		}

		public void setAdresse2(String adresse2) {
			this.adresse2 = adresse2;
		}

		public String getCp() {
			return cp;
		}

		public void setCp(String cp) {
			this.cp = cp;
		}

		public String getVille() {
			return ville;
		}

		public void setVille(String ville) {
			this.ville = ville;
		}

		public String getPays() {
			return pays;
		}

		public void setPays(String pays) {
			this.pays = pays;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getTelephone() {
			return telephone;
		}

		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}

		public Boolean getDjClient() {
			return djClient;
		}

		public void setDjClient(Boolean boolean1) {
			this.djClient = boolean1;
		}

		public Boolean getActif() {
			return actif;
		}

		public void setActif(Boolean actif) {
			this.actif = actif;
		}

		public String getRefClient() {
			return refClient;
		}

		public void setRefClient(String refClient) {
			this.refClient = refClient;
		}
	
	
}
