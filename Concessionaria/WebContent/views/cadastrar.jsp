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
                            <input name="cpf" type="text" class="form-control" id="cpf" placeholder=" 999.999.999-99 " required>
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
                        <label for="exampleFormControlInput1">Complemento </label>
                        <input name="complemento" type="text" class="form-control" id="exampleFormControlInput1" placeholder="Adicione um complemento">
                      </div>
                      <div class="form-group">
                            <label for="exampleFormControlInput1">CEP </label>
                            <input name="cep" type="text" class="form-control" id="cep" placeholder="99999-999" required>
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Rua</label>
                            <input name="endereco" type="text" class="form-control" id="exampleFormControlInput1" placeholder="Rua Clemente 13" required>
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Número </label>
                            <input name="numResidencia" type="text" class="form-control" id="exampleFormControlInput1" placeholder="Digite o número da residência" required>
                        </div>
                        <div class="form-group">
                                <label for="exampleFormControlInput1">Cidade </label>
                                <input name="cidade" type="text" class="form-control" id="exampleFormControlInput1" placeholder="Digite o nome da sua cidade" required>
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Bairro </label>
                            <input name="bairro" type="text" class="form-control" id="exampleFormControlInput1" placeholder="Digite o nome do bairro" required>
                        </div>
                      
                        <div class="form-group">     
                              <label for="estado">Estado </label>
					      <select id="estado" name="estado" class="form-control" required>
					        <option selected>RJ</option>
					        <option>SP</option>
					      </select>
                        </div>
                        <div class="custom-control custom-checkbox">
                          <input type="checkbox" class="custom-control-input" id="defaultLoginFormRemember">
                          <label class="custom-control-label" for="defaultLoginFormRemember">Declaro que li e aceito os Termos</label>
                      </div>
                       <button class="btn btn-dark btn-block my-4" type="submit">Cadastrar</button>

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
    					
<c:import url="footer.jsp"></c:import>
