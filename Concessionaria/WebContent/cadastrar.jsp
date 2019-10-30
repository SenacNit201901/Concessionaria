<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
          <!-- Meta tags Obrigat�rias -->
          <meta charset="utf-8">
          <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

          <!-- Bootstrap CSS -->
          <link rel="stylesheet" href="index.css">
          <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
          <link rel="shortcut icon" href="imagens/favicon.png" type="image/x-png"/>

          <script src="https://kit.fontawesome.com/c766cb3ea7.js"></script>

          <title>CADASTRE-SE</title>

  </head>
  <body>

<!--################### NAV BAR ##########################-->


          <nav id="navbar" class="navbar navbar-expand-lg navbar-dark bg-red fixed-top">

              <main class="container">

                <a class="navbar-brand" style="width: 100px;" href="index.html">
                  <img id="logo" style="width: 100%;" rc="./imagens/logo.png"  alt="">
                </a>

                  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#conteudoNavbarSuportado" aria-controls="conteudoNavbarSuportado" aria-expanded="false" aria-label="Alterna navega��o">
                    <span class="navbar-toggler-icon"></span>
                  </button>


                  <div class="collapse navbar-collapse" id="conteudoNavbarSuportado">
                    <ul class="navbar-nav mr-auto">


                          <li class="nav-item">
                            <a class="nav-link" href="index.html"><i class=""></i>HOME</span></a>
                        </li>

                        <li class="nav-item dropdown">
                          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            VE�CULOS
                          </a>
                          <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="chevrolet.html">CHEVROLET</a>
                            <a class="dropdown-item" href="fiat.html">FIAT</a>
                            <a class="dropdown-item" href="ford.html">FORD</a>
                            <a class="dropdown-item" href="honda.html">HONDA</a>
                            <a class="dropdown-item" href="renault.html">RENAULT</a>
                            <a class="dropdown-item" href="volks.html">VOLKSWAGEN</a>
                            <div class="dropdown-divider"></div>
                          </div>
                        </li>


                      <li class="nav-item">
                        <a class="nav-link" href="cadastro.html"><i class=""></i>CADASTRO</span></a>
                      </li>


                  </ul>
                  <ul class="navbar-nav mr-">
                    <li class="nav-item active" style="float:right">
                      <a class="nav-link" href="login.html" data-toggle="" style="font-size: 1.2em; font-weight: bold;" ><span><i class="fas fa-sign-in-alt"></i></span> FAZER LOGIN</a>
                    </li>
                    </ul>
                  </div>


          </nav>



<br>
<br>
            <!-- FORMULARIO CADASTRO -->
            <form action="ServletCadastro" method="post">
            <div id="" class="container" style="padding-top:70px; padding-bottom:20px;">
                    <div class="form-row">
                      <div id="" class="col-md-6 offset-md-3" >
                        <h3>Crie uma conta para compras na nossa concessionaria</h3>
                        <br>
					
                      <div class="form-group">
                            <label for="exampleFormControlInput1">Nome </label>
                            <input name="nome" type="text" class="form-control" id="exampleFormControlInput1" placeholder="Digite o nome">
                      </div>
                      <div class="form-group">
                            <label for="exampleFormControlInput1">Sobrenome</label>
                            <input name="sobrenome" type="text" class="form-control" id="exampleFormControlInput1" placeholder="Digite o Sobrenome">
                      </div>
                      <div class="form-group">
                            <label for="exampleFormControlInput1">CPF </label>
                            <input name="cpf" type="text" class="form-control" id="exampleFormControlInput1" placeholder=" 999.999.999-99 ">
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Email </label>
                            <input name="email" type="email" class="form-control" id="exampleFormControlInput1" placeholder="exemplo123@gmail.com">
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Senha </label>
                            <input name="senha" type="text" class="form-control" id="exampleFormControlInput1" placeholder="Digite sua senha">
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlInput1"><Table>Telefone</Table></label>
                            <input name="telefone" type="text" class="form-control" id="exampleFormControlInput1" placeholder="(xx)99999-9999">
                        </div>
                      <div class="form-group">
                        <label for="exampleFormControlInput1">Complemento </label>
                        <input name="complemento" type="text" class="form-control" id="exampleFormControlInput1" placeholder="Adicione um complemento">
                      </div>
                      <div class="form-group">
                            <label for="exampleFormControlInput1">CEP </label>
                            <input name="cep" type="text" class="form-control" id="exampleFormControlInput1" placeholder="99999-999">
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Rua</label>
                            <input name="endereco" type="text" class="form-control" id="exampleFormControlInput1" placeholder="">
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlInput1">N�mero </label>
                            <input name="numResidencia" type="text" class="form-control" id="exampleFormControlInput1" placeholder="Digite o n�mero da resid�ncia">
                        </div>
                        <div class="form-group">
                                <label for="exampleFormControlInput1">Cidade </label>
                                <input name="cidade" type="text" class="form-control" id="exampleFormControlInput1" placeholder="Digite o nome da sua cidade">
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Bairro </label>
                            <input name="bairro" type="text" class="form-control" id="exampleFormControlInput1" placeholder="Digite o nome do bairro">
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Estado </label>
                            <input name="estado" type="text" class="form-control" id="exampleFormControlInput1" placeholder="exemplo 'RJ'">
                        </div>
                        <div class="custom-control custom-checkbox">
                          <input type="checkbox" class="custom-control-input" id="defaultLoginFormRemember">
                          <label class="custom-control-label" for="defaultLoginFormRemember">Declaro que li e aceito os Termos</label>
                      </div>
                        <button class="btn btn-outline-dark btn-block my-4"  type="submit">Cadastrar</button>

                        </div>
                 
                    </div>
                           
            </div>
            </form>

            <!-- ###################### FIM DO CONTEUDO #####################################-->

              <!-- JavaScript (Opcional) -->
              <!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
              <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
              <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
              <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>


            <!-- ######################FOOTER #####################################-->

            <br>

            <!-- Footer -->
            <footer id="rodape" class="page-footer font-small stylish-color-dark pt-4">

            <!-- Footer Links -->
            <div class="container text-center text-md-left">

            <!-- Grid row -->

            <!-- Footer Links -->

            <hr>

            <hr>
            <!-- Social buttons -->
            <ul class="list-unstyled list-inline text-center">
            <li class="list-inline-item">
              <a class="btn-floating btn-fb mx-1">
                <i class="fab fa-facebook-f"> </i>
              </a>
            </li>
            <li class="list-inline-item">
              <a class="btn-floating btn-tw mx-1">
                <i class="fab fa-twitter"> </i>
              </a>
            </li>
            <li class="list-inline-item">
              <a class="btn-floating btn-gplus mx-1">
                <i class="fab fa-google-plus-g"> </i>
              </a>
            </li>
            <li class="list-inline-item">
              <a class="btn-floating btn-li mx-1">
                <i class="fab fa-linkedin-in"> </i>
              </a>
            </li>
            <li class="list-inline-item">
              <a class="btn-floating btn-dribbble mx-1">
                <i class="fab fa-dribbble"> </i>
              </a>
            </li>
            </ul>

            <br><br>
            <!-- Social buttons -->
            <h4 class="text-center alert ">Nossos Parceiros:
            </h4>
            <div class="container text-center" >
              <a class="navbar-brand" href="https://www.chevrolet.com/">
                <img id="logo" src="./imagens/logos/chevrolet.png"  alt="">
              </a>
        
              <a class="navbar-brand" href="https://www.fiat.com.br/?rede=g&campanha=marca&gclid=Cj0KCQjwl8XtBRDAARIsAKfwtxBuz-voj6W2MEXiAgELX1y9_PrgiRvMR2vS5UiuyXQubzDlKG02KsYaAgeTEALw_wcB&gclsrc=aw.ds">
                <img id="logo" src="./imagens/logos/fiat.png"  alt="">
              </a>
        
              <a class="navbar-brand" href="https://www.ofertasford.com.br/">
                <img id="logo" src="./imagens/logos/ford.png"  alt="">
              </a>
        
              <a class="navbar-brand" href="https://www.honda.com.br/">
                <img id="logo" src="./imagens/logos/honda.png"  alt="">
              </a>
        
              <a class="navbar-brand" href="https://www.renault.com.br/">
                <img id="logo" src="./imagens/logos/renault.png"  alt="">
              </a>
        
              <a class="navbar-brand" href="https://www.vw.com.br/pt.html">
                <img id="logo" src="./imagens/logos/volks.png"  alt="">
              </a>
            </div>

            <!-- Copyright -->
            <div class="footer-copyright text-center py-3"> <p>Copyright � 2019 Senac Motors Company</p> <p>Todos os direitos reservados</p>
            </div>
            <!-- Copyright -->

            </footer>
            <!-- Footer -->

            </body>
            </html>