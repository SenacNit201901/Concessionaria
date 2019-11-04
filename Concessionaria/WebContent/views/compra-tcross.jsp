<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="header.jsp"></c:import>
    <!-- ###################### INICIO DO CONTEUDO #####################################-->
	<br>
    <br>
    <br>
    <br>
    
    <div class="container">
      <div class="title">
        <h1 class="titulo">Ficha Técnica</h1>
      </div>
    </div>
   
            <!--compra-->

          <br>

    <div class="container">
    <div class="card-deck">
    <div class="card">
        <h5 class="titulo" id="title">T-CROSS</h5>
        <p class="desc">Comfortline 200 TSI Automático</p>
              <img class="card-img-top" src="http://localhost/imagens/carros/cross.png" alt="Imagem de capa do card" style="width: 80%;">
            <div class="descricao">
                <ul>
                    <li class="ano">Ano
                        <h6>2020/2020</h6>
                    </li>
                    <li class="km">Km
                        <h6>0 km</h6>
                    </li>
                    <li class="cor">cor
                        <h6>Preto</h6>
                    </li>
                    <li class="cambio">Câmbio
                        <h6>Automático</h6>
                    </li>
                    <li class="portas">Portas
                        <h6>4 Portas</h6>
                    </li>
                </ul>
            </div>
            


            <div class="card-body">
                <p class="desc3">* 3 PRIMEIRAS REVISÕES INCLUSAS</p>
                
            </div>

            <hr>

                <div class="#">
                    <ul>
                    <li class="flex"> 
                        
                        <p><img src="http://localhost/imagens/icones/flex.png" style="width: 5%;">  Flex</p>                                    
                    </li>
                    <li class="#">
                        
                        <p><img src="http://localhost/imagens/icones/cinto.png" style="width: 5%;">  Airbag motorista, alarme, freios ABS, airbag passageiro, airbag lateral, controle de tração, distribuição eletrônica de frenagem</p>
                    </li>
                    <li class="#">
                        
                    <p><img src="http://localhost/imagens/icones/volante.png" style="width: 5%;"> Ar-condicionado, travas elétricas, retrovisores elétricos, câmbio automático, ar-quente, piloto automático, direção elétrica, volante com regulagem de altura, trio eletrico</p>
                    </li>
                    <li class="#">
                        
                      <p><img src="http://localhost/imagens/icones/radio.png" style="width: 5%;">   Kit Multimídia, entrada USB, rádio FM/AM</p>
                      </li>
                      <li class="#">
                        
                        <p><img src="http://localhost/imagens/icones/banco.jpg" style="width: 5%;">  Ajuste de altura, ajuste elétrico</p>
                        </li>
                    <li class="#">
                            
                        <p><img src="http://localhost/imagens/icones/porta.png" style="width: 5%;">  Vidros elétricos dianteiros, limp. traseiro, desemb. traseiro, vidros elétricos traseiros</p>
                    </li>                         
                    </ul>
                </div>
            </div>
                  
                <div class="card-footer" style="background-color: white;">
                        <hr>
                        <p class="preco">R$ 94.990,00</p>
                        <hr>
                    <div>
                        <h5>
                            Formas de pagamento:
                            <br>
                            <br>
                            <img src="http://localhost/imagens/pagamentos/pagamento-juntos.png" style="width:300px;">
                        </h5>
                        <br>
                        <br>
                                
                    </div>
                    <form action="/Concessionaria/pedido/adicionar" method="post" >
				<input type="hidden"  name="id" value="8"/>
                    <center>
                      <input type="submit" class="btn btn-secondary" onclick="mostraDialogo('Item adicionado no carrinho')"  value="ADICIONAR AO CARRINHO"/>
                    </center>
                   </form>
                </div>
            </div>
          </div>
        </div>



<c:import url="footer.jsp"></c:import>
        