package br.com.senac.concessionaria.modelo;

public class TipoUsuario {
	
	private Integer id_tipo_usuario;
	private String tipo_usuario;
	
	public TipoUsuario() {
		// TODO Auto-generated constructor stub
	}
	
	
	public TipoUsuario( String tipo_usuario) {
		super();
		this.tipo_usuario = tipo_usuario;
	}


	public Integer getId_tipo_usuario() {
		return id_tipo_usuario;
	}
	public void setId_tipo_usuario(Integer id_tipo_usuario) {
		this.id_tipo_usuario = id_tipo_usuario;
	}
	public String getTipo_usuario() {
		return tipo_usuario;
	}
	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}
	
	

}
