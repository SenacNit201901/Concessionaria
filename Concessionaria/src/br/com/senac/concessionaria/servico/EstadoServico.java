package br.com.senac.concessionaria.servico;

import br.com.senac.concessionaria.modelo.Estado;

public class EstadoServico {
	Estado estado;
	
	public EstadoServico() {
		// TODO Auto-generated constructor stub
		estado = new Estado();
	}
	


	public EstadoServico(int id_UF, String UF) {
		estado = new Estado(id_UF, UF);
	}



	public int getId_UF() {
		return estado.getId_UF();
	}


	public void setId_UF(int id_UF) {
		estado.setId_UF(id_UF);
	}


	public String getUF() {
		return estado.getUF();
	}


	public void setUF(String UF) {
		estado.setUF(UF);
	}
}
