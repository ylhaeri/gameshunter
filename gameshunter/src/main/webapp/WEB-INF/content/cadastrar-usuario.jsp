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
	<s:form method="post" class="cadastro" action="novoUsuario">
		<s:textfield label="Nome" labelposition="top" labelSeparator=""
			id="nome" name="usuario.nome" value="%{usuario.nome}"
			errorPosition="bottom"></s:textfield>
		<s:textfield label="Apelido" labelposition="top" labelSeparator=""
			id="ape" name="usuario.apelido" value="%{usuario.apelido}"
			errorPosition="bottom"></s:textfield>
		<s:textfield label="E-mail" labelposition="top" labelSeparator=""
			id="mail" name="usuario." value="%{usuario.email}"
			errorPosition="bottom"></s:textfield>
		<s:textfield label="Senha" labelposition="top" labelSeparator=""
			id="senha" name="usuario.senha"></s:textfield>
		<s:textfield label="Confirme sua senha" labelposition="top"
			labelSeparator="" id="confirmasenha" name="usuario.senha"
			value="%{usuario.senha}" errorPosition="bottom"></s:textfield>
		<s:textfield label="CPF" labelposition="top" labelSeparator=""
			id="cpf" name="usuario.cpf" value="%{usuario.cpf}"
			errorPosition="bottom"></s:textfield>
		<s:textfield label="Telefone" labelposition="top" labelSeparator=""
			id="tel" name="usuario.telefone" value="%{usuario.telefone}"
			errorPosition="bottom"></s:textfield>
		<s:select list="sexo" label="Osvaldo"></s:select>
		<label id="sexo" for="dpsexo">Sexo</label>
		<select name="usuario.sexo" id="dpsexo">
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
		</select>
		<select id="mesbox" name="nascMes">
			<option selected="selected">Mês</option>
		</select>
		<select id="anobox" name="nascAno">
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
		<input type="hidden" id="recS" value="${usuario.sexo}">
		<input type="hidden" id="recD" value="${nascDia}">
		<input type="hidden" id="recM" value="${nascMes}">
		<input type="hidden" id="recA" value="${nascAno}">
		<input type="submit" value="Enviar" id="enviar">
	</s:form>
	<script src="resources/js/cadastrar-usuario.js"></script>
	<script src="resources/js/cadastrar-endereco.js"></script>
</body>
</html>