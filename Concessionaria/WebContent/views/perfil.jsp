<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
        
<c:import url="/views/header.jsp"></c:import>



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
                    <td><span id="detalhe" data-toggle="modal" data-target="#ExemploModalCentralizado" ><i class="fas fa-scroll"></i></span></td>
                  </tbody>
                
                </table>
                				
                
            </div>
	
              </c:forEach>
              
          </div>

 

    </div>
    </div>


  </div>
  
      <!-- Modal -->
    <div class="modal fade" id="ExemploModalCentralizado" tabindex="-1" role="dialog" aria-labelledby="TituloModalCentralizado"
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
                    <label>Nome do Comprador: </label><br>
                    <label>CPF do Comprador: </label><br>
                    <label>Valor Total: </label><br>
                    <hr>
                    <h3>Endereço de Entrega</h3>
                    <label>Rua: </label><br>
                    <label>Número: </label><br>
                    <label>Complemento: </label><br>
                    <label>Estado: </label><br>
                    <label>Cidade: </label><br>
                    <label>Bairro: </label><br>
                    <hr>
                    <h3>Itens do Pedido:</h3>
                    <label>Produto: Teste &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;&nbsp;Valor: <span class="valor">1000000</span></label><br>
                    <hr>
                    <h3>Data da Compra:</h3>
                    <label>Data: Variavel</label><br>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
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