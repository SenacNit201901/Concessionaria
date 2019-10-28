package br.com.senac.concessionaria.servico;

import br.com.senac.concessionaria.modelo.Endereco;

public class EnderecoServico {
	
	Endereco endereco;
	public EnderecoServico() {
		// TODO Auto-generated constructor stub
		endereco = new Endereco();
	}
	
	
	public EnderecoServico(int id_endereco, String cep, String rua, String numero, String complemento, CidadeServico cidade,
			EstadoServico estado, BairroServico bairro) {
		
		endereco = new Endereco(id_endereco, cep, rua, numero, complemento, cidade, estado, bairro);
		
	}


	public int getId_endereco() {
		return endereco.getId_endereco();
	}

	public void setId_endereco(int id_endereco) {
		endereco.setId_endereco(id_endereco);
	}

	public String getCep() {
		return endereco.getCep();
	}
	public void setCep(String cep) {
		endereco.setCep(cep);
	}
	public String getRua() {
		return endereco.getRua();
	}
	public void setRua(String rua) {
		endereco.setRua(rua);
	}
	public CidadeServico getCidade() {
		return endereco.getCidade();
	}

	public void setCidade(CidadeServico cidade) {
		endereco.setCidade(cidade);
	}

	public EstadoServico getEstado() {
		return endereco.getEstado();
	}

	public void setEstado(EstadoServico estado) {
		endereco.setEstado(estado);
	}

	public BairroServico getBairro() {
		return endereco.getBairro();
	}

	public void setBairro(BairroServico bairro) {
		endereco.setBairro(bairro);
	}

	public String getNumero() {
		return endereco.getNumero();
	}
	public void setNumero(String numero) {
		endereco.setNumero(numero);
	}
	public String getComplemento() {
		return endereco.getComplemento();
	}
	public void setComplemento(String complemento) {
		endereco.setComplemento(complemento);
	}

}
