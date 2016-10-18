// declaration du tableau Json de stockage
var tabJsonStockArticle = [];
var idclub;

$(document)
		.ready(
				function() {
					
					$(function() {
						$("#dateEnvoi").datepicker({
							dateFormat : "dd/mm/yy",
							showOn : "button",
							buttonImage : "images/calendar.gif",
							buttonImageOnly : true,
							buttonText : "Select date"

						});
					});

				
					// gestion des deletes Edit tableau en bas
					$(document).on(
							"click",
							'#tabArticle a',
							function() {
								if ($(this).html() == "Edit") {
									var select = $(this).closest("tr")
											.children("td").html();
									alert(select);
								}
								if ($(this).html() == "Delete") {
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

				});	