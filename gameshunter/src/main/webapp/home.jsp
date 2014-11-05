<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Games Hunter</title>
<link rel="stylesheet" href="resources/css/reset.css">
<link rel="stylesheet" href="resources/css/gameshunter.css">
</head>
<body class="container">

	<c:import url="cabecalho.jsp" />

	<h1>Bem Vindo</h1>

	<p>Efetue o login</p>
	<form action="">
		Email<input type="text" name="email" /> Senha<input type="password"
			name="senha" /> <input type="submit" value="Logar">
	</form>
	<div>
		<a href="recuperarsenha.jsp">Esqueceu a senha?</a>
	</div>
	<div>
		<a href="cadastrar-usuario.jsp">Cadastra-se</a>
	</div>
	
	<c:import url="rodape.jsp" />
</body>
</html>