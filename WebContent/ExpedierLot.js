$(document).ready(
		function() {
			$(document).on("click", '#tabArticle a', function() {
				if ($(this).html() == "Edit") {
					var select = $(this).closest("tr").children("td").text();
					alert(select);
				}
				if ($(this).html() == "Delete") {
					$(this).closest("tr").hide('slow');
				}
			});

			$('#ajouter').click(
					function() {
						var ref = $('#reference').val();
						var url = "TableauArticleAjaxServlet?valeur="
								+ escape(ref);
						$.getJSON(url, function(data) {
							console.log(data);
							var ligne = '<tr>' + '<td>' + data.sa_ref
									+ '</td>' + '<td>' + data.mo_nom
									+ '</td>' + '<td>' + data.ta_nom
									+ '</td>' + '<td><a href="#">Edit</a></td>'
									+ '<td><a href="#">Delete</a></td>'
									+ '</tr>';
							$(ligne).prependTo("#tabArticle");
						
						});

					});
		});