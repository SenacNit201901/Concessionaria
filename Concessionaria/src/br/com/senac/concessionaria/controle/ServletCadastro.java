package br.com.senac.concessionaria.controle;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.senac.concessionaria.servico.UsuarioServico;

/**
 * Servlet implementation class ServletCadastro
 */
@WebServlet({"/cadastrar", "/cadastro"})
public class ServletCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCadastro() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getServletPath().equals("/cadastro")) {
			request.getRequestDispatcher("views/cadastrar.jsp").forward(request, response);
		} else if(request.getServletPath().equals("/cadastrar")) {
			HttpSession sessao = request.getSession(true);
			sessao.setAttribute("erroEmail", false);
			sessao.setAttribute("erroCpf", false);
			cadastrar(request, response);
		}
		
		
	}
	protected void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String cpf = request.getParameter("cpf").replace(".", "").replace("-", "");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String telefone = request.getParameter("telefone").replace("(", "").replace(")", "").replace("-", "");
		String endereco = request.getParameter("endereco");
		String complemento = request.getParameter("complemento");
		String cep = request.getParameter("cep").replace("-", "");
		String numResidencial = request.getParameter("numResidencia");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		
		UsuarioServico u = new UsuarioServico();
		HttpSession sessao = request.getSession(true);
		try {
			u.cadastrarEndereco(endereco, complemento, cep, numResidencial, bairro, cidade, estado);
			u.cadastrarUsuario(nome, sobrenome, cpf, email, senha);
			String erro = u.erroGravar();
			if(erro == "erro email") {
				
				sessao.setAttribute("erroEmail", true);
				response.sendRedirect("cadastro");
				
			} else if (erro == "erro cpf") {
				
				sessao.setAttribute("erroCpf", true);
				response.sendRedirect("cadastro");
				
			}
			u.cadastrarContato(telefone);
			
			
			
		
			sessao.setAttribute("email", email);
			sessao.setAttribute("senha", senha);
			response.sendRedirect("logar");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}


}
