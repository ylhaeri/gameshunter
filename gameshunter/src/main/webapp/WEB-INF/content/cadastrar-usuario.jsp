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
<body>
	<header>
		<s:include value="cabecalho.jsp" />
	</header>
	<main class="container">
	<h1 id="titulo">Cadastre-se</h1>
	<s:form method="post" class="cadastro" action="novoUsuario">
		<s:textfield label="Nome" labelposition="top" labelSeparator=""
			id="nome" name="usuario.nome" value="%{usuario.nome}"
			errorPosition="bottom" />
		<tr><td class="separador"></td></tr>
		<s:textfield label="Apelido" labelposition="top" labelSeparator=""
			id="ape" name="usuario.apelido" value="%{usuario.apelido}"
			errorPosition="bottom" />
		<tr><td class="separador"></td></tr>
		<s:textfield label="E-mail" labelposition="top" labelSeparator=""
			id="mail" name="usuario.email" value="%{usuario.email}"
			errorPosition="bottom" />
		<tr><td class="separador"></td></tr>
		<s:password label="Senha" labelposition="top" labelSeparator=""
			id="senha" />
		<s:password label="Confirme sua senha" labelposition="top"
			labelSeparator="" id="confirmasenha" name="usuario.senha"
			errorPosition="bottom" />
		<tr><td class="separador" id="sepSenha"></td></tr>
		<s:textfield label="CPF" labelposition="top" labelSeparator=""
			id="cpf" name="usuario.cpf" value="%{usuario.cpf}"
			errorPosition="bottom" />
		<tr><td class="separador"></td></tr>
		<s:textfield label="Telefone" labelposition="top" labelSeparator=""
			id="tel" name="usuario.telefone" value="%{usuario.telefone}"
			errorPosition="bottom" />
		<tr><td class="separador"></td></tr>
		<s:select label="Sexo" labelposition="top" labelSeparator=""
			id="dpsexo" headerValue="Selecione" headerKey="Selecione"
			name="usuario.sexo" list="sexo" errorPosition="bottom" />
		<tr><td class="separador"></td></tr>
		<s:textfield label="Data de Nascimento" labelposition="top"
			labelSeparator="" id="dataNasc" name="dataNasc" value="%{dataNasc}"
			errorPosition="bottom" />
		<tr><td class="separador"></td></tr>
		<s:label label="Endereço" labelposition="top" labelSeparator="" />
		<s:include value="cadastrar-endereco.jsp"></s:include>
		<tr><td class="separador"></td></tr>
		<input type="hidden" id="recS" value="${usuario.sexo}">
		<s:submit value="Enviar" id="cadastrar" />
	</s:form> </main>
	<footer>
		<s:include value="rodape.jsp" />
	</footer>
	<script src="resources/js/cadastrar-usuario.js"></script>
	<script src="resources/js/cadastrar-endereco.js"></script>
</body>
</html>
