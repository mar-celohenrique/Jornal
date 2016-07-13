<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Jornalistas</title>
</head>
<body>

	<h2>Jornalistas</h2>
	
	<table  border="2">
		<tr style="border:1px solid">
			<td>ID</td>
			<td>NOME</td>
			<td>LOGIN</td>
			<td>E-MAIL</td>	
		</tr>
		<c:forEach var="j" items="${jornalistas}">
		<tr>
			<td>${j.idJornalista}</td>
			<td>${j.nome}</td>
			<td>${j.login}</td>
			<td>${j.email}</td>
			<tr />
		</c:forEach>
	</table>

</body>
</html>