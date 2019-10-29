package br.com.senac.concessionaria.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			System.out.println("Erro ao tentar abrir a conexão");
		}
	}
}
	
