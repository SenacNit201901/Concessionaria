package br.com.senac.concessionaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.senac.concessionaria.modelo.Combustivel;

public class CombustivelDAO extends DAO {
private Connection conn;
	
	public CombustivelDAO() {
		
	}
	
	public void gravar(Combustivel combustivel) throws SQLException{
		
		
		abreConexao();

		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement("insert into combustivel(tipo_combustivel) values(?)");
			
			pstmt.setString(1, combustivel.getTipo_combustivel());
			
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
	
	public List<Combustivel> listar() throws SQLException{
		abreConexao();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("select * from combustivel");
			rs = pstmt.executeQuery();
			
			List<Combustivel> combustiveis = new ArrayList<Combustivel>();
			while(rs.next()) {
				combustiveis.add(criaCombustivel(rs));
			}
			return combustiveis;
			
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
	
public Combustivel busca(int id) throws SQLException {
		
		abreConexao();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("select * from combustivel where id_combustivel = ?");
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return criaCombustivel(rs);
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
		pstmt = conn.prepareStatement("delete from combustivel where id_combustivel = ?");
		pstmt.setInt(1, id);
		
		int flag = pstmt.executeUpdate();
		
		if(flag == 0) {
			throw new SQLException("Erro ao excluir o combustivel: " + id + " do banco!");
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

public void editarCombustivel(Combustivel combustivel) throws SQLException {
	abreConexao();

	PreparedStatement pstmt = null;
	
	try {
		pstmt = conn.prepareStatement("update combustivel set tipo_combustivel = ? where id_combustivel = ?");
		
		pstmt.setString(1, combustivel.getTipo_combustivel());
		pstmt.setInt(2, combustivel.getId_combustivel());
		
		int flag = pstmt.executeUpdate();
		
		if(flag == 0) {				
			throw new SQLException("Erro ao atualizar o combustivel: " + combustivel.getId_combustivel() + " no banco!");
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
	
	private Combustivel criaCombustivel(ResultSet rs) throws SQLException {
		Combustivel combustivel;
		combustivel = new Combustivel();
		combustivel.setId_combustivel(rs.getInt(1));
		combustivel.setTipo_combustivel(rs.getString(2));
		return combustivel;
	}
}
