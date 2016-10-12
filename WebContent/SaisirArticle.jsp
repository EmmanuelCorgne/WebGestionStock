<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="jquery-3.1.0.min.js"></script>
<link rel="stylesheet" href="ExpedierLot.css" />
<link rel="stylesheet" href="CreaSport.css" />
<script src="SaisirArticle.js"></script>
<script src="Menu.js"></script>
<title>Saisir un article</title>
</head>
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
		<h1>Gestion des articles</h1>
	</div>
</div>

<div class="cadre">
	<form method="get" action="SaisirArticleServlet">
		<div class="conteneur">
			<div class="element">
				Réference: <input type="text" name="refArticle" id="refArticle" />
				actif<input type="checkbox" name="actif" id="actif" checked />
			</div>
		</div>
		<div class="conteneur">
			<div class="element">
				Nom : <input type="text" name="nomArticle" id="nomArticle" /> Hors
				Categorie<input type="checkbox" name="ishc" id="ishc" /><br>
			</div>
		</div>
		<div class="conteneur">
			<div class="element">
				Famille : <Select name="famille" id="famille">
					<option value="1" selected>Polo</option>
					<option value="6">Polo</option>
					<option value="2">Maillot</option>
				</select>
				Modéle : <Select name="modele" id="modele">
					<option value="1" selected>Anglirus</option>
					<option value="6">Esperou</option>
				</select>
			</div>
		</div>
		<div class="conteneur">
			<div class="element">
				Quantite : <input type="number" name="quantite" id="quantite" />
			</div>
			<div class="element" id="checkTaille">
				Taille XS : <input type="checkbox" name="tailXS" id="tailXS" />
			</div>
		</div>
		<div class="conteneur" id="bouton">
			<div>
				<input type="submit" name="valider" id="valider" value="valider" />
			</div>
		</div>
	</form>
</div>
<div class="titre2">Gestion des tailles</div>
<div class="cadre">

	<div class="conteneur">
		<div>
			<table id="tabArticle" border="1">
				<thead>
					<!-- En-tête du tableau -->
					<tr>
						<th>Ref article</th>
						<th>Taille</th>
						<th>Quantitz</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<!-- Corps du tableau -->
					<tr>
						<td>test Ref2</td>
						<td>Test Nom2</td>
						<td>Test taille2</td>
						<td><a href="#">Edit</a></td>
						<td><a href="#">Delete</a></td>
					</tr>
					<tr>
						<td>test Ref2</td>
						<td>Test Nom2</td>
						<td>Test taille2</td>
						<td><a href="#">Edit</a></td>
						<td><a href="#">Delete</a></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>