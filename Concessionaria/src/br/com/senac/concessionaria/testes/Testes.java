package br.com.senac.concessionaria.testes;

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

public class Testes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<ItemPedido> carrinho = new ArrayList<ItemPedido>();
		
		List<Contato> listaContatos = new ArrayList<Contato>();
		
		
		TipoUsuario cliente = new TipoUsuario(1, "cliente");
		

		
		
		Estado estado = new Estado(1, "RJ");
		
		Bairro bairro = new Bairro(1, "Boa Vista");
		
		Cidade cidade = new Cidade(1, "São Goncalo");
		

		
		Endereco endereco = new Endereco(1, "240000-000", "rua nova jersey",  "25", "casa", cidade, estado, bairro);
		
		Usuario usuario = new Usuario(1, "carlos", "henrique", "148.923.137-42", "machado@gmail.com", "123456", cliente, endereco);
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
