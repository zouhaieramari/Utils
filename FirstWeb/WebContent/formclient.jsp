<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Saisie client</title>
</head>
<body>
 vous ete connecte: ${compteur.valeur} <br>
vous ete l utilisateurs numero: ${compteurutilisateur.valeur} fois
<form method="post" action="ClientController">
	nom : <input type="text" name="nom" value="${ param.nom}"/>${ erreurNOM}<br/>
	prénom : <input type="text" name="prenom" value="${param.prenom}"/>${ erreurPRENOM}<br/>
	Date de naissance : <input type="date"  name="dateNaissance" value="${param.dateNaissance}"/>${ erreurAGE}<br/>
	email : <input type="email" name="email" value="${param.email}"/>${ erreurEMAIL}<br/>
	<input type="submit" value="Ajouter" name="boutonaction"/>
	<input type="submit" value="selecte" name="selecte"/>
</form>
		<% session.getId(); %>	

</body>
</html>