package br.com.senac.concessionaria.controle;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		response.getWriter().append("M�todo: " + request.getMethod());
	}

}