package br.com.senac.concessionaria.modelo;

public class Contato {

	private int id_contato;
	private String telefone;
	
	public Contato() {
		// TODO Auto-generated constructor stub
	}
	

	public Contato(int id_contato, String telefone) {
		super();
		this.id_contato = id_contato;
		this.telefone = telefone;
	}


	public int getId_contato() {
		return id_contato;
	}

	public void setId_contato(int id_contato) {
		this.id_contato = id_contato;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
