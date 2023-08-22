package ANAKIN.MODEL.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import ANAKIN.MODEL.VO.ControleSessaoVO;
import ANAKIN.MODEL.VO.UsuarioVO;
import ANAKIN.VIEW.TelaCadastroVIEW;

public class CadastroDAO {
	Connection conn;
	PreparedStatement PSTM;

	// medoto para logar/autenticar
	// medoto para cadastrar

	public void cadastrarUsuario(UsuarioVO infor) {

		String sql = "insert into usuario (nome_usuario, senha_usuario) values(?, ?)";
		conn = new ConexaoDAO().conectabd();
		try {
			PSTM = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			PSTM.setString(1, infor.getNome_usuario());
			PSTM.setString(2, infor.getSenha_usuario());
			PSTM.execute();
			
			ResultSet rs = PSTM.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				JOptionPane.showMessageDialog(null, "ESSE É SEU ID: " +id+"\n\nGUARDE-O PARA ALTERAR SUAS INFORMAÇÕES");

				UsuarioVO user = new UsuarioVO();
				user.setId_usuario(id);
				System.out.println(id);
			}
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "CadastroDAO: " + erro);
		}
	}

	public int usaId() {
		int aux = 0;
		int id;
		String sql = "select id_usuario from usuario where nome_usuario = ? and senha_usuario = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			UsuarioVO user = new UsuarioVO();

			pstm.setString(1, user.getNome_usuario());
			pstm.setString(2, user.getSenha_usuario());
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				aux = rs.getInt("id_usuario");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "CadastroDAO: " + e);

		}
		return id = aux;
	}

}
