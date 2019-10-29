package br.com.senac.concessionaria.controle;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.senac.concessionaria.servico.UsuarioServico;

/**
 * Servlet implementation class ServletCadastro
 */
@WebServlet("/ServletCadastro")
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
		
		try {
			u.cadastrarEndereco(endereco, complemento, cep, numResidencial, bairro, cidade, estado);
			u.cadastrarUsuario(nome, sobrenome, cpf, email, senha);
			u.cadastrarContato(telefone);
			response.sendRedirect("cadastrar.jsp");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
