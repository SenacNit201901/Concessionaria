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

public class Testes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<ItemPedido> lista = new ArrayList<ItemPedido>();
		Usuario usuario = new Usuario();
		usuario.setId_usuario(1);
		usuario.setNome("carlos");
		usuario.setSobrenome("henrique");
		usuario.setCpf("148.923.137-42");
		usuario.setEmail("machado@gmail.com");
		usuario.setSenha("123456");
		
		TipoUsuario tipo_usuario = new TipoUsuario();
		tipo_usuario.setId_tipo_usuario(1);
		tipo_usuario.setTipo_usuario("cliente");
		
		Endereco endereco = new Endereco();
		endereco.setId_endereco(1);
		endereco.setRua("rua nova jersey");
		endereco.setNumero("25");
		endereco.setComplemento("casa");
		endereco.setCep("240000-000");
		
		Estado estado = new Estado();
		estado.setId_UF(1);
		estado.setUF("RJ");
		
		Bairro bairro = new Bairro();
		bairro.setId_bairro(1);
		bairro.setNome_Bairro("Boa Vista");
		
		Cidade cidade = new Cidade();
		cidade.setId_cidade(1);
		cidade.setNome_cidade("Sao Gonçalo");
		
		
		endereco.setBairro(bairro);
		endereco.setCidade(cidade);
		endereco.setEstado(estado);
		
		Contato contatos = new Contato();
		contatos.setId_contato(1);
		contatos.setTelefone("(21) 98299-7212");
		
		List<Contato> listaContatos = new ArrayList<Contato>();
		listaContatos.add(contatos);
		
		usuario.setTipo_usuario(tipo_usuario);
		usuario.setEndereco(endereco);
		usuario.setContatos(listaContatos);
		
		Combustivel combustivel = new Combustivel();
		combustivel.setId_combustivel(1);
		combustivel.setTipo_combustivel("gasolina");
		
		Cor cor = new Cor();
		cor.setId_cor(1);
		cor.setNome_cor("amarelo");
		
		Marca marca = new Marca();
		marca.setId_marca(1);
		marca.setNome_marca("Fiat");
		
		Veiculo veiculo = new Veiculo();
		veiculo.setid_Veiculo(1);
		veiculo.setModeloVeiculo("Palio");
		veiculo.setChassiVeiculo("1515145458");
		veiculo.setAnoVeiculo(2014);
		veiculo.setCor(cor);
		veiculo.setMarca(marca);
		veiculo.setCombustivel(combustivel);
		veiculo.setValorVeiculo(30000.00);
		
		
		ItemPedido item = new ItemPedido();
		item.setId_item(1);
		item.setQuantidade(2);
		Double subTotal = veiculo.getValorVeiculo() * item.getQuantidade();
		item.setSub_Total(subTotal);
		item.setVeiculo(veiculo);
		lista.add(item);
		
		FormaPagamento pagamento = new FormaPagamento();
		pagamento.setId_forma_pagamento(1);
		pagamento.setTipo_pagamento("Cartao");
		
		
		
		
		
		Pedido pedido = new Pedido();
		
		pedido.setId_pedido(1);
		pedido.setData_pedido(new Date());
		pedido.setItem_pedido(lista);
		pedido.setPagamento(pagamento);
		
		pedido.setQuantidade_parcelamento(2);
		pedido.setUsuario(usuario);
		
		
		for(ItemPedido p: lista) {
			
			pedido.setValor_total(p.getSub_Total());
			
			
		}
		System.out.println("Veiculo cadastrado");
		
		System.out.println(pedido);
		
		
	}

}
