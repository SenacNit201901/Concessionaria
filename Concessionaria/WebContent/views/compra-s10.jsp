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
        <h5 class="titulo" id="title">S10 LTZ</h5>
        <p class="desc">MOTOR 2.5L ECOTEC</p>
              <img class="card-img-top" src="http://localhost/imagens/carros/s10.png" alt="Imagem de capa do card" style="width: 80%;">
            <div class="descricao">
                <ul>
                    <li class="ano">Ano
                        <h6>2019/2020</h6>
                    </li>
                    <li class="km">Km
                        <h6>0 km</h6>
                    </li>
                    <li class="cor">cor
                        <h6>Azul</h6>
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
                        <p class="compra"><img src="http://localhost/imagens/icones/flex.png" style="width: 5%;">  Flex</p>                                    
                    </li>
                    <li class="#">
                        <p class="compra"><img src="http://localhost/imagens/icones/cinto.png" style="width: 5%;">  Freios ABS</p>
                    </li>
                    <li class="#">
                    <p class="compra"><img src="http://localhost/imagens/icones/volante.png" style="width: 5%;"> Ar-condicionado, direção hidráulica, travas elétricas, retrovisores elétricos, câmbio automático, trio eletrico, ar-quente</p>
                    </li>
                    <li class="#"> 
                        <p class="compra"><img src="http://localhost/imagens/icones/porta.png" style="width: 5%;">  Vidros elétricos dianteiros</p>
                    </li>                         
                    </ul>
                </div>
            </div>
                  
                <div class="card-footer" style="background-color: white;">
                        <hr>
                        <p class="preco">R$ 130.990,00</p>
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
				<input type="hidden"  name="id" value="11"/>
                    <center>
                      <input type="submit" class="btn btn-secondary" onclick="mostraDialogo('Item adicionado no carrinho')"  value="ADICIONAR AO CARRINHO"/>
                    </center>
                   </form>
                </div>
            </div>
          </div>
        </div>



<c:import url="footer.jsp"></c:import>
        