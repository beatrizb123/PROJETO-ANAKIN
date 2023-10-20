package ANAKIN.MODEL.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

import ANAKIN.MODEL.VO.AuxiliarVO;
import ANAKIN.MODEL.VO.UsuarioVO;

public class AcessarControleSessaoDAO {
	PreparedStatement PSTM;
	Connection conn = null;

	public ResultSet AcessarSessaoDAO(int id) {
		conn = new ConexaoDAO().conectabd();
		ManterSessaoDAO MSD = new ManterSessaoDAO();
		UsuarioVO UV = new UsuarioVO();
		String usuario;
		String sql = "select nome_sessao,inventario_sessao,anotacoes_sessao from controle_sessao where id_sessao = ? and id_usuario like ?;";
		try {
			PSTM = conn.prepareStatement(sql);
			if (MSD.chamar() != null) {
				usuario = MSD.chamar();
			} else {
				usuario = UV.getNome_Usuario();
			}
			PSTM.setInt(1, id);
			PSTM.setString(1, usuario);
			ResultSet resultado = PSTM.executeQuery();
			if (resultado.next()) {
				return resultado;
			} else {
				System.err.println("erro na pesquisa: nao ouve resultado");
				return null;

			}

		} catch (SQLException erro) {
			System.err.println("erro na conexa:" + erro);
			return null;
		}
	}

	/*
	 * public ResultSet retornaFichasdaSessaoDAO() {
	 * 
	 */
	
	/*public int retornaIDSessaoDAO() {
		conn = new ConexaoDAO().conectabd();
		ManterSessaoDAO MSD = new ManterSessaoDAO();
		UsuarioVO UV = new UsuarioVO();
		AuxiliarVO AV = new AuxiliarVO();
		String nome = AV.getNomesessaoAUX();
		String usuario;
		int id;
		String sql = "select id_sessao from controle_sessao where nome_sessao like ? and id_usuario like ?;";
		try {
			PSTM = conn.prepareStatement(sql);
			if (MSD.chamar() != null) {
				usuario = MSD.chamar();
			} else {
				usuario = UV.getNome_Usuario();
			}
			PSTM.setString(1, nome);
			PSTM.setString(2, usuario);
			ResultSet resultado = PSTM.executeQuery();
			if (resultado.next()) {
				id = resultado.getInt(1);
				return id;
			} else {
				System.err.println("erro na pesquisa: nao ouve resultado");
				return 0;

			}

		} catch (SQLException erro) {
			System.err.println("erro na conexa:" + erro);
			return (Integer)null;
		}
}*/

	
}
