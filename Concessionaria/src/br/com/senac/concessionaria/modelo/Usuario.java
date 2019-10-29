package br.com.senac.concessionaria.modelo;

import java.util.List;

public class Usuario {
	
	private int id_usuario;
	private String nome;
	private String sobrenome;
	private String cpf;
	private String email;
	private String senha;
	private TipoUsuario tipo_usuario;
	private Endereco endereco;

	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Usuario(int id_usuario, String nome, String sobrenome, String cpf, String email, String senha,
			TipoUsuario tipo_usuario, Endereco endereco) {
		super();
		this.id_usuario = id_usuario;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.tipo_usuario = tipo_usuario;
		this.endereco = endereco;
	}


	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}



	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	public TipoUsuario getTipo_usuario() {
		return tipo_usuario;
	}
	public void setTipo_usuario(TipoUsuario tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}
	
	
	
}
