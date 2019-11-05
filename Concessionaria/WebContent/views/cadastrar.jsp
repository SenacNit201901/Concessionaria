<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="header.jsp"></c:import>

            <!-- FORMULARIO CADASTRO -->
            <form action="cadastrar" method="post" id="cadastro">
            <div id="" class="container" style="padding-top:70px; padding-bottom:20px;">
                    <div class="form-row">
                      <div id="" class="col-md-6 offset-md-3" >
                        <h3>Crie uma conta para compras na nossa concessionaria</h3>
                        <br>
					
                      <div class="form-group">
                            <label for="exampleFormControlInput1">Nome </label>
                            <input name="nome" type="text" class="form-control" id="exampleFormControlInput1" placeholder="Digite o nome" required>
                      </div>
                      <div class="form-group">
                            <label for="exampleFormControlInput1">Sobrenome</label>
                            <input name="sobrenome" type="text" class="form-control" id="exampleFormControlInput1" placeholder="Digite o Sobrenome">
                      </div>
                      <div class="form-group">
                            <label for="exampleFormControlInput1">CPF </label>
                            <input name="cpf" type="text" class="form-control" name="cpf" id="cpf" placeholder=" 999.999.999-99 " required>
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Email </label>
                            <input name="email" type="email" class="form-control" id="exampleFormControlInput1" placeholder="exemplo123@gmail.com" required>
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Senha </label>
                            <input name="senha" type="password" class="form-control" id="exampleFormControlInput1" placeholder="Digite sua senha" required>
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlInput1"><Table>Telefone</Table></label>
                            <input name="telefone" type="text" class="form-control" id="tel" placeholder="(xx)99999-9999" required>
                        </div>
                      <div class="form-group">
                            <label for="exampleFormControlInput1">CEP </label>
                            <input name="cep" type="text" class="form-control" id="cep" placeholder="99999-999" required>
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Rua</label>
                            <input name="endereco" type="text" class="form-control" id="rua" placeholder="Rua Clemente 13" required>
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Número </label>
                            <input name="numResidencia" type="text" class="form-control" id="exampleFormControlInput1" placeholder="Digite o número da residência" required>
                        </div>
                      <div class="form-group">
                        <label for="exampleFormControlInput1">Complemento </label>
                        <input name="complemento" type="text" class="form-control" id="exampleFormControlInput1" placeholder="Adicione um complemento">
                      </div>
                        <div class="form-group">
                                <label for="exampleFormControlInput1">Cidade </label>
                                <input name="cidade" type="text" class="form-control" id="cidade" placeholder="Digite o nome da sua cidade" required>
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Bairro </label>
                            <input name="bairro" type="text" class="form-control" id="bairro" placeholder="Digite o nome do bairro" required>
                        </div>
                      
                        <div class="form-group">     
                              <label for="estado">Estado </label>
					      <select id="uf" name="estado" class="form-control" required>
					     			<option></option>
                                    <option>AC</option>
                                    <option>AL</option>
                                    <option>AP</option>
                                    <option>AM</option>
                                    <option>BA</option>
                                    <option>CE</option>
                                    <option>DF</option>
                                    <option>ES</option>
                                    <option>GO</option>
                                    <option>MA</option>
                                    <option>MT</option>
                                    <option>MS</option>
                                    <option>MG</option>
                                    <option>PA</option>
                                    <option>PB</option>
                                    <option>PR</option>
                                    <option>PE</option>
                                    <option>PI</option>
                                    <option>RJ</option>
                                    <option>RN</option>
                                    <option>RS</option>
                                    <option>RO</option>
                                    <option>RR</option>
                                    <option>SC</option>
                                    <option>SP</option>
                                    <option>SE</option>
                                    <option>TO</option>
					      </select>
                        </div>
                       <button class="btn btn-dark btn-block my-4" onclick="return validar();" type="submit">Cadastrar</button>

                        </div>
                 
                    </div>
                           
            </div>
            </form>
         
              <script>
    $(function(){
      $("#cadastro").submit(function(){
        alert('Cadastro feito com sucesso!');
      });
    });
  </script>
  <!--Script para Mascara -->
		<script>
       						$('#cpf').mask('000.000.000-00');
       						$("#tel").mask("(99) 99999-9999");
       						$("#cep").mask("00000-000");
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
    $("#cpf").validate({
    	rules: {
    	    'cpf': {
    	        required: true,
    	        cpf: true,
    	        remote: {
    	            url: "/api/findUserByCpf",
    	            type: "GET",
    	            data: {
    	                cpf: function() {
    	                    return $("#validationCpfOperador").val()
    	                }
    	            },
    	            dataType: 'json',
    	            success: function(data) {
    	                if (data.existe == true) {
    	                    console.log("Já existe o CPF cadastrado")
    	                } else {
    	                    console.log("CPF disponivel")
    	                }
    	            }
    	        }
    	    },
    	},
    	messages: {
    	    'cpf': {
    	        required: "Informe o CPF",
    	        remote: 'CPF já cadastrado'
    	    },
    	}
    	});
    </script>
<c:import url="footer.jsp"></c:import>
