<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Notícias</title>
</head>
<body>
	<h2>Suas notícias</h2>
	<table border="2">
		<tr style="border: 1px solid">
			<td>TITULO</td>
			<td>SUBTITULO</td>
			<td>TEXTO</td>
			<td>IMAGEM</td>
			<td colspan="2">MODIFICAÇÕES</td>
		</tr>
		<c:forEach var="n" items="${noticia}">
			<tr>
				<td>${n.titulo}</td>
				<td>${n.subtitulo}</td>
				<td>${n.texto}</td>
				<td><img alt="${n.idNoticia}" height="350" width="350"
					src="<c:url value="/resources/images/${n.titulo}"  />" /><br /></td>
				<td><a href="alterarNoticiaFormulario?idNoticia=${n.idNoticia}">ALTERAR</a></td>
				<td><a href="removerNoticiaJornalista?idNoticia=${n.idNoticia}">REMOVER</a></td>
			<tr />
		</c:forEach>
	</table>


</body>
</html>