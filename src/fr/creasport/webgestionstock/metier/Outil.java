package fr.creasport.webgestionstock.metier;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Outil {
	
	
	public static Date convertStringToDate(String dateString)
	{
	    Date formatteddate = null;
	    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	    try{
			formatteddate = df.parse(dateString);
			//  formatteddate = df.parse(df.format(d1));
	    }
	    catch ( Exception ex ){
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
	}
	public static class recusManquants {
		public int id;
		public String nomClub;
		public String dateRecep;
		public int nbArticle;
		
		public recusManquants() {

		}
	}
	
}
