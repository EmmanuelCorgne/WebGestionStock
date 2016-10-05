<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="UTF-8">
<title>CreaSport : Menu général</title>
<link rel="stylesheet" href="CreaSport.css" />
<script src="jquery-ui.js"></script>
<script src="jquery-3.1.0.min.js"></script>
<link rel="stylesheet" href="jquery-ui.css">
<script>
	$(function() {
		$("#datepicker").datepicker({
			showOn : "button",
			buttonImage : "images/calendar.gif",
			buttonImageOnly : true,
			buttonText : "Select date"
		});
	});
</script>
</head>
<body>
	<table id="header">
		<tr>
			<td><img src="images/logoCreasport&Slogan.png" width="363"
				height="72"></td>
			<td><h1>Expedier les lots</h1></td>
		</tr>
	</table>

	<nav id="monMenu">
		<button>Expédier</button>
		<button>Réceptionner</button>
		<button>Gestion Stock</button>
	</nav>
	<hr>
	<!-- 
	 ____           _                   _               
	|  _ \ ___  ___| |__   ___ _ __ ___| |__   ___ _ __ 
	| |_) / _ \/ __| '_ \ / _ \ '__/ __| '_ \ / _ \ '__|
	|  _ <  __/ (__| | | |  __/ | | (__| | | |  __/ |   
	|_| \_\___|\___|_| |_|\___|_|  \___|_| |_|\___|_|   
	 -->
	<div name="groupe">
		<B name="titregroupe">Rechercher</B>
		<table id="recherche" width="100%">
			<tr>
				<td>Nom club</td>
				<td><select id="selectClub">
						<option value="value1">Le Mans</option>
						<option value="value1">Nantes</option>
				</select></td>
				<td>période</td>
				<td><input type="text" id="datepicker"> au <input
					type="text" id="datepicker"></td>
				<td rowspan="3" name="validation"><button id="validRecherche">Valider</button></td>
			</tr>
			<tr>
				<td>Nom contact</td>
				<td><select id="selectContact">
						<option value="value1">machin</option>
						<option value="value1">truc</option>
				</select></td>
				<td>Nom Article</td>
				<td><select id="selectArticle">
						<option value="value1">AR1</option>
						<option value="value1">AR2</option>
				</select></td>
			</tr>
			<tr>
				<td>Référence lot</td>
				<td><select id="selectLot">
						<option value="value1">001</option>
						<option value="value1">002</option>
				</select></td>
				<td colspan="2"></td>
			</tr>
		</table>
	</div>
	<!-- 
	 ____        _       _       _             _       _       
	/ ___| _   _(_)_   _(_)   __| | ___  ___  | | ___ | |_ ___ 
	\___ \| | | | \ \ / / |  / _` |/ _ \/ __| | |/ _ \| __/ __|
	 ___) | |_| | |\ V /| | | (_| |  __/\__ \ | | (_) | |_\__ \
	|____/ \__,_|_| \_/ |_|  \__,_|\___||___/ |_|\___/ \__|___/
	 -->
	<hr>
	<div name="groupe">
		<B name="titregroupe">Suivi des lots</B>
		<table>
			<tr>
				<td>
					<table id="envoyes" width="100%">
						<tr><td colspan=10><B name="titregroupe">Envoyés</B></td></tr>
						<tr>
							<th>Ref. Lot nom du club</th>
							<th>Date d'envoi</th>
							<th>Ref. Lot nom du club</th>
							<th>date retour prévue</th>
							<th></th>
						</tr>
					</table>
				</td>
				<td>
					<table id="recus" width="100%">
						<tr>
							<th>Ref. Lot nom du club</th>
							<th>Date de réception</th>
							<th>nombre de pièce manquante</th>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	<footer> CreaSport &copy; (2016) </footer>
</body>
</html>