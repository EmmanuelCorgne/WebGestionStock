/**
 * Saisir un article avec les tailles
 * 
 */
var artJSon;
var artTaille = [];
$(document).ready(
		function() {
			$('#valider').prop('disabled', true);
			$('#valider').click(function() {
				system.out.println(artJSon);
				var url = "WSAArticleServlet?ref=" + escape(ref);
				$.post(url,artJSon);

			});

			// connection ajax pour remplissage du tableau
			$('#genTaille').click(
					function() {
						$('#valider').prop('disabled', false);
						var artTaille = [];
						var ref = $('#reference').val();
						var qty = $('#qtArticle').val();
						var k = 0;

						artJson = {
							reference : ref,
							isActive : $('#actif').checked,
							isHC : $('#isHC').checked,
							nomArticle : $('#nom').val(),
							familleID : $('#famille').val(),
							modeleID : $('#modele').val(),
							artTaille : artTaille
						};

						// Traitement de la checkbox
						while ($("#" + k) != undefined && k <= 10) {

							if ($("#" + k).is(':checked')) {

								$('#valider').prop('disabled', false);
								$("#" + k).prop('checked', false);

								for (var v = 0, j = qty; v < j; v++) {
									var tailleJS = {
										reference : ref + "-" + $("#" + k).name
												+ v,
										taille : $("#" + k).prop('name')
									};
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
