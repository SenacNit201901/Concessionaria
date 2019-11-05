package br.com.senac.concessionaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.senac.concessionaria.modelo.ItemPedido;
import br.com.senac.concessionaria.modelo.Pedido;
import br.com.senac.concessionaria.modelo.Veiculo;
import br.com.senac.concessionaria.util.DAO;

public class ItemPedidoDao extends DAO {
	private Connection conn;
	
	private void abreConexao() {
		try {
			conn = getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao tentar abrir a conex�o");
		}
	}
	
	public void gravar(List<ItemPedido> i) throws SQLException {
		abreConexao();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
	
		try {
			
			for(ItemPedido p: i) {
				pstmt = conn.prepareStatement("INSERT INTO item_pedidos VALUES (null, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt.setInt(1, p.getQuantidade());
				pstmt.setDouble(2, p.getSub_Total());
				pstmt.setInt(3, p.getVeiculo().getId_Veiculo());
				pstmt.setInt(4, p.getPedido().getId_pedido());
				
				
				int flag = pstmt.executeUpdate();
				if(flag != 0) {
					rs = pstmt.getGeneratedKeys();
					rs.next();
					p.setId_item(rs.getInt(1));
				} else {
					throw new SQLException("Erro ao gravar no banco!");
				}
				
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
	
	public void deletar (int id_pedido) throws SQLException {
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
	public List<ItemPedido> listarVeiculoP() throws SQLException {
		abreConexao();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("	select i.id_item_pedido, i.quantidade, i.subtotal, i.id_pedido, v.modelo, v.valor_unitario  from item_pedidos as i inner join veiculos as v where i.id_veiculos_pedido = v.id_veiculo");
			rs = pstmt.executeQuery();
			
			List<ItemPedido> items = new ArrayList<ItemPedido>();
			
			while(rs.next()) { 
				ItemPedido i;
				i = new ItemPedido();
				i.setId_item(rs.getInt(1));
				i.setQuantidade(rs.getInt(2));
				i.setSub_Total(rs.getDouble(3));
				Pedido p = new Pedido();
				p.setId_pedido(rs.getInt(4));
				i.setPedido(p);
				Veiculo v = new Veiculo();
				v.setModeloVeiculo(rs.getString(5));
				v.setValorVeiculo(rs.getDouble(6));
				i.setVeiculo(v);
				
				items.add(i);
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
