package br.com.senac.concessionaria.modelo;

public class Veiculo {
	private int id_Veiculo;
	private String modeloVeiculo;
	private int anoVeiculo;
	private String chassiVeiculo;
	private Double valorVeiculo;
	private Cor cor;
	private Combustivel combustivel;
	private Marca marca;
	
	public Veiculo() {
		
	}
	
	public Veiculo(String modeloVeiculo, int anoVeiculo, String chassiVeiculo, Double valorVeiculo, Cor cor, Combustivel combustivel,Marca marca) {
		this.modeloVeiculo = modeloVeiculo;
		this.anoVeiculo = anoVeiculo;
		this.chassiVeiculo = chassiVeiculo;
		this.valorVeiculo = valorVeiculo;
		this.cor = cor;
		this.combustivel = combustivel;
		this.marca = marca;
	}	
	
	public int getId_Veiculo() {
		return id_Veiculo;
	}

	public void setId_Veiculo(int id_Veiculo) {
		this.id_Veiculo = id_Veiculo;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public Combustivel getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}


	
	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	
	public String getModeloVeiculo(){
		return modeloVeiculo;
	}
	
	public void setModeloVeiculo(String modeloVeiculo){
		this.modeloVeiculo = modeloVeiculo;
	}
	
	public int getAnoVeiculo(){
		return anoVeiculo;
	}
	
	public void setAnoVeiculo(int anoVeiculo){
		this.anoVeiculo = anoVeiculo;
	}
	
	public String getChassiVeiculo(){
		return chassiVeiculo;
	}
	
	public void setChassiVeiculo(String chassiVeiculo){
		this.chassiVeiculo = chassiVeiculo;
	}
	
	public Double getValorVeiculo(){
		return valorVeiculo;
	}
	
	public void setValorVeiculo(Double valorVeiculo){
		this.valorVeiculo = valorVeiculo;
	}
}
