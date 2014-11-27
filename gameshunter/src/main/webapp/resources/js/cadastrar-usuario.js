$(document).ready(function() {
$("#cpf").mask("999.999.999-99")
$("#tel").mask("?(99)9999-9999")
$("#dataNasc").mask("99/99/9999")

$("#table-cadastro tr td:first-child").addClass("td-label")

$("#mail").blur(function() {
	criaFeedNaMesmaLinha("feedImgMail", "mail")
	var feedImgMail = pegaFeedId("feedImgMail")
	var regex = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	var emailt = $("#mail")
	var email = emailt.val()
	feedImgMail.removeClass()
	emailt.removeClass()
	$("#mailfeed").html("")
	if (email != "") {
		if (regex.test(email)) {
			$.get("verificaEmail",
					{
				email : email
					},
					function(info) {
						if (info.disponivel) {
							feedImgMail.addClass("feedImgSuccess")
							emailt.addClass("feedSuccess")
							$("#mailfeed").html("<span class='successMessage'>E-mail disponível</span>")
						}
						else {
							feedImgMail.addClass("feedImgError")
							emailt.addClass("feedError")
							$("#mailfeed").html("<span class='errorMessage'>E-mail já cadastrado</span>")
						}
					})
		} else {
			feedImgMail.addClass("feedImgError")
			emailt.addClass("feedError")
			$("#mailfeed").html("<span class='errorMessage'>E-mail inválido</span>")
		}
	}
})

$("#confirmaSenha").blur(function() {
		criaFeedNaMesmaLinha("imagemSenhaFeed", "senha")
		criaFeedNaMesmaLinha("imagemConSenhaFeed", "confirmaSenha")
		var feedConSenha = pegaFeedId("feedConSenha")
		var feedImgSenha = pegaFeedId("imagemSenhaFeed")
		var feedImgConSenha = pegaFeedId("imagemConSenhaFeed")
		var senha = $("#senha")
		var conSenha = $("#confirmaSenha")
		feedImgSenha.removeClass()
		feedImgConSenha.removeClass()
		senha.removeClass()
		conSenha.removeClass()
		feedConSenha.html("")
		if(senha.val().length >= 6) {
			feedImgSenha.addClass("feedImgSuccess")
			senha.addClass("feedSuccess")
			if (senha.val() == conSenha.val()) {
				conSenha.addClass("feedSuccess")
				feedImgConSenha.addClass("feedImgSuccess")
			}
			else {
				conSenha.addClass("feedError")
				feedImgConSenha.addClass("feedImgError")
				feedConSenha.html("<span class='errorMessage'>" +
						"Senhas não conferem.</span>")
			}
		} else if (senha.val().length > 0 && senha.val().length <6) {
			senha.addClass("feedError")
			feedImgSenha.addClass("feedImgError")
			feedConSenha.html("<span class='errorMessage'>" +
					"Mínimo de 6 caracteres.</span>")
		}
})

$("#form-cadastro").submit(function(event) {
	var form = $(this)
	if (!senhaValida()) {
		event.preventDefault()
	} else {
		form.find("input[type='image'],input[type='submit']").attr("disabled", "true");
	}
})

function senhaValida() {
	var senha1 = $("#senha").val()
	var senha2 = $("#confirmaSenha").val()
	return senha1.length >= 6 && senha1 == senha2
}


function existeFeed(nome) {
	if($("#" + nome).val() == undefined)
		return false
	else
		return true
}

function criaFeedNaMesmaLinha(id, campo) {
	if(!existeFeed(id))
		$("<span id='"+id+"'></span>").insertAfter("#"+campo)
	return
}

function pegaFeedId(id) {
	return $("#"+id)
}
})