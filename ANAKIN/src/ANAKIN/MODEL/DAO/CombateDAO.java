package ANAKIN.MODEL.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import ANAKIN.MODEL.BO.FichaProtagonistaSelecionada;
import ANAKIN.MODEL.VO.AuxiliarVO;
import ANAKIN.MODEL.VO.CombateVO;

public class CombateDAO {
	Connection conn;
	PreparedStatement PSTM;
	
	public void persoAtual(int idP) {
		conn = new ConexaoDAO().conectabd();
		CombateVO comb = new CombateVO();
		String SQL = "SELECT nome_protagonista, "
				+ "vida_protagonista, "
				+ "defesa_protagonista, "
				+ "magia_protagonista, "
				+ "id_classe "
				+ "FROM protagonista where id_protagonista = ?;";
		try {
			PSTM = conn.prepareStatement(SQL);
			ResultSet rs = PSTM.executeQuery();
			
			while(rs.next()) {
				String nome = rs.getString(1);
				comb.setNome_Protag(nome);
				int vida = rs.getInt(2);
				comb.setVida_Protag(vida);
				int defesa = rs.getInt(3);
				comb.setDefesa_Protag(defesa);
				int mag = rs.getInt(4);
				comb.setMagia_Protag(mag);
				int id = rs.getInt(5);
				comb.setIdClasse(id);
				
			}
			PSTM.close();
			
			
		} catch (SQLException erro) {
			System.err.println("CadastroDAO: " + erro);
			
		}
	}
	
	public void NPCAtual(int idN) {
		conn = new ConexaoDAO().conectabd();
		CombateVO comb = new CombateVO();
		String SQL = "SELECT nome_NPC, "
				+ "vida_NPC, "
				+ "defesa_NPC, "
				+ "magia_NPC, "
				+ "id_Alinhamento "
				+ "FROM NPC where id_NPC = ?;";
		try {
			PSTM = conn.prepareStatement(SQL);
			ResultSet rs = PSTM.executeQuery();
			
			while(rs.next()) {
				String nome = rs.getString(1);
				comb.setNome_NPC(nome);
				int vida = rs.getInt(2);
				comb.setVida_NPC(vida);
				int defesa = rs.getInt(3);
				comb.setDefesa_NPC(defesa);
				int mag = rs.getInt(4);
				comb.setMagia_Protag(mag);
				int id = rs.getInt(5);
				comb.setIdAlinha(vida);
				
			}
			PSTM.close();
			
			
		} catch (SQLException erro) {
			System.err.println("CadastroDAO: " + erro);
			
		}
	}
	
	public void criarCombate() {
		conn = new ConexaoDAO().conectabd();
		String sql = "insert into combate (id_sessao) values (?)";
		AuxiliarVO AV = new AuxiliarVO();
		try {
			PSTM = conn.prepareStatement(sql);
			PSTM.setInt(1, AV.getIdsessao());
			int i = PSTM.executeUpdate();
			if (i > 0) {
				PSTM = conn.prepareStatement("SELECT LAST_INSERT_ID();");
				ResultSet rs = PSTM.executeQuery();
				if(rs.next()) {
					int id = rs.getInt(1);
					AV.setIdDados(id);
				}
			}
			PSTM.close();
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "criar CombateDAO: " + erro);
		}
	}
	
	public void salvaCombate (){
		
	}
}
