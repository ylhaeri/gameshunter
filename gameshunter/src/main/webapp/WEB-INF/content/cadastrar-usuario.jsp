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
<link
	href='http://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<script src="resources/js/jquery-2.1.1.js"></script>
<script src="resources/js/jquery-masked-input-1.4.0.js"></script>
<title>Cadastro - Games Hunter</title>
</head>
<body class="container">
	<h1 id="titulo">Cadastre-se</h1>
	<form method="post" class="cadastro" action="novoUsuario">
		<label for="nome">Nome</label><input type="text" id="nome"
			name="usuario.nome" value="${usuario.nome}">
		<s:fielderror fieldName="usuario.nome"></s:fielderror>
		<br />
		<label for="ape">Apelido</label><input type="text"
			name="usuario.apelido" id="ape" value="${usuario.apelido}">
		<s:fielderror fieldName="usuario.apelido"></s:fielderror>
		<br />
		<label for="mail">E-mail</label><input type="text"
			name="usuario.email" id="mail" value="${usuario.email}">
		<s:fielderror fieldName="usuario.email"></s:fielderror>
		<br />
		<label for="senha">Senha</label><input type="password" id="senha">
		<br />
		<label for="confirmasenha">Confirme sua senha</label><input
			type="password" id="confirmasenha" name="usuario.senha">
		<s:fielderror fieldName="usuario.senha"></s:fielderror>
		<br />
		<label for="cpf">CPF</label><input type="text" id="cpf"
			name="usuario.cpf" value="${usuario.cpf}">
		<s:fielderror fieldName="usuario.cpf"></s:fielderror>
		<br />
		<label for="tel">Telefone</label><input type="text" id="tel"
			name="usuario.telefone" value="${usuario.telefone}">
		<s:fielderror fieldName="usuario.telefone"></s:fielderror>
		<br />
		<label id="sexo" for="dpsexo">Sexo</label><select name="usuario.sexo"
			id="dpsexo">
			<option selected="selected">---Selecione---</option>
		</select>
		<s:fielderror fieldName="usuario.sexo"></s:fielderror>
		<br />
		<label id="dtnasc" for="diabox">Data de Nascimento</label>
		<br />
		<select id="diabox" name="nascDia">
			<option selected="selected">Dia</option>
			<c:forEach var="dia" begin="1" end="31">
				<option>${dia}</option>
			</c:forEach>
		</select><select id="mesbox" name="nascMes">
			<option selected="selected">Mês</option>
		</select><select id="anobox" name="nascAno">
			<option selected="selected">Ano</option>
		</select>
		<br />
		<s:fielderror fieldName="nascDia"></s:fielderror>
		<s:fielderror fieldName="nascMes"></s:fielderror>
		<s:fielderror fieldName="nascAno"></s:fielderror>
		<br />
		<fieldset class="endereco">
			<h2 id="ende">Endereço</h2>
			<br />
			<s:include value="cadastrar-endereco.jsp"></s:include>
		</fieldset>
		<br />
		<input type="submit" value="Enviar" id="enviar">
	</form>
	<script src="resources/js/cadastrar-usuario.js"></script>
	<script src="resources/js/cadastrar-endereco.js"></script>
</body>
</html>