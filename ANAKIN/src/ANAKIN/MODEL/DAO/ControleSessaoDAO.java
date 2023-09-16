package ANAKIN.MODEL.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.mysql.cj.protocol.Resultset;

import ANAKIN.MODEL.VO.ControleSessaoVO;
import ANAKIN.MODEL.VO.UsuarioVO;

//precisa de modificação com fk do user
public class ControleSessaoDAO {
	Connection conn;
	PreparedStatement PSTM;

	public void salvarInformacoes(ControleSessaoVO controle) {
		conn = new ConexaoDAO().conectabd();
		String sql = "insert into controle_sessao (nome_sessao, inventario_sessao, anotacoes_sessao, id_usuario) values (?,?,?,?)";
		try {
			PSTM = conn.prepareStatement(sql);
			PSTM.setString(1, controle.getNome_sessao());
			PSTM.setString(2, controle.getInventario_sessao());
			PSTM.setString(3, controle.getAnotacoes_sessao());
			PSTM.setString(4, controle.getFk_usuario());
			PSTM.execute();
			PSTM.close();
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "ControleSessaoDAO: " + erro);
		}
	}

	public ArrayList<String> chamarinformacoes(String nome_Sessao) {
		conn = new ConexaoDAO().conectabd();
		UsuarioVO user = new UsuarioVO();
		ArrayList<String> registrosnome = new ArrayList<>();
			String sql = "select nome_sessao From controle_sessao where nome_sessao like ?;";
		try {
			PSTM = conn.prepareStatement(sql);
			PSTM.setString(1, "%" + nome_Sessao + "%");
			ResultSet resultado = PSTM.executeQuery();
			while (resultado.next()) {
				String nomes = resultado.getString(1);
				registrosnome.add(nomes);
			}
			PSTM.close();

		} catch (SQLException problema) {

			System.err.println(" erro no chamarinformaçoes");
			return null;
		}
		return registrosnome;
	}
}
