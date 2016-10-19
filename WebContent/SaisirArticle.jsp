<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="fr.creasport.webgestionstock.metier.Taille"%>
<%@ page import="fr.creasport.webgestionstock.metier.Modele"%>
<%@ page import="fr.creasport.webgestionstock.metier.Famille"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="UTF-8">
<script src="jquery-3.1.0.min.js"></script>
<link rel="stylesheet" href="Article.css" />
<link rel="stylesheet" href="CreaSport.css" />
<link rel="stylesheet" href="dialClub.css" />
<link rel="stylesheet" href="jquery-ui.css">
<script src="jquery-ui.js"></script>
<script src="SaisirArticle.js"></script>
<script src="moment.js"></script>
<script src="Menu.js"></script>
<script src="dialClub.js"></script>

<title>Gestion des articles</title>

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
			<h1>Création d'un article</h1>
		</div>
	</div>
	<hr>
	<div class="cadre" name="groupe">
		<div class="conteneur" id="titre1">Article</div>
		<div class="conteneur">
			<div class="element">
				<div class="titreInput2">
					Réference : <input type="text" name="reference" id="reference"
						Placeholder="Réference" readonly/>
				</div>
			</div>
			<div>
				Actif<input type="checkbox" name="actif" id="actif" checked /> Hors
				Catégorie<input type="checkbox" name="isHC" id="isHC" />
			</div>
		</div>

		<div class="vide"></div>
		<div class="conteneur">
			<div class="element">
				<div class="titreInput2">
					Nom : <input type="text" name="nomArticle" id="nomArticle"
						Placeholder="Nom" />
				</div>
			</div>
		</div>

		<div class="conteneur">
			<div class="element">
				<div class="titreInput">
					<label for="famille">Famille : </label>
				</div>
				<div>
					<select name="famille" id="famille">
						<%
							List<Famille> listeFamille = (List<Famille>) request.getAttribute("listFamille");
						%>
						<%
							for (int i = 0, j = listeFamille.size(); i < j; i++) {
						%>
						<option value="<%=listeFamille.get(i).getFa_idString()%>" name ="<%=listeFamille.get(i).getFa_code()%>"><%=listeFamille.get(i).getFa_nom()%></option>
						<%
							}
						%>
					</select>
				</div>
			</div>
		</div>
		<div class="conteneur">
			<div class="element">
				<div class="titreInput">
					<label for="modele">Modéle : </label>
				</div>
				<div>
					<select name="modele" id="modele">
						<%
							List<Modele> listeModele = (List<Modele>) request.getAttribute("listModele");
						%>
						<%
							for (int i = 0, j = listeModele.size(); i < j; i++) {
						%>
						<option value="<%=listeModele.get(i).getMo_idString()%>" name="<%=listeModele.get(i).getMo_code()%>"><%=listeModele.get(i).getMo_nom()%></option>
						<%
							}
						%>
					</select>
				</div>
			</div>
		</div>
		<div class="conteneur">
			<div class="element">
				<div class="titreInput">Quantité :</div>
				<div>
					<input type="number" name="qtArticle" id="qtArticle"
						Placeholder="Quantité" />
				</div>
				
					<div name="taille" id="taille">
						<%
							List<Taille> listeTaille = (List<Taille>) request.getAttribute("listTaille");
						%>
						<%
							for (int i = 0, j = listeTaille.size(); i < j; i++) {
								
						%>
						<input type="checkbox" value="<%=listeTaille.get(i).getTa_idString()%> " id=<%=i%> name=<%=listeTaille.get(i).getTa_nom()%>><%=listeTaille.get(i).getTa_nom()%></option>
						<%
							}
						%>
					</div>
				
			</div>
			<div class="conteneur" id="bouton">
				<div>
					<input type="submit" name="Générer" id="genTaille"
						value="genTaille" />
				</div>
			</div>		
		</div>
		<div class="conteneur" id="bouton">
				<div>
					<input type="submit" name="valider" id="valider" value="valider" />
				</div>
			</div>
	</div>


	<div class="titre2"></div>
	<div class="cadre" name="groupe" id="tabListArticle" name="tabListArticle">
		<div class="conteneur" >Liste des articles par taille</div>
		
		<div class="conteneur" >
			<div>
				<table id="tabArticle" border="1">
					<thead>
						<!-- En-tête du tableau -->
						<tr>
							<th>Ref article</th>
							<th>Taille</th>
							<th>Quantité</th>
							<th>Supprimer</th>
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