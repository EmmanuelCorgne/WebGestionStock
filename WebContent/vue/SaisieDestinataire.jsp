<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html>
    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Saisie Destinataire</title>
        <link rel="stylesheet" href="SaisieDestinataire.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="SaisieDestinataire.js"></script>
      </head>
      <body>
        <form method ="get" action="SaisieDestinataireServlet">
          Nom : <input type="text" name="nom" id="nom"/><br>
          Prenom : <input type="text" name="prenom" id="prenom"/><br>
          Adresse1 : <input type="text" name="adresse" id="adresse"/><br>
          Adresse2 : <input type="text" name="adresse" id="adresse"/><br>
          Code postal : <input type="text" name="cp" id="cp"/><br>
          Pays : <input type="text" name="pays" id="pays"/><br>
          Deja client <input type="checkbox" name="djclient" id="djclient" value="oui" /><br>
         <div id="afficheRef">Ref Client<input type="text" id="refclient" name="refclient"/></div>
          actif<input type="checkbox" name="actif" id="actif" value="oui" /><br>
          <input type="submit" name="ajouterDest" id="ajouterDest" value="ajouterDestinataire"  />
        </form>
      </body>
    </html>
