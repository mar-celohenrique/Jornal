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
	
	<h2>Classificados</h2>
	<label>${c.titulo}</label><br />
	<img alt="${c.idClassificado}" height="350" width="350" src="<c:url value="/resources/images/${c.titulo}"  />" /><br />
	<label>${c.texto}</label><br />
	<label>${c.precoInicial}</label><br />
	<label>${c.telefoneContato}</label><br />
	
	<script>
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id))
				return;
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/pt_BR/sdk.js#xfbml=1&version=v2.6&appId=1632928703594461";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>

	<div class="fb-comments"
		data-href="http://localhost:8080/JornalFinal/detalharClassificado?id=${c.idClassificado}"
		data-numposts="4" data-order-by="time" data-include-parent="true" data-width="500"></div>
	


</body>
</html>