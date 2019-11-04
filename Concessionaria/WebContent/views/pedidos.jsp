<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="header.jsp"></c:import>
    <!-- ###################### INICIO DO CONTEUDO #####################################-->
	<br>
	<br>
	<br>
	<br>
    <div class="container" style="min-height: 500px;">
		<table class="table table-striped">
			<caption>Lista de Pedidos </caption>
			<thead>
				<tr>
					<th>id</th>
					<th>Data</th>
					<th>Valor Total</th>					
					<th>Parcelas</th>
					<th>Nome do Usuario</th>
					<th>Forma de Pagamento</th>
				</tr>
			</thead>
			<tbody>
				<!-- Tag responsavel por fazer repetições no HTML c:foreach -->
				<c:forEach items="${pedidos}" var="pedido">
				<!-- EL - Expression Language -->
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</c:forEach>
				
				
				
			</tbody>
		</table>
	</div>


<c:import url="footer.jsp"></c:import>
        