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
					$(document)
							.on(
									"click",
									'#tabArticle a',
									function() {
										if ($(this).html() == "Recu") {
											$(this).closest("tr")
													.children("td").first()
													.html("oui");
											var sa_id = $(this).attr("name");
											var ea_id = $('#club').attr("name");
											var url = "SaisirDateLotArticleServlet?ea_id="
													+ escape(ea_id)
													+ "&sa_id="
													+ escape(sa_id);
											$.get(url, function(data) {
												// console.log(data);
											});
										}
									});

					$('#valider').click(function() {
						var i=0;
						var ea_isRetourIncomplet=false;
						while(($("#"+i).val())!= undefined){
							var retour = $("#"+i).html().trim();
							if(retour==("non")){
								ea_isRetourIncomplet=true;
							}
							i++;	
						}
						var ea_id = $('#club').attr("name");
						var url = "SaisirExpeditionArticleServlet?ea_isRetourIncomplet="+escape(ea_isRetourIncomplet)+"&Expediteur=Reception&ea_id="+escape(ea_id);
						$.get(url, function(data) {
						});
						
					});

				});