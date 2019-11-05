<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
        
<c:import url="/views/header.jsp"></c:import>



  <h3 class="text-center">Meu Perfil</h3>
  <div id="" class="container-perfil" style="padding-top:70px; padding-bottom:20px;">
    <div class="row">
      <div id="" class="col-xl-5 col-md-4">
        <br>
        <form action="atualizar" method="POST">
          <h3>Dados Pessoais</h3><br>
          <label for="nome">Nome: </label>
          <input type="text" class="input-form" name ="nome" value="${nome}">

          <hr>
          <div class="form-group">
            <label for="sobrenome">Sobrenome: </label>
            <input type="text" class="input-form" name ="sobrenome" value="${sobrenome} ">
          </div>
          <hr>
          <div class="form-group">
            <label for="cpf">CPF: </label>
            <input type="text" id="cpf" class="input-form" name ="cpf" value="${cpf}">
          </div>
          <hr>
          <div class="form-group">
            <label for="email">Email: </label>
            <input type="text" class="input-form" name ="email" value="${email}">
          </div>
          <hr>
         
          <div class="form-group" id="formulario">
           <c:forEach items="${contato}" var="c">
            <label for="telefone">
              <Table>Telefone:</Table>
            </label>
            
            <input type="text"  id="tel" class="input-form" value="${c.telefone}">
            </c:forEach>
            <button type="button" id="add-campo"> + </button>
          </div>
          <hr>
          <br>
          <h3> Dados de Entrega </h3>
          <br>
          <div id="esc1">
            <div class="form-group">
              <label for="cep">CEP:</label>
              <input type="text" id="cep" class="input-form" name ="cep" value="${cep}">
            </div>
            <hr>
            <div class="form-group">
              <label for="rua">Rua: </label>
              <input type="text" class="input-form"  name ="rua" value="${rua}">
            </div>
            <hr>
            <div class="form-group">
              <label for="num">Número: </label>
              <input type="text" class="input-form" name ="numero" value="${numero}">
            </div>
            <hr>
            <div class="form-group">
              <label for="complemento">Complemento: </label>
              <input type="text" class="input-form"  name ="complemento" value="${complemento}">
            </div>
            <hr>
            <div class="form-group">
              <label for="cidade">Cidade: </label>
              <input type="text" class="input-form"  name ="cidade" value="${cidade}">
            </div>
            <hr>
            <div class="form-group">
              <label for="bairro">Bairro: </label>
              <input type="text" class="input-form" name ="bairro" value="${bairro}">
            </div>
            <hr>
               <div class="form-group">
              <label for="bairro">Estado: </label>
              <input type="text" class="input-form" name ="estado" value="${estado}">
            </div>
          </div>
          <button class="btn btn-dark btn-block my-4" type="submit">Atualizar</button>
        </form>
      </div>
      <div id="" class="col-xl-7 col-md-8">
        <br>

        <h3>Ultimas Compras</h3><br><br>
       
        <div class="container-compras">

        <c:choose>
        <c:when test="${pedidoqtd != 0}">
		<c:forEach items="${pedido}" var="p">
          <div class="container-item">
        
                <table class="table text-center">
                  <thead>
                    <th>N° Pedido</th>
                    <th>data</th>
                    <th>Valor</th>
                    <th>Tipo de pagamento</th>
                    <th>Detalhe</th>
                  </thead>
                    
                  <tbody>
                  
                    <td>${p.id_pedido}</td>
                    <td>${p.data_pedido}</td>
                    <td class="valor">${p.valor_total}</td>
                    <td></td>
                    <td><span id="detalhe" data-toggle="modal" data-target="#id${p.id_pedido}" ><i class="fas fa-scroll"></i></span></td>
                  </tbody>
                
                </table>
                				
                
            </div>
               <!-- Modal -->
    <div class="modal fade" id="id${p.id_pedido}" tabindex="-1" role="dialog" aria-labelledby="TituloModalCentralizado"
        aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="TituloModalCentralizado">Detalhe da Compra</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    

                    <h3>Dados da compra</h3>
                    <label>Nome do Comprador: </label> ${nome}<br> 
                    <label>CPF do Comprador:  </label> ${cpf}<br>
                    <label>Valor Total:  </label> R$:<span class="valor"> ${p.valor_total} </span> 
                    <hr>
                    <h3>Endereço de Entrega</h3>
                    <label>Rua: </label> ${rua}<br> 
                    <label>Número: </label> ${numero} <br>
                    <label>Complemento: </label> ${complemento} <br>
                    <label>Estado: </label> ${estado} <br>
                    <label>Cidade: </label> ${cidade} <br>
                    <label>Bairro: </label> ${bairro} <br>
                    <hr>
                    
                    <h3>Itens do Pedido:</h3>
                    		<c:forEach items="${item}" var="i">
                    		<c:if test="${i.pedido.id_pedido == p.id_pedido}">
                    	
                    <label>Veiculo: ${i.veiculo.modeloVeiculo} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;&nbsp;Valor: <span class="valor">${i.veiculo.valorVeiculo}</span></label><br>
                     </c:if>
                                 </c:forEach>
                   
                    <hr>
                    <h3>Data da Compra: </h3>
                    <label>${p.data_pedido}</label><br>
                   

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
                </div>
            </div>
        </div>
    </div>
            
	
              </c:forEach>
              </c:when>
              <c:otherwise>
              
             
            <h1 style="    padding: 60px;text-align: center;color: gray;"> Voce ainda nao realizou compras</h1>
              </c:otherwise>
              </c:choose>
          </div>



    </div>
    </div>


  </div>
  
   
    <br></br><br></br><br></br><br></br>
    <script>
        $('.valor').mask('##.#00,0', { reverse: true });
    </script>
    
    
		<script>
       						$('#cpf').mask('000.000.000-00');
       						$("#tel").mask("(99) 99999-9999");
       						$("#cep").mask("00000-000");
    					</script>
    					
  <script>
    $("#add-campo").click(function () {
      $("#formulario").append('<label>Telefone:</label> <input type="text" name="telefone" class="input-form" ><br>');
    });
  </script>
<c:import url="/views/footer.jsp"></c:import>