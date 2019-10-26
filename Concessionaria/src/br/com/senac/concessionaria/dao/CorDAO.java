package br.com.senac.concessionaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.senac.concessionaria.modelo.Cor;

public class CorDAO extends DAO {
private Connection conn;
	
	public CorDAO() {
		
	}
	
	public void gravar(Cor cor) throws SQLException{
		
		
		abreConexao();

		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement("insert into cor(nome_cor) values(?)");
			
			pstmt.setString(1, cor.getNome_cor());
			
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
	
	public List<Cor> listar() throws SQLException{
		abreConexao();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("select * from cor");
			rs = pstmt.executeQuery();
			
			List<Cor> cores = new ArrayList<Cor>();
			while(rs.next()) {
				cores.add(criaCor(rs));
			}
			return cores;
			
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
	
public Cor busca(int id) throws SQLException {
		
		abreConexao();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("select * from cor where id_cor = ?");
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return criaCor(rs);
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

public void deletaCor(int id) throws SQLException {
	abreConexao();
	
	PreparedStatement pstmt = null;
	
	try {
		pstmt = conn.prepareStatement("delete from cor where id_cor = ?");
		pstmt.setInt(1, id);
		
		int flag = pstmt.executeUpdate();
		
		if(flag == 0) {
			throw new SQLException("Erro ao excluir a cor: " + id + " do banco!");
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

public void editarCor(Cor cor) throws SQLException {
	abreConexao();

	PreparedStatement pstmt = null;
	
	try {
		pstmt = conn.prepareStatement("update cor set nome_cor = ? where id_cor = ?");
		
		pstmt.setString(1, cor.getNome_cor());
		pstmt.setInt(2, cor.getId_cor());
		
		int flag = pstmt.executeUpdate();
		
		if(flag == 0) {				
			throw new SQLException("Erro ao atualizar a cor: " + cor.getId_cor() + " no banco!");
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
	
	private Cor criaCor(ResultSet rs) throws SQLException {
		Cor cor;
		cor = new Cor();
		cor.setId_cor(rs.getInt(1));
		cor.setNome_cor(rs.getString(2));
		return cor;
	}
}


