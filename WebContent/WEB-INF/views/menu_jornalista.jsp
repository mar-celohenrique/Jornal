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
	<h2>Menu, Bem-vindo ${jornalista_logado.nome} </h2>

	<a href="inserirNoticiaFormulario"> Inserir notícia </a> <br />
	<a href="listarNoticiaJornalista?idJornalista=${jornalista_logado.idJornalista}"> Listar notícias </a> <br />
	<a href="buscarNoticiaFormulario">Buscar Notícias</a> <br />
	
	<a href="logout">Logout</a>
</body>
</html>