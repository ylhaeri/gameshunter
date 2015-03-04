$(document).ready(function() {
	if ($("#mensagem-email").text().indexOf('<') > 0) {
		var t = $("#mensagem-email").text();
		var email = $("#email-input-login").val();
		$("#mensagem-email").html(t.replace("{email}", email));
	}

	$("#path").val(window.location.pathname.replace("/gameshunter", ""))

	$("#btn-logout").click(function() {
		// FIXME tá bem porco. Precisa tirar o ajax e ajeitar no controller
		$.post("/gameshunter/usuario/logout", function() {
			window.location.reload()
		})
	})
})