package ANAKIN.MODEL.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import ANAKIN.MODEL.VO.Todososdados;


public class Dadosdosusuarios {
	Connection conn;
	PreparedStatement PSTM;
	//medoto para logar/autenticar
	//medoto para cadastrar
	public void cadastrarUsuario(Todososdados infor) {
		String sql ="insert into usuario (nome_usuario,senha_usuario) values(?,?)";
		conn = new ConexaoDAO().conectabd();
		try {
			PSTM = conn.prepareStatement(sql);
			PSTM.setString(1, infor.getNome_usuario());
			PSTM.setString(2, infor.getSenha_usuario());
			PSTM.execute();
			PSTM.close();
		}catch(Exception erro) {
		JOptionPane.showMessageDialog(null,erro);
		}
	}
	public ResultSet autenticaUsuario(Todososdados autent) {
		conn = new ConexaoDAO().conectabd();
		try {
			String SQL ="select * from usuario where nome_usuario = ? and senha_usuario = ?";
			PreparedStatement pstm = conn.prepareStatement(SQL);
			pstm.setString(1, autent.getNome_usuario());
			pstm.setString(2, autent.getSenha_usuario());
			ResultSet rs = pstm.executeQuery();
			return rs;
		}catch(SQLException erro) {
			JOptionPane.showMessageDialog(null,"todososdadosDAO"+ erro);
			return null;
		}
	
		
	}
}

