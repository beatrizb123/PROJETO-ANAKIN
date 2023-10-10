package ANAKIN.MODEL.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.cj.protocol.Resultset;

import ANAKIN.MODEL.VO.AuxiliarVO;
import ANAKIN.MODEL.VO.FichaProtagonistaVO;
import ANAKIN.MODEL.VO.UsuarioVO;

public class FichaProtagonistaDAO {
	Connection conn = null;
	PreparedStatement PSTM;

	public void SalvarInformaçoes(FichaProtagonistaVO prota) {
		conn = new ConexaoDAO().conectabd();
		String sql1 = "insert into protagonista(" + "nome_protagonista," + "ocupacao_protagonista,"
				+ "idade_Protagonista," + "altura_Protagonista," + "vida_Protagonista," + "defesa_Protagonista,"
				+ "magia_Protagonista," + "Poder," + "Forca," + "Carisma," + "Agilidade," + "Intelecto,"
				+ "id_SESSAO,id_CLASSE) " + "value (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		try {
			PSTM = conn.prepareStatement(sql1);
			PSTM.setString(1, prota.getNome_Protagonista());
			PSTM.setString(2, prota.getOcupaçao_Protagonista());
			PSTM.setInt(3, prota.getIdade_Protagonista());
			PSTM.setFloat(4, prota.getAltura_Protagonista());
			PSTM.setInt(5, prota.getVida_Protagonista());
			PSTM.setInt(6, prota.getDefesa_Protagonista());
			PSTM.setInt(7, prota.getMagia_Protagonista());
			PSTM.setInt(8, prota.getPoder_Protagonista());
			PSTM.setInt(9, prota.getForca_Protagonista());
			PSTM.setInt(10, prota.getCarisma_Protagonista());
			PSTM.setInt(11, prota.getAgilidade_Protagonista());
			PSTM.setInt(12, prota.getIntelecto_Protagonista());
			PSTM.setInt(13, prota.getFKIdSessao_Protagonista());
			PSTM.setInt(14, prota.getFkIdClasse_Protagonista());
			PSTM.executeUpdate();
			PSTM.close();
		} catch (SQLException erro) {
			System.out.println(erro + "erro em salvar informaçoes do protagonista");
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
	public int RetornaTantoDeFichas() {
		conn = new ConexaoDAO().conectabd();
		String sql = "SELECT COUNT(*) AS total FROM protagonista where id_sessao = ?;";
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
	public static void main(String[] args) {

	}
}
