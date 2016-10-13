<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>CreaSport : Menu général</title>

<link rel="stylesheet" href="CreaSport.css" />
<link rel="stylesheet" href="Index.css" />
<link rel="stylesheet" href="jquery-ui.css">

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

	<div id="dialog-club" hidden>
		<h1>Nouveau club</h1>
		<table>
			<tr>
				<td>Référence Club</td>
				<td><input type="text" size="10" placeholder="Obligatoire" id="dialClub_ref" /></td>
			</tr>
			<tr>
				<td>Nom</td>
				<td><input type="text" placeholder="Obligatoire" id="dialClub_nonClub" /></td>
			</tr>
			<tr>
				<td>Nom du contact</td>
				<td><input type="text" id="dialClub_nomContact" /></td>
			</tr>
			<tr>
				<td>Adresse ligne 1</td>
				<td><input type="text" size="30" placeholder="Obligatoire" id="dialClub_adresse1" /></td>
			</tr>
			<tr>
				<td>Adresse ligne 2</td>
				<td><input type="text" size="30" id="dialClub_adresse2" /></td>
			</tr>
			<tr>
				<td>Code postal</td>
				<td><input type="text" size="10" placeholder="Obligatoire" id="dialClub_codePostal" /></td>
			</tr>
			<tr>
				<td>Ville</td>
				<td><input type="text" size="25" placeholder="Obligatoire" id="dialClub_ville" /></td>
			</tr>
			<tr>
				<td colspan="2"><form id="dialClub_IsClient">Déjà client ?
				 <input type="radio" name="choix" value="O"><label for="oui"> Oui</label>
 					<input type="radio" name="choix" value="N"><label for="non"> Non</label>
				</form></td>
			</tr>
			<tr>
				<td>Pays</td>
				<td><input type="text" size="15" id="dialClub_pays" />
				<input hidden value="" id="dialClub_IDpays" /></td>
			</tr>
			<tr>
				<td colspan="2"><div id="dialClub_err"></div></td>
			</tr>
			<tr>
				<td class="tdClub" colspan="2">
					<button class="buttonVal" id="dialClub_valid">Valider</button>
					<button class="buttonVal" id="dialClub_close">Annuler</button>
				</td>
		</table>
	</div>



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
				<td><input type="text size=" 10" placeholder="Nom"
					id="nomContact" /></td>
				<td>Article</td>
				<td><input type="text" placeholder="Nom de l'article"
					size"5" id="selectArticle"></td>
			</tr>
			<tr>
				<td>Lot</td>
				<td><input type="number" placeholder="Num. lot" id="selectLot" />
					<input type="text" hidden id="idLot" /></td>
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
							<th>Ref. Lot nom du club</th>
							<th>Date de réception</th>
							<th>nombre de pièce manquante</th>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>


</body>
</html>