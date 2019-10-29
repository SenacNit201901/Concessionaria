package br.com.senac.concessionaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.senac.concessionaria.modelo.Endereco;
import br.com.senac.concessionaria.util.DAO;

public class EnderecoDAO extends DAO{
	
	private Connection conn;
	
	
	
	public void gravar(Endereco e) throws SQLException{
	
		abrirConexao();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			pstmt = conn.prepareStatement("INSERT INTO endereco VALUES (null, ?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, e.getCep());
			pstmt.setString(2, e.getRua());
			pstmt.setString(3, e.getNumero());
			pstmt.setString(4, e.getComplemento());
			pstmt.setObject(5, e.getEstado().getId_UF());
			pstmt.setObject(6, e.getBairro().getId_bairro());
			pstmt.setObject(7, e.getCidade().getId_cidade());
			
			
			int flag = pstmt.executeUpdate();
			
			if(flag == 0) {
				throw new SQLException("Erro ao gravar no banco!");
			} else {
				rs = pstmt.getGeneratedKeys();
				rs.next();
				e.setId_endereco(rs.getInt(1));
			}
		} finally {
			if(pstmt != null) {
				pstmt.close();
			}
			if(rs != null) {
				rs.close();
			}
			if(conn != null) {
				conn.close();
			}
		}
		
	}



	private void abrirConexao() {
		try {
			conn = getConnection();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Erro ao tentar abrir a conexão");
		}
	}
	
	
	

}
