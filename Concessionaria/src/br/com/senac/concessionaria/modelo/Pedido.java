package br.com.senac.concessionaria.modelo;

import java.util.Date;
import java.util.List;


public class Pedido {
	@Override
	public String toString() {
		return "Pedido [id_pedido=" + id_pedido + ", data_pedido=" + data_pedido + ", valor_total=" + valor_total
				+ ", item_pedido=" + item_pedido + ", quantidade_parcelamento=" + quantidade_parcelamento
				+ ", pagamento=" + pagamento + "]";
	}


	private int id_pedido;
	private Date data_pedido;
	private double valor_total;
	private List<ItemPedido> item_pedido;
	private int quantidade_parcelamento;
	private FormaPagamento pagamento;
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Pedido() {}
	
	public List<ItemPedido> getItem_pedido() {
		return item_pedido;
	}

	public void setItem_pedido(List<ItemPedido> item_pedido) {
		this.item_pedido = item_pedido;
	}

	public int getQuantidade_parcelamento() {
		return quantidade_parcelamento;
	}

	public void setQuantidade_parcelamento(int quantidade_parcelamento) {
		this.quantidade_parcelamento = quantidade_parcelamento;
	}

	public FormaPagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(FormaPagamento pagamento) {
		this.pagamento = pagamento;
	}

	public int getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}
	
	public Date getData_pedido() {
		return data_pedido;
	}

	public void setData_pedido(Date data_pedido) {
		this.data_pedido = data_pedido;
	}

	public double getValor_total() {
		return valor_total;
	}

	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}
	
	
	
	
	
}
