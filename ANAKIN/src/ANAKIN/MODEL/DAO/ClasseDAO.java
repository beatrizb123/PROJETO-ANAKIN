package ANAKIN.MODEL.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import ANAKIN.MODEL.VO.ClasseVO;

public class ClasseDAO {
	Connection conn;
	PreparedStatement PSTM;
	String[] classe = new String[3];

	// indicie para selecionar qual classe será indicada pelo usuario; 1 a 4
	public String[] classeSelecionada(int indicie) {
		String sql = "select tipo_classe, talento_especial, talento_padrão from classe where id_classe =" + indicie;
		conn = new ConexaoDAO().conectabd();
		ClasseVO cl = new ClasseVO();
		try {
			PSTM = conn.prepareStatement(sql);
			ResultSet rs = PSTM.executeQuery();
			if (rs.next()) {
				classe[0] = rs.getString(1);
				classe[1] = rs.getString(2);
				classe[2] = rs.getString(3);
				System.out.println(classe);
				return classe;
			} else {
				return null;
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ClasseDAO: " + e);
			return null;
		}

	}

}
