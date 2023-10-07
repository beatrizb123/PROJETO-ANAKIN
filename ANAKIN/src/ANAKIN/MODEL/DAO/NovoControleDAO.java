package ANAKIN.MODEL.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;

import ANAKIN.MODEL.VO.UsuarioVO;

public class NovoControleDAO {
	Connection conn;
	PreparedStatement PSTM;

	public int criarNovaSessao(String nomeSessao) {
		conn = new ConexaoDAO().conectabd();
		String nome;
		ManterSessaoDAO manter = new ManterSessaoDAO();
		UsuarioVO user = new UsuarioVO();
		ResultSet resultado = null;
		String sql2 = "select last_insert_id() from controle_sessao;";
		int id = 0;
		try {
			if (manter.chamar() != null) {
				nome = manter.chamar();
			} else {
				nome = user.getNome_Usuario();
			}
			String sql = "insert into controle_sessao(nome_sessao, id_usuario) values (?, ?)";
			
			PSTM = conn.prepareStatement(sql);
			PSTM.setString(1, nomeSessao);
			PSTM.setString(2, nome);
			int i = PSTM.executeUpdate();
			if(i > 0) {
				PSTM = conn.prepareStatement(sql2);
				resultado = PSTM.executeQuery();
				if(resultado.next()) {
				id = resultado.getInt(1);
				System.out.println("registro salvo com sucesso  id:"+ id);
				return id;
				}else {
				System.out.println("nao ouve retorno do id");
				return 0;
				}
			}else {
				System.out.println("nenhum registro salvo");
				return 0;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"NovoControleDAO: " + e);
			return (Integer)null;
		}
		}
	}
	
	/*public int retornaIdSessao () {
		conn = new ConexaoDAO().conectabd();
		String sql= "select last_insert_id() from controle_sessao;";
		int id;
		try {
			PSTM = conn.prepareStatement(sql);
			ResultSet rs = PSTM.executeQuery();
			
			if(rs.next()) {
				id = rs.getInt(1);
				return id;
			}else {
				return 0;
			}
			
		} catch (SQLException er) {
			JOptionPane.showMessageDialog(null,"NovoControleDAO: " + er);
			return (Integer)null;
		}
	}*/

