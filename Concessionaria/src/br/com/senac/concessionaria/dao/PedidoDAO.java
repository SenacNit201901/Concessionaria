package br.com.senac.concessionaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.senac.concessionaria.modelo.FormaPagamento;
import br.com.senac.concessionaria.modelo.Pedido;
import br.com.senac.concessionaria.util.DAO;

public class PedidoDAO extends DAO{

	private Connection conn;
	
	public void gravar(Pedido p) throws SQLException{
		abreConexao();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("INSERT INTO pedidos VALUES (null, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setObject(1, p.getData_pedido());
			pstmt.setDouble(2, p.getValor_total());
			pstmt.setObject(3, p.getQuantidade_parcelamento());
			pstmt.setLong(4, p.getUsuario().getId_usuario());
			pstmt.setObject(5, p.getPagamento().getId_forma_pagamento());
			
			int flag = pstmt.executeUpdate();
			if(flag != 0) {
				rs = pstmt.getGeneratedKeys();
				rs.next();
				p.setId_pedido(rs.getInt(1));
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
	private void abreConexao() {
		try {
			conn = getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao tentar abrir a conex�o");
		}
	}
public List<Pedido> busca(int id) throws SQLException {
		
		abreConexao();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("select p.id_pedido, p.data_pedido, p.valor_total, p.quantidade_parcelamento, f.tipo_pagamento, p.id_usuario from pedidos as p inner join forma_pagamento as f on f.id_forma_pagamento = p.id_forma_pagamento where id_usuario = ?");
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			List<Pedido> ps = new ArrayList<>();
			
			while(rs.next()) {
				Pedido p = new Pedido();
				p.setId_pedido(rs.getInt(1));
				p.setData_pedido(rs.getDate(2));
				p.setValor_total(rs.getDouble(3));
				p.setQuantidade_parcelamento(rs.getInt(4));
				FormaPagamento f = new FormaPagamento();
				f.setTipo_pagamento(rs.getString(5));
				p.setPagamento(f);
				
				ps.add(p);
			}
			
			return ps;
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
}
	
