package br.com.senac.concessionaria.controle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.senac.concessionaria.servico.PedidoServico;
import br.com.senac.concessionaria.servico.VeiculoServico;


@WebServlet({ "/pedido/adicionar", "/pedido/remover", "/pedido/listar", "/pedido/localizar", "/pedido/editar", "/pedido/atualizar" })
public class ServletPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
    PedidoServico pd;   
    VeiculoServico vs;

    public ServletPedido() {
        super();
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getServletPath().equals("/pedido/remover")) { 
			remover(request, response);
		} else if(request.getServletPath().equals("/pedido/editar")) { 
			editar(request, response);
		} else if(request.getServletPath().equals("/pedido/listar")) { 
			listar(request, response);
		} else if(request.getServletPath().equals("/pedido/localizar")) { 
			localizar(request, response);
		} else {
			response.getWriter().append("Página não localizada!!! " + request.getMethod());
		}
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getServletPath().equals("/pedido/adicionar")) { 
			adicionar(request, response);
		} else if(request.getServletPath().equals("/pedido/atualizar")) {
			atualizar(request, response);
		} else {
			response.getWriter().append("Página não localizada!!! " + request.getMethod());
		}
	}
	
	protected void adicionar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		pd = new PedidoServico();
		vs = new VeiculoServico();
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			pd.cadastrarPagamento("cartao");
			pd.cadastrarPedido(new Date(), 2, 2);
			pd.cadastrarItem(1, id);
			
			request.setAttribute("carrinho", pd.listarCarrinho());
			request.setAttribute("veiculo", vs.listar());
			request.getRequestDispatcher("/veiculo.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	protected void remover(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.getWriter().append("Método: " + request.getMethod());
	}
	
	protected void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.getWriter().append("Método: " + request.getMethod());
	}
	
	protected void localizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.getWriter().append("Método: " + request.getMethod());
	}
	
	protected void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.getWriter().append("Método: " + request.getMethod());
	}
	
	protected void atualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.getWriter().append("Método: " + request.getMethod());
	}

}