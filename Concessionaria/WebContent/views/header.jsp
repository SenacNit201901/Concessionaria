<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
          <!-- Meta tags Obrigatórias -->
          <meta charset="utf-8">
          <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

          <!-- Bootstrap CSS -->
          <link rel="stylesheet" href="http://localhost/css/index.css">
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">	
          <link rel="shortcut icon" href="http://localhost/imagens/favicon.png" type="image/x-png"/>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		   <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.10/jquery.mask.min.js"></script>
          <script src="https://kit.fontawesome.com/c766cb3ea7.js"></script>

	<style>
		#x:hover{
			color: red;
		}
		#alert-login{
		    width: 25%;
		  
		}
	</style>
          <title>Home</title>

  </head>
  <body>

<!--################### NAV BAR ##########################-->

	
          <nav id="navbar" class="navbar navbar-expand-lg navbar-dark bg-red fixed-top">

              <main class="container">

                <a class="navbar-brand" href="home">
                  <img id="logo" src="http://localhost/imagens/logo.png"  alt="">
                </a>



                  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#conteudoNavbarSuportado" aria-controls="conteudoNavbarSuportado" aria-expanded="false" aria-label="Alterna navega��o">
                    <span class="navbar-toggler-icon"></span>
                  </button>


                  <div class="collapse navbar-collapse" id="conteudoNavbarSuportado">
                    <ul class="navbar-nav mr-auto">


                          <li class="nav-item">
                            <a class="nav-link" href="/Concessionaria/home"><i class=""></i>HOME</span></a>
                        </li>

                        <li class="nav-item dropdown">
                          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            VEÍCULOS
                          </a>
                          <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="/Concessionaria/veiculos/chevrolet">CHEVROLET</a>
                            <a class="dropdown-item" href="/Concessionaria/veiculos/fiat">FIAT</a>
                            <a class="dropdown-item" href="/Concessionaria/veiculos/ford">FORD</a>
                            <a class="dropdown-item" href="/Concessionaria/veiculos/honda">HONDA</a>
                            <a class="dropdown-item" href="/Concessionaria/veiculos/renault">RENAULT</a>
                            <a class="dropdown-item" href="/Concessionaria/veiculos/volkswagen">VOLKSWAGEN</a>
                            <div class="dropdown-divider"></div>
                          </div>
                        </li>
	<% if(request.getSession().getAttribute("id") == null){ %>
	
                      <li class="nav-item">
                        <a class="nav-link" href="/Concessionaria/cadastro"><i class=""></i>CADASTRO</span></a>
                      </li>
                  </ul>
                  <ul class="navbar-nav mr-">
                    <li class="nav-item active" style="float:right">
                      <a class="nav-link" href="/Concessionaria/login" data-toggle="" style="font-size: 1.2em; font-weight: bold;" ><span><i class="fas fa-sign-in-alt"></i></span> FAZER LOGIN</a>
                    </li>
                    </ul>
                    <%}%>
                  <ul class="navbar-nav mr-">
                    <li class="nav-item active">
                      <a class="nav-link" href="/Concessionaria/pedido/carrinho"><i class="fas fa-shopping-cart"></i></a>
                    </li>
                  </ul>
                  </div>
				<% if(request.getSession().getAttribute("id") != null){ %>
			
                  <div class="dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"  style="font-size: 1.2em; font-weight: bold;">
                      LOGOUT
                    </a>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton" style="background: black;">
                      <a class="dropdown-item">${nome}</a>
                     
                      <a class="dropdown-item" href="/Concessionaria/usuario/perfil">Perfil</a>
                       <% if (request.getSession().getAttribute("nome") != null){ %>
                      
                       
                                              
                       
                       
                      <a class="dropdown-item" href="/Concessionaria/usuario/listar">Usuarios</a>
                      <a class="dropdown-item" href="/Concessionaria/pedido/listar">Pedidos</a>
                      
                    
                      <a class="dropdown-item" href="/Concessionaria/logout">Sair</a>
                    </div>
                
                <%} %>
                   <%} %>
                  </div>
          </nav>
          
          
          