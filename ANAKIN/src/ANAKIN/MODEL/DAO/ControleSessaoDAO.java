package ANAKIN.MODEL.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.mysql.cj.protocol.Resultset;

import ANAKIN.MODEL.VO.ControleSessaoVO;

//precisa de modificação com fk do user
public class ControleSessaoDAO {
	Connection conn;
	PreparedStatement PSTM;

	public void salvarInformacoes(ControleSessaoVO controle) {
		conn = new ConexaoDAO().conectabd();
		String sql = "insert into controle_sessao (nome_sessao, inventario_sessao, anotacoes_sessao) values (?,?,?)";
		try {
			PSTM = conn.prepareStatement(sql);
			PSTM.setString(1, controle.getNome_sessao());
			PSTM.setString(2, controle.getInventario_sessao());
			PSTM.setString(3, controle.getAnotacoes_sessao());			
			PSTM.execute();
			PSTM.close();
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "ControleSessaoDAO: " + erro);
		}
	}
	
}
