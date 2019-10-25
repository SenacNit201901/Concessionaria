package br.com.senac.concessionaria.modelo;

public class ItemPedido {
	@Override
	public String toString() {
		return "ItemPedido [id_item=" + id_item + ", quantidade=" + quantidade + ", veiculo=" + veiculo + ", sub_Total="
				+ sub_Total + ", itemPedido=" + "]";
	}

	private int id_item;
	private int quantidade;
	private Veiculo veiculo;
	private Double sub_Total;
	
	
	
	public ItemPedido() {}
	
	public ItemPedido(int id_item, int quantidade, Veiculo veiculo) {
		this.id_item = id_item;
		this.quantidade = quantidade;
		this.veiculo = veiculo;
	}

	public int getId_item() {
		return id_item;
	}

	public void setId_item(int id_item) {
		this.id_item = id_item;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Double getSub_Total() {
		return sub_Total;
	}

	public void setSub_Total(Double sub_Total) {
		this.sub_Total = sub_Total;
	}
	

}
