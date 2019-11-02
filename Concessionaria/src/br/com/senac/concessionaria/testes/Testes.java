package br.com.senac.concessionaria.testes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import br.com.senac.concessionaria.modelo.Bairro;
import br.com.senac.concessionaria.modelo.Cidade;
import br.com.senac.concessionaria.modelo.Combustivel;
import br.com.senac.concessionaria.modelo.Contato;
import br.com.senac.concessionaria.modelo.Cor;
import br.com.senac.concessionaria.modelo.Endereco;
import br.com.senac.concessionaria.modelo.Estado;
import br.com.senac.concessionaria.modelo.Marca;
import br.com.senac.concessionaria.modelo.TipoUsuario;
import br.com.senac.concessionaria.modelo.Usuario;
import br.com.senac.concessionaria.modelo.Veiculo;
import br.com.senac.concessionaria.servico.PedidoServico;
import br.com.senac.concessionaria.servico.UsuarioServico;

public class Testes {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		
		UsuarioServico user = new UsuarioServico();
		
		
		TipoUsuario cliente = new TipoUsuario( "cliente");
		
		
	
		Estado estado = new Estado("RJ");
		
		Bairro bairro = new Bairro( "Boa Vista");
		
		Cidade cidade = new Cidade("niteroi");
		

		
		Endereco endereco = new Endereco("240000000", " jersey",  "25", "casa", cidade, estado, bairro);
		
		
		Usuario usuario = new Usuario("igor", "rabelo", "55555", "igor@gmail.com", "5555", cliente, endereco);
		Usuario usuario3 = new Usuario("igor", "rabelo", "55555", "igor@gmail.com", "5555", cliente, endereco);

		
		Contato contato1 = new Contato(usuario, "(21) 77777-7212");
		Contato contato2 = new Contato(usuario, "(21) 88888-7002");
		/**
		user.cadastrarEndereco(endereco.getRua(), endereco.getComplemento(), endereco.getCep(), endereco.getNumero(), endereco.getBairro().getNome_Bairro(), endereco.getCidade().getNome_cidade(),	 endereco.getEstado().getUF());
		user.cadastrarUsuario(usuario.getNome(), usuario.getSobrenome(), usuario.getCpf(), usuario.getEmail(), usuario.getSenha());
		user.cadastrarContato(contato1.getTelefone());
		user.cadastrarContato(contato2.getTelefone());

		*/
		
		Combustivel combustivel = new Combustivel( "gasolina");

		Cor vermelho = new Cor( "vermelho");
		Cor preto = new Cor( "Preto");

		
		
		Marca marca = new Marca("ferrari");
				
		Veiculo veiculo = new Veiculo("PALIO", 2015, "22JJH222K22", 40.0, vermelho, combustivel, marca);
		Veiculo veiculo2 = new Veiculo( "f200", 2018, "2525515SSSAA", 4000.0, preto, combustivel, marca);
		
		/**
		VeiculoServico vS = new VeiculoServico();
		vS.cadastrarCombustivel(combustivel.getTipo_combustivel());
		vS.cadastrarMarca(marca.getNome_marca());
		vS.cadastrarCor(preto.getNome_cor());
		vS.cadastrarVeiculo(veiculo2.getModeloVeiculo(), veiculo2.getAnoVeiculo(), veiculo2.getChassiVeiculo(), veiculo2.getValorVeiculo());
		*/
		
		
		PedidoServico ps = new PedidoServico();
		

		ps.cadastrarPagamento("cartao");
		ps.cadastrarPedido(new Date(), 2, 2);
		
		Veiculo v = new Veiculo();
		v = ps.retornoVeiculo();
		
		ps.cadastrarItem(2, 1);
	
		
		 
			
		Usuario jj = new Usuario();
		System.out.println(jj);
		
	
		

		
		

		
		
		
	
		

		
		
	
		
		
	}

}
