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
			if(rs.next()) {
				int id = rs.getInt(1);
				ControleSessaoVO sessao = new ControleSessaoVO();
				sessao.setFk_usuario(id);
				System.out.println(id);
			}
			PSTM.close();
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "CadastroDAO: " + erro);
		}
	}


	}



