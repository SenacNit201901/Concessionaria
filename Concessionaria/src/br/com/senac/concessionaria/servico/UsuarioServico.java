package br.com.senac.concessionaria.servico;

import java.util.List;

import br.com.senac.concessionaria.modelo.Contato;
import br.com.senac.concessionaria.modelo.Endereco;
import br.com.senac.concessionaria.modelo.TipoUsuario;
import br.com.senac.concessionaria.modelo.Usuario;

public class UsuarioServico{
		
	Usuario usuario;
	
		public UsuarioServico() {
			usuario = new Usuario();
		}
		
		public UsuarioServico(int id_usuario, String nome, String sobrenome, String cpf, String email, String senha,
				TipoUsuarioServico tipo_usuario, Endereco endereco, List<Contato> contatos) {
			
			usuario = new Usuario(id_usuario, nome, sobrenome, cpf, email, senha, tipo_usuario, endereco, contatos );
			
		}
		public int getId_usuario() {
			return usuario.getId_usuario();
		}
		public void setId_usuario(int id_usuario) {
			usuario.setId_usuario(id_usuario);
		}
		public String getNome() {
			return usuario.getNome();
		}
		public void setNome(String nome) {
			usuario.setNome(nome);
		}
		public String getSobrenome() {
			return usuario.getSobrenome();
		}
		public void setSobrenome(String sobrenome) {
			usuario.setSobrenome(sobrenome);
			}
		public String getCpf() {
			return usuario.getCpf();
		}
		public void setCpf(String cpf) {
			usuario.setCpf(cpf);
		}
		public String getEmail() {
			return usuario.getEmail();
		}
		public void setEmail(String email) {
			usuario.setEmail(email);
		}
		public Endereco getEndereco() {
			return usuario.getEndereco();
		}

		public void setEndereco(Endereco endereco) {
			usuario.setEndereco(endereco);
		}

		public List<Contato> getContatos() {
			return usuario.getContatos();
		}

		public void setContatos(List<Contato> contatos) {
			usuario.setContatos(contatos);
		}


		public String getSenha() {
			return usuario.getSenha();
		}
		public void setSenha(String senha) {
			usuario.setSenha(senha);
		}

		
		
		public TipoUsuarioServico getTipo_usuario() {
			return usuario.getTipo_usuario();
		}
		public void setTipo_usuario(TipoUsuarioServico tipo_usuario) {
			usuario.setTipo_usuario(tipo_usuario);
		}
		
}
