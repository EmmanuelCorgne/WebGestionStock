<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="UTF-8">
<script src="jquery-3.1.0.min.js"></script>
<link rel="stylesheet" href="ExpedierLot.css" />
<link rel="stylesheet" href="CreaSport.css" />
<script src="ExpedierLot.js"></script>
<script src="Menu.js"></script>
<title>EXPEDIER LOT</title>
</head>
<body>
	<div id="menuHeader">
		<div>
			<div class="header">
				<div>
					<img src="images/logoCreasport&Slogan.png" width="363" height="72">
				</div>

			</div>
			<div class="header">
				<div>
					<nav id="menu"></nav>
				</div>
			</div>
		</div>
		<div class="titre">
			<h1>Expedier Lot</h1>
		</div>
	</div>

	<div class="cadre" name="groupe">
		<div class="conteneur">
			<div class="element">
				Destinataire: <input type="text" name="destinataire"
					id="destinataire" />
			</div>
			<div class="element">
				Préparé par : <input type="text" name="preparePar" id="preparePar" />
			</div>
			<div class="element">
				Le : <input type="text" name="dateEnvoi" id="dateEnvoi" />
			</div>
		</div>
		<div class="conteneur">
			<div class="element1">
				N° suivi colis : <input type="text" name="suiviColis"
					id="suiviColis" />
			</div>
		</div>
		<div class="conteneur">
			<div class="element">
				<label for="ameliorer">Commentaire : </label>
				<textarea name="commentaire" id="commentaire"></textarea>
			</div>
		</div>
		<div class="conteneur" id="bouton">
			<div>
				<input type="submit" name="valider" id="valider" value="valider" />
			</div>
		</div>
	</div>
	<div class="titre2">Liste des articles</div>
	<div class="cadre" name="groupe">
		<div class="conteneur">
			<div class="element">
				Réference : <input type="text" name="reference" id="reference" />
			</div>
			<div class="element">
				<input type="submit" name="ajouter" id="ajouter" value="ajouter" />
			</div>
			<div id="errBas"></div>
		</div>
		<div class="conteneur">
			<div>
				<table id="tabArticle" border="1">
					<thead>
						<!-- En-tête du tableau -->
						<tr>
							<th>Ref article</th>
							<th>Nom</th>
							<th>Taille</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<!-- Corps du tableau -->
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>