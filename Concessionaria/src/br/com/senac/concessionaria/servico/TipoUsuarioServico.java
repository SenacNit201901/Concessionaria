package br.com.senac.concessionaria.servico;

import br.com.senac.concessionaria.modelo.TipoUsuario;

public class TipoUsuarioServico {
	
	TipoUsuario tipoUsuario; 
	public TipoUsuarioServico() {
		// TODO Auto-generated constructor stub
		tipoUsuario = new TipoUsuario();
	}
	
	
	public TipoUsuarioServico(int id_tipo_usuario, String tipo_usuario) {

		tipoUsuario = new TipoUsuario(id_tipo_usuario, tipo_usuario );
	}


	public int getId_tipo_usuario() {
		return tipoUsuario.getId_tipo_usuario();
	}
	public void setId_tipo_usuario(int id_tipo_usuario) {
		tipoUsuario.setId_tipo_usuario(id_tipo_usuario);
	}
	public String getTipo_usuario() {
		return tipoUsuario.getTipo_usuario();
	}
	public void setTipo_usuario(String tipo_usuario) {
		tipoUsuario.setTipo_usuario(tipo_usuario);
	}
	

}
