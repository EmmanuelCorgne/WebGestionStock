$(document).ready(function() {

	
	
	$("#djClient").on("click", function() {
		if ($("#afficheRef").css("display") == "block") {
			$("#afficheRef").css("display", "none");
		} else {
			$("#afficheRef").css("display", "block");
		}
	});
});
