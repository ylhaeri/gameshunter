<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>

<header class="header-area">
	<div class="usermenu-area">
		<div class="container">
			<div class="row">
				<div class="col-md-8">
					<div class="user-menu">
						<ul>
							<shiro:user>
								<li><a href="<c:url value="/user/account" /> "><i
										class="fa fa-user"></i>Minha conta</a></li>
								<li><a href="cart.html"><i class="fa fa-user"></i> My
										Cart</a></li>
								<li><a href="checkout.html"><i class="fa fa-user"></i>
										Checkout</a></li>
								<li><form action="<c:url value="/user/logout" />" method="post">
										<input class="userlogout-btn" type="submit" value="Sair">
									</form></li>
							</shiro:user>
							<shiro:guest>
								<li><a class="signup-link"
									href="<c:url value="/user/login" />"><i class="fa fa-user"></i>Entrar</a></li>
								<li><a class="signup-link"
									href="<c:url value="/user/signup" />"><i class="fa fa-user"></i>Cadastre-se</a></li>
							</shiro:guest>
						</ul>

					</div>
				</div>

				<div class="col-md-4">
					<div class="header-right">
						<ul class="list-unstyled list-inline">
							<li class="dropdown dropdown-small"><a
								data-toggle="dropdown" data-hover="dropdown"
								class="dropdown-toggle" href="#"> <span class="key">currency
										:</span> <span class="value">USD </span> <b class="caret"></b>
							</a>
								<ul class="dropdown-menu">
									<li><a href="#">USD</a></li>
									<li><a href="#">INR</a></li>
									<li><a href="#">GBP</a></li>
								</ul></li>

							<li class="dropdown dropdown-small"><a
								data-toggle="dropdown" data-hover="dropdown"
								class="dropdown-toggle" href="#"> <span class="key">Idioma
										:</span> <span class="value">Português</span> <b class="caret"></b>
							</a>
								<ul class="dropdown-menu">
									<li><a href="#">English</a></li>
									<li><a href="#">Português</a></li>
								</ul></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End header area -->

	<div class="site-branding-area">
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<div class="logo">
						<h1>
							<a href="<c:url value="/" />">Games<span>Hunter</span></a>
						</h1>
					</div>
				</div>

				<div class="col-sm-6">
					<div class="shopping-item">
						<a href="cart.html">Cart - <span class="cart-amunt">$800</span>
							<i class="fa fa-shopping-cart"></i> <span class="product-count">5</span></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End site branding area -->

	<div class="mainmenu-area">
		<div class="container">
			<div class="row">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li><a href="<c:url value="/" />">Início</a></li>
						<li><a href="<c:url value="/how-it-works" />">Como
								funciona</a></li>
						<li><a href="<c:url value="/about" />">Sobre</a></li>
						<li><a href="<c:url value="/contact" />">Fale conosco</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- End mainmenu area -->
</header>