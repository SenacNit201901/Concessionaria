package br.com.senac.concessionaria.servico;

import br.com.senac.concessionaria.modelo.Cidade;

public class CidadeServico {
	Cidade cidade;
	
	public CidadeServico() {
		// TODO Auto-generated constructor stub
		cidade = new Cidade();
	}
	
	public CidadeServico(int id_cidade, String nome_cidade) {
		cidade = new Cidade(id_cidade, nome_cidade);
	}

	public int getId_cidade() {
		return cidade.getId_cidade();
	}
	public void setId_cidade(int id_cidade) {
		cidade.setId_cidade(id_cidade);
	}
	public String getNome_cidade() {
		return cidade.getNome_cidade();
	}
	public void setNome_cidade(String nome_cidade) {
		cidade.setNome_cidade(nome_cidade);
	}
}
