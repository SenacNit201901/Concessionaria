package br.com.senac.concessionaria.modelo;

public class Combustivel {
	
	private int id_combustivel;
	private String tipo_combustivel;
	
	public Combustivel() {}
	
	public Combustivel(String tipo_combustivel) {
		this.tipo_combustivel = tipo_combustivel;
	}

	public int getId_combustivel() {
		return id_combustivel;
	}

	public void setId_combustivel(int id_combustivel) {
		this.id_combustivel = id_combustivel;
	}

	public String getTipo_combustivel() {
		return tipo_combustivel;
	}

	public void setTipo_combustivel(String tipo_combustivel) {
		this.tipo_combustivel = tipo_combustivel;
	}

}
