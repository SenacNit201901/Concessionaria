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

import br.com.senac.concessionaria.modelo.ItemPedido;
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
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}
	protected void logar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		UsuarioServico u = new UsuarioServico();
		try {
			Usuario log = new Usuario();
			 log = u.login(email, senha);
			if (log != null) {
				request.getSession().setAttribute("nome", log.getNome());
				request.getSession().setAttribute("id", log.getId_usuario());
				
				HttpSession sessao = request.getSession(true);
				List<ItemPedido> carrinho = new ArrayList<>();
				
				sessao.setAttribute("carrinho", carrinho);
				
				


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
