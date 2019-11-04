package br.com.senac.concessionaria.servico;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.senac.concessionaria.dao.CombustivelDAO;
import br.com.senac.concessionaria.dao.CorDAO;
import br.com.senac.concessionaria.dao.FormaPagamentoDAO;
import br.com.senac.concessionaria.dao.ItemPedidoDao;
import br.com.senac.concessionaria.dao.MarcaDAO;
import br.com.senac.concessionaria.dao.PedidoDAO;
import br.com.senac.concessionaria.dao.UsuarioDAO;
import br.com.senac.concessionaria.dao.VeiculoDAO;
import br.com.senac.concessionaria.modelo.FormaPagamento;
import br.com.senac.concessionaria.modelo.ItemPedido;
import br.com.senac.concessionaria.modelo.Pedido;
import br.com.senac.concessionaria.modelo.Usuario;
import br.com.senac.concessionaria.modelo.Veiculo;

public class PedidoServico {
	
	Usuario usuario;
	Veiculo veiculo;
	Pedido pedido;
	List<ItemPedido> carrinho = new ArrayList<>();
	FormaPagamento formPag;
	
	public void cadastrarPedido(Date data, int quantParc, int idUsuario)  throws SQLException{
		selUsuario(idUsuario);
		
		this.pedido = new Pedido(data, quantParc, this.formPag, this.usuario);
		

	}
	
	
	
	public void cadastrarItem(int quantidade, int idVeiculo)  throws SQLException{
		
		selVeiculo(idVeiculo);
		
		
		Double sub_Total = this.veiculo.getValorVeiculo() * quantidade;
		
		if(this.carrinho.size() != 0) {
			int i = this.carrinho.size();
			this.carrinho.add(i, new ItemPedido(quantidade,sub_Total, this.veiculo, this.pedido));

		} else {
			this.carrinho.add(new ItemPedido(quantidade,sub_Total, this.veiculo, this.pedido));

		}
		
		

		
	}
	
	public List<ItemPedido> listarCarrinho(){
		return this.carrinho;
	}



	public void gravarPedido(Pedido p) throws SQLException {
		PedidoDAO pedido = new PedidoDAO();
		pedido.gravar(p);
	}
	
	
	
	public FormaPagamento buscarPagamento(FormaPagamento f)  throws SQLException{
		
		FormaPagamentoDAO fm = new FormaPagamentoDAO();
		return fm.busca(f);
	}
	
/*	
	public void finalizarPedido() throws SQLException {
		Double valorTotal = 0d;
		for(ItemPedido i : this.carrinho) {
			valorTotal = valorTotal + i.getSub_Total();
		}
		
		
		this.pedido.setValor_total(valorTotal);
		gravarPedido();
		gravarCarrinho();
	}

*/

	public void gravarCarrinho(List<ItemPedido> item) throws SQLException {
		ItemPedidoDao i = new ItemPedidoDao();
		i.gravar(item);
	}
	
	
	private void selUsuario(int id_Usuario) throws SQLException{
		this.usuario = new Usuario();
		this.usuario.setId_usuario(id_Usuario);
		
		UsuarioDAO u = new UsuarioDAO();
		u.listarUsuario(this.usuario);
		
	}
	
	public void selVeiculo(int id_Veiculo) throws SQLException{
		this.veiculo = new Veiculo();
		this.veiculo.setId_Veiculo(id_Veiculo);
		
		VeiculoDAO v = new VeiculoDAO();
		CorDAO c = new CorDAO();
		MarcaDAO m = new MarcaDAO();
		CombustivelDAO com = new CombustivelDAO();
		
		v.listarVeiculoId(this.veiculo);
		
		this.veiculo.setMarca(m.busca(this.veiculo.getMarca().getId_marca()));
		this.veiculo.setCor(c.busca(this.veiculo.getCor().getId_cor()));
		this.veiculo.setCombustivel(com.busca(this.veiculo.getCombustivel().getId_combustivel()));
		
	}
	public Veiculo retornoVeiculo() {
		return this.veiculo;
	}
	public List<Pedido> buscaPedido(int id) throws SQLException {
		PedidoDAO p = new PedidoDAO();
		return p.busca(id);
		
	}
	
}
