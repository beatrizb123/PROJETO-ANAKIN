package ANAKIN.MODEL.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import ANAKIN.MODEL.VO.ControleSessaoVO;
import ANAKIN.MODEL.VO.UsuarioVO;

public class LoginDAO {
	Connection conn;
	PreparedStatement PSTM;

	public ResultSet autenticaUsuario(UsuarioVO autent) {
		conn = new ConexaoDAO().conectabd();
		try {
			String SQL = "select * from usuario where nome_usuario = ? and senha_usuario = ?";
			PSTM = conn.prepareStatement(SQL);
			PSTM.setString(1, autent.getNome_usuario());
			PSTM.setString(2, autent.getSenha_usuario());
			ResultSet rs = PSTM.executeQuery();
			return rs;
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "LoginDAO: " + erro);
			return null;
		}
	

	}

}
