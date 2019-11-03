<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="header.jsp"></c:import>


      <!--################### LOGIN  ##########################-->
      <hr><hr>

      <div class="row">
          <div id="" class="col-md-6 offset-md-3" >
      <!-- Default form login -->
      <form class="text-center border border-light p-5" action="logar" method="post">

          <p class="h4 mb-4">Entre com o seu usuário e senha</p>
          <br>

          <!-- Email -->
          <input type="email" id="defaultLoginFormEmail"  name="email" class="form-control mb-4" placeholder="Usuario" required>

          <!-- Password -->
          <input type="password" id="defaultLoginFormPassword" name="senha" class="form-control mb-4" placeholder="Senha" required>

          <div class="d-flex justify-content-around">
              <div>
                  <!-- Remember me -->
                  <div class="custom-control custom-checkbox">
                      <input type="checkbox" class="custom-control-input" id="defaultLoginFormRemember">
                      <label class="custom-control-label" for="defaultLoginFormRemember">Lembre-me</label>
                  </div>
              </div>
              <div>
                  <!-- Forgot password -->
                  <a href="/Concessionaria/usuario/recuperar-senha" style="color: black; font-size: 1em;">Esqueceu a sua senha?</a>
              </div>
          </div>

            <button class="btn btn-dark btn-block my-4"  type="submit">Entrar</button>

            <!-- Register -->
            <p>Ainda não tem um cadastro?
                <a href="cadastro.html"style="color: black; font-size: 1em;" >Cadastre-se!</a>
            </p>


          <!-- Social login -->

      </form>
      <!-- Default form login -->
      




</div>
</div>

</div>

  <c:import url="footer.jsp"></c:import>