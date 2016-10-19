/**
 * 
 */
$(document).ready(
	 function() {
		// préparation de la page
		$('#nomClub').val = "votre choix";

		// supprimer la ligne après avoir programmé la gestion des stocks
		
		//$('#stock').hide();
		
		// Gestion des autocomplete de la recherche club

		var choixClub = [];
		var choixContact = [];
		var data;
		var idChoixClub = 0;
		var url = "AutoCompDestinataireExperdierLot?valeur=";
		
		// fonction d'ajout d'un nombre de jour à une date en format javascript
		Date.prototype.addDays = function(days) {
		  this.setDate(this.getDate() + parseInt(days));
		  return this;
		};
		
		
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
					 idChoixClub = data[choixClub.indexOf(ui.item.label)].de_id;
				  }
				});
		  $("#nomContact").autocomplete(
				{
				  source : choixContact,
				  select : function(event, ui) {
					 $('#nomClub').val("");
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
/*				if ($('#datedeb').val().length < 5)
				  err += "il manque la date de début ";
				if ($('#datedeb').val().length < 5)
				  err += "il manque la date de début ";
				if ($('#selectArticle').val().length < 5)
				  err += " - il choisir un article ";
*/				if (err != "")
				  $('#ErrorRecherche').html(err);
				else {
				  $('button[name="boutonRecep"').parent().parent().parent().remove();
				  url = "WSarticlesenvoyes?limit=0&id=" + idChoixClub;
					var ArticleEnvoyes = [];
					$.getJSON(url, function(data) {
					  $.each(data, function(key, value) {
						 var parts = value.dateCreation.split('/');
						 // parts[0] : jour;
						 // parts[2] : année;
						 var dateRetour = new Date(parts[2], parts[1], parts[0]).addDays(15);
						 $('#envoyes').append(
							  '<tr><td>' + value.id + ' (' + value.nomClub + ') </td><td>'
									+ value.dateCreation + ' </td><td> ' + value.nbArticle
									+ '</td><td> ' + moment(dateRetour).format('DD/MM/YYYY')
									+ ' </td><td> ' + '<a href="ReceptionLotServlet?ea_id='
									+ value.id
									+ '"><button name="boutonRecep" class="buttonval">Réception</button></a>');
						 ArticleEnvoyes.push(value.nom);
					  });
					});
				};
			 });


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

		url = "WSarticlesenvoyes?limit=5&id=0";
		var ArticleEnvoyes = [];

		$.getJSON(url, function(data) {

		  $.each(data, function(key, value) {
			 var parts = value.dateCreation.split('/');
			 // parts[0] : jour;
			 // parts[2] : année;
			 var dateRetour = new Date(parts[2], parts[1], parts[0]).addDays(15);
			 $('#envoyes').append(
				  '<tr><td>'+ value.nomClub + ' </td><td>'
						+ value.dateCreation + ' </td><td> ' + value.nbArticle
						+ '</td><td> ' + moment(dateRetour).format('DD/MM/YYYY')
						+ ' </td><td> ' + '<a href="ReceptionLotServlet?ea_id='
						+ value.id
						+ '"><button name="boutonRecep" class="buttonval">Réception</button></a>');
			 ArticleEnvoyes.push(value.nom);
		  });
		});

		// Chargement de l'état des stocks

		url = "WSrecusManquants?limit=5";
		var recusManquants = [];

		$.getJSON(
			 url,
			 function(data) {
				$.each(data, function(key, value) {
				  $('#recus').append(
						'<tr><td>'+ value.nomClub + ' </td><td>'
							 + value.dateRecep + ' </td><td> ' + value.nbArticle
							 + '</td><td> ');
				  recusManquants.push(value.nom);
				});

			 }).done(data, function() {
		  if (recusManquants.length == 0)
			 $('#recus').hide();
		  else
			 $('#recus').show();
		});
		console.log('fin du javasrcipt');
	 });


    var listRupture = [];
		url = "WSruptureArticle?limit=5";
    
    $.getJSON(
    	 url,
    	 function(data) {
    		$.each(data, function(key, value) {
    		  $('#rupture').append(
    				'<tr><td>'+ value.famille + '('+value.modele+') </td><td>'
    					 + value.article +'('+value.taille+ ') </td><td> ' + value.nbArticle
    					 + '</td><td> ');
    		  console.log('test');
    		  listRupture.push(value.nom);
    		});
    
    	 })
    	 .done(data, function() {
      if (listRupture.length == 0)
    	 $('#rupture').hide();
      else
    	 $('#rupture').show();
    });
