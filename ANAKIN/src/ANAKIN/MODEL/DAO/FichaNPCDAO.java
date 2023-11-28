package ANAKIN.MODEL.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ANAKIN.MODEL.BO.FichaNPCSelecionada;
import ANAKIN.MODEL.BO.FichaProtagonistaSelecionada;
import ANAKIN.MODEL.BO.MiniFichasNPCBO;
import ANAKIN.MODEL.BO.MiniFichasProtaBO;
import ANAKIN.MODEL.VO.AuxiliarVO;
import ANAKIN.MODEL.VO.FichaNPCVO;
import ANAKIN.MODEL.VO.FichaProtagonistaVO;

public class FichaNPCDAO {
	Connection conn = null;
	PreparedStatement PSTM;
	
	public boolean VereficaNPC_OPEN() {
		conn = new ConexaoDAO().conectabd();
		String sql = "select vereficador from npc_open;";
		try {
			PSTM = conn.prepareStatement(sql);
			ResultSet RESP = PSTM.executeQuery();
			if(RESP.next()){
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public void AtivaNPC_OPEN() {
		conn = new ConexaoDAO().conectabd();
		String sql = "insert into NPC_OPEN(ID_Porta,vereficador) value (1,'open');";
		
		try {
			PSTM = conn.prepareStatement(sql);
			PSTM.executeUpdate();
			PSTM.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void DesativaNPC_OPEN() {
		conn = new ConexaoDAO().conectabd();
		String sql = "delete NPC_open from npc_open where id_Porta = 1 ;";
		
		try {
			PSTM = conn.prepareStatement(sql);
			PSTM.executeUpdate();
			PSTM.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void retornaInforNPC(String nome, int vida, int def, int mag) {
		
		conn = new ConexaoDAO().conectabd();
		FichaNPCSelecionada FNS = null;
		String SQL = "select nome_NPC, ocupacao_NPC, descricao,idade_NPC,altura_NPC,Vida_NPC,Defesa_NPC,Magia_NPC,poder,forca,carisma,intelecto,ID_Alinhamento from NPC where Nome_NPC = ? and vida_NPC = ? and defesa_NPC = ? and Magia_NPC = ?;";
		try {
			PSTM = conn.prepareStatement(SQL);
			PSTM.setString(1, nome);
			PSTM.setInt(2, vida);
			PSTM.setInt(3, def);
			PSTM.setInt(4, mag);
			ResultSet infor = PSTM.executeQuery();
			if(infor.next()) {
				
				FNS = new FichaNPCSelecionada(infor.getString(1),infor.getString(2), infor.getInt(4), infor.getInt(5), infor.getString(3), infor.getInt(6), infor.getInt(7),infor.getInt(8), infor.getInt(9), infor.getInt(10), infor.getInt(11), infor.getInt(12), infor.getInt(13),infor.getInt(14));
				PSTM.close();
			}else {
			PSTM.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public MiniFichasNPCBO RetornaInforBase(int posicao) {
		conn = new ConexaoDAO().conectabd();
		AuxiliarVO AV = new AuxiliarVO();
		String SQL = "select nome_NPC,vida_NPC,defesa_NPC,Magia_NPC from npc where id_sessao = ? limit 1 offset ?;";
		MiniFichasNPCBO MFNPC = null;
		try {
			PSTM = conn.prepareStatement(SQL);
			PSTM.setInt(1,AV.getIdsessao() );
			PSTM.setInt(2, posicao);
			ResultSet resultado = PSTM.executeQuery();
			while(resultado.next()) {
				String nome = resultado.getString(1);
				int vida =  resultado.getInt(2);
				int def = resultado.getInt(3);
				int mag = resultado.getInt(4);
				MFNPC = new MiniFichasNPCBO(nome, vida, def, mag);
			}
			return MFNPC;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
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
				+ "	id_ALINHAMENTO = ?,"
				+ " descriçao = ?"
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
			PSTM.setString(14, NPC.getPersonalidade());
			PSTM.setInt(15, AV.getIdNPC());
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
