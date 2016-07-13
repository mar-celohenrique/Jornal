<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserir Notícia</title>
</head>
<body>

	<form action="inserirNoticia" method="POST" enctype="multipart/form-data">
		Título: <input type="text" name="titulo" /> <br /> Sub-título: <input
			type="text" name="subtitulo" /> <br /> Data: <input type="text"
			name="data" /><br /> Seção: <select name="nome">
			<c:forEach var="s" items="${secoes}">
				<option>${s.nome}</option>
			</c:forEach>
		</select><br /> Texto:
		<textarea rows="20" cols="20" name="texto"></textarea> <br />
		Imagem: <input type="file" name="imagem"/> <br />
		 <input type="submit"
			value="Cadastrar">
	</form>
</body>
</html>