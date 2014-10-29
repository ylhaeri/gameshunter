<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="resources/js/jquery-2.1.1.js"></script>
<script>
	function teste() {
		$.get("testaAjax", function(data) {
				var teste = data.nomes;
				teste.forEach(function(a) {
					$("#huehue").append("<option>"+a+"</option>")
				})
			}
		);
	}
</script>
</head>
<body>
	<select id="huehue">
		<option>Oi</option>
		<option>Goku</option>
		<option>Tudo bem</option>
		<option>Com você?</option>
	</select>
	<br>
	<a href="#" onclick="teste()">Alterar Ajax</a>
</body>
</html>