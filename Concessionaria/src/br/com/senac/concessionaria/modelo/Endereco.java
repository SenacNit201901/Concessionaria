package br.com.senac.concessionaria.modelo;

import br.com.senac.concessionaria.servico.BairroServico;
import br.com.senac.concessionaria.servico.CidadeServico;
import br.com.senac.concessionaria.servico.EstadoServico;

public class Endereco  {
	private int id_endereco;
	private String cep;
	private String rua;
	private String numero;
	private String complemento;
	private Cidade cidade;
	private Estado estado;
	private Bairro bairro;
	
	public Endereco() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Endereco(int id_endereco, String cep, String rua, String numero, String complemento, Cidade cidade,
			Estado estado, Bairro bairro) {
		super();
		this.id_endereco = id_endereco;
		this.cep = cep;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.cidade = cidade;
		this.estado = estado;
		this.bairro = bairro;
	}


	public int getId_endereco() {
		return id_endereco;
	}

	public void setId_endereco(int id_endereco) {
		this.id_endereco = id_endereco;
	}

	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro	 bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
}
