<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
connexion numero: ${compteur.valeur} <br>

vous venez de creer le compte de ${clientAttr.prenom } ${clientAttr.nom }
<table border="blind">
<tr><th>prenom</th><th>nom</th><th> email</th><th>date de naissance</th><th>Ajouter</th>

	<tr>
	<td>${clientAttr.prenom }</td><td>${clientAttr.nom }</td><td>${clientAttr.email }</td><td>${clientAttr.dateNaissance }</td>
	<td>
	<form  method="post">
	<input type= "hidden" name="nom" value="${clientAtt.nom}" />
	 <input type="submit" value="valide" name= "boutonaction" />
	 </form>
	 </td>
	
		</tr>

</table>
<form method="post" action="ClientController">
	nom : <input type="text" name="nom" value="${ param.nom}"/><br/>
	prénom : <input type="text" name="prenom" value="${param.prenom}"/><br/>
	Date de naissance : <input type="date"  name="age" value="${param.age}"/><br/>
	email : <input type="email" name="email" value="${param.email}"/><br/>
	<input type="submit" value="Ajouter" name="boutonaction"/>
</form>
</body>
</html>