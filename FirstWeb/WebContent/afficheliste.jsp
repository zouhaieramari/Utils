<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:choose>
  <c:when test="${not empty erreurDao}"><h1>!!!Erreur !!! <br>${erreurDao}</h1></c:when>
  <c:otherwise></c:otherwise>
</c:choose>

<c:if test="${not empty erreurEnregistgrement}">
<h1>${erreurEnregistgrement}</h1>

</c:if >
<c:if test="${not empty erreurRecheche}">
<h1>${erreurRecheche}</h1>

</c:if >
<table>
<tr><th>nom</th><th>prenom</th><th> email</th><th>date de naissance</th><th>Ajouter</th>
<c:forEach var= "client" items= "${listeClients}">
	<tr>
	<td>${client.nom }</td><td>${client.prenom }</td><td>${client.email }</td><td>${client.dateNaissance }</td>
	<td>
	<form  method="post">
	<input type= "hidden" name="nom" value="${client.nom}" />
	 <input type="submit" value="modifier" name= "modifier" />
	 </form>
	 </td>
		</tr>
</c:forEach>
 
</table>
<br><a href="ClientController">retour</a>

</body>
</html>