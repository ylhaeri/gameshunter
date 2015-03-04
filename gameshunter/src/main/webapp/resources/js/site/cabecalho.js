$(document).ready(function() {
	$("#path").val(window.location.pathname.replace("/gameshunter", ""))

	$("#btn-logout").click(function() {
		// FIXME tá bem porco. Precisa tirar o ajax e ajeitar no controller
		$.post("/gameshunter/usuario/logout", function() {
			window.location.reload()
		})
	})
})