package ANAKIN.MODEL.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.cj.xdevapi.Result;

import ANAKIN.MODEL.VO.UsuarioVO;

public class NovoControleDAO {
	Connection conn;
	PreparedStatement PSTM;

	public void criarNovaSessao(String nomeSessao) {
		conn = new ConexaoDAO().conectabd();
		String nome;
		ManterSessaoDAO manter = new ManterSessaoDAO();
		UsuarioVO user = new UsuarioVO();

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
			
			PSTM.execute();
			PSTM.close();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"NovoControleDAO: " + e);
		}
	}
	
	public int retornaIdSessao () {
		conn = new ConexaoDAO().conectabd();
		String sql= "select distinct last_insert_id() from controle_sessao;";
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
	}
	
	public static void main(String[] args) {
		NovoControleDAO novo = new NovoControleDAO();
		int i = novo.retornaIdSessao();
		System.out.println(i);
	}
}
