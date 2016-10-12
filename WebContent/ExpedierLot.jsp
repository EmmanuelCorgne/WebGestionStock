<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="fr.creasport.webgestionstock.metier.TypeExpedition" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="UTF-8">
<script src="jquery-3.1.0.min.js"></script>
<link rel="stylesheet" href="ExpedierLot.css" />
<link rel="stylesheet" href="CreaSport.css" />
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
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
					id="destinataire" Placeholder="Destinataire" />
			</div>
			<div class="element">
				Préparé par : <input type="text" name="preparePar" id="preparePar"
					Placeholder="Préparé par" />
			</div>
			<div class="element">
				Le : <input type="text" name="dateEnvoi" id="dateEnvoi"
					Placeholder="date" />
			</div>
		</div>
		<div class="conteneur">
			<div class="element">
			<label for="expedition">Expedition : </label>
			<select name="expedition" id="expedition" >
			<% List<TypeExpedition> listeTypesExpeditions = (List<TypeExpedition>)request.getAttribute("listoption"); %>
			<% for(int i=0, j=listeTypesExpeditions.size(); i < j ; i++) { %>
				<option value="<% listeTypesExpeditions.get(i).getTe_id(); %>"><%=listeTypesExpeditions.get(i).getTe_nom() %></option>
			<% } %>
			</select>
			</div>
		</div>
		<div class="conteneur">
			<div class="element">
				N° suivi colis : <input type="text" name="suiviColis"
					id="suiviColis" Placeholder="N° suvi colis" />
			</div>
		</div>
		<div class="conteneur">
			<div class="element">
				<label for="ameliorer">Commentaire : </label>
				<textarea name="commentaire" id="commentaire"
					Placeholder="Commentaire"></textarea>
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
				Réference : <input type="text" name="reference" id="reference"
					Placeholder="Référence" />
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