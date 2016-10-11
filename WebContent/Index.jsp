<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>CreaSport : Menu général</title>

<link rel="stylesheet" href="CreaSport.css" />
<link rel="stylesheet" href="jquery-ui.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	
<script src="jquery-ui.js"></script>
<script src="jquery-3.1.0.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script src="Menu.js"></script>
<script src="Index.js"></script>


</head>
<body>
	<table id="header">
		<tr>
			<td><img src="images/logoCreasport&Slogan.png" width="363"
				height="72"></td>
			<td><h1>Accueil</h1></td>
		</tr>
	</table>

	<nav id="menu"></nav>
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
				<td><input type="text" value"Nom du club id="nomClub"></td>
				<td>période</td>
				<td><input type="text" size="10" id=datedeb> au <input
					type="text" id="datefin" size="10"></td>
				<td rowspan="3" name="validation"><button class="buttonVal" id="validRecherche">Valider</button></td>
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
	<div name="groupe">
		<B name="titregroupe">Suivi des lots</B>
		<table class="tab0">
			<tr>
				<td>
					<table class="tab1" id="envoyes">
						<tr>
							<td colspan=10><B name="titregroupe">Envoyés</B></td>
						</tr>
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
					<table class="tab1" id="recus" width="100%">
						<tr>
							<td colspan=10><B name="titregroupe">Reçus manquants</B></td>
						</tr>
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