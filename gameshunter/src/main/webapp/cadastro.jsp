<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/reset.css">
<title>Cadastro - Games Hunter</title>
</head>
<body>
	<h1>Cadastre-se</h1>
	<form method="post">
		Nome <input type="text" size="80">
		<br />
		Apelido <input type="text">
		<br />
		E-mail <input type="text">
		<br />
		Senha <input type="password">
		<br />
		Confirme sua senha<input type="text">
		<br />
		Sexo Masculino <input type="radio"> Feminino <input
			type="radio">
		<br />
		Data de Nascimento
		<br />
		dia
		<select>
			<option>1</option>
		</select>
		mês
		<select>
			<option>1</option>
		</select>
		ano
		<select>
			<option>1990</option>
		</select>
		<br />
		Endereço
		<br />
		CEP<input type="text">
		<br />
		Logradouro<input type="text">Número<input type="text">
		<br />
		Complemento<input type="text">
		<br />
		Bairro<input type="text">
		<br />
		País
		<select>
			<option>Selecione um país</option>
		</select>
		Estado
		<select>
			<option>Selecione um estado</option>
		</select>
		Cidade
		<select>
			<option>Selecione uma cidade</option>
		</select>
		<br />
		Telefone <input type="text">
		<br />
		RG <input type="text">
		<br />
		<input type="submit" value="Pirocuda">
	</form>
</body>
</html>