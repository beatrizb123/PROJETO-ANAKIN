package ANAKIN.MODEL.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoDAO {

	private Connection conn;

	public Connection conectabd() {
		this.conn = null;
		try {
			String URL = "jdbc:mysql://localhost:3306/anakinpj?user=root&password=123456";

			this.conn = DriverManager.getConnection(URL);
			System.out.print("Conexao realizada!\n");
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "conexaoDAO" + erro.getMessage());
		}
		return this.conn;

	}

}
