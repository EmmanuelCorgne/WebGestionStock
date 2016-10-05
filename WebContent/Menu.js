/**

 */
$(document).ready(function() {
	$('#Menu').html('<a href="ExpedierServlet"><button>Expédier</button></a>'
			+'<a href="ExpedierServlet"><button>Réceptionner</button></a>'
			+'<a href=""><button>Gestion Stock</button></a>' );
	
	// fonction de test, ne pas en tenir compte
	
	$('#validRecherche').click(function() {
		var url = "WebServiceServlet";
		var retour = "...";
		alert('retour');
		$
		.get(url, function(retour) {
			console.log("on lance l'url");
		})
		.fail(function(jqXHR, textStatus, error){
			console.log("Post error: " + error);
		});
		alert(retour);
	});
});