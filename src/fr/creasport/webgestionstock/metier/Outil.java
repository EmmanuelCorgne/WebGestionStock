package fr.creasport.webgestionstock.metier;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Outil {

	public static Date convertStringToDate(String dateString) {
		Date formatteddate = null;
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try {
			formatteddate = df.parse(dateString);
			// formatteddate = df.parse(df.format(d1));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return formatteddate;
	}

	public static class retourWS {
		public int id;
		public String dateCreation;
		public int nbArticle;
		public String nomClub;

		public retourWS() {

		}

		@Override
		public String toString() {
			return "retourWS [id=" + id + ", dateCreation=" + dateCreation + ", nbArticle=" + nbArticle + ", nomClub="
					+ nomClub + "]";
		}
	}

	public static class recusManquants {
		public int id;
		public String nomClub;
		public String dateRecep;
		public int nbArticle;

		public recusManquants() {

		}

		@Override
		public String toString() {
			return "recusManquants [id=" + id + ", nomClub=" + nomClub + ", dateRecep=" + dateRecep + ", nbArticle="
					+ nbArticle + "]";
		}
	}

	public static class stockArticlesRupture {
		public String famille;
		public String modele;
		public String article;
		public String taille;
		public int nbArticle;

		public stockArticlesRupture() {

		}

		@Override
		public String toString() {
			return "stockArticlesRupture [famille=" + famille + ", modele=" + modele + ", article=" + article + ", taille="
					+ taille + ", nbArticle=" + nbArticle + "]";
		}

	}

}
