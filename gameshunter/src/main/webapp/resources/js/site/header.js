$(document).ready(function() {
	$(".path").val(window.location.pathname.replace("/gameshunter", ""));

	$('.menu-img').click(function() {
		$('nav').addClass('open-menu');
		$("html").addClass("transparent-background");
	});
	
	$('.close-menu').click(function(){
		$("html").removeClass("transparent-background");
		$('nav').removeClass("open-menu");
	});
	
	
	$(document).click(function(event) {
		if (event.target === document.documentElement) {
			$("html").removeClass("transparent-background");
			$('nav').removeClass("open-menu");
		}

	});
});