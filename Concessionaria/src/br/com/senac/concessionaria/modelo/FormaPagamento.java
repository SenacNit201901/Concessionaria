package br.com.senac.concessionaria.modelo;

public class FormaPagamento {
	private int id_forma_pagamento;
	private String tipo_pagamento;
	
	public FormaPagamento() {
		
	}
	
	public FormaPagamento(String tipo_pagamento) {
		this.tipo_pagamento = tipo_pagamento;
	}

	public int getId_forma_pagamento() {
		return id_forma_pagamento;
	}

	public void setId_forma_pagamento(int id_forma_pagamento) {
		this.id_forma_pagamento = id_forma_pagamento;
	}

	public String getTipo_pagamento() {
		return tipo_pagamento;
	}

	public void setTipo_pagamento(String tipo_pagamento) {
		this.tipo_pagamento = tipo_pagamento;
	}
}
