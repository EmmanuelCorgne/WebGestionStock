<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="fr.creasport.webgestionstock.metier.TypeExpedition"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="UTF-8">
<script src="jquery-3.1.0.min.js"></script>
<link rel="stylesheet" href="ExpedierLot.css" />
<link rel="stylesheet" href="CreaSport.css" />
<link rel="stylesheet" href="dialClub.css" />
<link rel="stylesheet"href="jquery-ui.css">
<script src="jquery-ui.js"></script>
<script src="ExpedierLot.js"></script>
<script src="moment.js"></script>
<script src="Menu.js"></script>
<script src="dialClub.js"></script>

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
	<hr>
	<div class="cadre" name="groupe">
		<div class="conteneur" id="titre1">Information Destinataire</div>
		<div class="conteneur">
			<div class="element">
				<div class="titreInput">Club:</div>
				<div>
					<input type="text" name="club" id="club" Placeholder="Club" />
					<input type="button" value="+" id="addClub" />
				</div>
			</div>
			<div class="vide"></div>
			<div class="element">
				<div class="titreInput2"> Préparé par : <input type="text" name="preparePar" id="preparePar"
					Placeholder="Préparé par" maxlength="05" /></div>
			</div>
			<div class="vide"></div>
			<div class="element">
				 <div class="titreInput2">Le : <input type="text" name="dateEnvoi" id="dateEnvoi"
					Placeholder="date" /></div>
			</div>
		</div>
		<div class="conteneur">
			<div class="element">
				<div class="titreInput">
					<label for="expedition">Expedition : </label>
				</div>
				<div>
					<select name="expedition" id="expedition">
						<%
							List<TypeExpedition> listeTypesExpeditions = (List<TypeExpedition>) request.getAttribute("listoption");
					
						%>
						<%
							for (int i = 0, j = listeTypesExpeditions.size(); i < j; i++) {
								
						%>
						
						<option value="<%=listeTypesExpeditions.get(i).getTe_idString()%>" ><%=listeTypesExpeditions.get(i).getTe_nom()%></option>
						<%
							}
						%>
					</select>
				</div>
			</div>
		</div>

		<div class="conteneur">
			<div class="element">
				<div class="titreInput">N° suivi colis :</div>
				<div>
					<input type="text" name="suiviColis" id="suiviColis"
						Placeholder="N° suvi colis" />
				</div>
			</div>
		</div>
		<div class="conteneur">
			<div class="element">
				<div class="titreInput">
					<label for="ameliorer">Commentaire : </label>
				</div>
				<div>
					<textarea name="commentaire" id="commentaire"
						Placeholder="Commentaire"></textarea>
				</div>
			</div>
		</div>
		<div class="conteneur" id="bouton">
			<div>
				<input type="submit" class="buttonVal" name="valider" id="valider" value="valider" />
			</div>
		</div>
	</div>
	<div class="titre2"></div>
	<div class="cadre" name="groupe">
		<div class="conteneur">Liste des articles</div>
		<div class="conteneur">
			<div class="element">
			<div class="titreInput">Réference :</div>
				 <input type="text" name="reference" id="reference"
					Placeholder="Référence" />
			</div>
			<div class="element">
				<input type="submit" name="ajouter" id="ajouter" class="buttonVal" value="ajouter" />
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
							<th>Supprimer</th>
						</tr>
					</thead>
					<tbody>
						<!-- Corps du tableau -->
					</tbody>
				</table>
			</div>
			<div class="vide"></div><div><h1  id="afficheNbElement"></h1></div>
		</div>
	</div>
<%@include file="dialClub.jsp" %>	
</body>
</html>