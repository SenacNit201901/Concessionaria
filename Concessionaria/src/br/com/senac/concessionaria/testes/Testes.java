package br.com.senac.concessionaria.testes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import br.com.senac.concessionaria.servico.VeiculoServico;

public class Testes {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		List<ItemPedido> carrinho = new ArrayList<ItemPedido>();
		
		UsuarioServico user = new UsuarioServico();
		
		
		TipoUsuario cliente = new TipoUsuario( "cliente");
		TipoUsuario funcionario = new TipoUsuario( "funcionario");
		
		
	
		Estado estado = new Estado("RJ");
		
		Bairro bairro = new Bairro( "Boa Vista");
		
		Cidade cidade = new Cidade("São Goncalo");
		

		
		Endereco endereco = new Endereco("240000000", "rua nova jersey",  "25", "casa", cidade, estado, bairro);
		
		
		Usuario usuario = new Usuario("joao", "kleber", "55555", "mdo@gmail.com", "6656", cliente, endereco);
		
		


		System.out.println(usuario.getId_usuario());
		System.out.println(funcionario.getId_tipo_usuario());
		
		Contato contato1 = new Contato(usuario, "(21) 98299-7212");
		Contato contato2 = new Contato(usuario, "(21) 98209-7002");
		
		user.cadastrarEndereco(endereco.getRua(), endereco.getComplemento(), endereco.getCep(), endereco.getNumero(), endereco.getBairro().getNome_Bairro(), endereco.getCidade().getNome_cidade(),	 endereco.getEstado().getUF());
		user.cadastrarUsuario(usuario.getNome(), usuario.getSobrenome(), usuario.getCpf(), usuario.getEmail(), usuario.getSenha());
		user.cadastrarContato(contato1.getTelefone());
		user.cadastrarContato(contato2.getTelefone());

		
		Combustivel combustivel = new Combustivel( "gasolina");

		Cor vermelho = new Cor( "vermelho");
		Cor preto = new Cor( "Preto");

		
		
		Marca marca = new Marca("FIAT");
				
		Veiculo veiculo = new Veiculo("PALIO", 2015, "22JJH222K22", 40.0, vermelho, combustivel, marca);
		Veiculo veiculo2 = new Veiculo( "UNO", 2010, "2525515SSSAA", 50.0, preto, combustivel, marca);
		
		VeiculoServico vS = new VeiculoServico();
		vS.cadastrarCor(vermelho.getNome_cor());
		vS.cadastrarCombustivel(combustivel.getTipo_combustivel());
		vS.cadastrarMarca(marca.getNome_marca());
		vS.cadastrarVeiculo(veiculo.getModeloVeiculo(), veiculo.getAnoVeiculo(), veiculo.getChassiVeiculo(), veiculo.getValorVeiculo());
		
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
		
	
		

		
		
	
		
		
	}

}
