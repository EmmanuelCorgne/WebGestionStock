<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Saisir un article</title>
<link rel="stylesheet" href="CreaSport.css" />
<script src="jquery-ui.js"></script>
<script src="jquery-3.1.0.min.js"></script>
<link rel="stylesheet" href="jquery-ui.css">
</head>
<body>
	<form method="get" action="SaisirArticleServlet">
		<div>
			Réference : <input type="text" name="refArticle" id="refArticle" />
			actif<input type="checkbox" name="actif" id="actif" checked /><br>
			Nom : <input type="text" name="nomArticle" id="nomArticle" />
			Hors Categorie<input type="checkbox" name="ishc" id="ishc" /><br>
			Famille : <Select name="famille" id="famille">
				<option value="1" selected>Polo</option>
				<option value="6">Polo</option>
				<option value="2">Maillot</option>
			</select>
			Modèle : <Select name="modele" id="modele">
				<option value="1" selected>Anglirus</option>
				<option value="2">Espagne</option>
				<option value="3">Italie</option>
			</select>

		</div>
		<input type="submit" name="ajouterArticle" id="ajouterArticle"
			value="ajouterArticle" />
	</form>

</body>
</html>