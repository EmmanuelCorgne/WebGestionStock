<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html>
    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Saisie Destinataire</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="SaisieDestinataire.js"></script>
      </head>
      <body>
        <form method ="get" action="SaisieDestinataireServlet">
          <input type="text" name="nom" id="nom"/>
          <input type="text" name="prenom" id="prenom"/>
          <input type="text" name="adress" id="adress"/>
            <input type="text" name="pays" id="pays"/>
          <input type="submit" name="ajouterDest" id="ajouterDest" value="ajouterDestinataire"  />
        </form>
      </body>
    </html>
