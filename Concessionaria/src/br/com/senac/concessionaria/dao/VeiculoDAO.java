package br.com.senac.concessionaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.senac.concessionaria.modelo.Veiculo;
import br.com.senac.concessionaria.util.DAO;

public class VeiculoDAO extends DAO {
	
	private Connection conn;
	
	
	public void gravar(Veiculo v) throws SQLException  {
		abrirConexao();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(" INSERT INTO veiculos VALUES (null, ?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, v.getModeloVeiculo());
			pstmt.setInt(2, v.getAnoVeiculo());
			pstmt.setString(3, v.getChassiVeiculo());
			pstmt.setDouble(4, v.getValorVeiculo());
			pstmt.setObject(5, v.getCor().getId_cor());
			pstmt.setObject(6, v.getMarca().getId_marca());
			pstmt.setObject(7, v.getCombustivel().getId_combustivel());
			
			
			int flag = pstmt.executeUpdate();
			if (flag == 0) {
				throw new SQLException("Erro ao tentar gravar no banco");
			} else {
				rs = pstmt.getGeneratedKeys();
				rs.next();
				v.setId_Veiculo(rs.getInt(1));
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
	public Veiculo listarVeiculoId(Veiculo v) throws SQLException{
		abrirConexao();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			pstmt = conn.prepareStatement("select * from veiculos where id_veiculo = ?");
			pstmt.setInt(1, v.getId_Veiculo());



			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				v.setId_Veiculo(rs.getInt(1));
				v.setModeloVeiculo(rs.getString(2));
				v.setAnoVeiculo(rs.getInt(3));
				v.setChassiVeiculo(rs.getString(4));
				v.setValorVeiculo(rs.getDouble(5));

			
				
			}
			return v;
			

			
			
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
	
	public List<Veiculo> listarVeiculo() throws SQLException{
		abrirConexao();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Veiculo veiculo;
		
		try {
			pstmt = conn.prepareStatement("select * from veiculos");
			

			List<Veiculo> v = new ArrayList<>();

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				veiculo = new Veiculo();
				veiculo.setId_Veiculo(rs.getInt(1));
				veiculo.setModeloVeiculo(rs.getString(2));
				veiculo.setAnoVeiculo(rs.getInt(3));
				veiculo.setChassiVeiculo(rs.getString(4));
				veiculo.setValorVeiculo(rs.getDouble(5));
				
				v.add(veiculo);

			
				
			}
			return v;
			

			
			
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
			
			e.printStackTrace();
			System.out.println("Erro ao tentar abrir a conexão");
		}
	}
	

}
