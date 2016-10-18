<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="fr.creasport.webgestionstock.metier.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="UTF-8">
<script src="jquery-3.1.0.min.js"></script>
<link rel="stylesheet" href="ReceptionLot.css" />
<link rel="stylesheet" href="CreaSport.css" />
<link rel="stylesheet"href="jquery-ui.css">
<script src="jquery-ui.js"></script>
<script src="ReceptionLot.js"></script>
<script src="Menu.js"></script>

<title>RECEPTION LOT</title>

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
			<h1>RECEPTION LOT</h1>
		</div>
	</div>
	<hr>
	<div class="cadre" name="groupe">
		<div class="conteneur" id="titre1">Information Destinataire</div>
		<div class="conteneur">
			<div class="element">
				<div class="titreInput">Club:</div>
				<div>
					<input type="text" name="club" id="club" Placeholder="${bean.club}" readonly  />
				</div>
			</div>
			<div class="vide"></div>
			<div class="element">
				<div class="titreInput2"> Préparé par : <input type="text" name="preparePar" id="preparePar"
					Placeholder="${bean.ea_realisePar}" maxlength="05" readonly /></div>
			</div>
			<div class="vide"></div>
			<div class="element">
				 <div class="titreInput2">Le : <input type="text" name="dateEnvoi" id="dateEnvoi"
					Placeholder="${bean.ea_dateCreation}" readonly  /></div>
			</div>
		</div>
		<div class="conteneur">
			<div class="element">
				<div class="titreInput">
					<label for="expedition">Expedition : </label>
				</div>
				<div>
					<select name="expedition" id="expedition">
						<option value="${bean.expedition}" >${bean.expedition}  </option>
					</select>
				</div>
			</div>
		</div>

		<div class="conteneur">
			<div class="element">
				<div class="titreInput">N° suivi colis :</div>
				<div>
					<input type="text" name="suiviColis" id="suiviColis"
						Placeholder="${bean.ea_TrackingColis}" readonly />
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
						Placeholder="${bean.ea_infoComplementaire}" readonly ></textarea>
				</div>
			</div>
		</div>
	</div>
	<div class="titre2"></div>
	<div class="cadre" name="groupe">
		<div class="conteneur">Liste des articles</div>
		<div class="conteneur">
					<div class="titreInput">Réference :</div>
				 <input type="text" name="reference" id="reference"
					Placeholder="Référence" />
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
						<%

						List<StockArticle> listStockArticle = (List<StockArticle>) request.getAttribute("ListStockArticle");
						List<Taille> listTaille = (List<Taille>) request.getAttribute("listTaille");
						List<Modele> listModele = (List<Modele>) request.getAttribute("listModele");
						%>
						<%
						
							for (int i = 0, j = listStockArticle.size(); i < j; i++) {
						%>
						<tr>
							<td><%=listStockArticle.get(i).getSa_ref()%></td>
							<td><%=listTaille.get(i).getTa_nom()%></td>
							<td><%=listModele.get(i).getMo_nom()%></td>
							<td><a href="#">Supprimer</a></td>
						</tr>		
						<%
							}
						%>
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