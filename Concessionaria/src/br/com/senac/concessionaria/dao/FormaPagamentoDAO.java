package br.com.senac.concessionaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.senac.concessionaria.modelo.FormaPagamento;

public class FormaPagamentoDAO extends DAO {
private Connection conn;
	
	public FormaPagamentoDAO() {
		
	}
	
	public void gravar(FormaPagamento fp) throws SQLException{
		
		
		abreConexao();

		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement("insert into forma_pagamento(tipo_pagamento) values(?)");
			
			pstmt.setString(1, fp.getTipo_pagamento());
			
		} catch (Exception e) {
			int flag = pstmt.executeUpdate();

			if(flag == 0) {
				throw new SQLException("Erro ao gravar no banco!");
			}
		} finally {
			if(conn != null) {
				conn.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
		}
		}
	
	public List<FormaPagamento> listar() throws SQLException{
		abreConexao();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("select * from forma_pagamento");
			rs = pstmt.executeQuery();
			
			List<FormaPagamento> forma_pagamentos = new ArrayList<FormaPagamento>();
			while(rs.next()) {
				forma_pagamentos.add(criaFormaPagamento(rs));
			}
			return forma_pagamentos;
			
		} finally {
			if(conn != null) {
				conn.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(rs != null) {
				rs.close();
			}
		}
		
	}
	
public FormaPagamento busca(int id) throws SQLException {
		
		abreConexao();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("select * from forma_pagamento where id_forma_pagamento = ?");
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return criaFormaPagamento(rs);
			}
			
			return null;
		} finally {
			if(conn != null) {
				conn.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(rs != null) {
				rs.close();
			}
		}
	}

public void deletaFormaPagamento(int id) throws SQLException {
	abreConexao();
	
	PreparedStatement pstmt = null;
	
	try {
		pstmt = conn.prepareStatement("delete from forma_pagamento where id_forma_pagamento = ?");
		pstmt.setInt(1, id);
		
		int flag = pstmt.executeUpdate();
		
		if(flag == 0) {
			throw new SQLException("Erro ao excluir a forma de pagamento: " + id + " do banco!");
		}

	} finally {
		if(conn != null) {
			conn.close();
		}
		if(pstmt != null) {
			pstmt.close();
		}
	}
}

public void editarFormaPagamento(FormaPagamento fp) throws SQLException {
	abreConexao();

	PreparedStatement pstmt = null;
	
	try {
		pstmt = conn.prepareStatement("update forma_pagamento set tipo_pagamento = ? where id_forma_pagamento = ?");
		
		pstmt.setString(1, fp.getTipo_pagamento());
		pstmt.setInt(2, fp.getId_forma_pagamento());
		
		int flag = pstmt.executeUpdate();
		
		if(flag == 0) {				
			throw new SQLException("Erro ao atualizar a forma d e pagamento: " + fp.getId_forma_pagamento() + " no banco!");
		}
		
	} finally {
		if(conn != null) {
			conn.close();
		}
		if(pstmt != null) {
			pstmt.close();
		}
	}
}
		
	
	
	private void abreConexao() {
		try {
			conn = getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao tentar abrir a conexão");
		}
	}
	
	private FormaPagamento criaFormaPagamento(ResultSet rs) throws SQLException {
		FormaPagamento fp;
		fp = new FormaPagamento();
		fp.setId_forma_pagamento(rs.getInt(1));
		fp.setTipo_pagamento(rs.getString(2));
		return fp;
	}
}


