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
	private Pedido pedido;
	
	


	public ItemPedido() {}
	

	
	public ItemPedido( int quantidade, Veiculo veiculo, Pedido pedido) {
		super();
		this.quantidade = quantidade;
		this.veiculo = veiculo;
		this.pedido = pedido;
	}
	
	public ItemPedido( int quantidade, Double sub_Total, Veiculo veiculo, Pedido pedido) {
		super();
		this.quantidade = quantidade;
		this.sub_Total = sub_Total;
		this.veiculo = veiculo;
		this.pedido = pedido;
	}
	public ItemPedido( int quantidade, Veiculo veiculo) {
		super();
		this.quantidade = quantidade;
		this.veiculo = veiculo;
	}



	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
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
