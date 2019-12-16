<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	
	<style>
		.bd-placeholder-img {
			font-size: 1.125rem;
			text-anchor: middle;
			-webkit-user-select: none;
			-moz-user-select: none;
			-ms-user-select: none;
			user-select: none;
		}
		
		html,
		body {
			height: 100%;
			background-color: #333;
		}
		
		body {
			display: -ms-flexbox;
  			display: flex;
			color: #fff;
			text-shadow: 0 .05rem .1rem rgba(0, 0, 0, .5);
			box-shadow: inset 0 0 5rem rgba(0, 0, 0, .5);
		}
		
		.cover-container {
 			max-width: 42em;
		}
		
		.cover {
			padding: 0 1.5rem;
		}
		
		.cover
		.btn-lg {
			padding: .75rem 1.25rem;
  			font-weight: 700;
		}
		
		@media ( min-width : 768px) {
			.bd-placeholder-img-lg {
				font-size: 3.5rem;
			}
		}
	</style>
	<title>Acceso Denegado</title>
</head>

<body class="text-center">
	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
		<a class="navbar-brand" href="${pageContext.request.contextPath}">Ejemplo JPA</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExampleDefault"
			aria-controls="navbarsExampleDefault" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
	</nav>
	<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
		<main role="main" class="inner cover">
			<p></p>
			<p></p>
			<p></p>
			<h1 class="cover-heading">code: 403</h1>
			<p class="lead">Acceso denegado, ud no tiene permiso para acceder a este recurso.</p>
			<p class="lead">
				<a href="${pageContext.request.contextPath}/login" class="btn btn-lg btn-secondary">Acceder</a>
			</p>
		</main>
	</div>
</body>
</html>