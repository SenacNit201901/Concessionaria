package br.com.senac.concessionaria.modelo;

public class Contato {

	private int id_contato;
	private String telefone;
	private Usuario usuario;
	
	public Contato() {
		// TODO Auto-generated constructor stub
	}
	

	public Contato(int id_contato, Usuario usuario, String telefone) {
		super();
		this.id_contato = id_contato;
		this.usuario = usuario;
		this.telefone = telefone;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
