$(document).ready(
		function() {
			$("#path")
					.val(window.location.pathname.replace("/gameshunter", ""));

			$("#language-selector").ddslick({
				width : 200,
				imagePosition : "left"
			})

			$(".dd-options")
					.click(
							function() {
								var language = $("#language-selector").data(
										'ddslick').selectedData.value;
								var url = "/gameshunter/?language=" + language;
								$.get(url, function() {
									window.location.reload();
								})
							})

			$('.open-menu').click(function() {
				$('.navigation').css({'left' : '0'});
			});
			
			$('.close-menu').click(function(){
				$('.navigation').css({'left' : '-90%'});
			});

		});
