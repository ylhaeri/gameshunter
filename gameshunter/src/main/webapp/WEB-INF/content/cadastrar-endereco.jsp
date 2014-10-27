<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<label for="cept">CEP</label><input type="text" name="endereco.cep" id="cept">
<br />
<label for="logt">Logradouro</label><input type="text" id="logt" 
name="endereco.logradouro">
<label id="num" for="numt">N�</label><input type="text" id="numt" 
name="endereco.numero">
<br />
<label for="comt">Complemento</label><input type="text" id="comt" 
name="endereco.complemento">
<br />
<label for="bairrot">Bairro</label><input type="text" id="bairrot" name="endereco.bairro">
<br />
<label id="pais">Pa�s</label><select name="endereco.pais" onchange="funcao()">
	<option selected="selected">Selecione um pa�s</option>
	<c:forEach var="pais" items="${paises}" varStatus="status">
		<option value="${status.index}">${pais.nome}</option>
	</c:forEach>
</select>
<label id="estado">Estado</label><select name="endereco.estado">
	<option>Selecione um estado</option>
</select>
<label id="cidade">Cidade</label><select name="endereco.cidade">
	<option>Selecione uma cidade</option>
</select>