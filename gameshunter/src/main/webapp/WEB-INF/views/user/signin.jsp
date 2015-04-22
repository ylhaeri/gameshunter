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
	<form action="<c:url value='/user/login' />" method="post">
		<input type="hidden" name="path" class="path"><input
			type="text" name="email"> <input type="password"
			name="password"> <input type="submit">
	</form>
	</main>
	<gameshunter:footer />
</body>
</html>