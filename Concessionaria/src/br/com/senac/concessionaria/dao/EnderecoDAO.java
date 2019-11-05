package br.com.senac.concessionaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.senac.concessionaria.modelo.Bairro;
import br.com.senac.concessionaria.modelo.Cidade;
import br.com.senac.concessionaria.modelo.Endereco;
import br.com.senac.concessionaria.modelo.Estado;
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
	public void editarEnd(Endereco e) throws SQLException {
		abrirConexao();

		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement("update endereco SET  cep = ?, rua = ?, numero = ?, complemento = ? where id_endereco = ?");
			
			pstmt.setString(1, e.getCep());
			pstmt.setString(2, e.getRua());
			pstmt.setString(3, e.getNumero());
			pstmt.setString(4, e.getComplemento());

			
			int flag = pstmt.executeUpdate();
			
			if(flag == 0) {				
				throw new SQLException("Erro ao atualizar o estado: " + e.getId_endereco() + " no banco!");
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
		

	public Endereco busca(int id) throws SQLException {
		
		abrirConexao();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("select * from endereco where id_endereco = ?");
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return criaEndereco(rs);
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

	private void abrirConexao() {
		try {
			conn = getConnection();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Erro ao tentar abrir a conex�o");
		}
	}
	
	private Endereco criaEndereco(ResultSet rs) throws SQLException {
		Endereco e;
		e = new Endereco();
		e.setId_endereco(rs.getInt(1));
		e.setCep(rs.getString(2));
		e.setRua(rs.getString(3));
		e.setNumero(rs.getString(4));
		e.setComplemento(rs.getString(5));
		Estado es = new Estado();
		es.setId_UF(rs.getInt(6));
		e.setEstado(es);
		Bairro b = new Bairro();
		b.setId_bairro(rs.getInt(7));
		e.setBairro(b);
		Cidade c = new Cidade();
		c.setId_cidade(rs.getInt(8));
		e.setCidade(c);
		
		return e;
	}
	

}
