package br.com.senac.concessionaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.senac.concessionaria.modelo.Bairro;
import br.com.senac.concessionaria.util.DAO;

public class BairroDAO extends DAO {

	private Connection conn;
	
	public BairroDAO() {
		
	}
	
	public void gravar(Bairro b) throws SQLException{
		
		
		abreConexao();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("insert into bairro(nome_bairro) values(?)", PreparedStatement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, b.getNome_Bairro());
			
		
			int flag = pstmt.executeUpdate();

			if(flag == 0) {
				throw new SQLException("Erro ao gravar no banco!");
			}else {
				rs = pstmt.getGeneratedKeys();
				rs.next();
				b.setId_bairro(rs.getInt(1));
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
	
	public List<Bairro> listar() throws SQLException{
		abreConexao();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("select * from bairro");
			rs = pstmt.executeQuery();
			
			List<Bairro> bairros = new ArrayList<Bairro>();
			while(rs.next()) {
				bairros.add(criaBairro(rs));
			}
			return bairros;
			
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
	
public Bairro busca(int id) throws SQLException {
		
		abreConexao();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("select * from bairro where id_bairro = ?");
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return criaBairro(rs);
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

public void deletaBairro(int id) throws SQLException {
	abreConexao();
	
	PreparedStatement pstmt = null;
	
	try {
		pstmt = conn.prepareStatement("delete from bairro where id_bairro = ?");
		pstmt.setInt(1, id);
		
		int flag = pstmt.executeUpdate();
		
		if(flag == 0) {
			throw new SQLException("Erro ao excluir o bairro: " + id + " do banco!");
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

public void editarBairro(Bairro b) throws SQLException {
	abreConexao();

	PreparedStatement pstmt = null;
	
	try {
		pstmt = conn.prepareStatement("update bairro set nome_bairro = ? where id_bairro = ?");
		
		pstmt.setString(1, b.getNome_Bairro());
		pstmt.setInt(2, b.getId_bairro());
		
		int flag = pstmt.executeUpdate();
		
		if(flag == 0) {				
			throw new SQLException("Erro ao atualizar o cliente: " + b.getId_bairro() + " no banco!");
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
	
	private Bairro criaBairro(ResultSet rs) throws SQLException {
		Bairro b;
		b = new Bairro();
		b.setId_bairro(rs.getInt(1));
		b.setNome_Bairro(rs.getString(2));
		return b;
	}
}

