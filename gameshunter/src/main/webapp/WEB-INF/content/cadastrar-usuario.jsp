<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/reset.css">
<link rel="stylesheet" href="resources/css/bootstrap.css">
<link rel="stylesheet" href="resources/css/gameshunter-bootstrap.css">
<link rel="stylesheet" href="resources/css/cadastrar-usuario.css">
<script src="resources/js/jquery-2.1.1.js"></script>
<script src="resources/js/jquery-masked-input-1.4.0.js"></script>
<title>Cadastro - Games Hunter</title>
</head>
<body>
	<s:include value="cabecalho.jsp" />
	<main>
	<h1 id="titulo">Cadastre-se</h1>
	<form method="post" action="novoUsuario">
		<table class="table">
			<s:textfield label="Nome" labelposition="left" labelSeparator=""
				cssClass="form-control arara" id="nome" name="usuario.nome"
				value="%{usuario.nome}" errorPosition="bottom" />
			<tr>
				<td class="separador"></td>
			</tr>
			<s:textfield label="Apelido" labelposition="left" labelSeparator=""
				id="ape" name="usuario.apelido" value="%{usuario.apelido}"
				errorPosition="bottom" />
			<tr>
				<td class="separador"></td>
			</tr>
			<s:textfield label="E-mail" labelposition="left" labelSeparator=""
				id="mail" name="usuario.email" value="%{usuario.email}"
				errorPosition="bottom" />
			<tr>
				<td class="separador" id="mailfeed"></td>
			</tr>
			<s:password label="Senha" labelposition="left" labelSeparator=""
				id="senha" />
			<tr>
				<td class="separador"></td>
			</tr>
			<s:password label="Confirme sua senha" labelposition="left"
				labelSeparator="" id="confirmaSenha" name="login.senha"
				errorPosition="bottom" />
			<tr>
				<td class="separador" id="feedConSenha"></td>
			</tr>
			<s:textfield label="CPF" labelposition="left" labelSeparator=""
				id="cpf" name="usuario.cpf" value="%{usuario.cpf}"
				errorPosition="bottom" />
			<tr>
				<td class="separador"></td>
			</tr>
			<s:textfield label="Telefone" labelposition="left" labelSeparator=""
				id="tel" name="usuario.telefone" value="%{usuario.telefone}"
				errorPosition="bottom" />
			<tr>
				<td class="separador"></td>
			</tr>
			<s:select label="Sexo" labelposition="left" labelSeparator=""
				id="dpsexo" headerValue="Selecione" headerKey="Selecione"
				name="usuario.sexo" list="sexo" errorPosition="bottom" />
			<tr>
				<td class="separador"></td>
			</tr>
			<s:textfield label="Data de Nascimento" labelposition="left"
				labelSeparator="" id="dataNasc" name="dataNasc" value="%{dataNasc}"
				errorPosition="bottom" />
		</table>
		<input class="btn btn-main" type="submit" value="Enviar"
			id="cadastrar" />
	</form>
	</main>
	<footer>
		<s:include value="rodape.jsp" />
	</footer>
	<script src="resources/js/aindasemlugar.js"></script>
	<script src="resources/js/cadastrar-usuario.js"></script>
	<script src="resources/js/cadastrar-endereco.js"></script>
</body>
</html>
