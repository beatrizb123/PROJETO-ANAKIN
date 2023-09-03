package ANAKIN.MODEL.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import ANAKIN.MODEL.VO.DadosVO;

public class DadosDAO {
	Connection conn;
	PreparedStatement PSTM;

	public void salvarRegistro(DadosVO dados) {
		conn = new ConexaoDAO().conectabd();
		String sql = "insert into dados (registro) values (?)";
		try {
			PSTM = conn.prepareStatement(sql);
			PSTM.setString(1, dados.getRegistro());
			PSTM.execute();
			PSTM.close();
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "DadosVO: " + erro);
		}
	}
	
}
