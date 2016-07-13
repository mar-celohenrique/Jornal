<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Classificados</title>
</head>
<body>
	<h2>Seus classificados</h2>
	<table border="2">
		<tr style="border: 1px solid">
			<td>TITULO</td>
			<td>TEXTO</td>
			<td>PREÇO INICIAL</td>
			<td>CONTATO</td>
			<td>IMAGEM</td>
			<td colspan="2">MODIFICAÇÕES</td>
		</tr>
		<c:forEach var="c" items="${classificados}">
			<tr>
				<td>${c.titulo}</td>
				<td>${c.texto}</td>
				<td>${c.precoInicial}</td>
				<td>${c.telefoneContato}</td>
				<td><img alt="${c.titulo}"
					src="<c:url value="/resources/images/${c.titulo}"  />" /></td>
				<td><a
					href="alterarClassificadoFormulario?idClassificado=${c.idClassificado}">ALTERAR</a></td>
				<td><a
					href="removerClassificado?idClassificado=${c.idClassificado}">REMOVER</a></td>
			<tr />
		</c:forEach>
	</table>

</body>
</html>