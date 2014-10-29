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
<label id="pais">País</label><select name="endereco.pais" id="dpais" onchange="crEst()">
	<option selected="selected">Selecione um país</option>
	<c:forEach var="pais" items="${paises}">
		<option value="${pais.id}">${pais.nome}</option>
	</c:forEach>
</select>
<label id="estado">Estado</label><select id="dpest" name="endereco.estado" onchange="crCid()">
	<option selected="selected">Selecione um estado</option>
</select>
<label id="cidade">Cidade</label><select name="endereco.cidade" id="dpcid">
	<option selected="selected">Selecione uma cidade</option>
</select>