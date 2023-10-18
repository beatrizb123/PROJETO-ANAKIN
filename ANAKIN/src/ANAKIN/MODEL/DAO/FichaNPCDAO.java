package ANAKIN.MODEL.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ANAKIN.MODEL.VO.AuxiliarVO;
import ANAKIN.MODEL.VO.FichaNPCVO;
import ANAKIN.MODEL.VO.FichaProtagonistaVO;

public class FichaNPCDAO {
	Connection conn = null;
	PreparedStatement PSTM;
	
	public void criandoRegistroNPC() {
		conn = new ConexaoDAO().conectabd();
		String sql = " insert into NPC(id_sessao) value (?);";
		AuxiliarVO AV = new AuxiliarVO();
		try {
			PSTM = conn.prepareStatement(sql);
			PSTM.setInt(1, AV.getIdsessao());
			int i = PSTM.executeUpdate();
			if(i>0) {
				PSTM = conn.prepareStatement("SELECT LAST_INSERT_ID()controle_sessao;");
				ResultSet value = PSTM.executeQuery();
				if(value.next()) {
					int id = value.getInt(1);
					AV.setIdNPC(id);
					System.out.println("id do NPC: "+ id);
					PSTM.close();
				}else {
					System.out.println(" erro ao retornar id NPC");
					PSTM.close();
				}
			}
			PSTM.close();
			
		} catch (SQLException e) {
			System.err.println("erro criandoFichaNPC "+ e);
		}
	}

	public void SalvarInformaçoesNPC(FichaNPCVO NPC) {
		AuxiliarVO AV = new AuxiliarVO();
		
		conn = new ConexaoDAO().conectabd();
		String sql1 = "update NPC "
				+ "set nome_NPC = ?,"
				+ "	ocupacao_NPC = ?,"
				+ "	idade_NPC = ?,"
				+ "    altura_NPC = ?,"
				+ "    vida_NPC = ?,"
				+ "    defesa_NPC = ?,"
				+ "    magia_NPC = ?,"
				+ "    Poder = ?,"
				+ "    Forca = ?,"
				+ "    Carisma = ?,"
				+ "	Agilidade = ?,"
				+ "	Intelecto = ?,"
				+ "	id_ALINHAMENTO = ?"
				+ "    where id_NPCS = ?;";
		try {
			PSTM = conn.prepareStatement(sql1);
			PSTM.setString(1, NPC.getNome_NPC());
			PSTM.setString(2, NPC.getOcupaçao_NPC());
			PSTM.setInt(3, NPC.getIdade_NPC());
			PSTM.setFloat(4, NPC.getAltura_NPC());
			PSTM.setInt(5, NPC.getVida_NPC());
			PSTM.setInt(6,NPC.getDefesa_NPC());
			PSTM.setInt(7, NPC.getMagia_NPC());
			PSTM.setInt(8, NPC.getPoder_NPC());
			PSTM.setInt(9, NPC.getForca_NPC());
			PSTM.setInt(10, NPC.getCarisma_NPC());
			PSTM.setInt(11, NPC.getAgilidade_NPC());
			PSTM.setInt(12, NPC.getIntelecto_NPC());
			PSTM.setInt(13, NPC.getFkIdALINHAMENTO_NPC());
			PSTM.setInt(14, AV.getIdNPC());
			PSTM.executeUpdate();
			PSTM.close();
		} catch (SQLException erro) {
			System.out.println("erro em salvar informaçoes NPC " + erro);
		}
	}

	public int retornaidUsuario(String nome) {
		conn = new ConexaoDAO().conectabd();
		int valor;

		try {
			String sql2 = "select id_sessao from controle_sessao where id_usuario =?";
			PSTM = conn.prepareStatement(sql2);
			PSTM.setString(1, nome);
			ResultSet resultado = PSTM.executeQuery();

			if (resultado.next()) {
				valor = resultado.getInt(1);
				System.out.println(resultado);
				return valor;

			} else {
				System.out.println(" resultado nao encontrado");
			}
			PSTM.close();
			return 0;

		} catch (SQLException erro) {
			System.out.println(erro + " erro ao chamar id do usuario");
			return 0;
		}

	}
	public int RetornaTotalDeFichasNPC() {
		conn = new ConexaoDAO().conectabd();
		String sql = "SELECT COUNT(*) AS total FROM NPC where id_sessao = ?;";
		AuxiliarVO AV = new AuxiliarVO();
		int totalint = 0;
		try {
			PSTM = conn.prepareStatement(sql);
			PSTM.setInt(1,AV.getIdsessao());
			ResultSet total = PSTM.executeQuery();
			if(total.next()) {
				totalint = total.getInt(1);
			}else {
				totalint = 0;
			}
			
			return totalint;
		}catch (SQLException e) {
			System.out.println("erro em contar fichas existentes" + e);
			return 0;
		}
	}

}
