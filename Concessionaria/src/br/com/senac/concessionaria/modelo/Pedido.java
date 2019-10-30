package br.com.senac.concessionaria.modelo;

import java.util.Date;
import java.util.List;


public class Pedido {
	@Override
	public String toString() {
		return "Pedido [id_pedido=" + id_pedido + ", data_pedido=" + data_pedido + ", valor_total=" + valor_total
				+ ", item_pedido="  + ", quantidade_parcelamento=" + quantidade_parcelamento
				+ ", pagamento=" + pagamento + "]";
	}


	private int id_pedido;
	private Date data_pedido;
	private double valor_total;
	private int quantidade_parcelamento;
	private FormaPagamento pagamento;
	private Usuario usuario;
	
	public Pedido() {}
	
	
	
	public Pedido(Date data_pedido, double valor_total, List<ItemPedido> item_pedido,
			int quantidade_parcelamento, FormaPagamento pagamento, Usuario usuario) {
		super();
		this.data_pedido = data_pedido;
		this.valor_total = valor_total;
		this.quantidade_parcelamento = quantidade_parcelamento;
		this.pagamento = pagamento;
		this.usuario = usuario;
	}



	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
