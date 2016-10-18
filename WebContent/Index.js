/**
 * 
 */
$(document).ready(
	 function() {
		// préparation de la page
		$('#nomClub').val = "votre choix";

		// Gestion des autocomplete de la recherche club

		var choixClub = [];
		var choixContact = [];
		var data;
		var url = "AutoCompDestinataireExperdierLot?valeur=";
		$.getJSON(url, function(data) {
		  $.each(data, function(key, value) {
			 choixClub.push(value.de_nomClub);
			 choixContact.push(value.de_nomContact);
		  });
		  $("#nomClub").autocomplete(
				{
				  source : choixClub,
				  select : function(event, ui) {
					 $('#nomContact').val("");
					 $('#nomContact').attr("placeholder",
						  data[choixClub.indexOf(ui.item.label)].de_nomContact);
					 console.log($('#nomContact').attr("placeholder"));
				  }
				});
		  $("#nomContact").autocomplete(
				{
				  source : choixContact,
				  select : function(event, ui) {
					 $('#nomClub').val("");
					 console.log($('#nomClub').attr("value"));
					 $('#nomClub').attr("placeholder",
						  data[choixContact.indexOf(ui.item.label)].de_nomClub);

				  }
				});
		});

		// gestion de l'autocomplete des numéros de lot

		var choixLot = [];
		var url = "WSAlotServlet?limit=0";
		$.getJSON(url, function(data) {
		  $.each(data, function(key, value) {
			 choixLot.push(value.ea_nomClub);
			 choixLot.push(value.de_nomContact);
		  });
		  $("#selectLot").autocomplete(
				{
				  source : choixLot,
				  select : function(event, ui) {
					 $('#idLot').val(
						  data[choixLot.indexOf(ui.item.label)].de_nomContact);
				  }
				});
		  $("#nomContact").autocomplete(
				{
				  source : choixContact,
				  select : function(event, ui) {
					 $('#nomClub').val("");
					 console.log($('#nomClub').attr("value"));
					 $('#nomClub').attr("placeholder",
						  data[choixContact.indexOf(ui.item.label)].de_nomClub);

				  }
				});

		});

		// autotcomplte pour les articles
		
		var choixArticle = [];
		var data;
		var url = "WSAlistArticle";
		$.getJSON(url, function(data) {
		  $.each(data, function(key, value) {
			 choixArticle.push(value.nom);
		  });
		  $("#selectArticle").autocomplete({
			 source : choixArticle,
			 select : function(event, ui) {
				$('#selectArticle').val("");
				$('#ArticleId').val(data[choixArticle.indexOf(ui.item.label)].id);
			 }
		  });
		});
		
		// validation de la recherche

		$('#validRecherche').click(
			 function() {
				var err = "";
				if ($('#datedeb').val().length < 5)
				  err += "il manque la date de début ";
				if ($('#datedeb').val().length < 5)
				  err += "il manque la date de début ";
				if ($('#selectArticle').val().length < 5)
				 err += " - il choisir un article ";
				if (err != "")
				  $('#ErrorRecherche').html(err);
				console.log("on envoie : club " + $('#nomClub').val()
					 + ", date deb " + $('#datedeb').val());
			 });
		console.log('fin du javasrcipt');

		// affichage des combo de date en Jquery UI
		$(function() {
		  $("#datedeb").datepicker({
			 dateFormat : "dd/mm/yy",
			 showOn : "button",
			 buttonImage : "images/calendar.gif",
			 buttonImageOnly : true,
			 buttonText : "Cliquer pour avoir un calendrier"
		  });
		});
		$(function() {
		  $("#datefin").datepicker({
			 dateFormat : "dd/mm/yy",
			 showOn : "button",
			 buttonImage : "images/calendar.gif",
			 buttonImageOnly : true,
			 buttonText : "Cliquer pour avoir un calendrier"
		  });
		});
		
		// Chargement du suivi des lots
		
		
		
		// Chargement de l'état des stocks
		
		

		
	 });