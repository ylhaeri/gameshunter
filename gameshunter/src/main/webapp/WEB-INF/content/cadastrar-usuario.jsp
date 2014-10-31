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
<script src="resources/js/jquery-2.1.1.js"></script>
<script src="resources/js/jquery-masked-input-1.4.0.js"></script>
<script src="resources/js/cadastrar-endereco.js"></script>
</head>
<body class="container">
	<s:fielderror fieldName="usuario.nome"></s:fielderror>
	<h1 id="titulo">Cadastre-se</h1>
	<form method="post" class="cadastro" action="novoUsuario">
		<label for="nome">Nome</label><input type="text" id="nome"
			name="usuario.nome">
		<br />
		<label for="ape">Apelido</label><input type="text"
			name="usuario.apelido" id="ape">
		<br />
		<label for="mail">E-mail</label><input type="text"
			name="usuario.email" id="mail">
		<br />
		<label for="senha">Senha</label><input type="password" id="senha">
		<br />
		<label for="confirmasenha">Confirme sua senha</label><input
			type="password" id="confirmasenha" name="usuario.senha">
		<br />
		<label for="cpf">CPF</label><input type="text" id="cpf"
			name="usuario.cpf">
		<br />
		<label for="tel">Telefone</label><input type="text" id="tel"
			name="usuario.telefone">
		<br />
		<label for="rg">RG</label><input type="text" id="rg" name="usuario.rg">
		<br />
		<label id="sexo" for="gndbx">Sexo</label><select name="usuario.sexo">
			<option selected="selected">---Selecione---</option>
			<c:forEach var="sexo" items="${sexo}">
				<option>${sexo}</option>
			</c:forEach>
		</select>
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
			<c:forEach var="mes" items="${meses}" varStatus="valor">
				<option value="${valor.index}">${mes}</option>
			</c:forEach>
		</select><select id="anobox" name="nascAno">
			<option selected="selected">Ano</option>
			<c:forEach var="ano" items="${anos}">
				<option>${ano}</option>
			</c:forEach>
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
<script type="text/javascript">
	$("#cpf").mask("999.999.999-99")
	$("#tel").mask("?(99)99999-9999")
/* 	$("#enviar").click(function() {
		var teste = $("#anobox").val()
		if (teste.indexOf("no"))
			alert("Sim")
	}) */
</script>
</html>
