package ANAKIN.MODEL.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ManterSessaoDAO {
	Connection conn;
	PreparedStatement PSTM;

	public void finalizaSessao() {
		conn = new ConexaoDAO().conectabd();
		try {
			String SQL = "update NumeroVereficador set numero = 0 where id = 1;";
			PSTM = conn.prepareStatement(SQL);
			PSTM.executeUpdate();
			PSTM.close();
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, erro + "ouve um erro");
		}
	}

	public ResultSet VereficaManterSessao() {
		conn = new ConexaoDAO().conectabd();
		try {
			String SQL = "Select numero from numerovereficador where id = 1";
			PSTM = conn.prepareStatement(SQL);
			ResultSet numero = PSTM.executeQuery();
			return numero;

		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, erro);
			return null;
		}

	}

	public void Sessaomanter(int numerador) {
		conn = new ConexaoDAO().conectabd();
		try {
			String SQL = "update NumeroVereficador set numero = ? where id = 1;";
			PSTM = conn.prepareStatement(SQL);
			PSTM.setInt(1, numerador);
			PSTM.executeUpdate();
			PSTM.close();

		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, erro);
		}

	}

}
