<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rational</title>
</head>
<body>
	<h1>Jornal Rational</h1>


	<a href="loginFormulario">Login</a>
	<div id="fb-root"></div>
	<script>
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id))
				return;
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/pt_BR/sdk.js#xfbml=1&version=v2.6&appId=1738125549777066";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>

	<div class="fb-login-button" data-max-rows="2" data-size="small"
		data-show-faces="true" data-auto-logout-link="true"></div>

	<hr />
	<br />
	<a href="listarClassificados">Classificados </a><br />
	<c:forEach var="secao" items="${secoes}">
		<a href="manchetes?id=${secao.idSecao}">${secao.nome} </a>
	</c:forEach>
	<h1>Últimas Noticias</h1>
	<c:forEach var="noticia" items="${noticias}">
		<h2>${noticia.titulo}</h2>
		<h4>${noticia.subtitulo}</h4>
		<a href="visualizarNoticia?id=${noticia.idNoticia}">Ler</a>
	</c:forEach>

</body>
</html>