/**
 */
$(document).ready(function() {
	var nomPage = $(document).attr("URL");
	nomPage = nomPage.split("/");
	nomPage = nomPage[nomPage.length - 1];
	//nom = nom.substr(0, nom.lastIndexOf("."));
	//nom = nom.replace(new RegExp("(%20|_|-)", "g"), "");
	//alert(nomPage);
	var menu = "";
	// construction du menu en fonction de page courante
	if (nomPage != "IndexServlet")
		menu += '<a href="IndexServlet"><button>Menu général</button></a>';
	if (nomPage != "ExpedierServlet")
		menu += '<a href="ExpedierServlet"><button>Expédier</button></a>';
//	if (nomPage != "ReceptionLotServlet")
//		menu += '<a href="ReceptionLotServlet"><button>Réceptionner</button></a>';
	if (nomPage != "SaisirArticleServlet")
		menu += '<a href="SaisirArticleServlet"><button>Gestion Stock</button></a>';
	
	$('#menu').html(menu);
	$('body').append("<footer> CreaSport &copy; (2016) </footer>");
});