package br.com.senac.concessionaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.senac.concessionaria.modelo.ItemPedido;
import br.com.senac.concessionaria.util.DAO;

public class ItemPedidoDao extends DAO {
	private Connection conn;
	
	private void abreConexao() {
		try {
			conn = getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao tentar abrir a conexão");
		}
	}
	
	private void gravar(ItemPedido i, int id_Pedido) throws SQLException {
		abreConexao();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			pstmt = conn.prepareStatement("INSERT INTO item_pedidos VALUES (null, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, i.getQuantidade());
			pstmt.setDouble(2, i.getSub_Total());
			pstmt.setInt(3, i.getVeiculo().getId_Veiculo());
			pstmt.setInt(4, i.get);
			
			
			int flag = pstmt.executeUpdate();
			if(flag != 0) {
				rs = pstmt.getGeneratedKeys();
				rs.next();
				i.setId_item(rs.getInt(1));
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
	
	private void deletar (int id_pedido) throws SQLException {
		abreConexao();	
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("delete from item_pedidos where id_item_pedido = ?");
			pstmt.setInt(1, id_pedido); // bind
			
			int flag = pstmt.executeUpdate();
			
			if(flag == 0) {
				throw new SQLException("Erro ao excluir o ItemPedido : " + id_pedido + " do banco!");
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

	public List<ItemPedido> listar() throws SQLException {
		abreConexao();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from item_pedidos");
			rs = pstmt.executeQuery();
			
			List<ItemPedido> items = new ArrayList<ItemPedido>();
			
			while(rs.next()) { 
				ItemPedido i;
				i = new ItemPedido();
				i.setId_item(rs.getInt(1));
				i.setQuantidade(rs.getInt(2));
				i.setSub_Total(rs.getDouble(3));
				
			}
			
			return items;			
		}finally {
			if(conn != null) {
				conn.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}
	}
	
	
	
}
