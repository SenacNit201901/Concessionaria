<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body >
	
	
	
	<nav class="navbar navbar-dark bg-dark" style="padding-right: 100px;">
		<a  style="color: white;" class="navbar-toggler"><span class="navbar-toggler-icon"></span> Home </a>
		<% if(session.getAttribute("id") != null){ %>
		<div class="dropdown">
			
			<a style="color: white" href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" >Logout</a>
			<div class="dropdown-menu text-center">
				<a>${nome}</a>
				<a class="dropdown-item">Perfil</a>
				<a  class="dropdown-item" href="/Concessionaria/usuario/listar"> Usuarios</a>
				<a class="dropdown-item" href="/Concessionaria/veiculo/listar">Veiculos</a>
				
				<div class="dropdown-divider"></div>
				<a class="dropdown-item" style="cursor: pointer;">sair</a>

			
			
			</div>
			<%}  else { %>
				<ul class="nav justify-content-center">
				  <li class="nav-item">
				    <a style="color: white;" class="nav-link active" href="login">Login</a>
				  </li>
					<li class="nav-item">
				    <a style="color: white;" class="nav-link active" href="cadastro">cadastrar</a>
				  </li>
				</ul>
			<%} %>
		</div>
	</nav>
	
	
	
	
	


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>