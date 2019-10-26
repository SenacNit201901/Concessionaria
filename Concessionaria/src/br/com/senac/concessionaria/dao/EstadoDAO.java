package br.com.senac.concessionaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.senac.concessionaria.modelo.Estado;

public class EstadoDAO extends DAO {
private Connection conn;
	
	public EstadoDAO() {
		
	}
	
	public void gravar(Estado es) throws SQLException{
		
		
		abreConexao();

		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement("insert into estado(uf) values(?)");
			
			pstmt.setString(1, es.getUF());
			
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
	
	public List<Estado> listar() throws SQLException{
		abreConexao();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("select * from estado");
			rs = pstmt.executeQuery();
			
			List<Estado> estados = new ArrayList<Estado>();
			while(rs.next()) {
				estados.add(criaEstado(rs));
			}
			return estados;
			
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
	
public Estado busca(int id) throws SQLException {
		
		abreConexao();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("select * from estado where id = ?");
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return criaEstado(rs);
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

public void deletaEstado(int id) throws SQLException {
	abreConexao();
	
	PreparedStatement pstmt = null;
	
	try {
		pstmt = conn.prepareStatement("delete from estado where id = ?");
		pstmt.setInt(1, id);
		
		int flag = pstmt.executeUpdate();
		
		if(flag == 0) {
			throw new SQLException("Erro ao excluir o estado: " + id + " do banco!");
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

public void editarEstado(Estado es) throws SQLException {
	abreConexao();

	PreparedStatement pstmt = null;
	
	try {
		pstmt = conn.prepareStatement("update estado set uf = ? where id = ?");
		
		pstmt.setString(1, es.getUF());
		pstmt.setInt(2, es.getId_UF());
		
		int flag = pstmt.executeUpdate();
		
		if(flag == 0) {				
			throw new SQLException("Erro ao atualizar o estado: " + es.getId_UF() + " no banco!");
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
	

	private Estado criaEstado(ResultSet rs) throws SQLException {
		Estado es;
		es = new Estado();
		es.setId_UF(rs.getInt(1));
		es.setUF(rs.getString(2));
		return es;
	}
}