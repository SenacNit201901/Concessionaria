package br.com.senac.concessionaria.servico;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import br.com.senac.concessionaria.dao.FormaPagamentoDAO;
import br.com.senac.concessionaria.dao.ItemPedidoDao;
import br.com.senac.concessionaria.dao.PedidoDAO;
import br.com.senac.concessionaria.dao.UsuarioDAO;
import br.com.senac.concessionaria.modelo.FormaPagamento;
import br.com.senac.concessionaria.modelo.ItemPedido;
import br.com.senac.concessionaria.modelo.Pedido;
import br.com.senac.concessionaria.modelo.Usuario;
import br.com.senac.concessionaria.modelo.Veiculo;

public class PedidoServico {
	
	Usuario usuario;
	Veiculo veiculo;
	Pedido pedido;
	List<ItemPedido> item;
	FormaPagamento formPag;
	
	public void cadastrarPedido(Date data, Double valorTotal, int quantParc)  throws SQLException{
		this.pedido = new Pedido(data, valorTotal, this.item, quantParc, this.formPag, this.usuario);
		
		PedidoDAO p = new PedidoDAO();
		p.gravar(this.pedido);
	}
	
	
	
	public void cadastrarItem(int quantidade, Double subTotal)  throws SQLException{
		this.item.add(new ItemPedido(quantidade, this.veiculo, this.pedido));
		
		ItemPedidoDao i = new ItemPedidoDao();
		i.gravar(this.item);
	}
	
	
	
	public void cadastrarPagamento(String formaPag)  throws SQLException{
		this.formPag = new FormaPagamento(formaPag);
		FormaPagamentoDAO fm = new FormaPagamentoDAO();
		fm.gravar(this.formPag);
	}
	
	
	public void selUsuario(int id_Usuario) throws SQLException{
		this.usuario = new Usuario();
		this.usuario.setId_usuario(id_Usuario);
		
		UsuarioDAO u = new UsuarioDAO();
		u.selUsuario(this.usuario);
		
	}
	
	public void selVeiculo(int id_Veiculo) throws SQLException{
		this.veiculo = new Veiculo();
		this.veiculo.setId_Veiculo(id_Veiculo);
		
		
	}
	
}
