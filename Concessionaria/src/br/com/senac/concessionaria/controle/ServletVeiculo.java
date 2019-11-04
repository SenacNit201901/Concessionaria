package br.com.senac.concessionaria.controle;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.senac.concessionaria.servico.VeiculoServico;

@WebServlet({ "/veiculos/adicionar", "/veiculos/remover", "/veiculos/listar", "/veiculos/localizar", "/veiculos/editar", "/veiculos/atualizar", "/veiculos/ford", "/veiculos/chevrolet", "/veiculos/chevrolet/onix", "/veiculos/chevrolet/prisma", "/veiculos/chevrolet/cruze", "/veiculos/chevrolet/sltz", "/veiculos/chevrolet/tracker", "/veiculos/fiat", "/veiculos/fiat/toro", "/veiculos/fiat/unoattractive", "/veiculos/fiat/grandsiena", "/veiculos/fiat/cronos", "/veiculos/fiat/argo", "/veiculos/honda", "/veiculos/honda/wrv", "/veiculos/honda/civic", "/veiculos/honda/hrv", "/veiculos/honda/accord", "/veiculos/honda/city", "/veiculo/ford", "/veiculos/ford/ka", "/veiculos/ford/kasedan", "/veiculos/ford/ecosport", "/veiculos/ford/ranger", "/veiculos/ford/newfiesta", "/veiculos/renault", "/veiculos/renault/kwid", "/veiculos/renault/sanderolife", "/veiculos/renault/logan", "/veiculos/renault/duster", "/veiculos/renault/captur", "/veiculos/volkswagen", "/veiculos/volkswagen/t-cross", "/veiculos/volkswagen/polo", "/veiculos/volkswagen/virtus", "/veiculos/volkswagen/jetta", "/veiculos/volkswagen/gol" })

public class ServletVeiculo extends HttpServlet implements Serializable {
	private static final long serialVersionUID = 1L;
    VeiculoServico vs;

    
    public ServletVeiculo() {
        super();
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    								//chevrolet links
    	
    	if(request.getServletPath().equals("/veiculos/chevrolet")) { 
			request.getRequestDispatcher("/views/chevrolet.jsp").forward(request, response);
			
			
										//ONIX
		} else if(request.getServletPath().equals("/veiculos/chevrolet/onix")) { 
			request.getRequestDispatcher("/views/compra-onix.jsp").forward(request, response);
										
										//CRUZE
		} else if(request.getServletPath().equals("/veiculos/chevrolet/cruze")) { 
			request.getRequestDispatcher("/views/compra-cruze.jsp").forward(request, response);
			
			
										//PRISMA
		} else if(request.getServletPath().equals("/veiculos/chevrolet/prisma")) { 
			request.getRequestDispatcher("/views/compra-prisma.jsp").forward(request, response);
			
			
										//S10
		} else if(request.getServletPath().equals("/veiculos/chevrolet/sltz")) { 
			request.getRequestDispatcher("/views/compra-s10.jsp").forward(request, response);
										//TRACKER
		} else if(request.getServletPath().equals("/veiculos/chevrolet/tracker")) { 
			request.getRequestDispatcher("/views/compra-tracker.jsp").forward(request, response);
			
			
									//fiat links
		} else if(request.getServletPath().equals("/veiculos/fiat")) { 
				request.getRequestDispatcher("/views/fiat.jsp").forward(request, response);
				
										//TORO
			} else if(request.getServletPath().equals("/veiculos/fiat/toro")) { 
				request.getRequestDispatcher("/views/compra-toro.jsp").forward(request, response);
				
										//UNO
			} else if(request.getServletPath().equals("/veiculos/fiat/unoattractive")) { 
				request.getRequestDispatcher("/views/compra-uno.jsp").forward(request, response);
				
							
										//GRANDSIENA		
			} else if(request.getServletPath().equals("/veiculos/fiat/grandsiena")) { 
				request.getRequestDispatcher("/views/compra-grandsiena.jsp").forward(request, response);
										//CRONOS
			} else if(request.getServletPath().equals("/veiculos/fiat/cronos")) { 
				request.getRequestDispatcher("/views/compra-cronos.jsp").forward(request, response);
										//ARGO
			} else if(request.getServletPath().equals("/veiculos/fiat/argo")) { 
				request.getRequestDispatcher("/views/compra-argo.jsp").forward(request, response);
				
				
					
				
										//FORD LINKS
			} else if(request.getServletPath().equals("/veiculos/ford")) { 
			request.getRequestDispatcher("/views/ford.jsp").forward(request, response);
		
										//KA
			} else if(request.getServletPath().equals("/veiculos/ford/ka")) { 
			request.getRequestDispatcher("/views/compra-ka.jsp").forward(request, response);
			
								//SEDAN
			} else if(request.getServletPath().equals("/veiculos/ford/kasedan")) { 
			request.getRequestDispatcher("/views/compra-sedan.jsp").forward(request, response);
			
					
									//ECO-SPORT		
			} else if(request.getServletPath().equals("/veiculos/ford/ecosport")) { 
			request.getRequestDispatcher("/views/compra-eco.jsp").forward(request, response);
									//RANGER
			} else if(request.getServletPath().equals("/veiculos/ford/ranger")) { 
			request.getRequestDispatcher("/views/compra-ranger.jsp").forward(request, response);
										//FIESTA
			} else if(request.getServletPath().equals("/veiculos/ford/newfiesta")) { 
			request.getRequestDispatcher("/views/compra-fiesta.jsp").forward(request, response);
			
			
										//HONDA LINKS
			} else if(request.getServletPath().equals("/veiculos/honda")) { 
			request.getRequestDispatcher("/views/honda.jsp").forward(request, response);
			
										 //WRV
			} else if(request.getServletPath().equals("/veiculos/honda/wrv")) { 
			request.getRequestDispatcher("/views/compra-wrv.jsp").forward(request, response);
			
										//CIVIC
			} else if(request.getServletPath().equals("/veiculos/honda/civic")) { 
			request.getRequestDispatcher("/views/compra-civic.jsp").forward(request, response);
			
			
										//HRV		
			} else if(request.getServletPath().equals("/veiculos/honda/hrv")) { 
			request.getRequestDispatcher("/views/compra-hrv.jsp").forward(request, response);
										//ACCORD
			} else if(request.getServletPath().equals("/veiculos/honda/accord")) { 
			request.getRequestDispatcher("/views/compra-accord.jsp").forward(request, response);
										//CITY
			} else if(request.getServletPath().equals("/veiculos/honda/city")) { 
			request.getRequestDispatcher("/views/compra-city.jsp").forward(request, response);
		
			
										//RENAULT LINKS
			} else if(request.getServletPath().equals("/veiculos/renault")) { 
			request.getRequestDispatcher("/views/renault.jsp").forward(request, response);
			
						 				//KWID
			} else if(request.getServletPath().equals("/veiculos/renault/kwid")) { 
			request.getRequestDispatcher("/views/compra-kwid.jsp").forward(request, response);
			
										//SANDERO
			} else if(request.getServletPath().equals("/veiculos/renault/sanderolife")) { 
			request.getRequestDispatcher("/views/compra-sandero.jsp").forward(request, response);
			
			
										//LOGAN		
			} else if(request.getServletPath().equals("/veiculos/renault/logan")) { 
			request.getRequestDispatcher("/views/compra-logan.jsp").forward(request, response);
										//DUSTER
			} else if(request.getServletPath().equals("/veiculos/renault/duster")) { 
			request.getRequestDispatcher("/views/compra-duster.jsp").forward(request, response);
										//CAPTUR
			} else if(request.getServletPath().equals("/veiculos/renault/captur")) { 
			request.getRequestDispatcher("/views/compra-captur.jsp").forward(request, response);
			
			
			
										//VOLKSWAGEN LINKS
			} else if(request.getServletPath().equals("/veiculos/volkswagen")) { 
			request.getRequestDispatcher("/views/volks.jsp").forward(request, response);
			
										//T-CROSS
			} else if(request.getServletPath().equals("/veiculos/volkswagen/t-cross")) { 
			request.getRequestDispatcher("/views/compra-tcross.jsp").forward(request, response);
			
										//POLO
			} else if(request.getServletPath().equals("/veiculos/volkswagen/polo")) { 
			request.getRequestDispatcher("/views/compra-polo.jsp").forward(request, response);
			
			
										//VIRTUS		
			} else if(request.getServletPath().equals("/veiculos/volkswagen/virtus")) { 
			request.getRequestDispatcher("/views/compra-virtus.jsp").forward(request, response);
										//JETTA
			} else if(request.getServletPath().equals("/veiculos/volkswagen/jetta")) { 
			request.getRequestDispatcher("/views/compra-jetta.jsp").forward(request, response);
										//GOL
			} else if(request.getServletPath().equals("/veiculos/volkswagen/gol")) { 
			request.getRequestDispatcher("/views/compra-gol.jsp").forward(request, response);
			
			
			
			}
		else if(request.getServletPath().equals("/veiculo/editar")) { 
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
				request.getRequestDispatcher("/views/veiculo.jsp").forward(request, response);
		
			
			
			
			
			
			
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