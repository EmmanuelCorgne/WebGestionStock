/**
 * 
 */
$(document)
	 .ready(
		  function() {
			 // préparation de la page
			 $('#nomClub').val = "votre choix";
			 $('#validRecherche').click(function() {
				console.log('insérer validRecherche');
			 });
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

			 // création d'un nouveau club
			 var choixPays = [];
			 var data;
			 var url = "WSApaysServlet";
			 $.getJSON(url, function(data) {
				$.each(data, function(key, value) {
				  choixPays.push(value.pa_nom);
				});
				$("#dialClub_pays").autocomplete(
					 {
						source : choixPays,
						select : function(event, ui) {
						  $('#nomContact').val("");
						  $('#dialClub_IDpays').val(
								data[choixPays.indexOf(ui.item.label)].pa_id);
						}
					 });
			 });
			 $("#addClub")
				  .click(
						function() {
						  $('#dialog-club').show();
						  $('#dialClub_valid')
								.click(
									 function() {
										var textErr = "";
										console.log("---"
											 + $('input[name=choix]:checked',
												  '#dialClub_IsClient').length + "---")
										if ($('#dialClub_ref').val.length < 3)
										  textErr += "<br>La référence est obligatoire. ";
										if ($('#dialClub_nom').val.length < 3)
										  textErr += "<br>Il faut am moins 3 caractères pour le noms du club. ";
										if ($('#dialClub_adresse1').val.length < 3)
										  textErr += "<br>La première ligne d'adresse est nécessaire. ";
										if ($('#dialClub_codePostal').val.length < 3)
										  textErr += "<br>Le code postal est obligatoire. ";
										if ($('#dialClub_ville').val.length < 3)
										  textErr += "<br>La ville est obligatoire. ";
										if ($('input[name=choix]:checked',
											 '#dialClub_IsClient').length < 1)
										  textErr += "<br>Le club est il déjà client ? ";
										if (textErr != "")
										  $('#dialClub_err').html(textErr);
									 });

						  $('#dialClub_close').click(function() {
							 $('#dialog-club').hide();
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

			 // validation de la recherche
			 $('#validRecherche').click(function() {

			 });
			 console.log('fin du javasrcipt');

			 // affichage des combo de date en Jquery UI
			 $(function() {
				$("#datedeb").datepicker({
				  showOn : "button",
				  buttonImage : "images/calendar.gif",
				  buttonImageOnly : true,
				  buttonText : "Select date"
				});
			 });
			 $(function() {
				$("#datefin").datepicker({
				  showOn : "button",
				  buttonImage : "images/calendar.gif",
				  buttonImageOnly : true,
				  buttonText : "Select date"
				});
			 });
		  });