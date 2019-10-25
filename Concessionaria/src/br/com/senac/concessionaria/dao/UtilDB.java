package br.com.senac.concessionaria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilDB {

		private static String URL = "jdbc:sqlserver://51DE150143\\SQLEXPRESS:1433;databaseName=concessionariaDB;integratedSecurity=true";
		
		public static Connection getConnection() throws SQLException {
		    try {
		        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
		        return DriverManager.getConnection(URL);

		    } catch (InstantiationException | IllegalAccessException e) {
		        throw new RuntimeException(e);
		    } catch (SQLException e) {
		        throw new RuntimeException(e);
		    } catch (ClassNotFoundException e) {
		        throw new RuntimeException(e);
		    }
		}

		
}
