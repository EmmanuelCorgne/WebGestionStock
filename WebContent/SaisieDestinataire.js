$(document).ready(function() {
	$("#ajoutPays").keyup(function(){
		$("#pays").append(new Option((prompt('nouveau Pays','FR'))));
	});
	$("#djClient").on("click", function() {
		if ($("#afficheRef").css("display") == "block") {
			$("#afficheRef").css("display", "none");
		} else {
			$("#afficheRef").css("display", "block");
		}
	});
	
	
});
