package ANAKIN.MODEL.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import ANAKIN.MODEL.VO.ControleSessaoVO;

public class ControleSessaoDAO {
	Connection conn;
	PreparedStatement PSTM;
	
	public void salvarInformacoes(ControleSessaoVO controle) {
		conn = new ConexaoDAO().conectabd();
		String sql = "insert into controle_sessao (inventario_sessao, anotacoes_sessao) values (?, ?)";
		try {
			PSTM = conn.prepareStatement(sql);
			PSTM.setString(1, controle.getInventario_sessao());
			PSTM.setString(2, controle.getAnotacoes_sessao());
			PSTM.execute();
			PSTM.close();
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "ControleSessaoDAO: " + erro);
		}	
	}
}
