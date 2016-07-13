<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserir Jornalista</title>
</head>
<body>

	<form action="inserirJornalista" method="POST">
	<label>Nome: </label> <input type="text" name="nome"><br />
	<label>Login: </label> <input type="text" name="login"><br />
	<label>E-mail: </label> <input type="text" name="email"><br />
	<label>Senha: </label> <input type="password" name="senha"><br />
	<input type="SUBMIT" value="Cadastrar">
	</form>

</body>
</html>