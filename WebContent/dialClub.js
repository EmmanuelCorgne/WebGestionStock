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
										if (!($('#dialClub_ref').val()))
										  textErr += "<br>La référence est obligatoire. ";
										if (!($('#dialClub_nonClub').val()))
										  textErr += "<br>Il faut am moins 3 caractères pour le noms du club. ";
										if (!($('#dialClub_adresse1').val()))
										  textErr += "<br>La première ligne d'adresse est nécessaire. ";
										if (!($('#dialClub_codePostal').val()))
										  textErr += "<br>Le code postal est obligatoire. ";
										if (!($('#dialClub_ville').val()))
										  textErr += "<br>La ville est obligatoire. ";
										if ($('input[name="choix"]:checked',
											 '#dialClub_IsClient').length < 1) {
										  console.log("isClient"
												+ ($('input[name=choix]:checked',
													 '#dialClub_IsClient').val()));
										  textErr += "<br>Le club est il déjà client ? ";
										} else
										  console.log("isClient"
												+ ($('input[name=choix]:checked',
													 '#dialClub_IsClient').val()));
										if (!($('#dialClub_pays').val()))
										  textErr += "<br>il faut choisir un pays. ";

										$('#dialClub_err').html(textErr);
										if (textErr == "") {
										  url = "WSAaddClubServlet";
										  var dataClub = {};
										  dataClub.ref = $('#dialClub_ref').val();
										  dataClub.nom = $('#dialClub_nonClub').val();
										  dataClub.nomContact = $('#dialClub_nomContact')
												.val();
										  dataClub.adr1 = $('#dialClub_adresse1').val();
										  dataClub.adr2 = $('#dialClub_adresse2').val();
										  dataClub.cp = $('#dialClub_codePostal').val();
										  dataClub.ville = $('#dialClub_ville').val();
										  dataClub.isClient = $(
												'input[name=choix]:checked',
												'#dialClub_IsClient').val();
										  dataClub.idpays = $('#dialClub_IDpays').val();
										  console.log(dataClub);
										  $.post(url, dataClub, function(retour) {

										  }).done(function(retour) {
											 if (retour == "OK")
												$('#dialog-club').hide();
											 else {
												textErr = retour;
												$('#dialClub_err').html(textErr);
											 }
										  });
										};
									 });
						  $('#dialClub_close').click(function() {
							 $('#dialog-club').hide();
						  });
						});

		  });