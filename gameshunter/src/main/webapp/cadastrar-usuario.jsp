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
	<form method="post" class="cadastro" action="novoUsuario">
		<label>Nome</label><input type="text" name="usuario.nome">
		<br />
		<label>Apelido</label><input type="text" name="usuario.apelido">
		<br />
		<label>E-mail</label><input type="text" name="usuario.email">
		<br />
		<label for="senha">Senha</label><input type="password" id="senha">
		<br />
		<label for="confirmasenha">Confirme sua senha</label><input
			type="password" id="confirmasenha">
		<br />
		<label for="cpf">CPF</label><input type="text" id="cpf"
			name="usuario.cpf">
		<br />
		<label>Telefone</label><input type="text" id="telefone" name="usuario.telefone">
		<br />
		<label for="rg">RG</label><input type="text" id="rg" name="usuario.rg">
		<br />
		<h2 id="sexo">Sexo</h2>
		<br />
		<label for="masulinobtn" id="masculino">Masculino</label><input
			type="radio" name="sexo" id="masculinobtn" name="usuario.sexo"><label
			for="feminino" id="feminino">Feminino</label><input type="radio"
			name="sexo" id="femininobtn" name="usuario.sexo">
		<br />
		<h2 id="dtnasc">Data de Nascimento</h2>
		<br />
		<label for="diabox" id="dia">Dia</label>
		<select id="diabox" name="dia">
			<option>1</option>
		</select>
		<label for="mesbox" id="mes">Mês</label>
		<select id="mesbox" name="mes">
			<option>1</option>
		</select>
		<label for="anobox" id="ano">Ano</label>
		<select id="anobox" name="ano">
			<option>1990</option>
		</select>
		<br />
		<fieldset class="endereco">
			<h2 id="ende">Endereço</h2>
			<br />
			<s:include value="cadastrar-endereco.jsp"></s:include>
		</fieldset>
		<br />
		<input type="submit" value="Enviar" id="enviar">
	</form>
</body>
</html>