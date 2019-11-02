<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix ="c" %>
    
<!doctype html>
<html lang="pt-BR">
  <head>
    
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Pizzaria Web 402</title>
  </head>
  <body>
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
	<div id="" class="container" style="padding-top:70px; padding-bottom:20px;">
        <div class="form-row">
          <div id="" class="col-md-6 offset-md-3" >
            <h3>Meu Perfil</h3>
            <br>
            <c:forEach items="user" var="u">
            
            
            <form action="" method = POST>
              <div class="form-group">
                    <label for="exampleFormControlInput1">Nome: ${nome}</label>
                    
              </div>
              </c:forEach>
              <hr>
              <div class="form-group">
                    <label for="exampleFormControlInput1">Sobrenome: ${sobrenome} </label>
              </div>
              <hr>
              <div class="form-group">
                    <label for="exampleFormControlInput1">CPF: ${cpf}</label>
                </div>
                <hr>
                <div class="form-group">
                    <label for="exampleFormControlInput1">Email: ${email}</label>
                </div>
                <hr>
                <hr>
                <div class="form-group">
                    <label for="exampleFormControlInput1"><Table>Telefone:</Table></label>
                </div>
                <hr>
                <div class="form-group">
                    <label for="exampleFormControlInput1">Endereço:</label>
              </div>
              <hr>
              <div class="form-group">
                <label for="exampleFormControlInput1">Complemento:{$complemento}</label>
              </div>
              <hr>
              <div class="form-group">
                    <label for="exampleFormControlInput1">CEP:${cep}</label>
                </div>
                <hr>
                <div class="form-group">
                    <label for="exampleFormControlInput1">Rua:${rua}</label>
                </div>
                <hr>
                <div class="form-group">
                    <label for="exampleFormControlInput1">Número: ${numero}</label>
                </div>
                <hr>
                <div class="form-group">
                        <label for="exampleFormControlInput1">Cidade: ${cidade}</label>
                </div>
                <hr>
                <div class="form-group">
                    <label for="exampleFormControlInput1">Bairro:${bairro}</label>
                </div>
          
                <button class="btn btn-dark btn-block my-4"  type="submit">Atualizar</button>
            </form>
              </div>
          </div>
  </div>
	

    
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>