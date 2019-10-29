package br.com.senac.concessionaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.senac.concessionaria.modelo.Usuario;
import br.com.senac.concessionaria.util.DAO;

public class UsuarioDAO extends DAO{
	private Connection conn;

	
	public void gravar(Usuario u) throws SQLException{
		abreConexao();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			pstmt = conn.prepareStatement("INSERT INTO usuario VALUES (null, ?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, u.getNome());
			pstmt.setString(2, u.getSobrenome());
			pstmt.setString(3, u.getCpf());
			pstmt.setString(4, u.getEmail());
			pstmt.setString(5, u.getSenha());
			pstmt.setObject(6, u.getEndereco().getId_endereco());
			pstmt.setObject(7, u.getTipo_usuario().getId_tipo_usuario());

			
			
			int flag = pstmt.executeUpdate();
			if(flag != 0) {
				rs = pstmt.getGeneratedKeys();
				rs.next();
				u.setId_usuario(rs.getInt(1));
			} else {
				throw new SQLException("Erro ao gravar no banco!");
			}
			
			
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
	
	public Usuario login(Usuario u) throws SQLException{
		abreConexao();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			pstmt = conn.prepareStatement("select * from usuario where email = ? and senha = ?");
			pstmt.setString(1, u.getEmail());
			pstmt.setString(2, u.getSenha());


			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				u.setId_usuario(rs.getInt(1));
				u.setNome(rs.getString(2));
				u.setSobrenome(rs.getString(3));
				u.setCpf(rs.getString(4));
				u.setEmail(rs.getString(5));
				u.setSenha(rs.getString(6));
			}
			return u;
			

			
			
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
	
	

	
	
	private void abreConexao() {
		try {
			conn = getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao tentar abrir a conexão");
		}
	}
}
