<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar a Seção</title>
</head>
<body>

	<h2>Alterar Seção</h2>

	<form action="alterarSecao" method="POST">
		<input type="hidden" name="idSecao" value="${secao.idSecao}" />
		<input type="text" name="nome" value="${secao.nome}" />
		<input type="text" name="descricao" value="${secao.descricao}" />
		
		<input type="submit" value="ALTERAR">		
	
	</form>
</body>
</html>