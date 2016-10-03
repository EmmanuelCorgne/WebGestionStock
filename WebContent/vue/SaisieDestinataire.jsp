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
          Nom club : <input type="text" name="nomClub" id="nomClub"/><br>
          Nom contact : <input type="text" name="nomContact" id="nomContact"/><br>
          Adresse1 : <input type="text" name="adresse1" id="adresse1"/><br>
          Adresse2 : <input type="text" name="adresse2" id="adresse2"/><br>
          Code postal : <input type="text" name="cp" id="cp"/><br>
          Ville : <input type="text" name="ville" id="ville"/><br>
          Pays : <input type="text" name="pays" id="pays"/><br>
          Email : <input type="text" name="email" id="email"/><br>
          Telephone : <input type="text" name="telephone" id="telephone"/><br>
          Deja client <input type="checkbox" name="djClient" id="djClient" value="oui" /><br>
         <div id="afficheRef">Ref Client<input type="text" id="refClient" name="refClient"/></div>
          actif<input type="checkbox" name="actif" id="actif" value=true checked/><br>
          <input type="submit" name="ajouterDest" id="ajouterDest" value="ajouterDestinataire"  />
        </form>
      </body>
    </html>
