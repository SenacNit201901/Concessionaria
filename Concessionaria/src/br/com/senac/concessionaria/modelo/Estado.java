package br.com.senac.concessionaria.modelo;

public class Estado {
	private int id_UF;
	private String UF;
	
	public Estado() {
		// TODO Auto-generated constructor stub
	}
	


	public Estado(int id_UF, String UF) {
		super();
		this.id_UF = id_UF;
		this.UF = UF;
	}



	public int getId_UF() {
		return id_UF;
	}


	public void setId_UF(int id_UF) {
		this.id_UF = id_UF;
	}


	public String getUF() {
		return UF;
	}


	public void setUF(String UF) {
		this.UF = UF;
	}
	
	
	

	
	
	
}
