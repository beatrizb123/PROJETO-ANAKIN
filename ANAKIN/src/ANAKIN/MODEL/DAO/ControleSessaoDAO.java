package ANAKIN.MODEL.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.mysql.cj.protocol.Resultset;

import ANAKIN.MODEL.VO.AuxiliarVO;
import ANAKIN.MODEL.VO.ControleSessaoVO;
import ANAKIN.MODEL.VO.UsuarioVO;

//precisa de modificação com fk do user
public class ControleSessaoDAO {
	Connection conn;
	PreparedStatement PSTM;

	public void salvarInformacoes(ControleSessaoVO controle) {
		conn = new ConexaoDAO().conectabd();
		AuxiliarVO AV = new AuxiliarVO();
		String sql = "update controle_sessao set anotacoes_sessao = ?, inventario_sessao = ? where id_sessao = ?;";
		try {
			//int id = novo.retornaIdSessao();
			PSTM = conn.prepareStatement(sql);
			PSTM.setString(1, controle.getAnotacoes_sessao());
			PSTM.setString(2, controle.getInventario_sessao());
			PSTM.setInt(3, AV.getIdsessao());
			PSTM.executeUpdate();
			PSTM.close();
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "ControleSessaoDAO: " + erro);
		}
	}

	public ArrayList<String> chamarinformacoes(String nome_Sessao, String user) {
		conn = new ConexaoDAO().conectabd();

		ArrayList<String> registrosnome = new ArrayList<>();
		String sql = "select nome_sessao From controle_sessao where nome_sessao like ? and id_usuario like ?;";
		try {
			PSTM = conn.prepareStatement(sql);
			PSTM.setString(1, "%" + nome_Sessao + "%");
			PSTM.setString(2, user);
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