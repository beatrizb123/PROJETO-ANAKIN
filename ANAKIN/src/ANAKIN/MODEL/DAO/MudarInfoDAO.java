package ANAKIN.MODEL.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import ANAKIN.MODEL.VO.UsuarioVO;
import ANAKIN.VIEW.EsqueceuSenhaVIEW;

public class MudarInfoDAO {
	Connection conn;
	PreparedStatement pstm;
	
	public void mudaSenha(UsuarioVO sen) {
	String sql = "update usuario set senha_usuario = ? where nome_usuario = ? and id_usuario = ?";
	try {
		conn = new ConexaoDAO().conectabd();
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, sen.getSenha_usuario());
		pstm.setString(2, sen.getNome_usuario());
		pstm.setInt(3, sen.getId_usuario());
		
		pstm.execute();
		pstm.close();
		
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, e);	
	}
	
	
	}

}
