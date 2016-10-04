<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="UTF-8">
<title>CreaSport : Menu général</title>
<link rel="stylesheet" href="CreaSport.css" />
<script src="jquery-ui.js"></script>
<script src="jquery-3.1.0.min.js"></script>
<link rel="stylesheet" href="jquery-ui.css">
<script>
  $( function() {
    $( "#datepicker" ).datepicker({
      showOn: "button",
      buttonImage: "images/calendar.gif",
      buttonImageOnly: true,
      buttonText: "Select date"
    });
  } );
  </script>
</head>
<body>
	<table id="header">
		<tr>
			<td><img src="images/logoCreasport&Slogan.png" width="363" height="72"></td>
			<td><h1>Accueil</h1></td>
		</tr>
	</table>

	<nav id="monMenu">
		<button>Expédier</button>
		<button>Réceptionner</button>
		<button>Gestion Stock</button>
	</nav>
	<hr>
	<B>Rechercher</B>
	<div name="groupe">
		<table id="recherche" width="100%">
			<tr>
				<td>Nom club</td>
				<td><select id="selectClub">
						<option value="value1">Le Mans</option>
						<option value="value1">Nantes</option>
				</select></td>
					<td>période</td>
				<td>
				<input type="text" id="datepicker"> au <input type="text" id="datepicker"> 
				</td>
			<td rowspan="3" name="validation"><button id="validRecherche">Valider</button></td>
			</tr>
			<tr>
			<td>Nom contact</td>
			<td><select id="selectContact">
						<option value="value1">machin</option>
						<option value="value1">truc</option>
				</select>
			</td>
			<td>Nom Article</td>
			<td><select id="selectArticle">
						<option value="value1">AR1</option>
						<option value="value1">AR2</option>
				</select>
			</td>
			</tr>
			<tr>
			<td>Référence lot</td>
			<td><select id="selectLot">
						<option value="value1">001</option>
						<option value="value1">002</option>
				</select>
			</td>
			<td colspan="2"></td>
			</tr>
		</table>
	</div>
	<hr>
	<footer> copyright : site web créé le </footer>
</body>
</html>