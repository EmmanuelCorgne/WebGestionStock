/**
 * 
 */
$(document)
	 .ready(
		  function() {
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

		  });