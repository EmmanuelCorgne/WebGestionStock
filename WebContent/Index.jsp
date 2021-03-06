<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>CreaSport : Menu général</title>

<link rel="stylesheet" href="CreaSport.css" />
<link rel="stylesheet" href="dialClub.css" />
<link rel="stylesheet" href="jquery-ui.css"> 

<script src="jquery-3.1.0.min.js"></script>

<script src="jquery-ui.js"></script>

<script src="Menu.js"></script>
<script src="Index.js"></script>
<script src="dialClub.js"></script>
<script src="moment.js"></script>


</head>
<body>
	<table id="header" width="100%">
		<tr>
			<td width="10%"><img src="images/logoCreasport&Slogan.png" width="363"
				height="72"></td>
			<td align="center"><h1>Accueil</h1></td>
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
				<td>Club</td>
				<td><input type="text" placeholder="référence du club"
					id="nomClub" value=""> <input type="button" value="+"
					id="addClub" /></td>
				<td>période</td>
				<td><input type="text" placeholder="date de début" size="10"
					id=datedeb> au <input type="text" placeholder="date de fin"
					size="10" id="datefin"></td>
				<td rowspan="3" name="validation"><button class="buttonVal"
						id="validRecherche">Valider</button></td>
			</tr>
			<tr>
				<td>Contact</td>
				<td><input type="text" size="15" placeholder="Nom"
					id="nomContact" /></td>
				<td>Article</td>
				<td><input type="text" placeholder="Nom de l'article"
					size"5" id="selectArticle"><input tpe="text" hidden id="ArticleId"/></td>
			</tr>
			<tr> 
				<td>Lot</td>
				<td><input type="number" placeholder="Num. lot" id="selectLot" />
					<input type="text" hidden id="idLot" /></td>
				<td id="ErrorRecherche" colspan="2"></td>
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
							<th>Nom du club</th>
							<th>Date d'envoi</th>
							<th>Nb articles</th>
							<th>Retour prévue</th>
							<td></td>
						</tr>
					</table>
				</td>
				<td>
					<table class="tab1" id="recus" width="100%">
						<tr>
							<td colspan=10><B name="titregroupe">Reçus manquants</B></td>
						</tr>
						<tr>
							<th>Nom du club</th>
							<th>Date de réception</th>
							<th>nombre de pièce(s) manquante(s)</th>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
<!-- 
 _____ _        _         _             ____  _             _        
| ____| |_ __ _| |_    __| | ___  ___  / ___|| |_ ___   ___| | _____ 
|  _| | __/ _` | __|  / _` |/ _ \/ __| \___ \| __/ _ \ / __| |/ / __|
| |___| || (_| | |_  | (_| |  __/\__ \  ___) | || (_) | (__|   <\__ \
|_____|\__\__,_|\__|  \__,_|\___||___/ |____/ \__\___/ \___|_|\_\___/
 -->
 
 <div name="groupe" id="stock">
<B name="titregroupe">Etat des sttocks</B>
 <table>
 <tr>
 				<td>
					<table class="tab1" id="rupture">
						<tr>
							<td colspan=10><B name="titregroupe">Rupture</B></td>
						</tr>
						<tr>
							<th>Famille (modèle)</th>
							<th>Nom d'article (taille)</th>
							<th>Nombre d'article restants</th>
							<td></td>
						</tr>
					</table>
				</td>
				<td class="tdBorderLeft" hidden>
					<table class="tab1" id="recus" width="100%">
						<tr>
							<td colspan=10><B name="titregroupe">Vendus</B></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
						</tr>
					</table>
				</td>
 </tr>
 </table>
 </div>
 
 <%@include file="dialClub.jsp" %>	
</body>
</html>