package ANAKIN.MODEL.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.cj.xdevapi.Result;

import ANAKIN.MODEL.VO.AuxiliarVO;
import ANAKIN.MODEL.VO.ControleSessaoVO;
import ANAKIN.MODEL.VO.DadosVO;

public class DadosDAO {
	Connection conn;
	PreparedStatement PSTM;

	public void criarRegistro () {
		conn = new ConexaoDAO().conectabd();
		String sql = "insert into dados (id_sessao) values (?)";
		AuxiliarVO AV = new AuxiliarVO();
		try {
			PSTM = conn.prepareStatement(sql);
			PSTM.setInt(1, AV.getIdsessao());
			int i = PSTM.executeUpdate();
			if (i > 0) {
				PSTM = conn.prepareStatement("SELECT LAST_INSERT_ID();");
				ResultSet rs = PSTM.executeQuery();
				if(rs.next()) {
					int id = rs.getInt(1);
					AV.setIdDados(id);
				}
			}
			PSTM.close();
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "criar DadosDAO: " + erro);
		}
	}
	
	
	public void salvarRegistro(DadosVO dados) {
		conn = new ConexaoDAO().conectabd();
		ControleSessaoDAO cont = new ControleSessaoDAO();
		String sql = "update dados set registro = ? where id_dados = ?";
		AuxiliarVO AV = new AuxiliarVO();
		try {
			PSTM = conn.prepareStatement(sql);
			PSTM.setString(1, dados.getRegistro());
			PSTM.setInt(2, AV.getIdDados());

			PSTM.executeUpdate();
			PSTM.close();
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "salvar DadosDAO: " + erro);
		}
	}
	
}
