<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Notícias</title>
</head>
<body>
<h2>Todas as Notícias</h2>
	<table  border="2">
		<tr style="border:1px solid">
			<td>TITULO</td>
			<td>SUBTITULO</td>
			<td>TEXTO</td>
			<td colspan="2">MODIFICAÇÕES</td>			
		</tr>
		<c:forEach var="n" items="${noticia}">
		<tr>
			<td>${n.titulo}</td>
			<td>${n.subtitulo}</td>
			<td>${n.texto}</td>
			<td><a href="removerNoticiaEditor?idNoticia=${n.idNoticia}">REMOVER</a></td>
			<tr />
		</c:forEach>
	</table>


</body>
</html>