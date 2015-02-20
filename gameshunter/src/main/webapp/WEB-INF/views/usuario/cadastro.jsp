<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page import="br.com.gameshunter.model.Sexo"%>

<tr>
	<td class="td-label" id="td-nome-label"><label id="nome-label"
		class="control-label" for="nome-input">Nome completo</label></td>
	<td class="td-input" id="td-nome-input"><form:input
			id="nome-input" class="form-control" path="usuario.nome" /> <form:errors
			path="usuario.nome" cssClass="text-danger" /></td>
</tr>
<tr>
	<td class="td-label" id="td-sexo-label"><label id="sexo-label"
		class="control-label" for="sexo-input">Sexo</label></td>
	<td><form:select id="sexo-input" path="usuario.sexo">
			<form:option value="Selecione" selected="selected" />
			<form:options items="<%=Sexo.values()%>" />
		</form:select> <form:errors path="usuario.sexo" cssClass="text-danger" /></td>
</tr>
<tr>
	<td class="td-label" id="td-cpf-label"><label id="cpf-label"
		class="control-label" for="cpf-input">CPF</label></td>
	<td class="td-input" id="td-cpf-input"><form:input id="cpf-input"
			class="form-control" path="usuario.cpf" /> <form:errors
			path="usuario.cpf" cssClass="text-danger" /></td>
</tr>
<tr>
	<td class="td-label" id="td-telefone-label"><label
		id="telefone-label" class="control-label" for="telefone-input">Telefone</label></td>
	<td class="td-input" id="td-telefone-input"><form:input
			id="telefone-input" class="form-control" path="usuario.telefone" />
		<form:errors path="usuario.telefone" cssClass="text-danger" /></td>
</tr>
<tr>
	<td class="td-label" id="td-celular-label"><label
		id="celular-label" class="control-label" for="celular-input">Celular</label></td>
	<td class="td-input" id="td-celular-input"><form:input
			id="celular-input" class="form-control" path="usuario.celular" /> <form:errors
			path="usuario.celular" cssClass="text-danger" /></td>
</tr>
<tr>
	<td class="td-label" id="td-data-nascimento-label"><label
		id="data-nascimento-label" class="control-label"
		for="dia-nascimento-input">Data de nascimento</label></td>
	<td class="td-input" id="td-dia-nascimento-input"><form:input
			id="nascimento-input" class="form-control"
			path="usuario.dataNascimento" /> <form:errors
			path="usuario.dataNascimento" cssClass="text-danger" /></td>
</tr>

<tr>
	<td class="td-label" id="td-email-label"><label id="email-label"
		class="control-label" for="email-input">E-mail</label></td>
	<td class="td-input" id="td-email-input"><form:input
			id="email-input" class="form-control" path="usuario.email" /> <form:errors
			path="usuario.email" cssClass="text-danger" /></td>
</tr>
<tr>
	<td class="td-label" id="td-apelido-label"><label
		id="apelido-label" class="control-label" for="apelido-input">Apelido</label></td>
	<td class="td-input" id="td-apelido-input"><form:input
			id="apelido-input" class="form-control" path="usuario.apelido" /> <form:errors
			path="usuario.apelido" cssClass="text-danger" /></td>
</tr>
<tr>
	<td class="td-label" id="td-senha-label"><label id="senha-label"
		class="control-label" for="senha-input">Senha</label></td>
	<td class="td-input" id="td-senha-input"><input id="senha-input"
		class="form-control" type="password"></td>
</tr>
<tr>
	<td class="td-label" id="td-confirma-senha-label"><label
		id="confirma-senha-label" class="control-label"
		for="confirma-senha-input">Confirme sua senha</label></td>
	<td class="td-input" id="td-confirma-senha-input"><form:password
			id="confirma-senha-input" class="form-control" path="usuario.senha" />
		<form:errors path="usuario.senha" cssClass="text-danger" /></td>
</tr>