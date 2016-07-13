<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<center>
		<h3>ENTRAR:</h3>
		<form action="login" class="form-inline" method="post">
			<div class="form-group">
				<label for="exampleInputName2">Login</label> <input type="text"
					class="form-control" placeholder="login" name="login">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Senha</label> <input
					type="password" class="form-control" placeholder="senha"
					name="senha">
			</div>
			<button type="submit" class="btn btn-default">ENTRAR</button>
		</form>
</body>
</html>