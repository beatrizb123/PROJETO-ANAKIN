package ANAKIN.MODEL.DAO;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ANAKIN.MODEL.VO.AuxiliarVO;
import ANAKIN.MODEL.VO.ControleSessaoVO;
import ANAKIN.MODEL.VO.UsuarioVO;

public class AbrirSessaoDAO {
	Connection conn;
	PreparedStatement PSTM;
	ResultSet rs;
	public void EncerraAcessoSessao() {
		conn = new ConexaoDAO().conectabd();
		String SQL = "update SessaoAcessada set id_sessao = null, nome_sessao = null where idPorta = 1;";
		try {
			PSTM = conn.prepareStatement(SQL);
			PSTM.executeUpdate();
			PSTM.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	public ResultSet retornaInforSessao() {
		AuxiliarVO AV = new AuxiliarVO();
		conn = new ConexaoDAO().conectabd();
		String SQL = "select nome_sessao, inventario_sessao, anotacoes_sessao from controle_sessao where id_sessao = ?;";
		try {
			PSTM = conn.prepareStatement(SQL);
			PSTM.setInt(1, AV.getIdsessao());
			ResultSet informaçoes = PSTM.executeQuery();
			return informaçoes;
		} catch (SQLException e) {
			System.err.println("erro ao retornar informaçoes :"+e);
			return null;
		}
	}
	public int VereficaSessaoAcessada() {
		conn = new ConexaoDAO().conectabd();
		String SQL = "select id_sessao from SessaoAcessada where idPorta = 1;";
		int i = 0;
		try {
			PSTM = conn.prepareStatement(SQL);
			ResultSet teste = PSTM.executeQuery();
			if(teste.next()) {
				i = 1;
			}else {
				i = 0;
			}
			return i;
		} catch (SQLException e) {
			System.out.println("erro ao vereficar SessaoAcessada: " + e);
			return 0;
		}
		
	}
	public void SessaoAcessada(int id, String nome) {
		conn = new ConexaoDAO().conectabd();
		String SQL = "update SessaoAcessada set id_sessao = ? , nome_sessao= ? where idPorta = 1;";
		try {
			PSTM = conn.prepareStatement(SQL);
			PSTM.setInt(1, id);
			PSTM.setString(2, nome);
			PSTM.executeUpdate();
			PSTM.close();
		} catch (SQLException e) {
			System.err.println("erro ao registrar acesso a uma sessao" + e);

		}
	}
	public int RetornaIdSessao(String nome,String nomeuser) {
		conn = new ConexaoDAO().conectabd();
		String SQL = "select id_sessao from controle_sessao where nome_sessao = ? and id_usuario = ?;";
		int id = 0;
		try {
			PSTM = conn.prepareStatement(SQL);
			PSTM.setString(1, nome);
			PSTM.setString(2, nomeuser);
			ResultSet resultado = PSTM.executeQuery();
			while(resultado.next()) {
				id = resultado.getInt(1);
			}
			return id;
		} catch (SQLException e) {
			System.err.println("erro ao chamar id da sessao :" + e);
			return (Integer)null;
		}
	}
	public ArrayList<String> abrirControleSessao(int id) {
		ArrayList<String> registrosControle = new ArrayList<>();
		UsuarioVO user = new UsuarioVO();
		ControleSessaoVO cont = new ControleSessaoVO();
		//select nome_sessao, inventario_sessao, anotacoes_sessao from controle_sessao where id_sessao = 1;
		//String sql = "SELECT nome_sessao, inventario_sessao, anotacoes_sessao from controle_sessao where nome_sessao = ? and id_usuario = 'beabna'";
		String sql = "select nome_sessao from controle_sessao where id_sessao = ?";
		conn = new ConexaoDAO().conectabd();
		
		try {
			PSTM = conn.prepareStatement(sql);
			PSTM.setInt(1, id);
			
			rs = PSTM.executeQuery();
			
			while (rs.next()) {
				 String nome = rs.getString(1);
				 registrosControle.add(nome);
				 System.out.println(registrosControle);
			}
			PSTM.close();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "AbrirSessaoDAO: " + e);
			return null;
		}
		return registrosControle;
	}

}
