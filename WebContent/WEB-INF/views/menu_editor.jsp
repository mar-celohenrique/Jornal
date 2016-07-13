<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu</title>
</head>
<body>
	<h2>Menu, Bem-vindo ${editor_logado.nome} </h2>

	<a href="inserirJornalistaFormulario"> Inserir Jornalista </a> <br />
	<a href="listarJornalistas">Listar Jornalistas</a> <br />
	<a href="inserirSecaoFormulario">Inserir Seção</a> <br />
	<a href="listarSecao">Listar Seção</a> <br />
	<a href="listarNoticias">Listar Notícias</a> <br />
	<a href="inserirClassificadoFormulario">Inserir Classificado</a> <br />
	<a href="listarClassificadoEditor?idEditor=${editor_logado.idEditor}">Listar Classificados</a> <br />
	
	
	
	
		
	<a href="logout">Logout</a>
</body>
</html>