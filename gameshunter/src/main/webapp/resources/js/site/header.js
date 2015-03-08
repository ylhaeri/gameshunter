$(document).ready(function() {
	$("#path").val(window.location.pathname.replace("/gameshunter", ""))

	$("#btn-logout").click(function() {
		// FIXME tá bem porco. Precisa tirar o ajax e ajeitar no controller
		$.post("/gameshunter/usuario/logout", function() {
			window.location.reload()
		})
	})

	$("#arara").ddslick({
		width : 300,
		imagePosition : "left",
		selectText : "Select your favorite social network",
		onSelected : function(data) {
			console.log(data);
		}
	})
})