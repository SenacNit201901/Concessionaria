package br.com.senac.concessionaria.testes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.senac.concessionaria.dao.BairroDAO;
import br.com.senac.concessionaria.dao.CidadeDAO;
import br.com.senac.concessionaria.dao.EnderecoDAO;
import br.com.senac.concessionaria.dao.EstadoDAO;
import br.com.senac.concessionaria.dao.TipoUsuarioDAO;
import br.com.senac.concessionaria.dao.UsuarioDAO;
import br.com.senac.concessionaria.modelo.Bairro;
import br.com.senac.concessionaria.modelo.Cidade;
import br.com.senac.concessionaria.modelo.Combustivel;
import br.com.senac.concessionaria.modelo.Contato;
import br.com.senac.concessionaria.modelo.Cor;
import br.com.senac.concessionaria.modelo.Endereco;
import br.com.senac.concessionaria.modelo.Estado;
import br.com.senac.concessionaria.modelo.FormaPagamento;
import br.com.senac.concessionaria.modelo.ItemPedido;
import br.com.senac.concessionaria.modelo.Marca;
import br.com.senac.concessionaria.modelo.Pedido;
import br.com.senac.concessionaria.modelo.TipoUsuario;
import br.com.senac.concessionaria.modelo.Usuario;
import br.com.senac.concessionaria.modelo.Veiculo;
import br.com.senac.concessionaria.servico.UsuarioServico;

public class Testes {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		List<ItemPedido> carrinho = new ArrayList<ItemPedido>();
		

		
		
		TipoUsuario cliente = new TipoUsuario( "cliente");
		TipoUsuario funcionario = new TipoUsuario( "funcionario");
		
		TipoUsuarioDAO t = new TipoUsuarioDAO();
		t.gravar(cliente);
		
		Estado estado = new Estado(1, "RJ");
		
		Bairro bairro = new Bairro(1, "Boa Vista");
		
		Cidade cidade = new Cidade(1, "São Goncalo");
		
		BairroDAO b = new BairroDAO();
		CidadeDAO c = new CidadeDAO();
		EstadoDAO e = new EstadoDAO();
		
		b.gravar(bairro);
		c.gravar(cidade);
		e.gravar(estado);
		
		Endereco endereco = new Endereco(1, "240000000", "rua nova jersey",  "25", "casa", cidade, estado, bairro);
		EnderecoDAO en = new EnderecoDAO();
		en.gravar(endereco);
		
		Usuario usuario = new Usuario(1, "carlos", "henrique", "55555", "mdo@gmail.com", "6656", cliente, endereco);
		UsuarioDAO u = new UsuarioDAO();
		u.gravar(usuario);
		


		System.out.println(usuario.getId_usuario());
		System.out.println(funcionario.getId_tipo_usuario());
		
		Contato contato1 = new Contato(1, usuario, "(21) 98299-7212");
		Contato contato2 = new Contato(1, usuario, "(21) 98209-7002");

		
		Combustivel combustivel = new Combustivel(1, "gasolina");

		Cor vermelho = new Cor(1, "vermelho");
		Cor preto = new Cor(1, "Preto");

		
		
		Marca marca = new Marca(1, "FIAT");
				
		Veiculo veiculo = new Veiculo(1, "PALIO", 2015, "22JJH222K22", 40.0, vermelho, combustivel, marca);
		Veiculo veiculo2 = new Veiculo(1, "UNO", 2010, "2525515SSSAA", 50.0, preto, combustivel, marca);

		
		FormaPagamento pagamento = new FormaPagamento(1, "Cartao");
		// primeiro item
		ItemPedido item1 = new ItemPedido(1, 2, veiculo);
		
		Double subTotal = veiculo.getValorVeiculo() * item1.getQuantidade();
		item1.setSub_Total(subTotal);
		
		// segundo item
		
		ItemPedido item2 = new ItemPedido(2, 3, veiculo2 );
		Double subTotal2 = veiculo2.getValorVeiculo() * item2.getQuantidade();
		item2.setSub_Total(subTotal2);
		
		carrinho.add(item1);
		carrinho.add(item2);
		
		Pedido pedido = new Pedido();
		
		pedido.setId_pedido(1);
		pedido.setData_pedido(new Date());
		pedido.setItem_pedido(carrinho);
		pedido.setPagamento(pagamento);
		
		pedido.setQuantidade_parcelamento(2);
		pedido.setUsuario(usuario);
		
		Double soma = 0d;
		
		for(ItemPedido p: carrinho) {
			soma = soma + p.getSub_Total();
			}
		pedido.setValor_total(soma);
		
	
		
		UsuarioServico user = new UsuarioServico();
		
		
	
		
		
	}

}
