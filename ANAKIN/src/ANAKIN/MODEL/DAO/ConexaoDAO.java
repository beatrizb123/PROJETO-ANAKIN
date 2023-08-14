package ANAKIN.MODEL.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;



public class ConexaoDAO {
	
	public Connection conectabd (){
		Connection conn = null;
		try {
			String URL = "jdbc:mysql://localhost:3306/bancoteste?user=root&password=anakin2023&";
			
			conn = DriverManager.getConnection(URL);
		}catch(SQLException erro) {
			JOptionPane.showMessageDialog(null,"conexaoDAO"+erro.getMessage());
		}
		return conn;
		
	}
}
