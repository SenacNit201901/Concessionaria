package br.com.senac.concessionaria.controle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.senac.concessionaria.modelo.Endereco;
import br.com.senac.concessionaria.modelo.ItemPedido;
import br.com.senac.concessionaria.modelo.TipoUsuario;
import br.com.senac.concessionaria.modelo.Usuario;
import br.com.senac.concessionaria.servico.PedidoServico;
import br.com.senac.concessionaria.servico.UsuarioServico;

@WebServlet({"/login", "/logout", "/logar"})
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PedidoServico pd = new PedidoServico();    
    public ServletLogin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		// TODO Auto-generated method stub
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getServletPath().equals("/logar")) {
			logar(request, response);
		} else if (request.getServletPath().equals("/logout")) {
			logout(request, response);
		} else if(request.getServletPath().equals("/login")) {
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
		}
		
	}
	protected void logar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		UsuarioServico u = new UsuarioServico();
		try {
		
			Boolean login = u.login(email, senha);
			if (login) {
				Usuario user = new Usuario();
				user.setEmail(email);
				user.setSenha(senha);
				Endereco e = new Endereco();
				TipoUsuario tp = new TipoUsuario();
				
				user = u.listar(user);
			
				tp = u.listarTipoUser(user.getTipo_usuario().getId_tipo_usuario());
				e = u.listarEndereco(user.getEndereco().getId_endereco());
				
				HttpSession sessao = request.getSession(true);
				sessao.setAttribute("nome", user.getNome());
				sessao.setAttribute("id", user.getId_usuario());
				request.getSession().setAttribute("sobrenome", user.getSobrenome());
				request.getSession().setAttribute("cpf", user.getCpf());
				request.getSession().setAttribute("email", user.getEmail());
				request.getSession().setAttribute("cep", e.getCep());
				request.getSession().setAttribute("rua", e.getRua());
				request.getSession().setAttribute("bairro", e.getBairro().getNome_Bairro());
				request.getSession().setAttribute("cidade", e.getCidade().getNome_cidade());
				request.getSession().setAttribute("estado", e.getEstado().getUF());
				request.getSession().setAttribute("numero", e.getNumero());
				request.getSession().setAttribute("complemento", e.getComplemento());
				

				
				
				List<ItemPedido> carrinho = new ArrayList<>();
				Double valor = 0.0;
				int qtd = 0;
				sessao.setAttribute("carrinho", carrinho);
				sessao.setAttribute("valor", valor);
				sessao.setAttribute("qtd", qtd);

				
				
				


				response.sendRedirect("home");
				
			} else {
			
				response.sendRedirect("cadastro");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		// TODO Auto-generated method stub
		doPost(request, response);
	}
	
	

}
