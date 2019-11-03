package br.com.senac.concessionaria.modelo;

public class Bairro {
	
	@Override
	public String toString() {
		return "Bairro [id_bairro=" + id_bairro +", nome_Bairro=" + nome_Bairro + "]";
	}
	
	private int id_bairro;
	private String nome_Bairro;
	

	public Bairro() {
		// TODO Auto-generated constructor stub
	}
	
	public Bairro( String nome_Bairro) {
		super();
		this.nome_Bairro = nome_Bairro;
	}

	public int getId_bairro() {
		return id_bairro;
	}

	public void setId_bairro(int id_bairro) {
		this.id_bairro = id_bairro;
	}

	public String getNome_Bairro() {
		return nome_Bairro;
	}

	public void setNome_Bairro(String nome_Bairro) {
		this.nome_Bairro = nome_Bairro;
	}
	
}
