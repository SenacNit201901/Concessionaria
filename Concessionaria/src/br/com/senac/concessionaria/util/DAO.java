package br.com.senac.concessionaria.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {

		public DAO() {
			
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
			} catch (ClassNotFoundException cnfe) { 
				cnfe.printStackTrace();
				System.out.println("Classe Driver n�o encontrada. Erro: " + cnfe.getMessage());
			}
		}
		

		public Connection getConnection() throws SQLException {
			return DriverManager.getConnection("jdbc:mysql://localhost:3361/concessionariaDB", "root", "");
		}
	}


