<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Classificado</title>
</head>
<body>

		<h2>Alterar Classificado</h2>

	<form action="alterarClassificado" method="POST">
 		<label>Título</label><input type="text" name="titulo" value="${classificado.titulo}" /><br />
		<label>Texto</label><input type="text" name="texto" value="${classificado.texto}" /><br />
		<label>Preço Inicial</label><input type="text" name="precoInicial" value="${classificado.precoInicial}" /><br />
		<label>Telefone Contato</label><input type="text" name="telefoneContato" value="${classificado.telefoneContato}" /><br />
		
		<input type="submit" value="ALTERAR">	
		
		<input type="hidden" name="idClassificado" value="${classificado.idClassificado}" /><br />
		<input type="hidden" name="idEditor" value="${classificado.idEditor}" /><br />	
	
	</form>

</body>
</html>