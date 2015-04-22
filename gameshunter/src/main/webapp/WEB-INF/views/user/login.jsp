<%@taglib prefix="gameshunter" tagdir="/WEB-INF/tags/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!Doctype html>
<html>
<head>
<meta charset="UTF-8">
<gameshunter:resources />
</head>
<body>
	<gameshunter:header />
	<main class="container">
	<form action='<c:url value="/user/login" />' method="post">
		<div>
			<label>E-mail</label><input type="text" name="email"> <br />
			<label>Senha</label><input type="password" name="password"> <br />
			<input type="checkbox" name="rememberMe"> <input
				type="submit" value="login">
			<form:errors path="login.email"></form:errors>
		</div>
		<a href="<c:url value="/user/signup" />">Cadastre-se</a>
	</form>
	</main>
	<gameshunter:footer />
</body>
</html>