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
<link rel="stylesheet" href="resources/css/gameshunter.css">
<link rel="stylesheet" href="resources/css/cadastrar-usuario.css">
<title>Cadastro - Games Hunter</title>
</head>
<body class="container">
	<h1 id="titulo">Cadastre-se</h1>
	<form method="post" class="cadastro">
		<label>Nome</label><input type="text" size="50">
		<br />
		<label>Apelido</label><input type="text">
		<br />
		<label>E-mail</label><input type="text">
		<br />
		<label for="senha">Senha</label><input type="password" id="senha">
		<br />
		<label for="confirmasenha">Confirme sua senha</label><input
			type="password" id="confirmasenha">
		<br />
		<h2 id="sexo">Sexo</h2>
		<br />
		<label for="masulinobtn" id="masculino">Masculino</label><input
			type="radio" name="sexo" id="masculinobtn"><label
			for="feminino" id="feminino">Feminino</label><input type="radio"
			name="sexo" id="femininobtn">
		<br />
		<h2 id="dtnasc">Data de Nascimento</h2>
		<br />
		<label for="diabox" id="dia">Dia</label>
		<select id="diabox">
			<option>1</option>
		</select>
		<label for="mesbox" id="mes">Mês</label>
		<select id="mesbox">
			<option>1</option>
		</select>
		<label for="anobox" id="ano">Ano</label>
		<select id="anobox">
			<option>1990</option>
		</select>
		<br />
		<fieldset class="endereco">
			<h2 id="ende">Endereço</h2>
			<br />
			<s:include value="cadastro-endereco.jsp"></s:include>
		</fieldset>
		<br />
		<label>Telefone</label><input type="text">
		<br />
		<label>RG</label><input type="text">
		<br />
		<input type="submit" value="Enviar" id="enviar">
	</form>
</body>
</html>