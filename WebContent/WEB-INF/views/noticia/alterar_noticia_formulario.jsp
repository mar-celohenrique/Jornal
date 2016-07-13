<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar a Notícia</title>
</head>
<body>

	<h2>Alterar Notícia</h2>

	<form action="alterarNoticia" method="POST">
 		<label>Título</label><input type="text" name="titulo" value="${noticia.titulo}" /><br />
		<label>Subtítulo</label><input type="text" name="subtitulo" value="${noticia.subtitulo}" /><br />
		<label>Data</label><input type="text" name="data" value="${noticia.data}" /><br />
		<label>Texto</label><input type="text" name="texto" value="${noticia.texto}" /><br />
		
		<input type="submit" value="ALTERAR">	
		
		<input type="hidden" name="idNoticia" value="${noticia.idNoticia}" /><br />
		<input type="hidden" name="idSecao" value="${noticia.idSecao}" /><br />
		<input type="hidden" name="idJornalista" value="${noticia.idJornalista}" /><br />	
	
	</form>
</body>
</html>