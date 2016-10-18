/**
 * Saisir un article avec les tailles
 * 
 */
var artJSon = [];
var art={};
var artTaille = [];
$(document).ready(
		function() {
			$('#valider').prop('disabled', true);
			$('#valider').click(function() {
				var url = "WSAArticleAddServlet";
			
				art.reference=$('#reference').val();
				art.nom= $('#nom').val();
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
						// console.log(tabJsonStockArticle[k]);
						artTaille[k].artID = escape(data);
						console.log(artTaille[k]);
						$.post(url2, artTaille[k]);
					}
					// $.post(url2, tabJsonStockArticle);

				});
			});

			// connection ajax pour remplissage du tableau
			$('#genTaille').click(
					function() {
						$('#valider').prop('disabled', false);

						var ref = $('#reference').val();
						var qty = $('#qtArticle').val();
						var k = 0;
						//artJSon.push(art);
					
						// Traitement de la checkbox
						while ($("#" + k).val() != undefined && k <= 10) {

							if ($("#" + k).is(':checked')) {

								$('#valider').prop('disabled', false);
								$("#" + k).prop('checked', false);

								for (var v = 0, j = qty; v < j; v++) {
									var tailleJS = {
										reference : ref + "-" + $("#" + k).prop('name')
												+ v,
										taille : $("#" + k).prop('name')
									};
									console.log("TailleJS :"+tailleJS.reference);
									artTaille.push(tailleJS);
								}
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

					});

		});
