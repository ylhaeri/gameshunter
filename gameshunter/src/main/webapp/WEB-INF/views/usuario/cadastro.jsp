<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page import="br.com.gameshunter.model.Gender"%>

<tr>
	<td class="td-label" id="td-nome-label"><span
		class="asterisk_input"> </span><label id="nome-label"
		class="control-label" for="nome-input"><spring:message
				code="user.firstName" /></label></td>
	<td class="td-input" id="td-nome-input"><form:input
			id="nome-input" class="form-control" path="usuario.firstName" /> <form:errors
			path="usuario.firstName" cssClass="text-danger" /></td>
</tr>
<tr>
	<td class="td-label" id="td-sobrenome-label"><span
		class="asterisk_input"> </span><label id="sobrenome-label"
		class="control-label" for="sobrenome-input"><spring:message
				code="user.lastName" /></label></td>
	<td class="td-input" id="td-sobrenome-input"><form:input
			id="sobrenome-input" class="form-control" path="usuario.lastName" />
		<form:errors path="usuario.lastName" cssClass="text-danger" /></td>
</tr>
<tr>
	<td class="td-label" id="td-apelido-label"><span
		class="asterisk_input"> </span><label id="apelido-label"
		class="control-label" for="apelido-input"><spring:message
				code="user.nickname" /></label></td>
	<td class="td-input" id="td-apelido-input"><form:input
			id="apelido-input" class="form-control" path="usuario.nickname" /> <form:errors
			path="usuario.nickname" cssClass="text-danger" /></td>
</tr>
<tr>
	<td class="td-label" id="td-sexo-label"><span
		class="asterisk_input"> </span><label id="sexo-label"
		class="control-label" for="sexo-input"><spring:message
				code="user.gender" /></label></td>
	<td><form:radiobuttons path="usuario.gender" itemLabel="label" />
		<form:errors path="usuario.gender" cssClass="text-danger" /></td>
</tr>
<tr>
	<td class="td-label" id="td-cpf-label"><span
		class="asterisk_input"> </span><label id="cpf-label"
		class="control-label" for="cpf-input"><spring:message
				code="user.document" /></label></td>
	<td class="td-input" id="td-cpf-input"><form:input id="cpf-input"
			class="form-control" path="usuario.cpf" /> <form:errors
			path="usuario.cpf" cssClass="text-danger" /></td>
</tr>
<tr>
	<td class="td-label" id="td-telefone-label"><span
		class="asterisk_input"> </span><label id="telefone-label"
		class="control-label" for="telefone-input"><spring:message
				code="user.phone" /></label></td>
	<td class="td-input" id="td-telefone-input"><form:input
			id="telefone-input" class="form-control" path="usuario.phone" /> <form:errors
			path="usuario.phone" cssClass="text-danger" /></td>
</tr>
<tr>
	<td class="td-label" id="td-celular-label"><label
		id="celular-label" class="control-label" for="celular-input"><spring:message
				code="user.mobile" /></label></td>
	<td class="td-input" id="td-celular-input"><form:input
			id="celular-input" class="form-control" path="usuario.mobile" /> <form:errors
			path="usuario.mobile" cssClass="text-danger" /></td>
</tr>
<tr>
	<td class="td-label" id="td-data-nascimento-label"><span
		class="asterisk_input"> </span><label id="data-nascimento-label"
		class="control-label" for="dia-nascimento-input"><spring:message
				code="user.bday" /></label></td>
	<td class="td-input" id="td-dia-nascimento-input"><form:input
			id="nascimento-input" class="form-control" path="usuario.birthDay" />
		<form:errors path="usuario.birthDay" cssClass="text-danger" /></td>
</tr>

<tr>
	<td class="td-label" id="td-email-label"><span
		class="asterisk_input"> </span><label id="email-label"
		class="control-label" for="email-input"><spring:message
				code="user.email" /></label></td>
	<td class="td-input" id="td-email-input"><form:input
			id="email-input" class="form-control" path="usuario.email" /> <form:errors
			path="usuario.email" cssClass="text-danger" /></td>
</tr>
<tr>
	<td class="td-label" id="td-senha-label"><span
		class="asterisk_input"> </span><label id="senha-label"
		class="control-label" for="senha-input"><spring:message
				code="user.password" /></label></td>
	<td class="td-input" id="td-senha-input"><input id="senha-input"
		class="form-control" type="password"></td>
</tr>
<tr>
	<td class="td-label" id="td-confirma-senha-label"><span
		class="asterisk_input"> </span><label id="confirma-senha-label"
		class="control-label" for="confirma-senha-input"><spring:message
				code="user.confirm_password" /></label></td>
	<td class="td-input" id="td-confirma-senha-input"><form:password
			id="confirma-senha-input" class="form-control"
			path="usuario.password" /> <form:errors path="usuario.password"
			cssClass="text-danger" /></td>
</tr>