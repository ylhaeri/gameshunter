<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<span class="asterisk_input"> </span>
<label id="nome-label" class="control-label" for="nome-input"><spring:message
		code="user.firstName" /></label>
<form:input id="nome-input" class="form-control" path="user.firstName" />
<form:errors path="user.firstName" cssClass="text-danger" />


<span class="asterisk_input"> </span>
<label id="sobrenome-label" class="control-label" for="sobrenome-input"><spring:message
		code="user.lastName" /></label>
<form:input id="sobrenome-input" class="form-control"
	path="user.lastName" />
<form:errors path="user.lastName" cssClass="text-danger" />




<span class="asterisk_input"> </span>
<label id="apelido-label" class="control-label" for="apelido-input"><spring:message
		code="user.nickname" /></label>
<form:input id="apelido-input" class="form-control" path="user.nickname" />
<form:errors path="user.nickname" cssClass="text-danger" />

<div class="inline">
<span class="asterisk_input" > </span>
<label id="sexo-label" class="control-label" for="sexo-input">
<spring:message	code="user.gender" /></label>
<form:radiobuttons path="user.gender" itemLabel="label" />
<form:errors path="user.gender" cssClass="text-danger" />
</div>

<span class="asterisk_input"> </span>
<label id="cpf-label" class="control-label" for="cpf-input"><spring:message
		code="user.document" /></label>
<form:input id="cpf-input" class="form-control" path="user.cpf" />
<form:errors path="user.cpf" cssClass="text-danger" />


<span class="asterisk_input"> </span>
<label id="telefone-label" class="control-label" for="telefone-input"><spring:message
		code="user.phone" /></label>
<form:input id="telefone-input" class="form-control" path="user.phone" />
<form:errors path="user.phone" cssClass="text-danger" />


<label id="celular-label" class="control-label" for="celular-input"><spring:message
		code="user.mobile" /></label>
<form:input id="celular-input" class="form-control" path="user.mobile" />
<form:errors path="user.mobile" cssClass="text-danger" />


<span class="asterisk_input"> </span>
<label id="data-nascimento-label" class="control-label"
	for="dia-nascimento-input"><spring:message code="user.bday" /></label>
<form:input id="nascimento-input" class="form-control"
	path="user.birthDay" />
<form:errors path="user.birthDay" cssClass="text-danger" />



<span class="asterisk_input"> </span>
<label id="email-label" class="control-label" for="email-input"><spring:message
		code="user.email" /></label>
<form:input id="email-input" class="form-control" path="user.email" />
<form:errors path="user.email" cssClass="text-danger" />


<span class="asterisk_input"> </span>
<label id="senha-label" class="control-label" for="senha-input"><spring:message
		code="user.password" /></label>
<input id="senha-input" class="form-control" type="password">


<span class="asterisk_input"> </span>
<label id="confirma-senha-label" class="control-label"
	for="confirma-senha-input"><spring:message
		code="user.confirm_password" /></label>
<input id="confirma-senha-input" class="form-control" type="password"
	name="password" />
<form:errors path="user.password" cssClass="text-danger" />
