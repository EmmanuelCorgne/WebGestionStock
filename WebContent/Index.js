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
	$.ajax({
		url : "WSAclubServlet",
		type : "GET",
		dataType : 'json',
		contentType : 'application/json; charset=utf-8',
		success : function(retour) {
			console.log('-------------> ' + retour);
			$.each(retour, function(key, value) {
				var temp = "<tr><td>";
				temp += value.firstname;
				temp += "</td><td>";
				temp += value.lastname;
				temp += "</td><td>";
				temp += value.address;
				temp += "</td><td>";
				temp += '<button value="' + value.id
						+ '" name="del">Supprimer</button> (' + value.id
						+ ')';
				temp += "</td></tr>";
				// $('#tab_customers').append(temp);
			});
			listClub = ['FC Nantes','MSB','Manchester'];
			// $('#lister').hide();
		},
		error : function(error) {
			listClub = ["error","Niort"];
			console.log("le get ne fonctionne pas : " + error);
		}
	});
	$(function() {
		var availableTags = listClub;
		// [ "Pommes", "Poires", "Abricots", "Prunes", "Raisins","Pastèques",
		// "pèches", "Mirabelles", "Tomates", "Ananas","Lechies", "Citrons",
		// "Oranges", "Mandarines", "Clémentines" ];
		$("#nomClub").autocomplete({
			source : availableTags
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
});


// a voir pour l'index dans l'autocomplete
$(".selector").autocomplete({
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