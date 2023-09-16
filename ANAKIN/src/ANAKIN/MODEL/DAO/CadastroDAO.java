package ANAKIN.MODEL.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;

import ANAKIN.MODEL.VO.ControleSessaoVO;
import ANAKIN.MODEL.VO.UsuarioVO;
import ANAKIN.VIEW.MenuPrincipalVIEW;
import ANAKIN.VIEW.TelaCadastroVIEW;

public class CadastroDAO {
	Connection conn;
	PreparedStatement PSTM;

	// medoto para logar/autenticar
	// medoto para cadastrar

	public void cadastrarUsuario(UsuarioVO infor) {

		String sql = "insert into usuario (nome_usuario, senha_usuario, filme_usuario) values(?, ?, ?)";

		conn = new ConexaoDAO().conectabd();
		try {
			PSTM = conn.prepareStatement(sql);

			ResultSet rs = PSTM
					.executeQuery("select * from usuario where nome_usuario = '" + infor.getNome_Usuario() + "'");
			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "USUARIO JA EXISTE");
			} else {
				PSTM.setString(1, infor.getNome_Usuario());
				PSTM.setString(2, infor.getSenha_usuario());
				PSTM.setString(3, infor.getFilme_Usuario());

			}

			PSTM.execute();
			PSTM.close();
		} catch (SQLException erro) {
			System.err.println("CadastroDAO: " + erro);
		}
	}

}
