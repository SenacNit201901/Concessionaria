<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="header.jsp"></c:import>
	<br>
	<br>
	<br>
	<br>
    <div class="container">
		<table class="table table-striped">
			<caption>Lista de Clientes </caption>
			<thead>
				<tr>
					<th>id</th>
					<th>Nome</th>
					<th>SobreNome</th>					
					<th>CPF</th>
					<th>E-mail</th>
					<th colspan="2">Gerenciar</th>
				</tr>
			</thead>
			<tbody>
				<!-- Tag responsavel por fazer repetições no HTML c:foreach -->
				<c:forEach items="${user}" var="cliente">
				<!-- EL - Expression Language -->
					<tr>
						<td>${cliente.id_usuario}</td>
						<td>${cliente.nome}</td>
						<td>${cliente.sobrenome}</td>
						
						<td id="cpf">${cliente.cpf}</td>
						<td>${cliente.email}</td>
						<td><a href="editar?id=${cliente.id_usuario}">Editar</a></td>
					</tr>
				</c:forEach>
				
				
				
			</tbody>
		</table>
	</div>
	
	
	
	    <script>
        $("#cpf").mask("000.000.000-00");
    </script>


<c:import url="footer.jsp"></c:import>