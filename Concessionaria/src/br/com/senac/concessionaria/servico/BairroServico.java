package br.com.senac.concessionaria.servico;

import br.com.senac.concessionaria.modelo.Bairro;

public class BairroServico {
	Bairro bairro;
	
	public BairroServico() {
		// TODO Auto-generated constructor stub
		bairro = new Bairro();
	}
	
	public BairroServico(int id_bairro, String nome_Bairro) {
		bairro = new Bairro(id_bairro, nome_Bairro);
	}

	public int getId_bairro() {
		return bairro.getId_bairro();
	}

	public void setId_bairro(int id_bairro) {
		bairro.setId_bairro(id_bairro);
	}

	public String getNome_Bairro() {
		return bairro.getNome_Bairro();
	}

	public void setNome_Bairro(String nome_Bairro) {
		bairro.setNome_Bairro(nome_Bairro);
	}

}
