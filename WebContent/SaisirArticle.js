/**
 * Saisir un article avec les tailles
 * 
 */

var art={};
var artTaille = [];
$(document).ready(
		function() {
			$('#valider').prop('disabled', true);
			$('#tabListArticle').hide();
			$('#qtArticle').val(0);
			$('#reference').prop("value","generation automatique");
			var key=Date.now();
			$(document).on(
					"click",
					'#tabArticle a',
					function() {
						if ($(this).html() == "Supprimer") {
							$(this).closest("tr").hide('slow');
							// Supprimer la ligne dans le tableau json
							// avec le
							// champ ref
							artTaille.splice(
									artTaille.indexOf($(this)
											.closest("tr").children(
													"td").html()), 1);
							// desactivation du bp valider si tableau
							// vide
							
							
							if (artTaille.length == 0) {
								$('#valider').prop('disabled', true);
								$('#tabListArticle').hide();
							}
						}
					});
			
			
			$('#valider').click(function() {
				var url = "WSAArticleAddServlet";
			
				art.reference=$('#reference').val();
				art.nom= $('#nomArticle').val();
				art.isActive=$('#actif').is(':checked');
				art.isHC=$('#isHC').is(':checked');
				art.familleID=$('#famille').val();
				console.log("famille "+$('#famille').val());
				console.log("familleart "+art.familleID);
				art.modeleID=$('#modele').val();

				$.post(url, art, function(data) {
					console.log("idartcile"+data);
					var url2 = "WSATailleArticleServlet";
					// console.log(tabJsonStockArticle);
					for (var k = 0; k < artTaille.length; k++) {
						
						artTaille[k].artID = escape(data);
						console.log("arttaille"+artTaille[k].artID);
						$.post(url2, artTaille[k]);
					}
					window.location = 'IndexServlet';
				});
			
			});

			// connection ajax pour remplissage du tableau
			$('#genTaille').click(
					function() {
						
						var qty = $('#qtArticle').val();
						console.log("qty"+$('#qtArticle').val());
						if(qty>=1)
						{
						var ref;
						
						$('#valider').prop('disabled', false);
						$('#tabListArticle').show();
						
						if ($('#isHC').is(':checked')) {
						 ref="HC"+$('#famille').val()+$('#modele').val()+key
						}else{
							ref="CR"+$('#famille').val()+$('#modele').val()+key
						}
						 
						$('#reference').prop("value",ref);
						
						
						var k = 0;
						
					
						// Traitement de la checkbox
						while ($("#" + k).val() != undefined && k <= 10) {

							if ($("#" + k).is(':checked')) {

								$('#valider').prop('disabled', false);
								$("#" + k).prop('checked', false);
								var tailleJS = {
										reference : ref + "-" + $("#" + k).prop('name'),
										tailleID :escape($("#" + k).val()),
										quantite :qty
										};
								artTaille.push(tailleJS);
								var ligne = '<tr>' + '<td>' + ref + "-"
										+ $("#" + k).prop('name') + '</td>'
										+ '<td>' + $("#" + k).prop('name')
										+ '</td>' + '<td>' + qty + '</td>'
										+ '<td><a href="#">Supprimer</a></td>'
										+ '</tr>';
								$(ligne).prependTo("#tabArticle");

							}
							k++;
						}
						}
					});
				

		});
