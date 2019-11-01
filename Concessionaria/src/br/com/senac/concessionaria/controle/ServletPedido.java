package br.com.senac.concessionaria.controle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.senac.concessionaria.modelo.ItemPedido;
import br.com.senac.concessionaria.modelo.Veiculo;
import br.com.senac.concessionaria.servico.PedidoServico;


@WebServlet({ "/pedido/adicionar", "/pedido/remover", "/pedido/listar", "/pedido/localizar", "/pedido/editar", "/pedido/atualizar" })
public class ServletPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ItemPedido p;
	private Veiculo v;
	private PedidoServico ps;

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
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			List<ItemPedido> carrinho = new ArrayList<>();
			carrinho = (List<ItemPedido>) request.getSession().getAttribute("carrinho");
			
			if(carrinho.size() == 0) {
				ps = new PedidoServico();
				ps.selVeiculo(id);
				
				p = new ItemPedido(2, ps.retornoVeiculo());
				Double subTotal = ps.retornoVeiculo().getValorVeiculo() * p.getQuantidade();	
				p.setSub_Total(subTotal);	
				carrinho.add(p);
			} else {
				ps = new PedidoServico();
				ps.selVeiculo(id);
				
				p = new ItemPedido(2, ps.retornoVeiculo());
				Double subTotal = ps.retornoVeiculo().getValorVeiculo() * p.getQuantidade();	
				p.setSub_Total(subTotal);
				carrinho.add(p);
				request.getSession().setAttribute("carrinho", carrinho);
			}
			HttpSession sessao = request.getSession(true);
			sessao.setAttribute("carrinho", carrinho);
			response.sendRedirect("listar");
				
			
	
			
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