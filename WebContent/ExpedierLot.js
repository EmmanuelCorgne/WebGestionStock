// declaration du tableau Json de stockage
var tabJsonStockArticle = [];

function activerAjouter() {
	// Active le bouton
	$('#valider').prop('disabled', false);
}

function desactiverAjouter() {
	// Désactive le bouton
	$("#valider").prop('disabled', true);
}

$(document).ready(
		function() {

			desactiverAjouter();

			$(document).on(
					"click",
					'#tabArticle a',
					function() {
						if ($(this).html() == "Edit") {
							var select = $(this).closest("tr").children("td")
									.html();
							alert(select);
						}
						if ($(this).html() == "Delete") {
							$(this).closest("tr").hide('slow');
							// Supprimer la ligne dans le tableau json avec le
							// champ ref
							tabJsonStockArticle.splice(tabJsonStockArticle
									.indexOf($(this).closest("tr").children(
											"td").html()), 1);
							// desactivation du bp valider si tableau vide
							if (tabJsonStockArticle.length == 0) {
								desactiverAjouter();
							}
						}
					});
			$('#ajouter').click(
					function() {
						activerAjouter();
						var ref = $('#reference').val();
						var url = "TableauArticleAjaxServlet?ref="
								+ escape(ref);
						$.getJSON(url, function(data) {
							// on test s'il y a la ref dans la base sinon msg d'erreur
							if (data.sa_ref) {
								tabJsonStockArticle.push(data);
								var ligne = '<tr>' + '<td>' + data.sa_ref
										+ '</td>' + '<td>' + data.mo_nom
										+ '</td>' + '<td>' + data.ta_nom
										+ '</td>'
										+ '<td><a href="#">Edit</a></td>'
										+ '<td><a href="#">Delete</a></td>'
										+ '</tr>';
								$(ligne).prependTo("#tabArticle");
							} else {
								$('#errBas').html(data);
							}
							;
						});

					});
		});