package br.com.senac.concessionaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.senac.concessionaria.modelo.TipoUsuario;

public class TipoUsuarioDAO extends DAO {
private Connection conn;
	
	public TipoUsuarioDAO() {
		
	}
	
	public void gravar(TipoUsuario tu) throws SQLException{
		
		
		abreConexao();

		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement("insert into tipo_usuario(tipo_usuario) values(?)");
			
			pstmt.setString(1, tu.getTipo_usuario());
			
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
	
	public List<TipoUsuario> listar() throws SQLException{
		abreConexao();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("select * from tipo_usuario");
			rs = pstmt.executeQuery();
			
			List<TipoUsuario> marcas = new ArrayList<TipoUsuario>();
			while(rs.next()) {
				marcas.add(criaTipoUsuario(rs));
			}
			return marcas;
			
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
	
public TipoUsuario busca(int id) throws SQLException {
		
		abreConexao();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("select * from tipo_usuario where id_tipo_usuario = ?");
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return criaTipoUsuario(rs);
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

public void deletaTipoUsuario(int id) throws SQLException {
	abreConexao();
	
	PreparedStatement pstmt = null;
	
	try {
		pstmt = conn.prepareStatement("delete from tipo_usuario where id_tipo_usuario = ?");
		pstmt.setInt(1, id);
		
		int flag = pstmt.executeUpdate();
		
		if(flag == 0) {
			throw new SQLException("Erro ao excluir o tipo de usuario: " + id + " do banco!");
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

public void editarTipoUsuario(TipoUsuario tu) throws SQLException {
	abreConexao();

	PreparedStatement pstmt = null;
	
	try {
		pstmt = conn.prepareStatement("update tipo_usuario set tipo_usuario = ? where id_tipo_usuario = ?");
		
		pstmt.setString(1, tu.getTipo_usuario());
		pstmt.setInt(2, tu.getId_tipo_usuario());
		
		int flag = pstmt.executeUpdate();
		
		if(flag == 0) {				
			throw new SQLException("Erro ao atualizar o tipo de usuario: " + tu.getId_tipo_usuario() + " no banco!");
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
	
	private TipoUsuario criaTipoUsuario(ResultSet rs) throws SQLException {
		TipoUsuario tu;
		tu = new TipoUsuario();
		tu.setId_tipo_usuario(rs.getInt(1));
		tu.setTipo_usuario(rs.getString(2));
		return tu;
	}
}

