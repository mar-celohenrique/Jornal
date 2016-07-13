<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserir Classificado</title>
</head>
<body>
	<form action="inserirClassificado" method="POST" enctype="multipart/form-data">
		<label>Titulo: </label> <input type="text" name="titulo"><br />
		<label>Texto: </label> <input type="text" name="texto"><br />
		<label>Contato: </label> <input type="text" name="telefoneContato"><br />
		<label>Preço inicial: </label> <input type="text" name="precoInicial"><br />
		<label>Imagem:</label> <input type="file" name="imagem"/> <br />
		 <input	type="SUBMIT" value="Cadastrar">
	</form>

</body>
</html>