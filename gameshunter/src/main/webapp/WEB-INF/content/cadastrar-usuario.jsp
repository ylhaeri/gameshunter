<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
		<button id="criaXml" class="admbutton">Cria XML</button>
		<button id="populaBanco" class="admbutton">Popula Banco</button>
	</header>
	<main class="container">
	<h1 id="titulo">Cadastre-se</h1>
	<s:form method="post" cssClass="cadastro" action="novoUsuario">
		<s:fielderror></s:fielderror>
		<table>
			<s:textfield label="Nome" labelposition="top" labelSeparator=""
				id="nome" name="usuario.nome" value="%{usuario.nome}"
				errorPosition="bottom" />
			<tr>
				<td class="separador"></td>
			</tr>
			<s:textfield label="Apelido" labelposition="top" labelSeparator=""
				id="ape" name="usuario.apelido" value="%{usuario.apelido}"
				errorPosition="bottom" />
			<tr>
				<td class="separador"></td>
			</tr>
			<s:textfield label="E-mail" labelposition="top" labelSeparator=""
				id="mail" name="usuario.email" value="%{usuario.email}"
				errorPosition="bottom" />
			<tr>
				<td class="separador" id="mailfeed"></td>
			</tr>
			<s:password label="Senha" labelposition="top" labelSeparator=""
				id="senha" />
			<tr>
				<td class="separador"></td>
			</tr>
			<s:password label="Confirme sua senha" labelposition="top"
				labelSeparator="" id="confirmaSenha" name="senha"
				errorPosition="bottom" />
			<tr>
				<td class="separador" id="feedConSenha"></td>
			</tr>
			<s:textfield label="CPF" labelposition="top" labelSeparator=""
				id="cpf" name="usuario.cpf" value="%{usuario.cpf}"
				errorPosition="bottom" />
			<tr>
				<td class="separador"></td>
			</tr>
			<s:textfield label="Telefone" labelposition="top" labelSeparator=""
				id="tel" name="usuario.telefone" value="%{usuario.telefone}"
				errorPosition="bottom" />
			<tr>
				<td class="separador"></td>
			</tr>
			<s:select label="Sexo" labelposition="top" labelSeparator=""
				id="dpsexo" headerValue="Selecione" headerKey="Selecione"
				name="usuario.sexo" list="sexo" errorPosition="bottom" />
			<tr>
				<td class="separador"></td>
			</tr>
			<s:textfield label="Data de Nascimento" labelposition="top"
				labelSeparator="" id="dataNasc" name="dataNasc" value="%{dataNasc}"
				errorPosition="bottom" />
			<tr>
				<td class="separadorGrande"></td>
			</tr>
		</table>
		<label id="endereco">Endereço</label>
		<s:include value="cadastrar-endereco.jsp"></s:include>
		<table>
			<tr>
				<td class="separador"></td>
			</tr>
			<tr>
				<td class="separador"></td>
			</tr>
		</table>
		<input type="submit" value="Enviar" id="cadastrar" />
	</s:form> </main>
	<footer>
		<s:include value="rodape.jsp" />
	</footer>
	<script src="resources/js/aindasemlugar.js"></script>
	<script src="resources/js/cadastrar-usuario.js"></script>
	<script src="resources/js/cadastrar-endereco.js"></script>
</body>
</html>
