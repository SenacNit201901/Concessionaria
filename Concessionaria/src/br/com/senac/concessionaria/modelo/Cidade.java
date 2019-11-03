package br.com.senac.concessionaria.modelo;

public class Cidade {
	
	@Override
	public String toString() {
		return "Cidade [id_cidade=" + id_cidade +", nome_cidade=" + nome_cidade + "]";
	}
	
	private int id_cidade;
	private String nome_cidade;
	
	public Cidade() {
		// TODO Auto-generated constructor stub
	}
	
	public Cidade( String nome_cidade) {
		super();
		this.nome_cidade = nome_cidade;
	}

	public int getId_cidade() {
		return id_cidade;
	}
	public void setId_cidade(int id_cidade) {
		this.id_cidade = id_cidade;
	}
	public String getNome_cidade() {
		return nome_cidade;
	}
	public void setNome_cidade(String nome_cidade) {
		this.nome_cidade = nome_cidade;
	}
	
	
	
}
