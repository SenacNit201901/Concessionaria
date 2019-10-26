package br.com.senac.concessionaria.controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({ "/pedido/adicionar", "/pedido/remover", "/pedido/listar", "/pedido/localizar", "/pedido/editar", "/pedido/atualizar" })
public class ServletPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletPedido() {
        super();
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getServletPath().equals("/pedido/remover")) { 
			remover(request, response);
		} else if(request.getServletPath().equals("/pedido/editar")) { 
			editar(request, response);
		} else if(request.getServletPath().equals("/pedido/listar")) { 
			listar(request, response);
		} else if(request.getServletPath().equals("/pedido/localizar")) { 
			localizar(request, response);
		} else {
			response.getWriter().append("Página não localizada!!! " + request.getMethod());
		}
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getServletPath().equals("/pedido/adicionar")) { 
			adicionar(request, response);
		} else if(request.getServletPath().equals("/pedido/atualizar")) {
			atualizar(request, response);
		} else {
			response.getWriter().append("Página não localizada!!! " + request.getMethod());
		}
	}
	
	protected void adicionar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.getWriter().append("Método: " + request.getMethod());
	}
	
	protected void remover(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.getWriter().append("Método: " + request.getMethod());
	}
	
	protected void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.getWriter().append("Método: " + request.getMethod());
	}
	
	protected void localizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.getWriter().append("Método: " + request.getMethod());
	}
	
	protected void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.getWriter().append("Método: " + request.getMethod());
	}
	
	protected void atualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.getWriter().append("Método: " + request.getMethod());
	}

}