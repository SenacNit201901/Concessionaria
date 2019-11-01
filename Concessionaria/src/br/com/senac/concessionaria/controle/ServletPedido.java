package br.com.senac.concessionaria.controle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.senac.concessionaria.modelo.ItemPedido;
import br.com.senac.concessionaria.modelo.Pedido;
import br.com.senac.concessionaria.modelo.Veiculo;
import br.com.senac.concessionaria.servico.PedidoServico;


@WebServlet({ "/pedido/adicionar", "/pedido/remover", "/pedido/listar", "/pedido/localizar", "/pedido/editar", "/pedido/atualizar", "/pedido/comprar" })
public class ServletPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ItemPedido p;
	private Veiculo v;
	private PedidoServico ps;
	private Pedido pedido;

    public ServletPedido() {
        super();
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	if(request.getServletPath().equals("/pedido/listar")) { 
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
		} else if(request.getServletPath().equals("/pedido/comprar")) {
			comprar(request, response);
		} else if(request.getServletPath().equals("/pedido/atualizar")) {
			atualizar(request, response);
		} else if(request.getServletPath().equals("/pedido/remover")) { 
			remover(request, response);
		} else {
			response.getWriter().append("Página não localizada!!! " + request.getMethod());
		}
	}
	
	protected void adicionar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession sessao = request.getSession(true);
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			List<ItemPedido> carrinho = new ArrayList<>();
			carrinho = (List<ItemPedido>) request.getSession().getAttribute("carrinho");
			Double valorTotal = (Double) request.getSession().getAttribute("valor");
			int q = Integer.parseInt(request.getParameter("quantidade"));
			
			if(carrinho.size() == 0) {
				ps = new PedidoServico();
				pedido = new Pedido();
				
				ps.selVeiculo(id);
				
				p = new ItemPedido(q, ps.retornoVeiculo());
				Double subTotal = ps.retornoVeiculo().getValorVeiculo() * p.getQuantidade();	
				p.setSub_Total(subTotal);
				p.setId_item(carrinho.size());
				Double valor = subTotal;
				sessao.setAttribute("valor", valor);
				pedido.setValor_total(valor);
				p.setPedido(pedido);
				carrinho.add(p);
			} else {
				ps = new PedidoServico();
				pedido = new Pedido();
				
				
				ps.selVeiculo(id);
				
				
				
				
				p = new ItemPedido(q, ps.retornoVeiculo());
				Double subTotal = ps.retornoVeiculo().getValorVeiculo() * p.getQuantidade();	
				p.setSub_Total(subTotal);
				p.setId_item(carrinho.size());
				Double valor = subTotal + valorTotal;
				sessao.setAttribute("valor", valor);
				pedido.setValor_total(valor);
				p.setPedido(pedido);
				carrinho.add(p);
			}
			
			
			

			sessao.setAttribute("carrinho", carrinho);
			response.sendRedirect("/Concessionaria/veiculo/listar");
				
			
	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	protected void remover(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id_item = Integer.parseInt(request.getParameter("id_item"));
		List<ItemPedido> carrinho = new ArrayList<>();
		carrinho = (List<ItemPedido>) request.getSession().getAttribute("carrinho");
		Double valorTotal = (Double) request.getSession().getAttribute("valor");

		
		if(carrinho.size() == 1) {
			carrinho.remove(0);
			Double valor = 0.0;

			HttpSession sessao = request.getSession(true);
			sessao.setAttribute("carrinho", carrinho);
			sessao.setAttribute("valor", valor );

			
		} else {
			for(int i = 0 ; i <= carrinho.size(); i++) {
				
					if(carrinho.get(i).getId_item() == id_item) {
						Double valor = valorTotal - carrinho.get(i).getSub_Total();
						carrinho.remove(i);
						HttpSession sessao = request.getSession(true);
						sessao.setAttribute("carrinho", carrinho);
						sessao.setAttribute("valor", valor );

						break;
					}
					
				
			}
			
		}
				
				

		
		
			
		
		
		response.sendRedirect("/Concessionaria/veiculo/listar");
	}
	
	protected void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.getWriter().append("Método: " + request.getMethod());
	}
	
	protected void localizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.getWriter().append("Método: " + request.getMethod());
	}
	
	protected void comprar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<ItemPedido> carrinho = new ArrayList<>();
		carrinho = (List<ItemPedido>) request.getSession().getAttribute("carrinho");
		
	}
	
	protected void atualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.getWriter().append("Método: " + request.getMethod());
	}

}