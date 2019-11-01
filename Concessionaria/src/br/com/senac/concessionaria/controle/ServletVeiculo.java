package br.com.senac.concessionaria.controle;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.senac.concessionaria.servico.PedidoServico;
import br.com.senac.concessionaria.servico.VeiculoServico;


@WebServlet({ "/veiculo/adicionar", "/veiculo/remover", "/veiculo/listar", "/veiculo/localizar", "/veiculo/editar", "/veiculo/atualizar", "/veiculos/ford", "/veiculos/chevrolet", "/veiculos/fiat",
	"/veiculos/honda", "/veiculos/renault", "/veiculos/volkswagen"})
public class ServletVeiculo extends HttpServlet implements Serializable {
	private static final long serialVersionUID = 1L;
    VeiculoServico vs;

    
    public ServletVeiculo() {
        super();
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	if(request.getServletPath().equals("/veiculo/remover")) { 
			remover(request, response);
		} else if(request.getServletPath().equals("/veiculo/editar")) { 
			editar(request, response);
		} else if(request.getServletPath().equals("/veiculo/listar")) { 
		
				listar(request, response);
			
			
			
		} else if(request.getServletPath().equals("/veiculo/localizar")) { 
			localizar(request, response);
		} else {
			response.getWriter().append("Página não localizada!!! " + request.getMethod());
		}
    	
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getServletPath().equals("/veiculo/adicionar")) { 
			adicionar(request, response);
		} else if(request.getServletPath().equals("/veiculo/atualizar")) {
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
		vs = new VeiculoServico();
		
		try {
				request.setAttribute("veiculo", vs.listar());
				request.getRequestDispatcher("/veiculo.jsp").forward(request, response);
		
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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