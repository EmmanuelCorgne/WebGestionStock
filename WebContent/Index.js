/**
 * 
 */
$(document).ready(function() {
	// préparation de la page
	$('#nomClub').val = "votre choix";
	$('#validRecherche').click(function() {
		var url = "WebServiceServlet";
		var retour = "...";
		alert('retour');
		$.get(url, function(retour) {
			console.log("on lance l'url");
		}).fail(function(jqXHR, textStatus, error) {
			console.log("Post error: " + error);
		});
		alert(retour);
	});	
	
});
$(function() {
	$("#datedeb").datepicker({
		showOn : "button",
		buttonImage : "images/calendar.gif",
		buttonImageOnly : true,
		buttonText : "Select date"
	});
});
$(function() {
	$("#datefin").datepicker({
		showOn : "button",
		buttonImage : "images/calendar.gif",
		buttonImageOnly : true,
		buttonText : "Select date"
	});
});
$(function() {
	var availableTags = [ "Pommes", "Poires", "Abricots", "Prunes", "Raisins",
			"Pastèques", "pèches", "Mirabelles", "Tomates", "Ananas",
			"Lechies", "Citrons", "Oranges", "Mandarines", "Clémentines" ];
	$("#fruits").autocomplete({
		source : availableTags
	});
});
// a voir pour l'index dans l'autocomplete
$( ".selector" ).autocomplete({
	   source: [{label:"First", idx:1},
	            {label:"Second", idx:2},
	            {label:"Third", idx:3}],
	   select: function(event, ui) { alert(ui.item.idx); }
	});