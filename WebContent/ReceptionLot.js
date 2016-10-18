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
								if ($(this).html() == "Recu") {	
								$(this).closest("tr").children("td").first().html("oui");
								
								}
							});

				});	