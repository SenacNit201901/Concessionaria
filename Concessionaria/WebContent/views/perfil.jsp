<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
        
<c:import url="header.jsp"></c:import>



  <h3 class="text-center">Meu Perfil</h3>
  <div id="" class="container-perfil" style="padding-top:70px; padding-bottom:20px;">
    <div class="row">
      <div id="" class="col-md-6">
        <br>
        <form action="" method=POST>
          <h3>Dados Pessoais</h3><br>
          <label for="nome">Nome: </label>
          <input type="text" class="input-form" value="${nome}">

          <hr>
          <div class="form-group">
            <label for="sobrenome">Sobrenome: </label>
            <input type="text" class="input-form" value="${sobrenome} ">
          </div>
          <hr>
          <div class="form-group">
            <label for="cpf">CPF: </label>
            <input type="text" id="cpf" class="input-form" value="${cpf}">
          </div>
          <hr>
          <div class="form-group">
            <label for="email">Email: </label>
            <input type="text" class="input-form" value="${email}">
          </div>
          <hr>
          <div class="form-group" id="formulario">
            <label for="telefone">
              <Table>Telefone: </Table>
            </label>
            <input type="text"  id="tel" class="input-form" value="${telefone}">
            <button type="button" id="add-campo"> + </button>
          </div>
          <hr>
          <br>
          <h3> Dados de Entrega </h3>
          <br>
          <div id="esc1">
            <div class="form-group">
              <label for="cep">CEP:</label>
              <input type="text" id="cep" class="input-form" value="${cep}">
            </div>
            <hr>
            <div class="form-group">
              <label for="rua">Rua: </label>
              <input type="text" class="input-form" value="${rua}">
            </div>
            <hr>
            <div class="form-group">
              <label for="num">Número: </label>
              <input type="text" class="input-form" value="${numero}">
            </div>
            <hr>
            <div class="form-group">
              <label for="complemento">Complemento: </label>
              <input type="text" class="input-form" value="${complemento}">
            </div>
            <hr>
            <div class="form-group">
              <label for="cidade">Cidade: </label>
              <input type="text" class="input-form" value="${cidade}">
            </div>
            <hr>
            <div class="form-group">
              <label for="bairro">Bairro: </label>
              <input type="text" class="input-form" value="${bairro}">
            </div>
            <hr>
               <div class="form-group">
              <label for="bairro">Estado: </label>
              <input type="text" class="input-form" value="${estado}">
            </div>
          </div>
          <button class="btn btn-dark btn-block my-4" type="submit">Atualizar</button>
        </form>
      </div>
      <div id="" class="col-md-6">
        <br>

        <h3>Ultimas Compras</h3><br><br>
        <div class="container-compras">
        
	
          <div class="container-item">
        
                <table class="table text-center">
                  <thead>
                    <th scope="col">N° Pedido</th>
                    <th scope="col">data</th>
                    <th scope="col">Valor</th>
                    <th scope="col">Tipo de pagamento</th>
                  </thead>
                    	<c:forEach items="${pedido}" var="p">
                  <tbody>
                  
                    <td>${p.id_pedido}</td>
                    <td>${p.data_pedido}</td>
                    <td>${p.valor_total}</td>
                    <td>${p.forma_pagamento.tipo_pagamento}</td>
                  </tbody>
                  </c:forEach>
                </table>
                				
                
            </div>

            
          </div>

 

    </div>
    </div>


  </div>
		<script>
       						$('#cpf').mask('000.000.000-00');
       						$("#tel").mask("(99) 99999-9999");
       						$("#cep").mask("00000-000");
    					</script>
    					
  <script>
    $("#add-campo").click(function () {
      $("#formulario").append('<label>Telefone: </label> <input type="text" name="telefone" class="input-form" >');
    });
  </script>
<c:import url="footer.jsp"></c:import>