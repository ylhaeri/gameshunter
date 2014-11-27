<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<s:textfield label="CEP" labelposition="left" labelSeparator=""
	cssClass="form-control" id="cept" name="cep" value="%{cep}"
	errorPosition="bottom" />
<s:textfield label="Logradouro" labelposition="left" labelSeparator=""
	cssClass="form-control" id="logt" value="%{code}"
	errorPosition="bottom" disabled="true" />
<s:textfield label="Número" labelposition="left" labelSeparator=""
	cssClass="form-control" id="numt" name="endereco.numero"
	value="%{endereco.numero}" errorPosition="bottom" maxLength="6" />
<s:textfield label="Complemento" labelposition="left" labelSeparator=""
	cssClass="form-control" id="comt" name="endereco.complemento"
	value="%{endereco.complemento}" errorPosition="bottom" />
<s:textfield label="Bairro" labelposition="left" labelSeparator=""
	cssClass="form-control" id="bairrot" errorPosition="bottom"
	disabled="true" />
<s:textfield label="Cidade" labelposition="left" labelSeparator=""
	cssClass="form-control" id="cidadet" errorPosition="bottom"
	disabled="true"></s:textfield>
<s:textfield label="Estado" labelposition="left" labelSeparator=""
	cssClass="form-control" id="estadot" errorPosition="bottom"
	disabled="true"></s:textfield>
</html>