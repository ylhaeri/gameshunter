$(document).ready(function() {
	$(".path").val(window.location.pathname.replace("/gameshunter", ""));

	$('.menu-img').click(function() {
		$('.navigation').addClass('open-menu');
		$("html").addClass("transparent-background");
	});
	
	$('.menu-close').click(function(){
		$("html").removeClass("transparent-background");
		$('.navigation').removeClass("open-menu");
	});
	
	
	$(document).click(function(event) {
		if (event.target === document.documentElement) {
			$("html").removeClass("transparent-background");
			$('.navigation').removeClass("open-menu");
		}

	});
	
	

});