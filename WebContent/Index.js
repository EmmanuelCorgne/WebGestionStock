/**
 * 
 */
$(document).ready(function() {
	// préparation de la page
	$('#nomClub').val = "votre choix";
	$('#validRecherche').click(function() {
		console.log('insérer validRecherche');
	});

	var listClub = [];
	var choixClub = [];
	var choixContact = [];
	var data;
	var url = "AutoCompDestinataireExperdierLot?valeur=";
	$.getJSON(url, function(data) {
		$.each(data, function(key, value) {
			choixClub.push(value.de_nomClub);
			choixContact.push(value.de_nomContact);
		});
		$("#nomClub").autocomplete({
			source : choixClub,
			select : function(event, ui) {
				$('#nomContact').val("");
				$('#nomContact').attr("placeholder",data[choixClub.indexOf(ui.item.label)].de_nomContact);
				console.log($('#nomContact').attr("placeholder"));
			}
		});
		$("#nomContact").autocomplete({
			source : choixContact,
			select : function(event, ui) {
				$('#nomClub').val("");
				console.log($('#nomClub').attr("value"));
				$('#nomClub').attr("placeholder",data[choixContact.indexOf(ui.item.label)].de_nomClub);
				
			}
		});

	});
	console.log('fin du javasrcipt');
	/*
	 * $(function() { var availableTags = listClub; // [ "Pommes", "Poires",
	 * "Abricots", "Prunes", // "Raisins","Pastèques", // "pèches",
	 * "Mirabelles", "Tomates", "Ananas","Lechies", // "Citrons", // "Oranges",
	 * "Mandarines", "Clémentines" ]; $("#nomClub").autocomplete({ source :
	 * availableTags }); });
	 */
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
});

// a voir pour l'index dans l'autocomplete
$("#temp").autocomplete({
	source : [ {
		label : "First",
		idx : 1
	}, {
		label : "Second",
		idx : 2
	}, {
		label : "Third",
		idx : 3
	} ],
	select : function(event, ui) {
		alert(ui.item.idx);
	}
});