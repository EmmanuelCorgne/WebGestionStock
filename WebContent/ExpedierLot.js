// declaration du tableau Json de stockage
var tabJsonStockArticle = [];
var idclub;
function activerAjouter() {
	// Active le bouton
	$('#valider').prop('disabled', false);
}

function desactiverAjouter() {
	// Désactive le bouton
	$("#valider").prop('disabled', true);
}

$(document)
		.ready(
				function() {

					$("#dateEnvoi").val(moment().format('DD/MM/YYYY'));
					$(function() {
						$("#dateEnvoi").datepicker({
							dateFormat : "dd/mm/yy",
							showOn : "button",
							buttonImage : "images/calendar.gif",
							buttonImageOnly : true,
							buttonText : "Select date"

						});
					});

					$('#valider')
							.click(
									function() {

										var validerJson = {};
										// date de creation
										validerJson.ea_dateCreation = $(
												'#dateEnvoi').val();
										// realisé par
										validerJson.ea_realisePar = $(
												'#preparePar').val();
										// numero de colis
										validerJson.ea_TrackingColis = $(
												'#suiviColis').val();
										// nb d'acticle
										validerJson.ea_nbArticleEnvoyeTotal = tabJsonStockArticle.length;
										// commentaire
										validerJson.ea_infoComplementaire = $(
												'#commentaire').val();
										// type d'expedition id
										validerJson.te_id = $('#expedition')
												.val();
										// destinataire id
										validerJson.de_id = idclub;
										
										var url = "SaisirExpeditionArticleServlet"
										$
												.post(
														url,
														validerJson,
														function(data) {
															var url2 = "SaisirLotArticleServlet";

															for (var k = 0; k < tabJsonStockArticle.length; k++) {

																tabJsonStockArticle[k].id = escape(data);

																$.post(url2,tabJsonStockArticle[k]);
															}
															window.location = 'IndexServlet';
															window.print();
														});
											
											

									});
					desactiverAjouter();
					// gestion des deletes Edit tableau en bas
					$(document).on(
							"click",
							'#tabArticle a',
							function() {
								if ($(this).html() == "Supprimer") {
									$(this).closest("tr").hide('slow');
									// Supprimer la ligne dans le tableau json
									// avec le
									// champ ref
									tabJsonStockArticle.splice(
											tabJsonStockArticle.indexOf($(this)
													.closest("tr").children(
															"td").html()), 1);
									// desactivation du bp valider si tableau
									// vide
									$('#afficheNbElement').html("il y a "+tabJsonStockArticle.length+" Article(s)");
									
									if (tabJsonStockArticle.length == 0) {
										desactiverAjouter();
										$('#afficheNbElement').html("");
									}
								}
							});
					// connection ajax pour remplissage du tableau
					$('#ajouter')
							.click(
									function() {
										activerAjouter();
										var ref = $('#reference').val();
										var url = "TableauArticleAjaxServlet?ref="
												+ escape(ref);
										$
												.getJSON(
														url,
														function(data) {
															// on test s'il y a
															// la ref dans la
															// base sinon msg
															// d'erreur
															if (data.sa_ref) {
																$('#errBas')
																.html("");
																tabJsonStockArticle
																		.push(data);
																var ligne = '<tr>'
																		+ '<td>'
																		+ data.sa_ref
																		+ '</td>'
																		+ '<td>'
																		+ data.mo_nom
																		+ '</td>'
																		+ '<td>'
																		+ data.ta_nom
																		+ '</td>'
																		+ '<td><a href="#">Supprimer</a></td>'
																		+ '</tr>';
																$(ligne)
																		.prependTo(
																				"#tabArticle");
																
																$('#afficheNbElement').html("il y a "+(tabJsonStockArticle.length)+" Article(s)");
															} else {
																$('#errBas')
																		.html(
																				data);
															}
															;
														});

										$('#reference').val("");
									});
					var JsonAutoCompleteClub = [];
					var url = "AutoCompDestinataireExperdierLot?valeur=";

					$.getJSON(url, function(data) {
						// console.log(data);
						for (var k = 0; k < data.length; k++) {
							JsonAutoCompleteClub.push(data[k].de_nomClub);
						}
						var options = {
							source : JsonAutoCompleteClub,
							select : function(event, ui) {
								idclub = data[JsonAutoCompleteClub
										.indexOf(ui.item.label)].de_id;
								// console.log(data[JsonAutoCompleteClub.indexOf(ui.item.label)].de_nomContact);
							}
						};
						$('#club').autocomplete(options);

					});

					// autoComplete Reference
					var JsonAutoCompleteRef = [];
					var url = "AutoCompRefStockArticle?valeur=";

					$.getJSON(url, function(data) {
						// console.log(data);
						for (var k = 0; k < data.length; k++) {
							// console.log(data[k].sa_ref);
							JsonAutoCompleteRef.push(data[k].sa_ref);
						}
						var options = {
							source : JsonAutoCompleteRef
						};
						$('#reference').autocomplete(options);

					});

				});