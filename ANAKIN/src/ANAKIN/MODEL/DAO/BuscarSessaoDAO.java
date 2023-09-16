package ANAKIN.MODEL.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import ANAKIN.MODEL.VO.UsuarioVO;

public class BuscarSessaoDAO {
	Connection conn;
	PreparedStatement PSTM;
	static int linhas;

	public static int getLinhas() {
		return linhas;
	}

	public String[] retornaSessoes(String [] s) {
		conn = new ConexaoDAO().conectabd();
		UsuarioVO user = new UsuarioVO();
		String sql = "select nome_sessao from controle_sessao where id_usuario = '" + user.getNome_Usuario() + "'";

		try {
			PSTM = new ConexaoDAO().conectabd().prepareStatement(sql);
			ResultSet resultSet = PSTM.executeQuery();
			int qtdeColunas = resultSet.getMetaData().getColumnCount();
			ArrayList<String> list = new ArrayList<String>();
			while (resultSet.next()) {
				list.add(resultSet.getString(1));
			}
			s = list.toArray(new String[list.size()]);
			
			resultSet.close();
			PSTM.close();
			System.out.println(s);
			return s;
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro);
			return null;
		}

	}

}
