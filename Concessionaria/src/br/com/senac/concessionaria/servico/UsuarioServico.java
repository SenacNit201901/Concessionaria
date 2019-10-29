package br.com.senac.concessionaria.servico;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.senac.concessionaria.dao.BairroDAO;
import br.com.senac.concessionaria.dao.CidadeDAO;
import br.com.senac.concessionaria.dao.ContatoDAO;
import br.com.senac.concessionaria.dao.EnderecoDAO;
import br.com.senac.concessionaria.dao.EstadoDAO;
import br.com.senac.concessionaria.dao.TipoUsuarioDAO;
import br.com.senac.concessionaria.dao.UsuarioDAO;
import br.com.senac.concessionaria.modelo.Bairro;
import br.com.senac.concessionaria.modelo.Cidade;
import br.com.senac.concessionaria.modelo.Contato;
import br.com.senac.concessionaria.modelo.Endereco;
import br.com.senac.concessionaria.modelo.Estado;
import br.com.senac.concessionaria.modelo.TipoUsuario;
import br.com.senac.concessionaria.modelo.Usuario;

public class UsuarioServico{
		Estado estado;
		Cidade cidade;
		Bairro bairro;
		Endereco endereco;
		Usuario usuario;
		TipoUsuario tipo_usuario;
		List<Contato> contato;
		
		
	public void cadastrarUsuario(String nome, String sobrenome, String cpf, String email, String senha) throws SQLException {
		
		this.tipo_usuario = new TipoUsuario("Cliente");
		usuario = new Usuario(nome, sobrenome, cpf, email, senha, this.tipo_usuario, this.endereco);
		
		TipoUsuarioDAO t = new TipoUsuarioDAO();
		t.gravar(this.tipo_usuario);
		UsuarioDAO u = new UsuarioDAO();
		u.gravar(this.usuario);
	}
	
	public void cadastrarEndereco(String endereco, String complemento, String cep, String numResidencial, String bairro, String cidade, String estado) throws SQLException{
		this.estado = new Estado(estado);
		this.cidade = new Cidade(cidade);
		this.bairro = new Bairro(bairro);
		this.endereco = new Endereco(cep, endereco, numResidencial, complemento, this.cidade, this.estado, this.bairro);
		
		EstadoDAO es = new EstadoDAO();
		es.gravar(this.estado);
		CidadeDAO c = new CidadeDAO();
		c.gravar(this.cidade);
		BairroDAO b = new BairroDAO();
		b.gravar(this.bairro);
		EnderecoDAO e = new EnderecoDAO();
		e.gravar(this.endereco);
		
		
	}
	public void cadastrarContato(String telefone) throws SQLException {
		ContatoDAO c = new ContatoDAO(); 
		contato = new ArrayList<>();
		contato.add(new Contato(this.usuario, telefone));
		c.gravar(this.contato);
		
	}
		
}
