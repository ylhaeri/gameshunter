$(document).ready(function() {

	$("#btn-login").click(function(event) {
		var email = $("#email-input-login").val()
		var senha = $("#senha-input-login").val()
		$("#usuario-invalido").remove()

		$.post("/gameshunter/usuario/login", {
			email : email,
			senha : senha
		}, function(data) {
			if (data == true) {
				window.location.reload()
			} else {
				$("#login-form").append("<div id='usuario-invalido'><span class='text-danger'>Usuário ou senha inválida</span></div>")
			}
		})
		event.preventDefault()
	})

	$("#btn-logout").click(function() {
		$.post("/gameshunter/usuario/logout", function() {
			window.location.reload()
		})
	})

})