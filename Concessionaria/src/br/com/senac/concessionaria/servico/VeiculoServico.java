package br.com.senac.concessionaria.servico;

import java.sql.SQLException;

import br.com.senac.concessionaria.dao.CombustivelDAO;
import br.com.senac.concessionaria.dao.CorDAO;
import br.com.senac.concessionaria.dao.MarcaDAO;
import br.com.senac.concessionaria.dao.VeiculoDAO;
import br.com.senac.concessionaria.modelo.Combustivel;
import br.com.senac.concessionaria.modelo.Cor;
import br.com.senac.concessionaria.modelo.Marca;
import br.com.senac.concessionaria.modelo.Veiculo;

public class VeiculoServico {
	
	Veiculo veiculo;
	Cor cor;
	Marca marca;
	Combustivel combustivel;
	
	
	public void cadastrarVeiculo(String modelo, int ano, String chassi, Double valor) throws SQLException{
		this.veiculo = new Veiculo(modelo, ano, chassi, valor, this.cor, this.combustivel, this.marca);
		VeiculoDAO v = new VeiculoDAO();
		v.gravar(this.veiculo);
	}
	
	public void cadastrarCor(String cor)  throws SQLException{
		this.cor = new Cor(cor);
		CorDAO c = new CorDAO();
		c.gravar(this.cor);
	}
	public void cadastrarMarca(String marca)  throws SQLException{
		this.marca = new Marca(marca);
		MarcaDAO m = new MarcaDAO();
		m.gravar(this.marca);
		
	}
	public void cadastrarCombustivel(String combustivel)  throws SQLException{
		this.combustivel = new Combustivel(combustivel);
		CombustivelDAO co = new CombustivelDAO();
		co.gravar(this.combustivel);
	}
}
