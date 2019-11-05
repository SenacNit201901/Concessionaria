package br.com.senac.concessionaria.controle;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.senac.concessionaria.modelo.Bairro;
import br.com.senac.concessionaria.modelo.Cidade;
import br.com.senac.concessionaria.modelo.Endereco;
import br.com.senac.concessionaria.modelo.Estado;
import br.com.senac.concessionaria.modelo.Usuario;
import br.com.senac.concessionaria.servico.UsuarioServico;


@WebServlet({ "/usuario/adicionar", "/usuario/remover", "/usuario/listar", "/usuario/localizar", "/usuario/editar", "/usuario/atualizar" , "/usuario/perfil"})
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UsuarioServico u;
    
    public ServletUsuario() {
        super();
        this.u = new UsuarioServico();
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	if(request.getServletPath().equals("/usuario/perfil")) { 
			request.getRequestDispatcher("/views/perfil.jsp").forward(request, response);;
		} else if(request.getServletPath().equals("/usuario/remover")) { 
			remover(request, response);
		} else if(request.getServletPath().equals("/usuario/editar")) { 
			editar(request, response);
		} else if(request.getServletPath().equals("/usuario/listar")) { 
			listar(request, response);
			
		} else if(request.getServletPath().equals("/usuario/localizar")) { 
			localizar(request, response);
		} else {
			response.getWriter().append("P�gina n�o localizada!!! " + request.getMethod());
		}
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getServletPath().equals("/usuario/adicionar")) { 
			adicionar(request, response);
		} else if(request.getServletPath().equals("/usuario/atualizar")) {
			atualizar(request, response);
		} else {
			response.getWriter().append("Pagina não localizada!!! " + request.getMethod());
		}
	}
	
	protected void adicionar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.getWriter().append("M�todo: " + request.getMethod());
	}
	
	protected void remover(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		
	
		try {
			u.deletarUsuario(id);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	protected void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		try {
			request.setAttribute("user", u.listarUser());
			request.getRequestDispatcher("/views/usuario.jsp").forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void localizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.getWriter().append("M�todo: " + request.getMethod());
	}
	
	protected void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.getWriter().append("M�todo: " + request.getMethod());
	}
	
	protected void atualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession sessao = request.getSession(true);
		Usuario u = new Usuario();
		int id = (int) sessao.getAttribute("id");
		String nome = (String) request.getParameter("nome");
		String sobrenome = (String) request.getParameter("sobrenome");
		String email = (String) request.getParameter("email");
		String cpf = (String) request.getParameter("cpf");
		
		int idEnd= (int) sessao.getAttribute("idEndereco");
		int idBairro= (int) sessao.getAttribute("idBairro");
		int idCidade= (int) sessao.getAttribute("idCidade");
		int idEstado= (int) sessao.getAttribute("idEstado");

		String cep = (String) request.getParameter("cep");
		String bairro = (String) request.getParameter("bairro");
		String rua = (String) request.getParameter("rua");
		String cidade = (String) request.getParameter("cidade");
		String estado = (String) request.getParameter("estado");
		String complemento = (String) request.getParameter("complemento");
		String numero = (String) request.getParameter("numero");
		
		u.setId_usuario(id);
		u.setNome(nome);
		u.setSobrenome(sobrenome);
		u.setCpf(cpf);
		u.setEmail(email);
		Estado es = new Estado(estado);
		es.setId_UF(idEstado);
		Bairro b = new Bairro(bairro);
		b.setId_bairro(idBairro);
		Cidade c = new Cidade(cidade);
		c.setId_cidade(idCidade);
		
		Endereco e = new Endereco(cep, rua, numero, complemento, c, es, b);
		e.setId_endereco(idEnd);
		
		UsuarioServico us = new UsuarioServico();
		try {
			us.atualizaBairro(b);
			us.atualizaCidade(c);
			us.atualizaEnd(e);
			us.atualizaEstado(es);
			us.atualizaUser(u);
			
			response.sendRedirect("/Concessionaria/usuario/perfil");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

}