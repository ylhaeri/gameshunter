<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<label for="cept">CEP</label><input type="text" name="endereco.cep" id="cept">
<br />
<label for="logt">Logradouro</label><input type="text" id="logt" 
name="endereco.logradouro">
<label id="num" for="numt">Nº</label><input type="text" id="numt" 
name="endereco.numero">
<br />
<label for="comt">Complemento</label><input type="text" id="comt" 
name="endereco.complemento">
<br />
<label for="bairrot">Bairro</label><input type="text" id="bairrot" name="endereco.bairro">
<br />
<label id="pais">País</label><select name="endereco.pais" onchange="funcaoTeste()">
	<option selected="selected">Selecione um país</option>
	<c:forEach var="pais" items="${paises}" varStatus="status">
		<option value="${status.index}">${pais.nome}</option>
	</c:forEach>
</select>
<label id="estado">Estado</label><select id="dpest" name="endereco.estado">
	<option selected="selected">Selecione um estado</option>
	<c:forEach var="estado" items="${estados}">
		<option>${estado.nome}</option>
	</c:forEach>
</select>
<label id="cidade">Cidade</label><select name="endereco.cidade">
	<option selected="selected">Selecione uma cidade</option>
</select>