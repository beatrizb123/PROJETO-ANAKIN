package ANAKIN.MODEL.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import ANAKIN.MODEL.VO.DadosVO;

public class DadosDAO {
	Connection conn;
	PreparedStatement PSTM;

	public void criarRegistro (DadosVO dados) {
		conn = new ConexaoDAO().conectabd();
		String sql = "insert into dados (registro) values ('SELECIONE OS DADOS PARA GERÁ-LOS!')";
		try {
			PSTM.setString(1, sql);
			PSTM.execute();
			PSTM.close();
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "DadosVO: " + erro);
		}
	}
	
	public void salvarRegistro(DadosVO dados) {
		conn = new ConexaoDAO().conectabd();
		String sql = "update dados set resgistro = ? where id_sessao = ?";
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
