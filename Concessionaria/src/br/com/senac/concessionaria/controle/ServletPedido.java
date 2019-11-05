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

import br.com.senac.concessionaria.modelo.FormaPagamento;
import br.com.senac.concessionaria.modelo.ItemPedido;
import br.com.senac.concessionaria.modelo.Pedido;
import br.com.senac.concessionaria.modelo.Usuario;
import br.com.senac.concessionaria.modelo.Veiculo;
import br.com.senac.concessionaria.servico.PedidoServico;


@WebServlet({ "/pedido/adicionar", "/pedido/remover", "/pedido/listar", "/pedido/localizar", "/pedido/editar", "/pedido/atualizar", "/pedido/comprar", "/pedido/carrinho", "/pedido/finalizar" })
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
		} else if(request.getServletPath().equals("/pedido/finalizar" )) { 
			request.getRequestDispatcher("/views/finalizar.jsp").forward(request, response);
		} else	if(request.getServletPath().equals("/pedido/carrinho")) { 
			request.getRequestDispatcher("/views/pagamento.jsp").forward(request, response);
		} else if(request.getServletPath().equals("/pedido/localizar")) { 
			localizar(request, response);
		} else {
			response.getWriter().append("P�gina n�o localizada!!! " + request.getMethod());
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
			response.getWriter().append("P�gina n�o localizada!!! " + request.getMethod());
		}
	}
	
	protected void adicionar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession sessao = request.getSession(true);
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			List<ItemPedido> carrinho = new ArrayList<>();
			carrinho = (List<ItemPedido>) request.getSession().getAttribute("carrinho");
			int qtd = (int) request.getSession().getAttribute("qtd");
			String marca;
			String modelo;

			Double valorTotal = (Double) request.getSession().getAttribute("valor");
			int q = 1;
			
			if(carrinho.size() == 0) {
				ps = new PedidoServico();
				pedido = new Pedido();
				
				ps.selVeiculo(id);
				
				p = new ItemPedido(q, ps.retornoVeiculo());
				marca = ps.retornoVeiculo().getMarca().getNome_marca();
				modelo = ps.retornoVeiculo().getModeloVeiculo();
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
				marca = ps.retornoVeiculo().getMarca().getNome_marca();
				modelo = ps.retornoVeiculo().getModeloVeiculo();
				Double subTotal = ps.retornoVeiculo().getValorVeiculo() * p.getQuantidade();	
				p.setSub_Total(subTotal);
				p.setId_item(carrinho.size());
				Double valor = subTotal + valorTotal;
				sessao.setAttribute("valor", valor);
				pedido.setValor_total(valor);
				p.setPedido(pedido);
				carrinho.add(p);
			}
			
			
			qtd = carrinho.size();
			sessao.setAttribute("qtd", qtd);
			sessao.setAttribute("carrinho", carrinho);
			modelo = modelo.toLowerCase().replace(" ","").replace(".", "").replace("1", "").replace("0", "");
			marca = marca.toLowerCase().replace(" ","").replace(".", "").replace("1", "").replace("0", "");
			
			response.sendRedirect("/Concessionaria/veiculos/"+ marca +"/"+ modelo);
				
			
	
			
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
				
				

		HttpSession sessao = request.getSession(true);
		
			
		int qtd = (int) request.getSession().getAttribute("qtd");

		qtd = carrinho.size();
		sessao.setAttribute("qtd", qtd);
		response.sendRedirect("/Concessionaria/pedido/carrinho");
	}
	
	protected void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("/views/pedidos.jsp").forward(request, response);
	}
	
	protected void localizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.getWriter().append("M�todo: " + request.getMethod());
	}
	
	protected void comprar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<ItemPedido> carrinho = new ArrayList<>();
		String formPag = "Debito";
		carrinho = (List<ItemPedido>) request.getSession().getAttribute("carrinho");
		Double valorTotal = (Double) request.getSession().getAttribute("valor");
			try {
				FormaPagamento f = new FormaPagamento();
				ps = new PedidoServico();
				Usuario u = new Usuario();
				
				f.setTipo_pagamento(formPag);
				Pedido ped = new Pedido();
				ped.setData_pedido(new Date());
				f = ps.buscarPagamento(f);
				ped.setPagamento(f);
				int id = (int) request.getSession().getAttribute("id");
				u.setId_usuario(id);
				ped.setUsuario(u);
				ped.setValor_total(valorTotal);
				ps.gravarPedido(ped);
				for(ItemPedido p:carrinho) {
					p.setPedido(ped);
				}
				
				ps.gravarCarrinho(carrinho);
				carrinho.removeAll(carrinho);
				HttpSession sessao = request.getSession(true);
				sessao.setAttribute("carrinho", carrinho);
				int qtd = carrinho.size();
				sessao.setAttribute("qtd", qtd);
				valorTotal = 0.0;
				int idPedido = ped.getId_pedido();
				sessao.setAttribute("valor", valorTotal);
				sessao.setAttribute("idPedido", idPedido);
				
				List<Pedido> pl = new ArrayList<>();
				PedidoServico ps = new PedidoServico();
				pl =  ps.buscaPedido(id);
				int pedidoqtd = pl.size();
				
				sessao.setAttribute("pedido", pl);
				sessao.setAttribute("pedidoqtd", pedidoqtd);
				
				response.sendRedirect("finalizar");
					
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
	}
	
	protected void atualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.getWriter().append("M�todo: " + request.getMethod());
	}

}