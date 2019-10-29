package br.com.senac.concessionaria.modelo;

public class Cor {
	private int id_cor;
	private String nome_cor;
	
	public Cor() {}
	
	public Cor(String nome_cor) {
		this.nome_cor = nome_cor;
	}

	public int getId_cor() {
		return id_cor;
	}

	public void setId_cor(int id_cor) {
		this.id_cor = id_cor;
	}

	public String getNome_cor() {
		return nome_cor;
	}

	public void setNome_cor(String nome_cor) {
		this.nome_cor = nome_cor;
	}
}
