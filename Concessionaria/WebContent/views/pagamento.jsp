<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
              
<c:import url="header.jsp"></c:import>
<br><br><br>
 <div class="container">
        <div class="py-5 text-center">
            <h2>Informações de Pagamento</h2>
            <p class="lead">
                Insira seus dados</p>
        </div>

        <div>
            <input type="radio" id="cadastro2" checked name="check1" class="atual">
            <label>Usar endereço de Cadastro</label><br>
            <input type="radio" id="cadastro" name="check1" class="outro">
            <label>Usar outro endereço &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
        </div><br>
        <div class="row">
            <div class="col-md-4 order-md-2 mb-4">
                <div style="overflow: scroll; height: 400px !important">
                    <h4 class="d-flex justify-content-between align-items-center mb-3">
                        <span class="text-muted">Seu carrinho</span>
                        
                        <!--Quantidade de produtos do carrinho-->
                        <span class="badge badge-secondary badge-pill">${qtd}</span>
                    </h4>
                    <ul class="list-group mb-3">

                        <!--Inicio do Foreach-->
                        			<c:forEach items="${carrinho}" var="c">
                        			<form action="/Concessionaria/pedido/remover" method="post" >
                        			<input type="hidden" value="${c.id_item}" name="id_item"/>
                        <li class="list-group-item d-flex justify-content-between lh-condensed">
                            <div>
                                <h6 class="my-0">${c.veiculo.modeloVeiculo}</h6>
                                <small class="text-muted">
                                    Quantidade: ${c.quantidade}</small>
                                    
                            </div>
                       
                            <span class="text-muted din">${c.sub_Total}</span>
                           <label for="submit" ><span class="text-muted"><i class="fas fa-times" style="cursor: pointer;" id="x"></i></span></label> 
                           <input style="display: none;" id="submit" type="submit" />
                           </form>
                        </li>
                
                        <!--Fim do foreach-->
                 	</c:forEach>
                    </ul>
                </div>

                <li class="list-group-item d-flex justify-content-between">
                        <span>Total (R$)</span>
                        <strong><div id="dinheiro">${valor}</div></strong>
                    </li>
            </div>


            <div class="col-md-8 order-md-1 esconder" id="esc2">
                <h4 class="mb-3">Endereço de cobrança</h4>
                <form action="comprar" method="post"class="needs-validation">
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="primeiroNome">Nome</label>
                            <input type="text" class="form-control" id="firstName" placeholder="José" value="" required>
                            <div class="invalid-feedback">
                                É necessário o primeiro nome válido.
                            </div>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="ultimoNome">Sobrenome</label>
                            <input type="text" class="form-control" id="lastName" placeholder="da Silva" value=""
                                required>
                            <div class="invalid-feedback">
                                é necessário o ultimo nome válido.
                            </div>
                        </div>
                    </div>

                    <div class="mb-3">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" id="email" placeholder="you@example.com">
                        <div class="invalid-feedback">
                            Digite um endereço de e-mail válido para atualizações de remessa.
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="exampleFormControlInput1">
                            <Table>Telefone</Table>
                        </label>
                        <input name="telefone" type="text" id="tel" class="form-control" placeholder="(xx) 99999-9999">
                    </div>


                    <div class="mb-3">

                        <div class="mb-3">
                            <label for="zip">CEP</label>
                            <input type="text" class="form-control" id="cep" placeholder="24000-909" required>
                            <div class="invalid-feedback">
                                Digite um CEP válido.
                            </div>
                        </div>
                        <div class="mb-3">
                            <label for="endereço">Endereço</label>
                            <input type="text" class="form-control" id="rua" placeholder="Rua Clemente 13" required>
                            <div class="invalid-feedback">
                                Por favor insira seu endereço de entrega.
                            </div>
                        </div>
                    </div>
                    <div class="row">

                        <div class="col-md-5 mb-3">
                            <label for="estado">Estado</label>
                            <input type="text" class="form-control" id="uf" placeholder="Digite o nome do estado">
                            <div class="invalid-feedback">
                                Por favor insira um estado válido.
                            </div>
                        </div>
                        <div class="col-md-5 mb-3">
                            <label for="cidade">Cidade</label>
                            <input type="text" class="form-control" id="cidade" placeholder="Digite o nome do estado">
                            <div class="invalid-feedback">
                                Por favor insira um estado válido.
                            </div>
                        </div>
                        <div class="col-md-2">
                            <label for="num">Número</label>
                            <input type="text" class="form-control" id="num">
                        </div>
                    </div>
                    <label for="complemento">Complemento <span class="text-muted">(opcional)</span></label>
                    <input type="text" class="form-control" id="address2" placeholder="Apartamento ou casa">

                    <br>
                    <hr class="mb-4"><br>

                    <h4 class="mb-3">Pagamento</h4>

                    <div class="custom-control custom-radio">
                        <input type="radio" id="botao" name="check" class="cred1"  checked>
                        <label for="credit">Cartão de crédito</label>
                    </div>
                    <div id="cart1">
                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <label for="cc-name">Nome do cartão</label>
                                <input type="text" class="form-control sumir" id="cc-name" placeholder="" required>
                                <small class="text-muted">Full name as displayed on card</small>
                                <div class="invalid-feedback">
                                    Name on card is required
                                </div>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="cc-number">Número do cartão de crédito</label>
                                <input type="text" class="form-control sumir" id="ccredito1" placeholder="" required>
                                <div class="invalid-feedback">
                                    Credit card number is required
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-3 mb-3">
                                <label for="cc-expiration">Data de validade</label>
                                <input type="text" class="form-control sumir" id="data1" placeholder="" required>
                                <div class="invalid-feedback">
                                    Expiration date required
                                </div>
                            </div>
                            <div class="col-md-3 mb-3">
                                <label for="cc-expiration">CVV</label>
                                <input type="text" class="form-control sumir" id="cvv1" placeholder="" required>
                                <div class="invalid-feedback">
                                    Security code required
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="custom-control custom-radio">
                        <input type="radio" id="botao" name="check" class="bol1">
                        <label for="debit">Boleto</label>
                    </div>
                    <hr class="mb-4">
                    <button class="btn btn-dark btn-lg btn-block" type="submit">Comprar</button>
                </form>
            </div>

            <div class="col-md-8 order-md-1" id="esc1">
                <h4 class="mb-3">Endereço de cobrança</h4>
                <form action="comprar" id="comprar" method="post"class="needs-validation">
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="primeiroNome">Nome</label>
                        <input type="text" class="form-control" id="firstName" placeholder="José" value="${nome}" required>
                        <div class="invalid-feedback">
                            É necessário o primeiro nome válido.
                        </div>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="ultimoNome">Sobrenome</label>
                        <input type="text" class="form-control" id="lastName" placeholder="da Silva" value="${sobrenome}" required>
                        <div class="invalid-feedback">
                            é necessário o ultimo nome válido.
                        </div>
                    </div>
                </div>

                <div class="mb-3">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" id="email" value="${email}" placeholder="you@example.com">
                    <div class="invalid-feedback">
                        Digite um endereço de e-mail válido para atualizações de remessa.
                    </div>
                </div>


                <div class="form-group">
                    <label for="exampleFormControlInput1">
                        <Table>Telefone</Table>
                    </label>
                    <input name="telefone" type="text" id="tel1" class="form-control" placeholder="(xx) 99999-9999">
                </div>


                <div class="mb-3">

                    <div class="mb-3">
                        <label for="zip">CEP</label>
                        <input type="text" class="form-control" id="cep1" value="${cep}" placeholder="24000-99" required>
                        <div class="invalid-feedback">
                            Digite um CEP válido.
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="endereço">Rua</label>
                        <input type="text" class="form-control" id="rua1" value="${rua}" placeholder="Rua Clemente 13" required>
                        <div class="invalid-feedback">
                            Por favor insira seu endereço de entrega.
                        </div>
                    </div>
                </div>
                <div class="row">

                    <div class="col-md-5 mb-3">
                        <label for="estado">Estado</label>
                        <input type="text" class="form-control" value="${estado}" id="uf1" placeholder="Digite o nome do estado">
                        <div class="invalid-feedback">
                            Por favor insira um estado válido.
                        </div>
                    </div>
                    <div class="col-md-5 mb-3">
                        <label for="cidade">Cidade</label>
                        <input type="text" class="form-control" value="${cidade}" id="cidade1" placeholder="Digite o nome do estado">
                        <div class="invalid-feedback">
                            Por favor insira um estado válido.
                        </div>
                    </div>
                    <div class="col-md-2">
                        <label for="num">Número</label>
                        <input type="text" class="form-control" value="${numero}" id="num">
                    </div>
                </div>
                <label for="complemento">Complemento <span class="text-muted">(opcional)</span></label>
                <input type="text" class="form-control" value="${complemento}" id="address2" placeholder="Apartamento ou casa">
                <br>

                <hr class="mb-4">

                <h4 class="mb-3">Pagamento</h4>

                <div class="custom-control custom-radio">
                    <input id="credit" name="paymentMethod" type="radio" class="custom-control-input" checked required>
                    <input type="radio" id="botao" name="formPag" class="cred" checked>
                    <label for="credit">Cartão de crédito</label>
                </div>
                <div id="cart">
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="cc-name">Nome do cartão</label>
                            <input type="text" class="form-control sumir" id="cc-name" placeholder="" required>
                            <small class="text-muted">Full name as displayed on card</small>
                            <div class="invalid-feedback">
                                Name on card is required
                            </div>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="cc-number">Número do cartão de crédito</label>
                            <input type="text" class="form-control sumir" id="ccredito" placeholder="" required>
                            <div class="invalid-feedback">
                                Credit card number is required
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-3 mb-3">
                            <label for="cc-expiration">Data de validade</label>
                            <input type="text" class="form-control sumir" id="data" placeholder="" required>
                            <div class="invalid-feedback">
                                Expiration date required
                            </div>
                        </div>
                        <div class="col-md-3 mb-3">
                            <label for="cc-expiration">CVV</label>
                            <input type="text" class="form-control sumir" id="cvv" placeholder="" required>
                            <div class="invalid-feedback">
                                Security code required
                            </div>
                        </div>
                    </div>
                </div>
               

                <div class="custom-control custom-radio">

                    <input type="radio" id="botao" name="formPag"  class="bol">
                    <label for="debit">Boleto</label>
                </div>
                <hr class="mb-4">

                <button class="btn btn-dark btn-lg btn-block" form="comprar">Comprar</button>
                </form>
                <br><br>
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
                        &nbsp;&nbsp;&nbsp;&nbsp;Valor: <span id="valor">1000000</span></label><br>
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
        $('#valor').mask('##.#00,0', { reverse: true });
    </script>
    

     <script>
        $(function () {
            $('.bol').click(function () {
                $('#cart').addClass('cartao');
            });
        });

        $(function () {
            $('.cred').click(function () {
                $('#cart').removeClass('cartao');
            });
        });

        $(function () {
            $('.bol1').click(function () {
                $('#cart1').addClass('cartao');
            });
        });

        $(function () {
            $('.bol').click(function () {
                $('.sumir').removeAttr('required');
            });
        });
        
        $(function () {
            $('.bol1').click(function () {
                $('.sumir').removeAttr('required');
            });
        });
        
        $(function () {
            $('.cred1').click(function () {
                $('#cart1').removeClass('cartao');
            });
        });

    </script>

    <script>

        $(function () {
            $('.outro').click(function () {
                $('#esc1').addClass('esconder');
                $('#esc2').removeClass('esconder');
            });
        });

        $(function () {
            $('.atual').click(function () {
                $('#esc2').addClass('esconder');
                $('#esc1').removeClass('esconder');
            });
        });

    </script>

    <!--Script para auto preenchimento de endereço a partir do CEP -->
    <script type="text/javascript">

        $(document).ready(function () {

            function limpa_formulário_cep() {
                // Limpa valores do formulário de cep.
                $("#rua").val("");
                $("#bairro").val("");
                $("#cidade").val("");
                $("#uf").val("");

            }

            //Quando o campo cep perde o foco.
            $("#cep").blur(function () {

                //Nova variável "cep" somente com dígitos.
                var cep = $(this).val().replace(/\D/g, '');

                //Verifica se campo cep possui valor informado.
                if (cep != "") {

                    //Expressão regular para validar o CEP.
                    var validacep = /^[0-9]{8}$/;

                    //Valida o formato do CEP.
                    if (validacep.test(cep)) {

                        //Preenche os campos com "..." enquanto consulta webservice.
                        $("#rua").val("...");
                        $("#bairro").val("...");
                        $("#cidade").val("...");
                        $("#uf").val("...");

                        //Consulta o webservice viacep.com.br/
                        $.getJSON("https://viacep.com.br/ws/" + cep + "/json/?callback=?", function (dados) {

                            if (!("erro" in dados)) {
                                //Atualiza os campos com os valores da consulta.
                                $("#rua").val(dados.logradouro);
                                $("#bairro").val(dados.bairro);
                                $("#cidade").val(dados.localidade);
                                $("#uf").val(dados.uf);
                            } //end if.
                            else {
                                //CEP pesquisado não foi encontrado.
                                limpa_formulário_cep();
                                alert("CEP não encontrado.");
                            }
                        });
                    } //end if.
                    else {
                        //cep é inválido.
                        limpa_formulário_cep();
                        alert("Formato de CEP inválido.");
                    }
                } //end if.
                else {
                    //cep sem valor, limpa formulário.
                    limpa_formulário_cep();
                }
            });
        });

    </script>

    <script>
        $("#tel").mask("(99) 99999-9999");
        $("#cep").mask("00000-000");
        $("#data").mask("00/00");
        $("#cvv").mask("000");
        $("#ccredito").mask("0000 0000 0000 0000");
        $("#data1").mask("00/00");
        $("#cvv1").mask("000");
        $("#ccredito1").mask("0000 0000 0000 0000");
        $("#tel1").mask("(99) 99999-9999");
        $("#cep1").mask("00000-000");
        $('#dinheiro').mask('##.#00,0', {reverse: true});
        $('.din').mask('##.#00,0', {reverse: true});
    </script>
    
    


<c:import url="footer.jsp"></c:import>