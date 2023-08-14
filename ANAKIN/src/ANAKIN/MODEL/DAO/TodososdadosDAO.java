package ANAKIN.MODEL.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import ANAKIN.MODEL.VO.Todososdados;


public class TodososdadosDAO {
	Connection conn;
	PreparedStatement PSTM;
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
			
		JOptionPane	.showMessageDialog(null, "todososdadosDAO"+erro);
			
		}
	}

}


